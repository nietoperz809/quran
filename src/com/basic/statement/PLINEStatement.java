package com.basic.statement;

import applications.PlotWindow;
import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by Administrator on 10/21/2016.
 */
public class PLINEStatement extends Statement
{
    Expression _x1;
    Expression _y1;
    Expression _x2;
    Expression _y2;

    public PLINEStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.PLINE);
        if (lt.getBuffer() != null)
        {
            parse(this, lt);
        }
    }

    private static void parse (PLINEStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        s._x1 = s.getNumericArg(lt);
        s.checkComma(lt);
        s._y1 = s.getNumericArg(lt);
        s.checkComma(lt);
        s._x2 = s.getNumericArg(lt);
        s.checkComma(lt);
        s._y2 = s.getNumericArg(lt);
    }

    public String unparse ()
    {
        return keyword.name() + " " + _x1 + "," + _y1 + "," + _x2 + "," + _y2;
    }

    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        PlotWindow pw = PLOTStatement.makePlotWindow();
        if (pw != null)
        {
            int x1 = (int) _x1.value(pgm);
            int y1 = (int) _y1.value(pgm);
            int x2 = (int) _x2.value(pgm);
            int y2 = (int) _y2.value(pgm);

            pw.line(x1, y1, x2, y2);
        }
        return pgm.nextStatement(this);
    }
}
