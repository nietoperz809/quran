/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

import misc.ImageTools;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Double buffered Turtle
 * @author Administrator
 */
public class DoubleBufferedTurtle extends Turtle
{
    private final GraphicsConfiguration gconf = GraphicsEnvironment
            .getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .getDefaultConfiguration();

    /**
     * Off-screen image used as canvas
     */
    private final BufferedImage origImage;
    private BufferedImage resizedImage;

    /**
     * Must be called at end of drawing/moving the turtle
     * @throws Exception
     */
    @Override
    public void execute(Graphics g) throws Exception
    {
        super.drawTurtleSteps(origImage.getGraphics());
        super.execute(g);
    }

    public void scale (float x)
    {
        int nx = (int) (origImage.getWidth()*x);
        int ny = (int) (origImage.getHeight()*x);
        resizedImage = ImageTools.resizeImage(origImage, nx, ny);
    }
    
    /**
     * Constructor taking width/height of image
     * @param width Width
     * @param height Height
     */
    public DoubleBufferedTurtle(int width, int height)
    {
        super(width, height);
        origImage = gconf.createCompatibleImage(width, height);
        penColor = Color.WHITE;
    }

    public BufferedImage getImage ()
    {
        return origImage;
    }
    public BufferedImage getResizedImage ()
    {
        if (resizedImage == null)
            return origImage;
        return resizedImage;
    }

    /**
     * Overridden function that draws image to screen
     * @param g Graphics context
     */
    @Override
    public void paint(Graphics g)
    {
        g.drawImage(getResizedImage(), 0, 0, this);
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
