package com.basic.streameditor;

import misc.BlockCaret;
import misc.Tools;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Administrator
 */
public class StreamingTextArea extends JTextArea implements Runnable
{
    private static final long serialVersionUID = 1L;
    private final RingBuffer<Character> inBuffer;
    private final InStream in;

    private final RingBuffer<Character> outBuffer;
    private final OutStream out;

    private transient Thread thread;
    //private boolean running = true;

    private int linenum = 0;

    /**
     *
     */
    public StreamingTextArea ()
    {
        super();
        setCaret(new BlockCaret());
        inBuffer = new RingBuffer<>(128);
        outBuffer = new RingBuffer<>(128);
        in = new InStream(inBuffer);
        out = new OutStream(outBuffer);
        listenCaret();
        startThread();
    }

    private void listenCaret ()
    {
        // Add a caretListener to the editor. This is an anonymous class because it is inline and has no specific name.
        this.addCaretListener((CaretEvent e) ->
        {
            JTextArea editArea = (JTextArea) e.getSource();

            // Lets start with some default values for the line and column.
            // We create a try catch to catch any exceptions. We will simply ignore such an error for our demonstration.
            try
            {
                // First we find the position of the caret. This is the number of where the caret is in relation to the start of the JTextArea
                // in the upper left corner. We use this position to find offset values (eg what line we are on for the given position as well as
                // what position that line starts on.
                int caretpos = editArea.getCaretPosition();
                linenum = editArea.getLineOfOffset(caretpos);

                // We subtract the offset of where our line starts from the overall caret position.
                // So lets say that we are on line 5 and that line starts at caret position 100, if our caret position is currently 106
                // we know that we must be on column 6 of line 5.
                //columnnum = caretpos - editArea.getLineStartOffset(linenum);
            }
            catch (Exception ex)
            {
            }
            // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
        });
        this.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped (KeyEvent e)
            {
                if (e.getKeyChar() == '\n')
                {
                    try
                    {
                        StreamingTextArea editArea = (StreamingTextArea) e.getSource();
                        String[] lines = editArea.getText().split("\\n");
                        int idx = (linenum > 0) ? linenum - 1 : linenum;
                        if (lines.length > idx)
                        {
                            String t = lines[idx];
                            for (int n = 0; n < t.length(); n++)
                            {
                                inBuffer.add(t.charAt(n));
                            }
                        }
                        inBuffer.add('\n');
                    }
                    catch (InterruptedException ex)
                    {
                    }
                }
            }

            @Override
            public void keyPressed (KeyEvent e)
            {
            }

            @Override
            public void keyReleased (KeyEvent e)
            {
            }
        });
    }

    public final void startThread ()
    {
        //running = true;
        thread = null;
        Tools.execute(this);

        while (thread == null)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
//        thread = new Thread(this);
//        thread.start();
    }

    /**
     * @return
     */
    public InputStream getInputStream ()
    {
        return in;
    }

    public PrintStream getPrintStream ()
    {
        return new PrintStream(out);
    }

    public DataInputStream getDataInputStream ()
    {
        return new DataInputStream(in);
    }

    /**
     * @return
     */
    public OutputStream getOutputStream ()
    {
        return out;
    }

    @Override
    public void paste ()
    {
        super.paste();
        String s = Tools.getClipBoardString();
        for (int n = 0; n < s.length(); n++)
        {
            try
            {
                inBuffer.add(s.charAt(n));
            }
            catch (InterruptedException ex)
            {
            }
        }
        //DebugOut.get().out.println(s);
    }

    public void fakeIn (String s)
    {
        for (int n = 0; n < s.length(); n++)
        {
            try
            {
                inBuffer.add(s.charAt(n));
            }
            catch (InterruptedException ex)
            {
            }
        }
    }

    /**
     *
     */
    public synchronized void destroy ()
    {
        thread.interrupt(); //running = false;
        inBuffer.notifyAll();
        outBuffer.notifyAll();
        try
        {
            thread.join();
        }
        catch (InterruptedException ex)
        {
        }
    }

    @Override
    public void run ()
    {
        thread = Thread.currentThread();
        while (!thread.isInterrupted())
        {
            String txt;
            try
            {
                txt = outBuffer.removeAsString();
            }
            catch (InterruptedException ex)
            {
                break;
            }
            try
            {
                synchronized (this)
                {
                    int cp = getCaretPosition();
                    insert(txt, cp);
                    setCaretPosition(cp + txt.length());
                }
            }
            catch (Exception ex)
            {
                System.out.println(ex + " -- " + txt);
            }
        }
        System.out.println("stream thread ended");
    }
}
