package com.basic.statement;

import applications.PlotWindow;
import com.basic.*;
import misc.MainWindow;

import javax.swing.*;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by Administrator on 10/18/2016.
 */
public class PLOTStatement extends Statement
{
    Expression xval;
    Expression yval;

    //static private PlotWindow plotter;

    private static final ThreadLocal<PlotWindow> plotter =
            new ThreadLocal<PlotWindow>() {
                @Override protected PlotWindow initialValue() {
                    return null;
                }
            };

    public PLOTStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.PLOT);
        if (lt.getBuffer() != null)
        {
            parse(this, lt);
        }
    }

    private static void parse (PLOTStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        Token t;

        t = lt.nextToken();
        switch (t.typeNum())
        {
            case CONSTANT:
            case VARIABLE:
                lt.unGetToken();
                s.xval = ParseExpression.expression(lt);
                break;
            default:
                throw new BASICSyntaxError("xval must be constant or variable");
        }

        t = lt.nextToken();
        if (!t.isSymbol(','))
        {
            lt.unGetToken();
            throw new BASICSyntaxError("missing comma separator");
        }

        t = lt.nextToken();
        switch (t.typeNum())
        {
            case CONSTANT:
            case VARIABLE:
                lt.unGetToken();
                s.yval = ParseExpression.expression(lt);
                break;
            default:
                throw new BASICSyntaxError("yval must be constant or variable");
        }
    }

    public String unparse ()
    {
        return "PLOT " + xval + "," + yval;
    }

    private PlotWindow createPlotWindow()
    {
        plotter.remove();
        JInternalFrame ji = MainWindow.getInstance().createMDIChild (PlotWindow.class);
        ji.setTitle ("Basic plot window: "+Thread.currentThread().getName());
        plotter.set((PlotWindow)ji);
        return (PlotWindow)ji;
    }

    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        PlotWindow w = plotter.get();
        if (w == null)
        {
            w = createPlotWindow();
        }
        else if (!w.isVisible())
        {
            w = createPlotWindow();
        }

        int x = (int)xval.value(pgm);
        int y = (int)yval.value(pgm);

        w.plot (x,y);

        return pgm.nextStatement(this);
    }
}
