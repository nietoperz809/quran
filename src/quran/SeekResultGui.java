/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quran;

import applications.QuranGUI;
import misc.ComboBoxTools;

/**
 *
 * @author Administrator
 */
public class SeekResultGui extends javax.swing.JInternalFrame
{
    private QuranGUI m_source;

    /**
     * Creates new form SeekResultGui
     * @param q Master GUI
     * @param text String that is seeked for
     * @param res List of found positions
     */
    public SeekResultGui (QuranGUI q, String text, String[] res)
    {
        m_source = q;
        initComponents();
        this.setTitle(text);

        // Fill JList from String array
        ComboBoxTools.pollute (listControl, res);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listControl = new javax.swing.JList();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        setDoubleBuffered(true);
        setMinimumSize(new java.awt.Dimension(100, 300));
        setName(""); // NOI18N
        try
        {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1)
        {
            e1.printStackTrace();
        }
        setVisible(true);

        listControl.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        listControl.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                listControlMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listControl);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listControlMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_listControlMouseClicked
    {//GEN-HEADEREND:event_listControlMouseClicked
        String v = (String)(listControl.getSelectedValue());
        m_source.display(v);
    }//GEN-LAST:event_listControlMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listControl;
    // End of variables declaration//GEN-END:variables
}
