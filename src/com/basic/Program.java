/*
 * Program.java - One BASIC program, ready to roll.
 *
 * Copyright (c) 1996 Chuck McManis, All Rights Reserved.
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

import com.basic.streameditor.StreamingTextArea;
import com.basic.util.RedBlackTree;
import com.sun.speech.freetts.Voice;

import java.io.*;
import java.util.Enumeration;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;
import midisystem.MidiSynthSystem;

import static com.basic.ParseStatement.*;

/**
 * This class instantiates a BASIC program. A valid program is one that is
 * parsed and ready to run. You can run it by invoking the run() method. The
 * standard input and output of the basic_prg_running basic program can either
 * be passed into the <b>run</b> method, or they can be presumed to be the in
 * and out streams referenced by the <b>System</b> class.
 *
 * This class uses Red-Black trees to hold the parsed statements and the symbol
 * table.
 *
 * @author Chuck McManis
 * @version 1.1
 * @see CommandInterpreter
 *
 */
public class Program implements Runnable, Serializable
{
    public static final long serialVersionUID = 1L;

    public final Voice voice;  // Speech synth
    
    public final StreamingTextArea area;
    public boolean basic_prg_running = true;  // Program basic_prg_running
    public boolean thread_running = true; // Thread basic_prg_running 
    public long basetime = System.currentTimeMillis();

    // this tree holds all of the statements.
    private final RedBlackTree<Integer, Statement> stmts = new RedBlackTree<>();

    // this tree holds all of the variables.
    private RedBlackTree<String, Variable> vars = new RedBlackTree<>();

    private Stack<Statement> stmtStack = new Stack<>();
    private Vector<Token> dataStore = new Vector<>();
    private int dataPtr = 0;
    private Random r = new Random(0);

    private boolean traceState = false;
    private PrintStream traceFile = null;

    private final CommandInterpreter m_caller;

    public Program (StreamingTextArea ta, Voice v, CommandInterpreter caller)
    {
        m_caller = caller;
        area = ta;
        voice = v;
    }

    public void trace (boolean a)
    {
        traceState = a;
    }

    public void trace (boolean a, String f)
    {
        if (traceFile == null)
        {
            try
            {
                traceFile = new PrintStream(new FileOutputStream(f));
            }
            catch (IOException e)
            {
                System.out.println("Couldn't open trace file.");
                traceFile = null;
            }
        }
        trace(a);
    }

    public Random getRandom ()
    {
        return r;
    }

    public void randomize (double seed)
    {
        r = new Random((long) seed);
    }

// --Commented out by Inspection START (4/23/2016 9:39 AM):
//    void randomize()
//    {
//        r = new Random(); // uses the clock
//    }
// --Commented out by Inspection STOP (4/23/2016 9:39 AM)

    /**
     * There are two ways to create a new program object, you can load one from
     * an already open stream or you can pass in a file name and load one from
     * the file system.
     *
     * @param source
     * @param out
     * @return
     * @throws java.io.IOException
     * @throws com.basic.BASICSyntaxError
     */
    private static Program load (InputStream source, PrintStream out, StreamingTextArea ar, Voice v) throws IOException, BASICSyntaxError
    {
        BufferedReader dis
                = new BufferedReader(new InputStreamReader(source));

        char data[] = new char[256];
        LexicalTokenizer lt = new LexicalTokenizer(data);
        String lineData;
        Statement s;
        Token t;
        Program result = new Program(ar, v, null);

        while (true)
        {
            // read a line of our BASIC program.
            lineData = dis.readLine();

            // if EOF simply return.
            if (lineData == null)
            {
                return result;
            }

            // if the line was blank, ignore it.
            if (lineData.length() == 0)
            {
                continue;
            }

            lt.reset(lineData);
            t = lt.nextToken();
            if (t.typeNum() != KeyWords.CONSTANT)
            {
                throw new BASICSyntaxError("Line failed to start with a line number.");
            }

            try
            {
                s = statement(lt);
            }
            catch (BASICSyntaxError bse)
            {
                out.println("Syntax error: " + bse.getMsg());
                out.println(lt.showError());
                throw bse;
            }
            s.addText(lineData);
            s.addLine((int) t.numValue());
            result.add((int) t.numValue(), s);
        }
    }

