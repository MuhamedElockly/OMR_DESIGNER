/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprush;

import java.awt.Color;
import static java.lang.reflect.Array.set;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class PropertiesPanel extends javax.swing.JPanel {

    private Map<String, String> allProperties;
    private DrawPanel drawPanel;

    public PropertiesPanel() {
        initComponents();

        this.propertyJTable2.addRow("isStudent", new Boolean(true));
        this.propertyJTable2.addRow("Today", new Date());
        this.propertyJTable2.addRow("Today", new String());
        this.propertyJTable2.addRow("      X1", new Integer(0));
        this.propertyJTable2.addRow("      X2", new Integer(0));
        this.propertyJTable2.addRow("Today", new String[]{"Ahmed", "Mohamed"});
        this.propertyJTable2.addRow("Color", Color.yellow);
        this.propertyJTable2.addRow("Stroke Width ", new PropertyJTable.MiniMaxInt(5, 1, 100, 1));
        // this.propertyJTable2.setDrawPanel(this.getDrawPanel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        propertyJTable2 = new paintprush.PropertyJTable();

        setBackground(new java.awt.Color(204, 0, 51));
        setPreferredSize(new java.awt.Dimension(200, 50));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(0, 2, 5, 0));
        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(propertyJTable2);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
  private javax.swing.JScrollPane jScrollPane2;
    private PropertyJTable propertyJTable1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private paintprush.PropertyJTable propertyJTable2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the allProperties
     */
    public Map<String, String> getAllProperties() {
        return allProperties;
    }

    /**
     * @param allProperties the allProperties to set
     */
    public void setAllProperties(Map<String, String> allProperties) {
        this.allProperties = allProperties;
//        updateGUI();
    }
//    public void updateGUI(){
//        jPanel1.removeAll();
//         jPanel1.add(jLabel1);
//         jPanel1.setBackground(Color.white);
//        jPanel1.add(jLabel2);
//        Set<String> keys=allProperties.keySet();
//        
//        for(String key : keys){
//            String val =allProperties.get(key);
//             jPanel1.add(new JLabel(key));
//             jPanel1.add(new JTextField(val));
//        }
//      
//       jPanel1.revalidate();
//       // jPanel1.doLayout();
//        //jPanel1.validate();
//    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public void setDrawPanel(DrawPanel drawPanel) {

        this.drawPanel = drawPanel;
    }

    PropertyJTable getPropertyJTable1() {

        return propertyJTable2;
    }

    public void setPropertyJTable1(PropertyJTable propertyJTable1) {

        this.propertyJTable2 = propertyJTable1;
    }
}
