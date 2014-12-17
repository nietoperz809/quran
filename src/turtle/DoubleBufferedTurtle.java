/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

import static java.awt.Color.WHITE;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import static java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_BYTE_BINARY;

/**
 * Double buffered Turtle
 * @author Administrator
 */
public class DoubleBufferedTurtle extends Turtle
{
    private final GraphicsConfiguration gconf = getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();

    /**
     * Off-screen image used as canvas
     */
    private BufferedImage offImg;
    
    public BufferedImage getImage()
    {
        return offImg;
    }
    
    /**
     * Must be called at end of drawing/moving the turtle
     * @param g
     * @throws Exception 
     */
    @Override
    public void execute(Graphics g) throws Exception
    {
        super.drawTurtleSteps(offImg.getGraphics());
        super.execute(g);
    }
    
    /**
     * Constructor taking width/height of image
     * @param width Width
     * @param height Height
     */
    public DoubleBufferedTurtle(int width, int height)
    {
        super(width, height);
        //offImg = gconf.createCompatibleImage(width, height);
        //offImg = TwitTools.thresholdImage(offImg, 128);
        offImg = new BufferedImage (width, 
                height, TYPE_BYTE_BINARY);
        penColor = WHITE;
    }

    /**
     * Overridden function that draws image to screen
     * @param g Graphics context
     */
    @Override
    public void paint(Graphics g)
    {
        Dimension d = this.getSize();
        g.drawImage(offImg, 0, 0, d.width, d.height, this);
    }
    
    /**
     * Overridden and empty to prevent unnecessary background clearing
     * @param g Graphics context
     */
    @Override
    public void update (Graphics g)
    {
        
    }
}