    /**
     * Load the specified file and parse the basic statements it contains.
     *
     * @param source
     * @param out
     * @param ar
     * @return 
     * @throws IOException when the filename cannot be located or opened.
     * @throws BASICSyntaxError when the file does not contain a properly formed
     * BASIC program.
     */
    public static Program load(String source, PrintStream out, StreamingTextArea ar, Voice v) throws IOException, BASICSyntaxError
    {
        // XXX this needs to use the SourceManager class //
        FileInputStream fis = new FileInputStream(source);
        Program r;
        try
        {
            r = load(fis, out, ar, v);
        }
        catch (BASICSyntaxError e)
        {
            fis.close();
            throw e;
        }
        fis.close();
        return r;
    }

// --Commented out by Inspection START (4/23/2016 9:40 AM):
//    /**
//     * Write the basic program out to the passed output stream. Conceptually
//     * this is identical to doing a list operation.
//     */
//    private void save (OutputStream out)
//    {
//        PrintStream p = new PrintStream(out);
//        list(p);
//    }
// --Commented out by Inspection STOP (4/23/2016 9:40 AM)

// --Commented out by Inspection START (4/23/2016 9:39 AM):
//    /**
//     * Write the program out to the file named in <i>output</i>.
//     */
//    public void save(String output) throws IOException
//    {
//        FileOutputStream fos = new FileOutputStream(output);
//        save(fos);
//        fos.flush();
//        fos.close();
//    }
// --Commented out by Inspection STOP (4/23/2016 9:39 AM)

// --Commented out by Inspection START (4/23/2016 9:39 AM):
//    /**
//     * This method starts this program basic_prg_running in its own thread.
//     */
//    void start()
//    {
//        Thread t = new Thread(this);
////        if (myName != null)
////        {
////            t.setName(myName + " execution.");
////        }
//        t.start();
//    }
// --Commented out by Inspection STOP (4/23/2016 9:39 AM)

    /**
     * Add a statement to the current program. Statements are indexed by line
     * number. If the add fails for some reason this method returns false.
     */
    boolean add(int line, Statement s)
    {
        Integer ln = line;
        stmts.put(ln, s);
        return true;
    }

    /**
     * Delete a statement from the current program. Statements are indexed by
     * line numbers. If the statement specified didn't exist, then this method
     * returns false.
     */
    boolean del(int line)
    {
        return stmts.remove(line) != null;
    }

    /**
     * Compute the indices based on the expressions in the variable object.
     */
    private int[] getIndices(Variable v) throws BASICRuntimeError
    {
        int result[] = new int[v.numExpn()];

        for (int i = 0; i < result.length; i++)
        {
            result[i] = (int) v.expn(i).value(this);
        }
        return result;
    }

    /**
     * Return the numeric value of a variable in the symbol table.
     *
     * @throws BASICRuntimeError if the variable isn't defined.
     *
     */
    public double getVariable (Variable v) throws BASICRuntimeError
    {
        Variable vi = vars.get(v.name);
        if (vi == null)
        {
            throw new BASICRuntimeError("Undefined variable '" + v.name + "'");
        }
        if (!vi.isArray())
        {
            return vi.numValue();
        }
        int ii[] = getIndices(v);
        return vi.numValue(ii);
    }

    /**
     * Return the contents of the string variable named <i>name</i>. If the
     * variable has not yet been declared (ie used) this method throws a
     * BASICRuntime error.
     */
    String getString(Variable v) throws BASICRuntimeError
    {
        Variable vi = vars.get(v.name);
        if (vi == null)
        {
            throw new BASICRuntimeError("Variable " + v.name + " has not been initialized.");
        }
        if (!v.isArray())
        {
            return vi.stringValue();
        }
        int ii[] = getIndices(v);
        return vi.stringValue(ii);
    }

    /**
     * Set the numeric variable <i>name</i> to have value <i>value</i>. If this
     * is the first time we have seen the variable, create a place for it in the
     * symbol table.
     */
    public <T> void setVariable (Variable v, T value) throws BASICRuntimeError
    {
        Variable vi = vars.get(v.name);
        if (vi == null)
        {
            if (v.isArray())
            {
                throw new BASICRuntimeError("Array must be declared in a DIM statement");
            }
            vi = new Variable(v.name);
            vars.put(v.name, vi);
        }
        if (!vi.isArray())
        {
            vi.setValue (value);
            return;
        }
        int ii[] = getIndices(v);
        vi.setValue (value, ii);
    }

    /**
     * Set the string variable named <i>name</i> to have the value <i>value</i>.
     * If this is the first use of the variable it is created.
     */
//    public void setVariable (Variable v, String value) throws BASICRuntimeError
//    {
//        Variable vi = vars.get(v.name);
//        if (vi == null)
//        {
//            if (v.isArray())
//            {
//                throw new BASICRuntimeError("Array must be declared in a DIM statement");
//            }
//            vi = new Variable(v.name);
//            vars.put(v.name, vi);
//        }
//        if (!vi.isArray())
//        {
//            vi.setValue(value);
//            return;
//        }
//        int ii[] = getIndices(v);
//        vi.setValue(value, ii);
//    }

