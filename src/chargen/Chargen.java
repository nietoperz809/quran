/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chargen;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class Chargen
{
    private final HashMap<Character, Integer> map = new HashMap<>();
    private char pixel = 'O';
    private static int setbit = WHITE.getRGB();
    private static int clrbit = BLACK.getRGB();

    /**
     * Constructor that sets character as pixel
     *
     * @param pix
     */
    public Chargen(char pix)
    {
        this();
        pixel = pix;
    }

    /**
     * Constructor, fills the char map
     */
    public Chargen()
    {
        map.put('0', 0x980);
        map.put('1', 0x988);
        map.put('2', 0x990);
        map.put('3', 0x998);
        map.put('4', 0x9a0);
        map.put('5', 0x9a8);
        map.put('6', 0x9b0);
        map.put('7', 0x9b8);
        map.put('8', 0x9c0);
        map.put('9', 0x9c8);

        map.put('a', 0x808);
        map.put('b', 0x810);
        map.put('c', 0x818);
        map.put('d', 0x820);
        map.put('e', 0x828);
        map.put('f', 0x830);
        map.put('g', 0x838);
        map.put('h', 0x840);
        map.put('i', 0x848);
        map.put('j', 0x850);
        map.put('k', 0x858);
        map.put('l', 0x860);
        map.put('m', 0x868);
        map.put('n', 0x870);
        map.put('o', 0x878);
        map.put('p', 0x880);
        map.put('q', 0x888);
        map.put('r', 0x890);
        map.put('s', 0x898);
        map.put('t', 0x8a0);
        map.put('u', 0x8a8);
        map.put('v', 0x8b0);
        map.put('w', 0x8b8);
        map.put('x', 0x8c0);
        map.put('y', 0x8c8);
        map.put('z', 0x8d0);

        map.put('A', 0x008);
        map.put('B', 0x010);
        map.put('C', 0x018);
        map.put('D', 0x020);
        map.put('E', 0x028);
        map.put('F', 0x030);
        map.put('G', 0x038);
        map.put('H', 0x040);
        map.put('I', 0x048);
        map.put('J', 0x050);
        map.put('K', 0x058);
        map.put('L', 0x060);
        map.put('M', 0x068);
        map.put('N', 0x070);
        map.put('O', 0x078);
        map.put('P', 0x080);
        map.put('Q', 0x088);
        map.put('R', 0x090);
        map.put('S', 0x098);
        map.put('T', 0x0a0);
        map.put('U', 0x0a8);
        map.put('V', 0x0b0);
        map.put('W', 0x0b8);
        map.put('X', 0x0c0);
        map.put('Y', 0x0c8);
        map.put('Z', 0x0d0);

        map.put('[', 0x8d8);
        //map.put (); // Pound
        map.put(']', 0x8e8);
        map.put('^', 0x8f0);
        map.put(' ', 0x900);
        map.put('!', 0x908);
        map.put('"', 0x910);
        map.put('#', 0x918);
        map.put('$', 0x920);
        map.put('%', 0x928);
        map.put('&', 0x930);
        map.put('\'', 0x938);
        map.put('(', 0x940);
        map.put(')', 0x948);
        map.put('*', 0x950);
        map.put('+', 0x958);
        map.put(',', 0x960);
        map.put('-', 0x968);
        map.put('.', 0x970);
        map.put('/', 0x978);

        map.put('’', 39 * 8);
        map.put('‘', 39 * 8);
        map.put('”', 34 * 8);
        map.put('“', 34 * 8);
        map.put('–', 0x968);
        map.put(':', 58 * 8);
        map.put(';', 59 * 8);

    }

    private int getIndex(char c)
    {
        if (map.containsKey(c))
        {
            return map.get(c);
        }
        return 0x298;  // dummy heart
    }


    /**
     * Prints string array to bitmap
     *
     * @param img
     * @param arr
     * @param x
     * @param y
     */
    public void printImg(BufferedImage img, String[] arr, int x, int y)
    {
        for (String str : arr)
        {
            printImg(img, str, x, y);
            y += 8;
        }
    }

    /**
     * Prints String into bitmap
     *
     * @param img Destination bitmap
     * @param s String to print
     * @param x start position x
     * @param y start position y
     */
    public void printImg(BufferedImage img, CharSequence s, int x, int y)
    {
        int xstart = x;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '\n')
            {
                y += 8;
                x = xstart;
            }
            else
            {
                printImg(img, c, x, y);
                x += 8;
            }
        }
    }

    public void printImg(BufferedImage img, char c, int x, int y)
    {
        Image i = getImage(getIndex(c));
        Graphics g = img.getGraphics();
        g.drawImage(i, x, y, null);
    }

    public Image getImage(int idx)
    {
        BufferedImage img = new BufferedImage(8, 8, TYPE_INT_ARGB);
        for (int rows = 0; rows < 8; rows++)
        {
            int c = ChargenData.c64Chargen[idx++];
            int i = 128;
            for (int lines = 0; lines < 8; lines++)
            {
                if ((c & i) == i)
                {
                    img.setRGB(lines, rows, setbit);
                }
                else
                {
                    img.setRGB(lines, rows, clrbit);
                }
                i >>>= 1;
            }
        }
        return img;
    }
}
