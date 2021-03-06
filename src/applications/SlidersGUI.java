package applications;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import misc.MDIChild;
import mixit.CapturePanel;
import mixit.Colorbox;
import mixit.HeadPanel;

/**
 * Created by IntelliJ IDEA. User: Administrator Date: 04.09.2008 Time: 00:48:36
 * To change this template use File | Settings | File Templates.
 */
public class SlidersGUI extends MDIChild implements Serializable, ActionListener
{
    public static final long serialVersionUID = 1L;
    
    public final HeadPanel two = new HeadPanel(this);
    public final Colorbox cb = new Colorbox(two);
    private static final int HEIGHTCONST = 400;
    private static final int WIDTHCONST = 800;
    //private static final int INTCONST = 100;

    /**
     *
     */
    public SlidersGUI()
    {
        setTitle("Mix it, baby! - Der lustige Farbmischer für die ganze Familie. - Jetzt auch mit Pixelgrabber!");
        setLayout(new BorderLayout(1, 1));
        add("North", two);
        add("Center", cb);
        add("South", new CapturePanel(two));
        setSize(SlidersGUI.WIDTHCONST, SlidersGUI.HEIGHTCONST);
        setBackground(Color.ORANGE);
        setVisible(true);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setOpaque(true);
    }
    
    private SlidersGUI(int x, int y)
    {
//        MenuBar m = new MenuBar();
//        Menu me = new Menu("Menu...");
//        me.add(new MenuItem("Noch'n Mixer"));
//        me.add(new MenuItem("-"));
//        me.add(new MenuItem("So geht's"));
//        m.add(me);
//        setMenuBar(m);
//        me.addActionListener(this);
//
//        addWindowListener(new WinCloser());
        this();
        setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Point pt = getLocation();
        if (null != e.getActionCommand())
        {
//            switch (e.getActionCommand())
//            {
//                case "Noch'n Mixer":
//                    new SlidersGUI(pt.x + 10, pt.y + 10);
//                    break;
//
//                case "So geht's":
//                    Dialog d = new Dialog(this, "...und so wird's gemacht", true);
//                    d.setBackground(Color.WHITE);
//                    d.setLocation(pt.x + SlidersGUI.INTCONST, pt.y + SlidersGUI.INTCONST);
//                    d.setLayout(new GridLayout(0, 1));
//                    d.addWindowListener(new WinCloser());
//                    d.add(new Label("Die Farbfelder C0, C1, C2 sind wählbar.", Label.CENTER));
//                    d.add(new Label("Die Farbe dieser Felder kann mit den Scrollbars (RGB) bzw. (HSV) eingestellt,",
//                            Label.CENTER
//                    )
//                    );
//                    d.add(new Label("oder es kann eine HTML-Farbe gewählt werden.", Label.CENTER));
//                    d.add(new Label("Die anderen Felder (C3...C8) zeigen das Ergebnis verschiedener Verknüpfungen.",
//                            Label.CENTER
//                    )
//                    );
//                    d.add(new Label("---------------------------------------------------------------------", Label.CENTER));
//                    d.add(new Label("C3: Additive Farbmischung von C0...C2.", Label.CENTER));
//                    d.add(new Label("C4: Subtraktive Farbmischung von C0...C2.", Label.CENTER));
//                    d.add(new Label("C5: Durchnittswerte der Felder C0...C2.", Label.CENTER));
//                    d.add(new Label("Die letzten drei Felder (C6, C7, C8) zeigen die Komplementärfarben von C3...C5",
//                            Label.CENTER
//                    )
//                    );
//                    d.add(new Label("---------------------------------------------------------------------", Label.CENTER));
//                    d.add(new Label(
//                            "Die Ergebnisfelder sind anklickbar d.h. die Farbwerte werden in die Controls übertragen,",
//                            Label.CENTER
//                    )
//                    );
//                    d.add(new Label("können aber nicht direkt verändert werden.", Label.CENTER));
//                    d.add(new Label("NEU: Duch 'Drag'n'Drop' des Feldes in der Ecke rechts unten kann", Label.CENTER));
//                    d.add(new Label("eine Bildschirmfarbe nach C0, C1 oder C2 geholt werden.", Label.CENTER));
//                    d.add(new Label("HAVE FUN....", Label.CENTER));
//                    d.pack();
//                    d.setVisible(true);
//                    break;
//            }
        }
    }

    @Override
    public Insets getInsets()
    {
        Insets i = super.getInsets();
        return new Insets(i.top + 1, i.left + 1, i.bottom + 1, i.right + 1);
    }

    public static void main(String[] args)
    {
        new SlidersGUI(10, 10);
    }

    @Override
    public void initAfterDeserialization()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