    /**
     * This method is used by the DIM statement to DECLARE arrays. Given the
     * nature of arrays we force them to be declared before they can be used.
     * This is common to most BASIC implementations.
     */
    public void declareArray (Variable v) throws BASICRuntimeError
    {
        Variable vi;
        int ii[] = getIndices(v);
        vi = new Variable(v.name, ii);
        vars.put(v.name, vi);
    }

    /**
     * Compute and return the next program statement to be executed. The policy
     * is, if the current statement has another statement hanging off its
     * <i>nxt</i> pointer use that one, otherwise use the next one in the
     * program numerically.
     */
    public Statement nextStatement (Statement s)
    {
        if (s == null)
        {
            return null;
        }
        else if (s.nxt != null)
        {
            return s.nxt;
        }
        return stmts.next(s.line);
    }

    /**
     * Return the statment whose line number is <i>line</i>
     */
    public Statement getStatement (int line)
    {
        return stmts.get(line);
    }

    /**
     * List program lines from <i>start</i> to <i>end</i> out to the PrintStream
     * <i>p</i>. Note that due to a bug in the Windows implementation of
     * PrintStream this method is forced to append a <CR> to the file.
     */
    void list(int start, int end, PrintStream p)
    {
        for (Enumeration<Map.Entry<Integer, Statement>> e = stmts.elements(); e.hasMoreElements();)
        {
            Map.Entry<Integer, Statement> entry = e.nextElement();
            Statement s = entry.getValue();
            if ((s.lineNo() >= start) && (s.lineNo() <= end))
            {
                p.print(s.asString());
                p.print("\r");
                p.println(); // for Windows clients
            }
        }
    }

    /**
     * Dump the symbol table
     */
    void dump(PrintStream p)
    {
        for (Enumeration e = vars.elements(); e.hasMoreElements();)
        {
            Map.Entry<String, Variable> entry = (Map.Entry<String, Variable>) e.nextElement();
            Variable v = entry.getValue();
            p.println(v.unparse() + " = " + (v.isString() ? "\"" + v.stringValue() + "\"" : "" + v.numValue()));
        }
    }

    /**
     * This is the first variation on list, it simply list from the starting
     * line to the the end of the program.
     */
    void list(int start, PrintStream p)
    {
        list(start, Integer.MAX_VALUE, p);
    }

    /**
     * This second variation on list will list the entire program to the passed
     * PrintStream object.
     */
    void list(PrintStream p)
    {
        list(0, p);
    }

// --Commented out by Inspection START (4/23/2016 9:38 AM):
//    /**
//     * This final variant of the list method will list the program on
//     * System.out.
//     */
//    void list()
//    {
//        list(System.out);
//    }
// --Commented out by Inspection STOP (4/23/2016 9:38 AM)

    /**
     * Run the program and use the passed in streams as its input and output
     * streams.
     *
     * Prior to basic_prg_running the program the statement stack is cleared,
     * and the data fifo is also cleared. Thus re-basic_prg_running a stopped
     * program will always work correctly.
     *
     * @param in
     * @param out
     * @param firstline
     * @throws BASICRuntimeError if an error occurs while basic_prg_running.
     */
    public void run(InputStream in, OutputStream out, int firstline) throws Exception
    {
        PrintStream pout;
        Enumeration<Map.Entry<Integer, Statement>> e = stmts.elements();
        stmtStack = new Stack();    // assume no stacked statements ...
        dataStore = new Vector();   // ...  and no data to be read.
        dataPtr = 0;
        Statement s;

        vars = new RedBlackTree<>();

        // if the program isn't yet valid.
        if (!e.hasMoreElements())
        {
            return;
        }
        
        MidiSynthSystem.get().deleteAllTracks(); // Run MidiSynthSystem
        
        if (out instanceof PrintStream)
        {
            pout = (PrintStream) out;
        }
        else
        {
            pout = new PrintStream(out);
        }

        /* First we load all of the data statements */
        while (e.hasMoreElements())
        {
            s = (e.nextElement()).getValue();
            if (s.keyword == KeyWords.DATA)
            {
                s.execute(this, in, pout);
            }
        }

        e = stmts.elements();
        s = e.nextElement().getValue();
        if (firstline != 0)  // Skip lines if desired
        {
            do 
            {
                if (s.line >= firstline)
                {
                    break;
                }
                s = e.nextElement().getValue();
            } while (e.hasMoreElements());
        }
        do
        {
            //Thread.yield();   // Let others run
            if (!basic_prg_running)
            {
                basic_prg_running = true;
                pout.println("Stopped at :" + s);
                push(s);
                break;
            }
            if (!thread_running)
            {
                thread_running = true;
                throw new Exception("Basic Thread forced to stop");
            }
            if (s.keyword != KeyWords.DATA)
            {
                if (traceState)
                {
                    s.trace(this, (traceFile != null) ? traceFile : pout);
                }

                s = s.execute(this, in, pout);
            }
            else
            {
                s = nextStatement(s);
            }
        }
        while (s != null);
        MidiSynthSystem.get().shutdown();
    }

// --Commented out by Inspection START (4/23/2016 9:39 AM):
//    /**
//     * This package private version of run() is used by the command interpreter
//     * to run a "single" statement in the context of this program. Single is in
//     * quotes because if the statement has additional statements chained off its
//     * next pointer, these will be run as well. Further if one of them is a GOTO
//     * or GOSUB or IF and they cause a tranfer to a numbered statement then
//     * exectution will start at that statement. This can be useful for debugging
//     * but unpredictable since not all variables will be declared if their
//     * assignment statements have not yet been executed.
//     *
//     * Unlike its sibling method above, it does NOT clear the statement stack or
//     * data FIFO. This is so the command interpreter can debug stopped programs
//     * using the immediate execution feature.
//     */
//    void run(Statement s, InputStream in, OutputStream out) throws BASICRuntimeError
//    {
//        // if the program isn't yet valid.
//        PrintStream pout;
//        Enumeration e = stmts.elements();
//        if (!e.hasMoreElements())
//        {
//            return;
//        }
//
//        if (out instanceof PrintStream)
//        {
//            pout = (PrintStream) out;
//        }
//        else
//        {
//            pout = new PrintStream(out);
//        }
//
//        do
//        {
//            s = s.execute(this, in, pout);
//        }
//        while (s != null);
//    }
// --Commented out by Inspection STOP (4/23/2016 9:39 AM)

