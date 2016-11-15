package com.basic.statement;

import applications.PlotWindow;
import com.basic.*;

import java.io.InputStream;
import java.io.PrintStream;

public class PPRINTStatement extends Statement
{
    Expression _x;
    Expression _y;
    String _text;

    public PPRINTStatement (LexicalTokenizer lt) throws BASICSyntaxError
    {
        super(KeyWords.PPRINT);
        if (lt.getBuffer() != null)
        {
            parse(this, lt);
        }
    }

    private static void parse (PPRINTStatement s, LexicalTokenizer lt) throws BASICSyntaxError
    {
        s._x= s.getNumericArg(lt);
        s.checkComma(lt);
        s._y = s.getNumericArg(lt);
        s.checkComma(lt);
        s._text = s.getStringArg(lt);
    }

    public String unparse ()
    {
        return keyword.name() + " " + _x + "," + _y + "," + _text;
    }

    public Statement doit (Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        PlotWindow pw = PLOTStatement.makePlotWindow();
        pw.print((int)_x.value(pgm), (int)_y.value(pgm), _text);
        return pgm.nextStatement(this);
    }
}
