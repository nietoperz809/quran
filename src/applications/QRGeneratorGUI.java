/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import misc.ImageTools;
import misc.MDIChild;
import misc.PixelCanvas;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author Administrator
 */
public class QRGeneratorGUI extends MDIChild implements ActionListener
{
    private BufferedImage _img = null;
    
    /**
     * Object initializer
     */
    {
        initComponents();
    }
    
    /**
     * Creates new form QRGeneratorGUI
     */
    public QRGeneratorGUI()
    {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        makeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputField = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        sizeField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        canvas = new misc.QuadraticPixelCanvas();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("QR Maker");
        setVisible(true);

        jPanel1.setBackground(new java.awt.Color(255, 0, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 140));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        makeButton.setText("Make!");
        makeButton.addActionListener(this);
        jPanel1.add(makeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 7, -1, -1));

        inputField.setColumns(20);
        inputField.setRows(5);
        jScrollPane1.setViewportView(inputField);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 462, -1));

        jButton1.setText("To Clip");
        jButton1.addActionListener(this);
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 39, -1, -1));

        jButton2.setText("Tweet");
        jButton2.addActionListener(this);
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 71, -1, -1));

        jButton7.setBackground(new java.awt.Color(255, 255, 0));
        jButton7.setText("Save");
        jButton7.addActionListener(this);
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        sizeField.setText("200");
        jPanel1.add(sizeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 50, -1));

        jLabel1.setText("---- SIZE --->");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 80, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        canvas.setBackground(new java.awt.Color(255, 255, 102));
        canvas.setPreferredSize(new Dimension(100,100));
        canvas.setLayout(null);
        getContentPane().add(canvas, java.awt.BorderLayout.CENTER);

        pack();
    }

    // Code for dispatching events from components to event handlers.

    public void actionPerformed(java.awt.event.ActionEvent evt)
    {
        if (evt.getSource() == makeButton)
        {
            QRGeneratorGUI.this.makeButtonActionPerformed(evt);
        }
        else if (evt.getSource() == jButton1)
        {
            QRGeneratorGUI.this.jButton1ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton2)
        {
            QRGeneratorGUI.this.jButton2ActionPerformed(evt);
        }
        else if (evt.getSource() == jButton7)
        {
            QRGeneratorGUI.this.jButton7ActionPerformed(evt);
        }
    }// </editor-fold>//GEN-END:initComponents

    private boolean render()
    {
        try
        {
            String txt = inputField.getText();
            if (txt.isEmpty())
                return false;
            final int x = 800;
            final int y = 800;
            QRCodeWriter w = new QRCodeWriter();
            BitMatrix m = w.encode(txt, BarcodeFormat.QR_CODE, x, y);
            _img = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
            _img.createGraphics();
            Graphics2D graphics = (Graphics2D) _img.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, x, y);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < x; i++)
            {
                for (int j = 0; j < y; j++)
                {
                    if (m.get(i, j))
                    {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            ((PixelCanvas)canvas).setImage(_img);
        }
        catch (NumberFormatException | WriterException exception)
        {
            System.out.println(exception);
            return false;
        }    
        return true;
    }
    
    private void makeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_makeButtonActionPerformed
    {//GEN-HEADEREND:event_makeButtonActionPerformed
        if (render())
        {
            canvas.invalidate();
            canvas.repaint();
        }
    }//GEN-LAST:event_makeButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        ((PixelCanvas)canvas).toClipboard();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        ((PixelCanvas)canvas).tweet("hello");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton7ActionPerformed
    {//GEN-HEADEREND:event_jButton7ActionPerformed
        int newsize = Integer.parseInt(sizeField.getText());
        BufferedImage img2 = ImageTools.resizeImage(_img, newsize, newsize);
        ImageTools.saveImage(img2, false);
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel canvas;
    private javax.swing.JTextArea inputField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton makeButton;
    private javax.swing.JTextField sizeField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void initAfterDeserialization()
    {
        //
    }
}
