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
    private static final ThreadLocal<PlotWindow> plotter =
            new ThreadLocal<PlotWindow>()
            {
                @Override
                protected PlotWindow initialValue ()
                {
                    return null;
                }
            };

    public static PlotWindow getPlotWindow()
    {
        return plotter.get();
    }

    Expression xval;
    Expression yval;

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
        s.xval = s.getNumericArg(lt);
        s.checkComma(lt);
        s.yval = s.getNumericArg(lt);
    }

    public String unparse ()
    {
        return keyword.name() + " " + xval + "," + yval;
    }

    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        PlotWindow w = makePlotWindow();

        int x = (int) xval.value(pgm);
        int y = (int) yval.value(pgm);

        w.plot(x, y);

        return pgm.nextStatement(this);
    }

    public static PlotWindow makePlotWindow()
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
        return w;
    }

    private static PlotWindow createPlotWindow ()
    {
        plotter.remove();
        JInternalFrame ji = MainWindow.getInstance().createMDIChild(PlotWindow.class);
        ji.setTitle("Basic plot window: " + Thread.currentThread().getName());
        plotter.set((PlotWindow) ji);
        return (PlotWindow) ji;
    }
}
