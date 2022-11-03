/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintprush;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class ToolsPanel extends javax.swing.JPanel {

    public boolean isDrawing() {
        return drawing;
    }

    public void setDrawing(boolean drawing) {
        this.drawing = drawing;
    }
    private boolean drawing = true;
    private boolean delete = false;

    public ToolsPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jToggleButtonSelect = new javax.swing.JToggleButton();
        jToggleButtonLIne = new javax.swing.JToggleButton();
        jToggleButtonRoundRect = new javax.swing.JToggleButton();
        jToggleButtonSquare = new javax.swing.JToggleButton();
        jToggleButtonRectangle = new javax.swing.JToggleButton();
        jToggleButtonCircle = new javax.swing.JToggleButton();
        jToggleButtonHebtagon = new javax.swing.JToggleButton();
        jToggleButtonOval = new javax.swing.JToggleButton();
        jToggleButtonBentagon = new javax.swing.JToggleButton();
        jToggleButtonTriangle = new javax.swing.JToggleButton();
        jToggleButtonHexagon = new javax.swing.JToggleButton();
        jToggleButtonSmilyFace2 = new javax.swing.JToggleButton();
        jToggleButtonSmilyFace3 = new javax.swing.JToggleButton();
        jToggleButtonSmilyFace1 = new javax.swing.JToggleButton();
        jToggleButtonText = new javax.swing.JToggleButton();
        jToggleButtonPencil = new javax.swing.JToggleButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(new java.awt.GridLayout(8, 2));

        jToggleButtonSelect.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonSelect);
        jToggleButtonSelect.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/SelectionTool.png"))); // NOI18N
        jToggleButtonSelect.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonSelectStateChanged(evt);
            }
        });
        jToggleButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSelectActionPerformed(evt);
            }
        });
        add(jToggleButtonSelect);

        jToggleButtonLIne.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonLIne);
        jToggleButtonLIne.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonLIne.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonLIne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Line.png"))); // NOI18N
        jToggleButtonLIne.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonLIneStateChanged(evt);
            }
        });
        add(jToggleButtonLIne);

        jToggleButtonRoundRect.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonRoundRect);
        jToggleButtonRoundRect.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonRoundRect.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonRoundRect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/RoundRect.png"))); // NOI18N
        jToggleButtonRoundRect.setBorder(null);
        jToggleButtonRoundRect.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonRoundRectStateChanged(evt);
            }
        });
        add(jToggleButtonRoundRect);

        jToggleButtonSquare.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonSquare);
        jToggleButtonSquare.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonSquare.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonSquare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Square.png"))); // NOI18N
        jToggleButtonSquare.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonSquareStateChanged(evt);
            }
        });
        add(jToggleButtonSquare);

        jToggleButtonRectangle.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonRectangle);
        jToggleButtonRectangle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonRectangle.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonRectangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Rectangle.png"))); // NOI18N
        jToggleButtonRectangle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonRectangleStateChanged(evt);
            }
        });
        jToggleButtonRectangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonRectangleActionPerformed(evt);
            }
        });
        add(jToggleButtonRectangle);

        jToggleButtonCircle.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonCircle);
        jToggleButtonCircle.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonCircle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Circle.png"))); // NOI18N
        jToggleButtonCircle.setSelected(true);
        jToggleButtonCircle.setBorder(null);
        jToggleButtonCircle.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jToggleButtonCircle.setMaximumSize(new java.awt.Dimension(70, 70));
        jToggleButtonCircle.setMinimumSize(new java.awt.Dimension(70, 70));
        jToggleButtonCircle.setPreferredSize(new java.awt.Dimension(70, 70));
        jToggleButtonCircle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonCircleStateChanged(evt);
            }
        });
        jToggleButtonCircle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCircleActionPerformed(evt);
            }
        });
        add(jToggleButtonCircle);

        jToggleButtonHebtagon.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonHebtagon);
        jToggleButtonHebtagon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonHebtagon.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonHebtagon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Hebtagon.png"))); // NOI18N
        jToggleButtonHebtagon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonHebtagonStateChanged(evt);
            }
        });
        add(jToggleButtonHebtagon);

        jToggleButtonOval.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonOval);
        jToggleButtonOval.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonOval.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonOval.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Oval.png"))); // NOI18N
        jToggleButtonOval.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonOvalStateChanged(evt);
            }
        });
        add(jToggleButtonOval);

        jToggleButtonBentagon.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonBentagon);
        jToggleButtonBentagon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonBentagon.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonBentagon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Bentagon.png"))); // NOI18N
        jToggleButtonBentagon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonBentagonStateChanged(evt);
            }
        });
        add(jToggleButtonBentagon);

        jToggleButtonTriangle.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonTriangle);
        jToggleButtonTriangle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonTriangle.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonTriangle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Triangle.png"))); // NOI18N
        jToggleButtonTriangle.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonTriangleStateChanged(evt);
            }
        });
        jToggleButtonTriangle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonTriangleActionPerformed(evt);
            }
        });
        add(jToggleButtonTriangle);

        jToggleButtonHexagon.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonHexagon);
        jToggleButtonHexagon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jToggleButtonHexagon.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButtonHexagon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/Hexagon.png"))); // NOI18N
        jToggleButtonHexagon.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonHexagonStateChanged(evt);
            }
        });
        jToggleButtonHexagon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonHexagonActionPerformed(evt);
            }
        });
        add(jToggleButtonHexagon);

        jToggleButtonSmilyFace2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonSmilyFace2);
        jToggleButtonSmilyFace2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/FaceSmile3.png"))); // NOI18N
        jToggleButtonSmilyFace2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonSmilyFace2StateChanged(evt);
            }
        });
        jToggleButtonSmilyFace2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonSmilyFace2ActionPerformed(evt);
            }
        });
        add(jToggleButtonSmilyFace2);

        jToggleButtonSmilyFace3.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonSmilyFace3);
        jToggleButtonSmilyFace3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/FaceAngry.png"))); // NOI18N
        jToggleButtonSmilyFace3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonSmilyFace3StateChanged(evt);
            }
        });
        add(jToggleButtonSmilyFace3);

        jToggleButtonSmilyFace1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jToggleButtonSmilyFace1);
        jToggleButtonSmilyFace1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paintprush/Icons/FaceSmile-1.png"))); // NOI18N
        jToggleButtonSmilyFace1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonSmilyFace1StateChanged(evt);
            }
        });
        add(jToggleButtonSmilyFace1);

        buttonGroup1.add(jToggleButtonText);
        jToggleButtonText.setText("Text");
        jToggleButtonText.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonTextStateChanged(evt);
            }
        });
        add(jToggleButtonText);

        buttonGroup1.add(jToggleButtonPencil);
        jToggleButtonPencil.setText("pencil");
        jToggleButtonPencil.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jToggleButtonPencilStateChanged(evt);
            }
        });
        add(jToggleButtonPencil);

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButtonCircleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCircleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonCircleActionPerformed

    private void jToggleButtonRectangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonRectangleActionPerformed


    }//GEN-LAST:event_jToggleButtonRectangleActionPerformed

    private void jToggleButtonLIneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonLIneStateChanged

        if (jToggleButtonLIne.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Line);
        }
    }//GEN-LAST:event_jToggleButtonLIneStateChanged

    private void jToggleButtonCircleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonCircleStateChanged
        if (jToggleButtonCircle.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Circle);
        }
    }//GEN-LAST:event_jToggleButtonCircleStateChanged

    private void jToggleButtonSquareStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonSquareStateChanged
        if (jToggleButtonSquare.isSelected()) {
            setDrawing(true);
        }
        if (jToggleButtonSquare.isSelected())
           setSelectedShape(ShapesEnum.Square);    }//GEN-LAST:event_jToggleButtonSquareStateChanged

    private void jToggleButtonRectangleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonRectangleStateChanged
        if (jToggleButtonRectangle.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Rectangle);
        }
    }//GEN-LAST:event_jToggleButtonRectangleStateChanged

    private void jToggleButtonRoundRectStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonRoundRectStateChanged
        if (jToggleButtonRoundRect.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.RoundRect);
        }
    }//GEN-LAST:event_jToggleButtonRoundRectStateChanged

    private void jToggleButtonOvalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonOvalStateChanged
        if (jToggleButtonOval.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Oval);
        }
    }//GEN-LAST:event_jToggleButtonOvalStateChanged

    private void jToggleButtonTriangleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonTriangleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonTriangleActionPerformed

    private void jToggleButtonTriangleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonTriangleStateChanged
        if (jToggleButtonTriangle.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Triangle);
        }
    }//GEN-LAST:event_jToggleButtonTriangleStateChanged

    private void jToggleButtonHexagonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonHexagonStateChanged
        if (jToggleButtonHexagon.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Hexagon);
        }
    }//GEN-LAST:event_jToggleButtonHexagonStateChanged

    private void jToggleButtonBentagonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonBentagonStateChanged
        if (jToggleButtonBentagon.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Bentagon);
        }
    }//GEN-LAST:event_jToggleButtonBentagonStateChanged

    private void jToggleButtonHebtagonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonHebtagonStateChanged
        if (jToggleButtonHebtagon.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Heptagon);
        }
    }//GEN-LAST:event_jToggleButtonHebtagonStateChanged
   // private Color selectedColor1 = null;


    private void jToggleButtonSmilyFace1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonSmilyFace1StateChanged
        if (jToggleButtonSmilyFace1.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.SmilyFace1);
        }
    }//GEN-LAST:event_jToggleButtonSmilyFace1StateChanged

    private void jToggleButtonSmilyFace2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonSmilyFace2StateChanged
        if (jToggleButtonSmilyFace2.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.SmilyFace2);
        }
    }//GEN-LAST:event_jToggleButtonSmilyFace2StateChanged

    private void jToggleButtonSmilyFace3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonSmilyFace3StateChanged
        if (jToggleButtonSmilyFace3.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.SmilyFace3);
        }
    }//GEN-LAST:event_jToggleButtonSmilyFace3StateChanged

    private void jToggleButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonSelectActionPerformed

    private void jToggleButtonSelectStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonSelectStateChanged
        if (jToggleButtonSelect.isSelected()) {
            //setDelete(false);
            drawing = false;
        } else {
            drawing = true;
        }
    }//GEN-LAST:event_jToggleButtonSelectStateChanged

    private void jToggleButtonSmilyFace2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonSmilyFace2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonSmilyFace2ActionPerformed
    public boolean text = false;
    private void jToggleButtonTextStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonTextStateChanged
        if (jToggleButtonText.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Text);
            text = true;
        }
    }//GEN-LAST:event_jToggleButtonTextStateChanged

    private void jToggleButtonHexagonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonHexagonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButtonHexagonActionPerformed

    private void jToggleButtonPencilStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jToggleButtonPencilStateChanged
         if (jToggleButtonPencil.isSelected()) {
            setDrawing(true);
            setSelectedShape(ShapesEnum.Pencil);
            text = true;
        }
    }//GEN-LAST:event_jToggleButtonPencilStateChanged

    ShapesEnum selectedShape = ShapesEnum.Line;
    Shape shape;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton jToggleButtonBentagon;
    private javax.swing.JToggleButton jToggleButtonCircle;
    private javax.swing.JToggleButton jToggleButtonHebtagon;
    private javax.swing.JToggleButton jToggleButtonHexagon;
    private javax.swing.JToggleButton jToggleButtonLIne;
    private javax.swing.JToggleButton jToggleButtonOval;
    private javax.swing.JToggleButton jToggleButtonPencil;
    private javax.swing.JToggleButton jToggleButtonRectangle;
    private javax.swing.JToggleButton jToggleButtonRoundRect;
    private javax.swing.JToggleButton jToggleButtonSelect;
    private javax.swing.JToggleButton jToggleButtonSmilyFace1;
    private javax.swing.JToggleButton jToggleButtonSmilyFace2;
    private javax.swing.JToggleButton jToggleButtonSmilyFace3;
    private javax.swing.JToggleButton jToggleButtonSquare;
    private javax.swing.JToggleButton jToggleButtonText;
    private javax.swing.JToggleButton jToggleButtonTriangle;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the selectedShape
     */
    public ShapesEnum getSelectedShape() {
        return selectedShape;
    }

//    public Color getSelectedColor1() {
//        return selectedColor1;
//    }
//
//    public void setSelectedColor1(Color selectedColor1) {
//        this.selectedColor1 = selectedColor1;
//    }

    public void setSelectedShape(ShapesEnum selectedShape) {
        this.selectedShape = selectedShape;
    }

    public boolean isFillColor() {
       // return this.jCheckBoxFillColor.isSelected();
       return true;
    }

}
