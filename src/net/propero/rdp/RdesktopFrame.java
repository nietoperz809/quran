package net.propero.rdp;

import javax.swing.JInternalFrame;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;

import net.propero.rdp.keymapping.KeyCode_FileBased;
import net.propero.rdp.rdp5.cliprdr.ClipChannel;

//import javax.swing.Box;
public class RdesktopFrame extends JInternalFrame
{
    private RdesktopCanvas canvas = null;

    /**
     * Register the clipboard channel
     *
     * @param c ClipChannel object for controlling clipboard mapping
     */
    public void setClip(ClipChannel c)
    {
        canvas.addFocusListener(c);
    }

    /**
     * Create a new RdesktopFrame. Size defined by Options.width and
     * Options.height Creates RdesktopCanvas occupying entire frame
     */
    public RdesktopFrame()
    {
        super();
        Common.frame = this;
        this.canvas = new RdesktopCanvas_Localised(Options.width, Options.height);
        add(this.canvas);
        setTitle ("RDP");

        canvas.requestFocus();
        this.setClosable(true);
        this.setResizable(true);
        this.setSize(Options.width, Options.height);

        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter()
        {
            @Override
            public void internalFrameClosing(InternalFrameEvent e)
            {
               Common.exit();
            }
        });
    }

    /**
     * Retrieve the canvas contained within this frame
     *
     * @return RdesktopCanvas object associated with this frame
     */
    public RdesktopCanvas getCanvas()
    {
        return this.canvas;
    }

    /**
     * Register the RDP communications layer with this frame
     *
     * @param rdp Rdp object encapsulating the RDP comms layer
     */
    public void registerCommLayer(Rdp rdp)
    {
        //this.rdp = rdp;
        canvas.registerCommLayer(rdp);
    }

    /**
     * Register keymap
     *
     * @param keys Keymapping object for use in handling keyboard events
     */
    public void registerKeyboard(KeyCode_FileBased keys)
    {
        canvas.registerKeyboard(keys);
    }

    /**
     * Notify the canvas that the connection is ready for sending messages
     */
    public void triggerReadyToSend()
    {
        this.show();
        canvas.triggerReadyToSend();
    }

}
