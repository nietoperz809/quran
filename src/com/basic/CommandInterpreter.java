/*
 * CommandInterpreter.java -  Provide the basic command line interface.
 *
 * ^
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for NON-COMMERCIAL purposes and without
 * fee is hereby granted provided that this copyright notice
 * appears in all copies.
 *
 * CHUCK MCMANIS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. CHUCK MCMANIS
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */
package com.basic;

import applications.BasicGUI;
import com.basic.streameditor.StreamingTextArea;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory;
import midisystem.MidiSynthSystem;
import misc.Transmitter;

import javax.sound.midi.Instrument;
import java.io.*;
import java.util.List;

import static com.basic.ParseStatement.statement;

/**
 * This class is an "interactive" BASIC environment. You can think of it as
 * BASIC debug mode. Using the streams you passed in to create the object, it
 * hosts an interactive session allowing the user to enter BASIC programs, run
 * them, save them, and load them.
 */
public class CommandInterpreter implements Serializable
{
    public static final long serialVersionUID = 1L;
    LexicalTokenizer tokenizer;
    public Program basicProgram;

    StreamingTextArea streamingTextArea;
    transient private DataInputStream inStream;
    transient private PrintStream outStream;

    transient private Voice voice;

    transient private BasicGUI m_bg;

    public Program getProg()
    {
       return basicProgram;
    }

    public BasicGUI getGUI()
    {
        return m_bg;
    }

    /**
     * Create a new command interpreter attached to the passed in streams.
     */
    public CommandInterpreter (BasicGUI bg)
    {
//        MyKevinVoiceDirectory mk = new MyKevinVoiceDirectory();
//        voice = mk.getVoices()[0];
//        voice.allocate();
        KevinVoiceDirectory dir = new KevinVoiceDirectory();
        voice = dir.getVoices()[0];
        voice.allocate();
        m_bg = bg;
    }

