/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basic.streameditor;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Administrator
 */
public class StreamingTextArea extends JTextArea implements KeyListener, Runnable
{
    private final RingBuffer<Character> inBuffer;
    private final InStream in;

    private final RingBuffer<Character> outBuffer;
    private final OutStream out;

    private transient Thread thread;
    boolean running = true;

    class FancyCaret extends DefaultCaret
    {
        protected synchronized void damage(Rectangle r)
        {
            if (r == null)
            {
                return;
            }

            // give values to x,y,width,height (inherited from java.awt.Rectangle)
            x = r.x;
            y = r.y;
            height = r.height;
            // A value for width was probably set by paint(), which we leave alone.
            // But the first call to damage() precedes the first call to paint(), so
            // in this case we must be prepared to set a valid width, or else paint()
            // will receive a bogus clip area and caret will not get drawn properly.
            if (width <= 0)
            {
                width = getComponent().getWidth();
            }

            repaint(); // calls getComponent().repaint(x, y, width, height)
        }

        public void paint(Graphics g)
        {
            JTextComponent comp = getComponent();
            if (comp == null)
            {
                return;
            }

            int dot = getDot();
            Rectangle r;
            try
            {
                r = comp.modelToView(dot);
                if (r == null)
                {
                    return;
                }
            }
            catch (BadLocationException e)
            {
                return;
            }

            g.setColor(comp.getCaretColor());
            g.setXORMode(comp.getBackground()); // do this to draw in XOR mode

            int diam = r.height;
            if (isVisible())
            {
                g.fillRect(r.x, r.y, width, r.height); //, 12, 12);
            }
            width = diam / 2 + 2;
        }
    }

    /**
     *
     */
    public StreamingTextArea()
    {
        setCaret(new FancyCaret());
        inBuffer = new RingBuffer<>(128);
        outBuffer = new RingBuffer<>(128);
        in = new InStream(inBuffer);
        out = new OutStream(outBuffer);
        addKeyListener(this);
        startThread();
    }

    public final void startThread()
    {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     *
     * @return
     */
    public InputStream getInputStream()
    {
        return in;
    }

    public PrintStream getPrintStream()
    {
        return new PrintStream(out);
    }

    public DataInputStream getDataInputStream()
    {
        return new DataInputStream(in);
    }

    /**
     *
     * @return
     */
    public OutputStream getOutputStream()
    {
        return out;
    }

    private String getClipboard()
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipData = clipboard.getContents(clipboard);
        if (clipData != null)
        {
            try
            {
                if (clipData.isDataFlavorSupported(DataFlavor.stringFlavor))
                {
                    String s = (String) (clipData.getTransferData(
                            DataFlavor.stringFlavor));
                    return s;
                }
            }
            catch (Exception ufe)
            {
                System.err.println("Flavor unsupported: " + ufe);
            }
        }
        return null;
    }

    @Override
    public void paste()
    {
        super.paste();
        String s = getClipboard();
        for (int n = 0; n < s.length(); n++)
        {
            try
            {
                inBuffer.add(s.charAt(n));
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
        //System.out.println(s);
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        if (e.isControlDown())
        {
            return;
        }
        try
        {
            inBuffer.add(e.getKeyChar());
        }
        catch (InterruptedException ex)
        {
            System.out.println(ex);
        }
    }

    public void fakeIn(String s)
    {
        for (int n = 0; n < s.length(); n++)
        {
            try
            {
                inBuffer.add(s.charAt(n));
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
//        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE) 
//        {
//            try
//            {
//                inBuffer.add('\b');
//                //System.out.println("bs");
//            }
//            catch (InterruptedException ex)
//            {
//                System.out.println (ex);
//            }
//        }
    }

    public void destroy()
    {
        running = false;
        inBuffer.notifyAll();
        outBuffer.notifyAll();
        try
        {
            thread.join();
        }
        catch (InterruptedException ex)
        {
            System.out.println(ex);
        }
    }

    @Override
    public void run()
    {
        while (running)
        {
            try
            {
                append("" + outBuffer.remove());
                setCaretPosition(getDocument().getLength());
            }
            catch (InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
        System.out.println("Streaming input thread end");
    }
}
