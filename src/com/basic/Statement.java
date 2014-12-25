package com.basic;

import com.basic.util.RedBlackTree;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;

/**
 * This class defines BASIC statements. As with expressions, there is a subclass
 * of Statement that does parsing called ParseStatement. This separation allows
 * the statement object to be half as large as it might otherwise be.
 *
 * The <i>execute</i> interface defines what the BASIC statements *do*. These
 * are all called by the containing <b>Program</b>.
 */
public abstract class Statement implements Ser
{

    /**
     * These are all of the statement keywords we can parse.
     */
    final static String keywords[] =
    {
        "*NONE*", "goto", "gosub", "return", "print",
        "if", "then", "end", "data", "restore", "read",
        "on", "rem", "for", "to", "next", "step", "gosub",
        "goto", "let", "input", "stop", "dim", "randomize",
        "tron", "troff", "timer", "cls", "sleep", "tweet",
        "seq", "sclr", "splay", "sspeed"
    };

    /**
     * This constants should match the indexes of the above keywords.
     */
    final static int NONE = 0; // invalid statement
    final static int GOTO = 1;
    final static int GOSUB = 2;
    final static int RETURN = 3;
    final static int PRINT = 4;
    final static int IF = 5;
    final static int THEN = 6;
    final static int END = 7;
    final static int DATA = 8;
    final static int RESTORE = 9;
    final static int READ = 10;
    final static int ON = 11;
    final static int REM = 12;
    final static int FOR = 13;
    final static int TO = 14;
    final static int NEXT = 15;
    final static int STEP = 16;
    final static int ON_GOSUB = 17;
    final static int ON_GOTO = 18;
    final static int LET = 19;
    final static int INPUT = 20;
    final static int STOP = 21;
    final static int DIM = 22;
    final static int RANDOMIZE = 23;
    final static int TRON = 24;
    final static int TROFF = 25;
    final static int TIMER = 26; // not a real statement
    final static int CLS = 27;
    final static int SLEEP = 28;
    final static int TWEET = 29;
    final static int SEQ = 30;
    final static int SCLR = 31;
    final static int SPLAY = 32;
    final static int SSPEED = 33;
    
    protected int keyword; // type of statement
    // type of statement
    protected int line;
    private String orig; // original string that was parsed into this statement.
    // original string that was parsed into this statement.

    Statement nxt;  // if there are chained statements
    protected RedBlackTree vars; // variables used by this statement.
    // variables used by this statement.

    /**
     * Construct a new statement object with a valid key.
     */
    protected Statement(int key)
    {
        keyword = key;
    }

    /**
     * This method does the actual statement execution. It works by calling the
     * abstract function 'doit' which is defined in each statement subclass. The
     * runtime error (if any) is caught so that the line number and statement
     * can be attached to the result and then it is re-thrown.
     */
    Statement execute(Program pgm, InputStream in, PrintStream out) throws BASICRuntimeError
    {
        Statement nxt = null;
        try
        {
            nxt = doit(pgm, in, out);
        }
        catch (BASICRuntimeError e)
        {
            throw new BASICRuntimeError(this, e.getMsg());
        }
        catch (Exception ex)
        {
            throw new BASICRuntimeError(this, "Java Error: "+ex.toString());
        }
        return nxt;
    }

    /**
     * Return a string representation of this statement. If the original text
     * was set then use that, otherwise reconstruct the string from the parse
     * tree.
     */
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("BASIC Statement :");
        if (orig != null)
        {
            sb.append(orig);
        }
        else
        {
            sb.append(unparse());
        }
        return sb.toString();
    }

    /**
     * Put a reference to the original string from which this statement was
     * parsed. this can be used for listing out the program in the native case
     * style of the user.
     */
    void addText(String t)
    {
        orig = t;
    }

    /**
     * Return the statement as a string.
     */
    String asString()
    {
        return orig;
    }

    /**
     * Update line number information in this statement. Used to determine the
     * next line to execute.
     */
    void addLine(int l)
    {
        line = l;
        if (nxt != null)
        {
            nxt.addLine(l);
        }
    }

    /**
     * Return this statements line number.
     */
    int lineNo()
    {
        return line;
    }

    /**
     * reconstruct the statement from the parse tree, this is most useful for
     * diagnosing parsing problems.
     */
    abstract String unparse();

    /**
     * This method "runs" this statement and returns a reference on the next
     * statement to run or null if there is no next statement.
     *
     * @throws BASICRuntimeError if there is a problem during statement
     * execution such as divide by zero etc.
     */
    abstract Statement doit(Program pgm, InputStream in, PrintStream out)
            throws BASICRuntimeError;

    /**
     * The trace method can be used during execution to print out what the
     * program is doing.
     */
    void trace(Program pgm, PrintStream ps)
    {
        StringBuilder sb = new StringBuilder();
        String n;
        sb.append("**:");

        if (vars == null)
        {
            vars = getVars();
        }

        /*
         * Print the line we're executing on the output stream.
         */
        n = line + "";
        for (int zz = 0; zz < 5 - n.length(); zz++)
        {
            sb.append(' ');
        }
        sb.append(n);
        sb.append(':');
        sb.append(unparse());
        ps.println(sb.toString());
        if (vars != null)
        {
            for (Enumeration e = vars.elements(); e.hasMoreElements();)
            {
                VariableExpression vi = (VariableExpression) e.nextElement();
                String t = null;
                try
                {
                    t = vi.stringValue(pgm);
                }
                catch (BASICRuntimeError bse)
                {
                    t = "Not yet defined.";
                }
                ps.println("        :" + vi.unparse() + " = " + (vi.isString() ? "\"" + t + "\"" : t));
            }
        }
    }

    /**
     * Can be overridden by statements that use variables in their execution.
     */
    RedBlackTree getVars()
    {
        return null;
    }
}
