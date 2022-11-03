
package paintprush;

import java.awt.BorderLayout;
import java.awt.Color;


public final class ColorPanel extends javax.swing.JPanel {

    
    public Color getColorOfPanel() {
        return colorOfPanel;
    }

   
    public void setColorOfPanel(Color colorOfPanel) {
        if (colorOfPanel == null) {
            setBackground(Color.BLACK);

        } else {
            this.colorOfPanel = colorOfPanel;
            setBackground(getColorOfPanel());
        }

    }

  
    public ColorPanel() {

        initComponents();

        if (colorOfPanel == null) {
            setBackground(Color.BLACK);
        }
      
        setBounds(0, 0, 50, 50);
        setLayout(new BorderLayout());

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private Color colorOfPanel = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
