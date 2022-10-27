package paintprush;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ColorPicker;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PaintPrushFram extends javax.swing.JFrame {

    public PaintPrushFram() {

        initComponents();

        this.drawPanel2.setToolPanel(this.toolsPanel1);
        this.drawPanel2.setPropertiesPanel(propertiesPanel2);
        this.jToolBar1.setBackground(Color.red);
        this.strokeColor1.setBackground(Color.BLACK);
        this.shapesColor1.setBackground(Color.CYAN);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        drawPanel2 = new paintprush.DrawPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButtonNonColor = new javax.swing.JButton();
        jButtonColor = new javax.swing.JButton();
        shapesColor1 = new paintprush.ShapesColor();
        jButtonColorPicker = new javax.swing.JButton();
        jButtonNonStrokeColor = new javax.swing.JButton();
        jButtonStrokeColor = new javax.swing.JButton();
        strokeColor1 = new paintprush.StrokeColor();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        propertiesPanel2 = new paintprush.PropertiesPanel();
        toolsPanel1 = new paintprush.ToolsPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSave = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Edit");
        jMenuBar1.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBackground(new java.awt.Color(255, 51, 51));
        jToolBar1.setForeground(new java.awt.Color(255, 0, 51));
        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonNonColor.setText("Non Color");
        jButtonNonColor.setFocusable(false);
        jButtonNonColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNonColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNonColorActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNonColor);

        jButtonColor.setText("color");
        jButtonColor.setFocusable(false);
        jButtonColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonColor.setPreferredSize(new java.awt.Dimension(55, 53));
        jButtonColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonColor);

        shapesColor1.setBackground(new java.awt.Color(255, 153, 153));
        shapesColor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        shapesColor1.setMaximumSize(new java.awt.Dimension(33, 33));
        shapesColor1.setMinimumSize(new java.awt.Dimension(33, 33));
        shapesColor1.setPreferredSize(new java.awt.Dimension(33, 33));

        javax.swing.GroupLayout shapesColor1Layout = new javax.swing.GroupLayout(shapesColor1);
        shapesColor1.setLayout(shapesColor1Layout);
        shapesColor1Layout.setHorizontalGroup(
            shapesColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        shapesColor1Layout.setVerticalGroup(
            shapesColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jToolBar1.add(shapesColor1);

        jButtonColorPicker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/ColorPicker.png"))); // NOI18N
        jButtonColorPicker.setFocusable(false);
        jButtonColorPicker.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonColorPicker.setMinimumSize(new java.awt.Dimension(53, 53));
        jButtonColorPicker.setPreferredSize(new java.awt.Dimension(53, 53));
        jButtonColorPicker.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonColorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonColorPickerActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonColorPicker);

        jButtonNonStrokeColor.setText("Non Stroke");
        jButtonNonStrokeColor.setFocusable(false);
        jButtonNonStrokeColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonNonStrokeColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonNonStrokeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNonStrokeColorActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonNonStrokeColor);

        jButtonStrokeColor.setText("Stroke color");
        jButtonStrokeColor.setFocusable(false);
        jButtonStrokeColor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonStrokeColor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonStrokeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStrokeColorActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonStrokeColor);

        strokeColor1.setBackground(new java.awt.Color(51, 51, 255));
        strokeColor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        strokeColor1.setMaximumSize(new java.awt.Dimension(33, 33));
        strokeColor1.setMinimumSize(new java.awt.Dimension(33, 33));
        strokeColor1.setPreferredSize(new java.awt.Dimension(33, 33));

        javax.swing.GroupLayout strokeColor1Layout = new javax.swing.GroupLayout(strokeColor1);
        strokeColor1.setLayout(strokeColor1Layout);
        strokeColor1Layout.setHorizontalGroup(
            strokeColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );
        strokeColor1Layout.setVerticalGroup(
            strokeColor1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        jToolBar1.add(strokeColor1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("  Stroke   ");
        jToolBar1.add(jLabel1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "4", "6", "8", "10", "12", "16", "20", "25" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.setMaximumSize(new java.awt.Dimension(32, 32));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jComboBox1);

        javax.swing.GroupLayout drawPanel2Layout = new javax.swing.GroupLayout(drawPanel2);
        drawPanel2.setLayout(drawPanel2Layout);
        drawPanel2Layout.setHorizontalGroup(
            drawPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, drawPanel2Layout.createSequentialGroup()
                .addComponent(toolsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(propertiesPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        drawPanel2Layout.setVerticalGroup(
            drawPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drawPanel2Layout.createSequentialGroup()
                .addComponent(propertiesPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(drawPanel2Layout.createSequentialGroup()
                .addGroup(drawPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jToolBar1.getAccessibleContext().setAccessibleParent(this);

        getContentPane().add(drawPanel2, java.awt.BorderLayout.CENTER);

        jMenuBar2.setBackground(new java.awt.Color(255, 51, 51));
        jMenuBar2.setPreferredSize(new java.awt.Dimension(60, 40));

        jMenu2.setBackground(new java.awt.Color(255, 51, 51));
        jMenu2.setText("File");

        jMenuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemOpen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItemOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Open.png"))); // NOI18N
        jMenuItemOpen.setText("Open...");
        jMenuItemOpen.setPreferredSize(new java.awt.Dimension(239, 54));
        jMenuItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOpenActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemOpen);

        jMenuItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSave.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/save 32.png"))); // NOI18N
        jMenuItemSave.setText("Save...");
        jMenuItemSave.setPreferredSize(new java.awt.Dimension(239, 54));
        jMenuItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSaveActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSave);

        jMenuItemExit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jMenuItemExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Exit.png"))); // NOI18N
        jMenuItemExit.setText("Exit");
        jMenuItemExit.setPreferredSize(new java.awt.Dimension(239, 54));
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemExit);

        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    File defaultFolder = null;
    private void jMenuItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSaveActionPerformed
        JFileChooser fc = new JFileChooser();
        FileFilter fileFilterPng = new FileNameExtensionFilter("png Image FIle", "png");
        FileFilter fileFilterSVG = new FileNameExtensionFilter("SVG Image FIle", "svg");
        //   fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setCurrentDirectory(defaultFolder);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.addChoosableFileFilter(fileFilterPng);
        fc.addChoosableFileFilter(fileFilterSVG);
        fc.setAcceptAllFileFilterUsed(true);
        int response = fc.showSaveDialog(this);

        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fc.getSelectedFile();
            defaultFolder = fc.getCurrentDirectory();
            String fileName = selectedFile.getAbsolutePath();
            if (fc.getFileFilter() == fileFilterPng) {
                if (!fileName.toLowerCase().endsWith(".png")) {
                    fileName += ".png";
                }
                boolean res = drawPanel2.saveAsPng(fileName);
                if (res == false) {
                    JOptionPane.showMessageDialog(this, "File Can't Be Saved ", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            } else if (fc.getFileFilter() == fileFilterSVG) {
                if (!fileName.toLowerCase().endsWith(".svg")) {
                    fileName += ".svg";
                }
                boolean res = drawPanel2.saveAsSVG(fileName);
                if (res == false) {
                    JOptionPane.showMessageDialog(this, "File Can't Be Saved ", "Error Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        fc.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY,
                new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                File currentFolder = (File) e.getNewValue();
                if (!currentFolder.equals(defaultFolder)) {
                    fc.setCurrentDirectory(defaultFolder);
                }
            }
        });

    }//GEN-LAST:event_jMenuItemSaveActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOpenActionPerformed
      
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//
//                new PaintPrushFram().setVisible(true);
//
//            }
//        });
        JFileChooser fc = new JFileChooser();
        //   FileFilter fileFilterPng = new FileNameExtensionFilter("png Image FIle", "png");
        FileFilter fileFilterSVG = new FileNameExtensionFilter("SVG Image FIle", "svg");
        //   fc.setCurrentDirectory(new File(System.getProperty("user.home")));
        fc.setCurrentDirectory(defaultFolder);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //   fc.addChoosableFileFilter(fileFilterPng);
        fc.addChoosableFileFilter(fileFilterSVG);
        fc.setAcceptAllFileFilterUsed(true);
        int response = fc.showSaveDialog(this);

        File file;
        String fileName = "";
        if (response == JFileChooser.APPROVE_OPTION) {
            file = new File(fc.getSelectedFile().getAbsolutePath());
            fileName = file.getAbsolutePath();
            if (fc.getFileFilter() == fileFilterSVG) {
                if (!fileName.toLowerCase().endsWith(".svg")) {
                    fileName += ".svg";
                }
            }
            //   System.out.println(fileName);
            ArrayList<Shape> allShapes = Utility.loadSVG(fileName, drawPanel2);
            //   ArrayList<Shape> allShapes = Utility.loadSVG("C:\\Users\\dell\\Desktop\\Image\\test\\pubbleSheet\\FinalBuppleSheet.svg");
            drawPanel2.allShapes.clear();
            drawPanel2.allShapes.addAll(allShapes);
            drawPanel2.repaint();

        }

// ArrayList<Shape> allShapes = Utility.loadSVG(fileName);
//            //   ArrayList<Shape> allShapes = Utility.loadSVG("C:\\Users\\dell\\Desktop\\Image\\test\\pubbleSheet\\FinalBuppleSheet.svg");
//
//            drawPanel2.allShapes.addAll(allShapes);
//            drawPanel2.repaint();
        fc.addPropertyChangeListener(JFileChooser.DIRECTORY_CHANGED_PROPERTY,
                new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                File currentFolder = (File) e.getNewValue();
                if (!currentFolder.equals(defaultFolder)) {
                    fc.setCurrentDirectory(defaultFolder);
                }
            }
        });
        drawPanel2.copyHistory();
    }//GEN-LAST:event_jMenuItemOpenActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // this.jComboBox1.removeAllItems();
        String value = this.jComboBox1.getSelectedItem().toString();
        int strokeValue = Integer.parseInt(value);
        this.drawPanel2.stokeValue = strokeValue;
        if (drawPanel2.getSelectedShape() != null) {
            drawPanel2.getSelectedShape().nonStroke = false;
            if (strokeValue != drawPanel2.getSelectedShape().getStroke()) {
                drawPanel2.getSelectedShape().setStroke(strokeValue);
                drawPanel2.copyHistory();
            }
            drawPanel2.repaint();
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed
    //ShapesColor shapeColor;
    private void jButtonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorActionPerformed
        JColorChooser colorchoser = new JColorChooser();

        Color temp = drawPanel2.currentColor;
        Color color = JColorChooser.showDialog(this, "Pick A Color", Color.BLACK);
        if (color == null) {
            color = temp;
        }
        drawPanel2.currentColor = color;
        shapesColor1.setBackground(color);
        if (drawPanel2.getSelectedShape() != null) {
            drawPanel2.getSelectedShape().setFilled(true);
            if (color != drawPanel2.getSelectedShape().getSelectedColor2()) {
                drawPanel2.getSelectedShape().setSelectedColor2(color);
                drawPanel2.copyHistory();
            }
            drawPanel2.repaint();
        }
    }//GEN-LAST:event_jButtonColorActionPerformed

    private void jButtonStrokeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStrokeColorActionPerformed
        JColorChooser colorchoser = new JColorChooser();
        Color temp = drawPanel2.currentStrokeColor;
        Color color = JColorChooser.showDialog(this, "Pick A Color", Color.BLACK);
        if (color == null) {
            color = temp;
        }
        strokeColor1.setBackground(color);
        drawPanel2.currentStrokeColor = color;
        if (drawPanel2.getSelectedShape() != null) {
            drawPanel2.getSelectedShape().nonStroke = false;
            if (color != drawPanel2.getSelectedShape().strokeColor) {
                drawPanel2.getSelectedShape().strokeColor = color;
                drawPanel2.copyHistory();
            }
            drawPanel2.repaint();
        }
    }//GEN-LAST:event_jButtonStrokeColorActionPerformed

    private void jButtonNonStrokeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNonStrokeColorActionPerformed
        if (drawPanel2.getSelectedShape() != null) {
            if (true != drawPanel2.getSelectedShape().nonStroke) {
                drawPanel2.getSelectedShape().nonStroke = true;
                drawPanel2.copyHistory();
            }
            drawPanel2.repaint();
        }
    }//GEN-LAST:event_jButtonNonStrokeColorActionPerformed

    private void jButtonNonColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNonColorActionPerformed
        if (drawPanel2.getSelectedShape() != null) {
            if (false != drawPanel2.getSelectedShape().isFilled()) {
                drawPanel2.getSelectedShape().setFilled(false);
                drawPanel2.copyHistory();
            }
            drawPanel2.repaint();
        }
    }//GEN-LAST:event_jButtonNonColorActionPerformed

    private void jButtonColorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonColorPickerActionPerformed
        drawPanel2.colorPicker = true;
        drawPanel2.setCursor(drawPanel2.colorPickerCursor());
        //System.out.println("dfdfd");
        //  shapesColor1.setBackground(drawPanel2.pickedColor);
//       if (drawPanel2.getSelectedShape() != null) {
//            drawPanel2.getSelectedShape().setSelectedColor2(drawPanel2.pickedColor);
//       }
//       
        drawPanel2.repaint();
    }//GEN-LAST:event_jButtonColorPickerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PaintPrushFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaintPrushFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaintPrushFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaintPrushFram.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new PaintPrushFram().setVisible(true);

            }
        });
    }

//    ColorPicker colorpicker =new ColorPicker();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private paintprush.DrawPanel drawPanel2;
    private javax.swing.JButton jButtonColor;
    private javax.swing.JButton jButtonColorPicker;
    private javax.swing.JButton jButtonNonColor;
    private javax.swing.JButton jButtonNonStrokeColor;
    private javax.swing.JButton jButtonStrokeColor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSave;
    private javax.swing.JToolBar jToolBar1;
    private paintprush.PropertiesPanel propertiesPanel2;
    private paintprush.ShapesColor shapesColor1;
    private paintprush.StrokeColor strokeColor1;
    private paintprush.ToolsPanel toolsPanel1;
    // End of variables declaration//GEN-END:variables
}
