package twittools;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class StringDivider
{
    private final String source;
    private int maxlen;
    
    public String[] divideWords()
    {
        List<String> list = new ArrayList<>();
        String[] ss = source.split(" ");
        
        String n = new String();
        for (String s : ss)
        {
            n = n + s + " ";
            if (n.length() >= maxlen)
            {
                list.add(n);
                n = new String();
            }    
        }
        if (n.length() != 0)
            list.add(n);
        
        int elem = list.size();
        int cnt = 0;
        String[] arr = new String[elem];
        if (elem == 1)
        {
            return new String[]{list.get(0)};
        }
        for (String s : list)
        {
            arr[cnt] = (cnt+1) + "/" + elem + " " + s;
            cnt++;
        }
        return arr;
    }
    
    String[] divideChars()
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
        return split (source, maxlen);
    }
    
    StringDivider (String s, int l)
    {
        maxlen = l;
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

    public static final String islamText
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

    
    static void test()
    {

        StringDivider sd = new StringDivider (islamText, 120);
        //String[] r = sd.divideChars();
        //DebugTools.printStringArray(r);
        
        String[] ls = sd.divideWords();
        DebugTools.printStringArray(ls);
    }
}