    /**
     * This final version of run is used to implement the <b>Runnable</b>
     * interface. It will run the program using System.in and System.out as the
     * standard I/O streams for the program and it does *NOT* throw
     * BASICRuntimeError. Instead it catches it and prints an error message to
     * standard out.
     */
    @Override
    public void run()
    {
        try
        {
            run(System.in, System.out, 0);
        }
        catch (BASICRuntimeError e)
        {
            System.out.println("Error Running program: " + e.getMsg());
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    /**
     * This method resumes a program that has been stopped. If the program
     * wasn't really stopped it throws a BASICRuntimeError.
     *
     * @throws BASICRuntimeError - Program wasn't in a stopped state.
     */
    void resume(InputStream in, PrintStream pout) throws BASICRuntimeError
    {
        Statement s;

        s = pop();
        if ((s == null) || (s.keyword != KeyWords.STOP))
        {
            throw new BASICRuntimeError("This program was not previously stopped.");
        }
        s = nextStatement(s);
        do
        {
            s = s.execute(this, in, pout);
        }
        while (s != null);
    }

    void cont(InputStream in, PrintStream pout) throws BASICRuntimeError
    {
        Statement s;

        s = pop();
        do
        {
//            /* While basic_prg_running we skip Data statements. */
//            try
//            {
//                yyy = in.available();
//            }
//            catch (IOException e)
//            {
//                yyy = 0;
//            }
//            if (yyy != 0)
//            {
//                pout.println("Stopped at :" + s);
//                push(s);
//                break;
//            }
            if (!basic_prg_running)
            {
                basic_prg_running = true;
                pout.println("Stopped at :" + s);
                push(s);
                break;
            }
            if (s.keyword != KeyWords.DATA)
            {
                if (traceState)
                {
                    s.trace(this, (traceFile != null) ? traceFile : pout);
                }

                s = s.execute(this, in, pout);
            }
            else
            {
                s = nextStatement(s);
            }
        }
        while (s != null);
    }


    /*
     * These methods deal with pushing and popping statements from the statement
     * stack, and data items from the data stack.
     */
    /**
     * Push this statement on the stack (one of FOR, GOSUB, or STOP)
     */
    public void push (Statement s)
    {
        stmtStack.push(s);
    }

    /**
     * Pop the next statement off the stack, return NULL if the stack is empty.
     */
    public Statement pop ()
    {
        if (stmtStack.isEmpty())
        {
            return null;
        }
        return stmtStack.pop();
    }

    /**
     * Add a token to the data FIFO.
     */
    public void pushData (Token t)
    {
        dataStore.addElement(t);
    }

    /**
     * Get the next token in the FIFO, return null if the FIFO is empty.
     */
    public Token popData ()
    {
        if (dataPtr > (dataStore.size() - 1))
        {
            return null;
        }
        return (Token) dataStore.elementAt(dataPtr++);
    }

    /**
     * Reset the data FIFO back to the beginning.
     */
    public void resetData ()
    {
        dataPtr = 0;
    }
}