    /**
     * This method basically dispatches the commands of the command interpreter.
     */
    Program processCommand (Program pgm, LexicalTokenizer lt, Token x) throws Exception
    {
        Token t;

        switch (x.kwValue) 
        {
            case CMD_RESUME:
                try
                {
                    pgm.resume(inStream, outStream);
                }
                catch (BASICRuntimeError e)
                {
                    outStream.println(e.getMsg());
                }
                return pgm;

            case CMD_CONT:
                try
                {
                    pgm.cont(inStream, outStream);
                }
                catch (BASICRuntimeError e)
                {
                    outStream.println(e.getMsg());
                }
                return pgm;

            case CMD_RUN:
                t = lt.nextToken();
                int startline = 0;
                if (t.typeNum() == KeyWords.EOL)
                {
                    startline = 0;
                }
                else if (t.typeNum() == KeyWords.CONSTANT)
                {
                    startline = (int) t.numValue();
                }
                try
                {
                    pgm.run(inStream, outStream, startline);
                }
                catch (BASICRuntimeError e2)
                {
                    outStream.println(e2.getMsg());
                }
                return pgm;

            case CMD_CMDS:
                List<KeyWords> list = KeyWords.getAlphabeticallySorted();
                for (KeyWords k : list)
                {
                    String description = k.getDesc();
                    if (description != null)
                    {
                        outStream.print (k.toString().toUpperCase());
                        outStream.println(" - "+ description);
                    }

                }
                return pgm;

            case CMD_INSTRLIST:
                Instrument[] instr = MidiSynthSystem.get().getInstruments();
                StringBuilder sb = new StringBuilder();
                for (int n = 0; n < instr.length; n++)
                {
                    sb.append(n);
                    sb.append(" -- ");
                    sb.append(instr[n].toString());
                    sb.append('\n');
                }
                outStream.println(sb.toString());
                return pgm;

            case CMD_CAT:
                t = lt.nextToken();
                if (t.typeNum() != KeyWords.STRING)
                {
                    outStream.println("File name expected for CAT Command.");
                    return pgm;
                }
                File f = new File(t.stringValue());
                InputStream in = new FileInputStream(f);
                Transmitter tr = new Transmitter(in, outStream);
                tr.doTransmission(null);
                return pgm;

            case CMD_DEL:
                t = lt.nextToken();
                if (t.typeNum() != KeyWords.STRING)
                {
                    outStream.println("File name expected for DEL Command.");
                    return pgm;
                }
                new File(t.stringValue()).delete();
                return pgm;
            
            case CMD_SAVE:
                t = lt.nextToken();
                if (t.typeNum() != KeyWords.STRING)
                {
                    outStream.println("File name expected for SAVE Command.");
                    return pgm;
                }
                if (new File(t.stringValue()).exists())
                {
                    outStream.println("ERROR: file already exists");
                    return pgm;
                }
                outStream.println("Saving file...");
                FileOutputStream fos;
                try
                {
                    fos = new FileOutputStream(t.stringValue());
                }
                catch (IOException except)
                {
                    outStream.println("ERROR while saving");
                    return pgm;
                }
                PrintStream pp = new PrintStream(fos);
                pgm.list(pp);
                pp.flush();
                try
                {
                    fos.close();
                }
                catch (IOException except)
                {
                }
                return pgm;

            case CMD_LOAD:
                t = lt.nextToken();
                if (t.typeNum() != KeyWords.STRING)
                {
                    outStream.println("File name expected for LOAD command.");
                    return pgm;
                }
                try
                {
                    pgm = Program.load(t.stringValue(), outStream, pgm.area, voice);
                    outStream.println("File loaded.");
                }
                catch (IOException e)
                {
                    outStream.println("File " + t.stringValue() + " not found.");
                    return pgm;
                }
                catch (BASICSyntaxError bse)
                {
                    outStream.println("Syntax error reading file.");
                    outStream.println(bse.getMsg());
                    return pgm;
                }
                return pgm;

            case CMD_DIR:
                File[] filesInFolder = new File(".").listFiles();
                for (final File fileEntry : filesInFolder)
                {
                    if (fileEntry.isFile())
                    {
                        outStream.println(fileEntry.getName()+ " -- " + fileEntry.length());
                    }
                }
                return pgm;

            case CMD_DUMP:
                PrintStream zzz = outStream;
                t = lt.nextToken();
                if (t.typeNum() == KeyWords.STRING)
                {
                    try
                    {
                        zzz = new PrintStream(new FileOutputStream(t.stringValue()));
                    }
                    catch (IOException ii)
                    {
                    }
                }
                pgm.dump(zzz);
                if (zzz != outStream)
                {
                    zzz.close();
                }
                return pgm;

            case CMD_LIST:
                t = lt.nextToken();
                if (t.typeNum() == KeyWords.EOL)
                {
                    pgm.list(outStream);
                }
                else if (t.typeNum() == KeyWords.CONSTANT)
                {
                    int strt = (int) t.numValue();
                    t = lt.nextToken();
                    if (t.typeNum() == KeyWords.EOL)
                    {
                        pgm.list(strt, outStream);
                    }
                    else if (t.isSymbol(','))
                    {
                        t = lt.nextToken();
                        if (t.typeNum() != KeyWords.CONSTANT)
                        {
                            outStream.println("Illegal parameter to LIST command.");
                            outStream.println(lt.showError());
                            return pgm;
                        }
                        int e = (int) t.numValue();
                        pgm.list(strt, e, outStream);
                    }
                    else
                    {
                        outStream.println("Syntax error in LIST command.");
                        outStream.println(lt.showError());
                    }
                }
                else
                {
                    outStream.println("Syntax error in LIST command.");
                    outStream.println(lt.showError());
                }
                return pgm;
        }
        outStream.println("Command not implemented.");
        return pgm;
    }

    char data[] = new char[256];

    /**
     * Processes backspace
     *
     * @param in
     * @return String with BS processed
     */
    private String processBS(String in)
    {
        StringBuilder buff = new StringBuilder();
        for (int n = 0; n < in.length(); n++)
        {
            char c = in.charAt(n);
            if (c == '\b')
            {
                if (buff.length() > 0)
                {
                    buff.deleteCharAt(buff.length() - 1);
                }
            }
            else
            {
                buff.append(c);
            }
        }
        return buff.toString();
    }

