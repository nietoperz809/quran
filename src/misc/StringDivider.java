package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to split string into array of strings which elements do not exceed a
 * specified length
 *
 * @author Administrator
 */
public class StringDivider
{
    private final String source;
    private int maxlen;

    /**
     * Splits string by Words
     *
     * @return Generated string array
     */
    public String[] splitByWords()
    {
        List<String> list = new ArrayList<>();
        String[] ss = source.split("\\s+");
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < ss.length; i++)
        {
            String s = ss[i] + " ";
            int before = n.length();
            n.append(s);
            if (n.length() > maxlen)
            {    
                i--;
                n.delete(before-1, n.length());
                list.add(n.toString());
                n = new StringBuilder();
            }
        }
        if (n.length() != 0)
        {
            list.add(n.toString());
        }

        int elem = list.size();
        int cnt = 0;
        String[] arr = new String[elem];
        if (elem == 1)
        {
            return new String[]
            {
                list.get(0)
            };
        }
        for (String s : list)
        {
            arr[cnt] = (cnt + 1) + "/" + elem + " " + s;
            cnt++;
        }
        return arr;
    }

    /**
     * Splits by Characters
     *
     * @return Generated string array
     */
    public String[] splitByChars()
    {
        int len = source.length();
        int minlen = maxlen / 2;
        while (true)
        {
            if (len % maxlen >= minlen)
            {
                break;
            }
            maxlen--;
            if (maxlen == 1)
            {
                break;
            }
        }
        return split(source, maxlen);
    }

    /**
     * Constructor
     *
     * @param s Source string
     * @param l Max length of one output string
     */
    public StringDivider(String s, int l)
    {
        maxlen = l;
        source = s;
    }
    
    /**
     * Constructor for Twitter
     * @param s String that is divided in ~140's parts
     */
    public StringDivider (String s)
    {
        maxlen = 130;
        source = s;
    }

    private String[] split(String src, int len)
    {
        int num = (int) Math.ceil((double) src.length() / (double) len);
        String[] result = new String[num];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = (i + 1) + "/" + num + " "
                    + src.substring(i * len, Math.min(src.length(), (i + 1) * len));
        }
        return result;
    }

    /**
     * Test function
     *
     * @param args
     */
    public static void main(String[] args)
    {
        final String islamText
                = "Oh mankind! Listen well to what I say. I do not know whether I will ever meet you again at "
                + "this place after this year. Behold! all practices of paganism and ignorance are now under my "
                + "feet. The blood-revenge of the Days of Ignorance are remitted. Usury is forbidden."
                + "It is unlawful for you to shed the blood of one another or unlawfully take the fortunes of one "
                + "another. They are as unlawful as shedding blood on such a day as today and in such a month "
                + "as this sacred month and in such a sanctified city as this sacred city. "
                + "The weak amongst you, feed them on what you eat, dress them as you are dressed. You will "
                + "meet your God and He will call you to account for your actions."
                + "Let those who are present warn those who are absent. You are all descended from Adam "
                + "and the best of you are those who best regard God. "
                + "Think deeply about what I say, let all your feuds be abolished, you must know that every "
                + "Muslim is brother of every other Muslim, and all Muslims are brothers, one to another. "
                + "Between Muslims there are no races and no tribes. "
                + "You must not take anything from your brother except what is given freely. Don’t oppress "
                + "and don’t be oppressed. "
                + "Oh my people, I am but a man it may be that the Angel of Death will visit me soon, and "
                + "death will overtake me. But I have left you a book, revealed by God, the Quran, which is "
                + "light and guidance. "
                + "This day, I have perfected your religion to you and completed my favor to you. And have "
                + "chosen for you Islam as your religion.";

        String txt2 = "cl class\n"
                + "cn continue\n"
                + "db double\n"
                + "df default:\n"
                + "dowhile do {\n"
                + "} while (condition);\n"
                + "eq equals\n"
                + "ex extends\n"
                + "fa false\n"
                + "fcom // <editor-fold></editor-fold>\n"
                + "fi final\n"
                + "fl float\n"
                + "forc for (Iterator it = collection.iterator();\n"
                + "it.hasNext();) {\n"
                + "Object elem = (Object) it.next();\n"
                + "}\n"
                + "fore for (Object elem : iterable) {\n"
                + "}\n"
                + "fori for (int i = 0; i < arr.length; i++) {}\n"
                + "forl for (int i = 0; i < lst.size(); i++) {\n"
                + "Object object = lst.get(i); }\n"
                + "forst for (StringTokenizer st = new\n"
                + "StringTokenizer(\"\"); st.hasMoreTokens();) }\n"
                + "forv for (int i = 0; i < vct.size(); i++) {\n"
                + "Object object = vct.elementAt(i);}\n"
                + "fy finally{ |}\n"
                + "ie interface\n"
                + "ifelse if (condition){}else {\n"
                + "}\n"
                + "iff if (exp) {}\n"
                + "im implements\n"
                + "inst if (exp instanceof Object) {\n"
                + "Object obj = (Object) exp;\n"
                + "iof instanceof\n"
                + "ir import\n"
                + "le length\n"
                + "na native\n"
                + "newo Object name = new Object(args);\n"
                + "pe protected\n"
                + "pr private\n"
                + "psf private static final\n"
                + "psfb private static final boolean\n"
                + "psfi private static final int\n"
                + "psfs private static final String\n"
                + "pst printStackTrace();\n"
                + "psvm public static void main(String[] args){\n"
                + "}\n"
                + "pu public\n"
                + "re return\n"
                + "runn Runnable runnable = new Runnable() {\n"
                + "public void run() {}};\n"
                + "serr System.err.println (\"|\");\n"
                + "sh short\n"
                + "sout System.out.println (\"|\");\n"
                + "soutv System.out.println(\"Object = \" + Object);\n"
                + "st static\n"
                + "su super\n"
                + "sw switch (var) { case val: break;\n"
                + "default: throw new AssertionError();}\n"
                + "sy synchronized\n"
                + "tds Thread.dumpStack();\n"
                + "th throws\n"
                + "tr transient\n"
                + "trycatch try {}\n"
                + "catch (Exception e) {}\n"
                + "tw throw\n"
                + "vo volatile\n"
                + "wh while (\n"
                + "whileit while (it.hasNext()) {\n"
                + "Object elem = (Object) it.next();}\n"
                + "whilen while (en.hasMoreElements()) {\n"
                + "Object elem = (Object) en.nextElement();}\n"
                + "whilexp while (exp) {}\n"
                + "JSP Editor Code Templates\n"
                + "ag application.getAttribute(\"|\")\n"
                + "ap application.putAttribute(\"|\",)\n"
                + "ar application.removeAttribute(\"|\")\n"
                + "cfgi config.getInitParameter(\"|\")\n"
                + "jspf <jsp:forward page=\"|\"/>\n"
                + "jspg <jsp:getProperty name=\"|\"\n"
                + "property=\"\" />\n"
                + "jspi <jsp:include page=\"|\"/>\n"
                + "jspp <jsp:plugin type=\"|\" code=\"\"\n"
                + "codebase=\"\"></jsp:plugin>\n"
                + "jsps <jsp:setProperty name=\"|\" property=\"\"/>\n"
                + "jspu <jsp:useBean id=\"I\" type=\"\"/>\n"
                + "oup out.print(\"|\")\n"
                + "oupl out.println(\"|\")\n"
                + "pcg pageContext.getAttribute(\"|\")\n"
                + "pcgn pageContext.getAttributeNamesInScope(\"|\")\n"
                + "pcgs pageContext.getAttributesScope(\"|\")\n"
                + "pcr pageContext.removeAttribute(\"|\")\n"
                + "pcs pageContext.setAttribute(\"|\",)\n"
                + "pg <%@page |%>\n"
                + "pga <%@page autoFlush=\"false\"%>\n"
                + "pgb <%@page buffer=\"|kb\"%>\n"
                + "pgc <%@page contentType=\"|\"%>\n"
                + "pgerr <%@page errorPage=\"|\"%>\n"
                + "pgex <%@page extends=\"|\"%>\n"
                + "pgie <%@page isErrorPage=\"true\"%>\n"
                + "pgim <%@page import=\"|\"%>\n"
                + "pgin <%@page info=\"|\"%>\n"
                + "pgit <%@page isThreadSafe=\"false\"%>\n"
                + "pgl <%@page language=\"java\"%>\n"
                + "pgs <%@page session=\"false\"%>\n"
                + "rg request.getParameter(\"|\")\n"
                + "sg session.getAttribute(\"|\")\n"
                + "sp session.setAttribute(\"|\", )\n"
                + "sr session.removeAttribute(\"|\")\n"
                + "tglb <%@";

        StringDivider sd = new StringDivider(txt2, 130); //max 138 chars
        //String[] r = sd.splitByChars();
        //DebugTools.printStringArray(r);

        String[] ls = sd.splitByWords();
        Tools.printStringArray(ls);
    }
}
