package applications;

import chargen.Chargen;
import misc.MDIChild;
import misc.PixelCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Administrator on 10/18/2016.
 */
public class PlotWindow extends MDIChild
{
    private JPanel mainpanel;
    private PixelCanvas pixelcanvas;
    private JButton button1;
    private JButton wipeButton;

    private BufferedImage off_Image;
    private Graphics2D g2;
    private Color col;

    private final int imgWidth = 1024;
    private final int imgHeight = 1024;

    public void setColor (Color c)
    {
        col = c;
        g2.setColor(col);
    }

    public void setColor (int r, int g, int b)
    {
        setColor(new Color(r, g, b));
    }

    public void clear ()
    {
        off_Image = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        g2 = off_Image.createGraphics();
        getPixelCanvas().setImage(off_Image);
    }

    public void print (int x, int y, String txt)
    {
        Chargen.getInstance().printImg(off_Image, txt, x, y);
        getPixelCanvas().setImage(off_Image);
    }

    public void circle (int x, int y, int radius)
    {
        g2.drawOval(x, y, radius, radius);
        getPixelCanvas().setImage(off_Image);
    }

    public void square (int x, int y, int width)
    {
        g2.drawRect(x, y, width, width);
        getPixelCanvas().setImage(off_Image);
    }

    public void line (int x1, int y1, int x2, int y2)
    {
        g2.drawLine(x1, y1, x2, y2);
        getPixelCanvas().setImage(off_Image);
    }

    public void plot (int x, int y)
    {
        g2.drawRect(x, y, 1, 1);
        getPixelCanvas().setImage(off_Image);
    }

    public PlotWindow ()
    {
        super();
        $$$setupUI$$$();
        getContentPane().add(mainpanel, BorderLayout.CENTER);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Plot Window: " + Thread.currentThread().getId());
        setSize(600, 650);
        setVisible(true);
        button1.addActionListener(e -> pixelcanvas.toClipboard());
        wipeButton.addActionListener(e -> this.clear());
    }

    public PixelCanvas getPixelCanvas ()
    {
        return pixelcanvas;
    }

    @Override
    public void initAfterDeserialization ()
    {

    }

    private void createUIComponents ()
    {
        pixelcanvas = new PixelCanvas();
        pixelcanvas.setOpaque(true);
        pixelcanvas.setDoubleBuffered(true);
        pixelcanvas.setBackground(Color.black);
        pixelcanvas.setLayout(null);
        pixelcanvas.setSize(100, 100);
        pixelcanvas.setVisible(true);
        clear();
        setColor(Color.white);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$ (String fontName, int style, int size, Font currentFont)
    {
        if (currentFont == null)
        {
            return null;
        }
        String resultName;
        if (fontName == null)
        {
            resultName = currentFont.getName();
        }
        else
        {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1'))
            {
                resultName = fontName;
            }
            else
            {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$ ()
    {
        createUIComponents();
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(0, 0));
        mainpanel.setForeground(new Color(-16777216));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel1.setBackground(new Color(-502703));
        panel1.setMinimumSize(new Dimension(100, 100));
        panel1.setPreferredSize(new Dimension(100, 30));
        panel1.setRequestFocusEnabled(true);
        mainpanel.add(panel1, BorderLayout.SOUTH);
        panel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), null));
        button1 = new JButton();
        button1.setActionCommand("toClip");
        button1.setLabel("toClip");
        button1.setPreferredSize(new Dimension(81, 20));
        button1.setText("toClip");
        panel1.add(button1);
        wipeButton = new JButton();
        wipeButton.setPreferredSize(new Dimension(81, 20));
        wipeButton.setText("wipe");
        panel1.add(wipeButton);
        pixelcanvas.setToolTipText("Graphics Window");
        mainpanel.add(pixelcanvas, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$ ()
    {
        return mainpanel;
    }
}
