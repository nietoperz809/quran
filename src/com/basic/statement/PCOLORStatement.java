package com.basic.statement;

import applications.PlotWindow;
import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

/**
 * Created by Administrator on 10/20/2016.
 */
public class PCOLORStatement extends Statement
{
    Expression _r;
    Expression _g;
    Expression _b;

    public PCOLORStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.PCOLOR);
        if (lt.getBuffer() != null)
        {
            parse(this, lt);
        }
    }

    private static void parse (PCOLORStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        s._r = s.getNumericArg(lt);
        s.checkComma(lt);
        s._g = s.getNumericArg(lt);
        s.checkComma(lt);
        s._b = s.getNumericArg(lt);
    }

    public String unparse ()
    {
        return "PCOLOR " + _r + "," + _g + "," + _b;
    }

    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        PlotWindow pw = PLOTStatement.getPlotWindow();
        if (pw != null)
        {
            pw.setColor((int) _r.value(pgm),
                    (int) _g.value(pgm),
                    (int) _b.value(pgm));
        }
        return pgm.nextStatement(this);
    }
}
