/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle;

/**
 *
 * @author Administrator
 */
public class LindenView extends javax.swing.JInternalFrame
{

    /**
     * Creates new form LindenView
     */
    public LindenView()
    {
        initComponents();
    }
    
    /**
     * Get embedded Turtle
     * @return 
     */
    public Turtle getTurtle()
    {
        return (Turtle)turtle;
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

        turtle = new DoubleBufferedTurtle(500,500);

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);

        turtle.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout turtleLayout = new javax.swing.GroupLayout(turtle);
        turtle.setLayout(turtleLayout);
        turtleLayout.setHorizontalGroup(
            turtleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        turtleLayout.setVerticalGroup(
            turtleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(turtle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(turtle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel turtle;
    // End of variables declaration//GEN-END:variables
}