    public void dispose()
    {
        voice.deallocate();
        streamingTextArea.destroy();
    }
    
    /**
     * Starts the interactive session. When running the user should see the
     * "Ready." prompt. The session ends when the user types the
     * <code>bye</code> command.
     * @return EndReason 1 == BYE detected
     * @throws java.lang.Exception
     */
    public int start (StreamingTextArea area) throws Exception
    {
        System.err.println("start BASIC system");
        streamingTextArea = area;
        inStream = new DataInputStream(area.getInputStream());
        outStream = new PrintStream(area.getOutputStream());

        if (tokenizer == null)
        {
            System.out.println("create Tokenizer");
            tokenizer = new LexicalTokenizer(data);
        }
        if (basicProgram == null)
        {
            System.out.println("create BASIC prog");
            basicProgram = new Program(area, voice, this);
        }

        DataInputStream dis = inStream;
        String lineData;

        outStream.println("*JavaBasic*\nType CMDS to see commands\n");

        while (true)
        {
            try
            {
                lineData = processBS(dis.readLine());
                System.out.println(lineData);
            }
            catch (IOException ioe)
            {
                System.out.println("Caught an IO exception reading the input stream!");
                return 0;
            }

            // exit on eof of the input stream
            if (lineData == null)
            {
                System.out.println("exit on EOF");
                return 0;
            }

            // ignore blank lines.
            if (lineData.length() == 0)
            {
                System.out.println("ignore blank line");
                continue;
            }

            tokenizer.reset(lineData);

            if (!tokenizer.hasMoreTokens())
            {
                System.out.println("no more tokens");
                continue;
            }

            Token t = tokenizer.nextToken();
            switch (t.typeNum())
            {
                /*
                 * Process one of the command interpreter's commands.
                 */
                case COMMAND:
                    if (t.kwValue  == KeyWords.CMD_BYE)
                    {
                        //System.exit(0);
                        return 1;
                    }
                    else if (t.kwValue == KeyWords.CMD_NEW)
                    {
                        basicProgram = new Program (area, voice, this);
                        System.gc();
                        break;
                    }
                    else
                    {
                        basicProgram = processCommand(basicProgram, tokenizer, t);
                    }
                    outStream.println("Ready.");
                    break;

                /*
                 * Process an initial number, it can be a new statement line
                 * or it may be an implicit delete command.
                 */
                case CONSTANT:
                    Token peek = tokenizer.nextToken();
                    if (peek.typeNum() == KeyWords.EOL)
                    {
                        basicProgram.del((int) t.numValue());
                        break;
                    }
                    else
                    {
                        tokenizer.unGetToken();
                    }
                    try
                    {
                        Statement s = statement(tokenizer);
                        s.addText(lineData);
                        s.addLine((int) t.numValue());
                        basicProgram.add((int) t.numValue(), s);
                    }
                    catch (BASICSyntaxError e)
                    {
                        outStream.println("Syntax Error : " + e.getMsg());
                        outStream.println(tokenizer.showError());
                        continue;
                    }
                    break;

                /*
                 * If initially it is a variable or a statement keyword then it
                 * must be an 'immediate' line.
                 */
                case VARIABLE:
                case KEYWORD: // immediate mode
                case SYMBOL:
                    tokenizer.unGetToken();
                    try
                    {
                        Statement s = statement(tokenizer);
                        do
                        {
                            s = s.execute(basicProgram, inStream, outStream);
                        }
                        while (s != null);

                    }
                    catch (BASICSyntaxError e)
                    {
                        outStream.println("Syntax Error : " + e.getMsg());
                        outStream.println(tokenizer.showError());
                    }
                    catch (BASICRuntimeError er)
                    {
                        outStream.println("RUNTIME ERROR.");
                        outStream.println(er.getMsg());
                    }
                    break;

                /*
                 * Blank lines are ignored.
                 */
                case EOL:
                    break;

                /*
                 * Anything else is an error.
                 */
                default:
                    outStream.println("Error, command not recognized.");
                    break;
            }
        }
    }
}
