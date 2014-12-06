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
import static java.lang.System.out;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class Chargen
{
    private final HashMap<Character, Integer> map = new HashMap<>();
    private char pixel = 'O';
    
    /**
     * Constructor that sets character as pixel
     * @param pix 
     */
    public Chargen (char pix)
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
    }

    /**
     * Get 8 pixels as chars
     * @param idx index into charge table
     * @return char array of pixels in row
     */
    private char[] getRow(int idx)
    {
        char[] chrs =
        {
            ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ',
        };
        int c = ChargenData.c64Chargen[idx];
        int i = 128;
        for (int s = 0; s < 8; s++)
        {
            if ((c & i) == i)
            {
                chrs[s] = pixel;
            }
            i >>>= 1;
        }
        return chrs;
    }

    public void printChar (BufferedImage img, int idx, int x, int y)
    {
        Image i = getImage (idx);
        Graphics g = img.getGraphics();
        g.drawImage(i, x, y, null);
    }
    
    public Image getImage (int idx)
    {
        int setbit = BLACK.getRGB();
        int clrbit = WHITE.getRGB();
        BufferedImage img = new BufferedImage (8,8, TYPE_INT_ARGB);
        for (int rows = 0; rows<8; rows++)
        {
            int c = ChargenData.c64Chargen[idx++];
            int i = 128;
            for (int lines = 0; lines<8; lines++)
            {
                if ((c & i) == i)
                    img.setRGB (lines, rows, setbit);
                else
                    img.setRGB (lines, rows, clrbit);
                i >>>= 1;
            }
        }
        return img;
    }
    
    /**
     * Get all rows of a character
     * @param idx The starting index of a char
     * @return two dimensional array
     */
    private char[][] getRows(int idx)
    {
        char[][] res = new char[8][8];
        for (int s = 0; s < 8; s++)
        {
            res[s] = getRow(idx++);
        }
        return res;
    }
    
    /**
     * Get char as printable string
     * @param idx starting index
     * @return string that is the char
     */
    private String getCharAt(int idx)
    {
        StringBuilder out = new StringBuilder();
        for (int s = 0; s < 8; s++)
        {
            out.append(getRow(idx++)).append("\n");
        }
        return out.toString();
    }

    /**
     * Get multiple chars as printable String
     * @param chars
     * @return 
     */
    public String getLine(int... chars)
    {
        StringBuilder out = new StringBuilder();
        char[][][] all = new char[chars.length][8][8];
        for (int s = 0; s < chars.length; s++)
        {
            all[s] = getRows(chars[s]);
        }

        for (int r = 0; r < 8; r++)
        {
            for (int s = 0; s < chars.length; s++)
            {
                out.append(all[s][r]);
                out.append("  ");
            }
            out.append("\n");
        }

        return out.toString();
    }

    /**
     * Translates a string and then get it as big pixel string
     * @param in input string
     * @return output string
     */
    public String translatedLine(String in)
    {
        int[] idxs = new int[in.length()];

        for (int s = 0; s < in.length(); s++)
        {
            char c = in.charAt(s);
            if (map.containsKey(c))
                idxs[s] = map.get(c);
            else
                idxs[s] = 0x298;  // dummy heart
        }
        return getLine(idxs);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Chargen g = new Chargen('*');
        //System.out.println (getCharAt(0));
        //System.out.println (gtCharAt(8));
        //System.out.println (getCharAt(16));

        //System.out.println (getLine (0,8,16));
        //System.out.println (getLine (0x800+8,0x800+16,0x800+24));
        //System.out.println (translatedLine("HALLO b"));
        //System.out.println (translatedLine("0123456789"));
        out.println(g.translatedLine("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG"));
        out.println(g.translatedLine("the quick brown fox jumps over the lazy dog"));
        out.println(g.translatedLine("0123456789+-*/"));

        class PAN extends JPanel
        {
            Chargen g;
            
            PAN(Chargen g)
            {
                this.g = g;            
            }
            
            @Override
            public void paint (Graphics gra)
            {
                Image img = g.getImage(0x808);
                gra.drawImage(img, 10, 10, this);
            }
        }
        
        JFrame frame = new JFrame();
        JPanel pan = new PAN(g);
        frame.add (pan);
        frame.setSize(100, 100);
        frame.setVisible (true);
    }
    
}
