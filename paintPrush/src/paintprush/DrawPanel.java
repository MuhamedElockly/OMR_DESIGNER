package paintprush;

import java.awt.Color;
import static java.awt.Color.blue;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ContextMenu;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import paintprush.Shapes.Circle;
import paintprush.Shapes.Pencil;
import paintprush.Shapes.Text;

public class DrawPanel extends javax.swing.JPanel {

    private int w;
    private int h;

    private BufferedImage offScreenImage;
    private Graphics offScreenGraphics;

    public Graphics getOffScreenGraphics() {
        return this.offScreenGraphics;
    }

    public boolean isGroup() {
        return group;
    }

    public ToolsPanel getTooLPanel1() {
        return this.toolPanel;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public boolean isCtrButton() {
        return ctrButton;
    }

    public void setCtrButton(boolean ctrButton) {
        this.ctrButton = ctrButton;
    }

    public boolean isShiftButton() {
        return shiftButton;
    }

    public void setShiftButton(boolean shiftButton) {
        this.shiftButton = shiftButton;
    }

    public PropertiesPanel getPropertiesPanel() {
        return propertiesPanel;
    }

    public void setPropertiesPanel(PropertiesPanel propertiesPanel) {
        this.propertiesPanel = propertiesPanel;
    }

    public ArrayList<Shape> allShapes = new ArrayList<>();
    protected ArrayList<Shape> selectedShapesIndex = new ArrayList<>();
    protected ArrayList<Shape> groupCopy = new ArrayList<>();
    protected ArrayList<Shape> tempCopy = new ArrayList<>();
    protected ArrayList<Shape> lastCopy = new ArrayList<>();
    public ArrayList<ArrayList<Shape>> back = new ArrayList<>();

    public ToolsPanel getToolPanel() {
        return toolPanel;
    }

    public void setToolPanel(ToolsPanel toolPanel) {
        this.toolPanel = toolPanel;
    }

    private int panelWidth = 0;
    private int panelHeight = 0;
    public int x_offScreen = 0;
    public int y_offScreen = 0;

    private double zoomFactor = 1;
    private double prevZoomFactor = 1;
    private boolean zoomer;
    private int xOffset = 0;
    private int yOffset = 0;
    private int xDiff;
    private int yDiff;
    private boolean move = false;
    public Color currentColor = Color.CYAN;
    private int shapeConstant = 0;
    Graphics cursorRectangel;
    private boolean shiftButton = false;

    public DrawPanel() {
        w = 800;
        this.panelWidth = w;
        h = (int) (w);
        this.panelHeight = h;
        int drawPanlWidth = this.maxX;
        offScreenImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        offScreenGraphics = offScreenImage.getGraphics();
        initComponents();
        KeyboardFocusManager keyManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keyManager.addKeyEventPostProcessor(new Keypoard_Events(this));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(205, 215, 230));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        cursorRectangel = g;
//        offScreenImage = new BufferedImage((int) (w * zoomFactor), (int) (h * zoomFactor), BufferedImage.TYPE_INT_RGB);
//        offScreenGraphics = offScreenImage.getGraphics();
        offScreenGraphics.setColor(Color.white);
        offScreenGraphics.fillRect(0, 0, offScreenImage.getWidth(), offScreenImage.getHeight());
        super.paintComponent(g);

        for (int i = 0; i < allShapes.size(); i++) {

            allShapes.get(i).draw(offScreenGraphics, this);
        }
        if (currentShape != null) {
            currentShape.draw(offScreenGraphics, this);
        }

        Graphics2D g2 = (Graphics2D) g;

//        int x1 = (this.getWidth() / 2) - (offScreenImage.getWidth() / 2);
        //  int y1 = (this.getHeight() / 2) - (offScreenImage.getHeight() / 2);
//        int x1 = ((this.getWidth() / 2) - (int) ((offScreenImage.getWidth() * zoomFactor) / 2));
//        int y1 = (this.getHeight() / 2) - (int) ((offScreenImage.getHeight() * zoomFactor) / 2);
        zoomFactor = 1;
        int x1 = ((this.getWidth() / 2) - (int) ((panelWidth * zoomFactor) / 2));
        int y1 = (this.getHeight() / 2) - (int) ((panelHeight * zoomFactor) / 2);
//
        x_offScreen = Math.max(x1, 0);
        y_offScreen = Math.max(y1, 0);
//
//        x_offScreen = ((this.getWidth() / 2) - (int) ((panelWidth) / 2));
//        y_offScreen = (this.getHeight() / 2) - (int) ((panelHeight) / 2);

//        x_offScreen = ((this.getWidth() / 2) - (int) ((panelWidth * zoomFactor) / 2));
//        y_offScreen = ((this.getHeight() / 2) - (int) ((panelHeight * zoomFactor) / 2));
        //System.out.println("panelWidth * zoomFactor  : " + ((panelWidth * zoomFactor)));
        //    System.out.println("panelWidth * zoomFactor int: " +(int) ((panelWidth * zoomFactor)));
//        System.out.println("x1 : " + x1);
//        System.out.println("c_offscreen : " + x_offScreen);
//        System.out.println("offScreenImage.getWidth() : " + offScreenImage.getWidth());
//        System.out.println("this.getWidth() : " + this.getWidth());
        g.drawImage(offScreenImage, x1, y1, (int) (panelWidth * zoomFactor), (int) (panelHeight * zoomFactor), null);

        //     g.drawImage(offScreenImage, x1, y1, panelWidth, panelHeight, null);
    }

    public boolean saveAsPng(String fileName) {

        try {
            ImageIO.write(offScreenImage, "png", new File(fileName));
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public boolean saveAsSVG(String fileName) {
        String svgString = String.format("<svg width=\"%d\" height=\"%d\" xmlns=\"http://www.w3.org/2000/svg\">\n",
                w, h
        );
        for (Shape s : allShapes) {
            svgString += "\t" + s.toSVG() + "\n";
        }
        svgString += "</svg>";
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.println(svgString);
            pw.flush();
            pw.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public BufferedImage createImage(JPanel panel) {
        deSelectAllShapes();
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        g.dispose();
        return bi;
    }

    public void correctMousePoint(java.awt.event.MouseEvent evt) {
        if (zoomFactor > 1) {
            repaint();
            //  x_offScreen +=((evt.getPoint().x)/zoomFactor);       
            //  x_offScreen += (int) ( (Math.abs(evt.getPoint().x)-x_offScreen*zoomFactor)/zoomFactor );
            //  y_offScreen = (int) (zoomFactor * y_offScreen);
        }
        evt.translatePoint(-x_offScreen, -y_offScreen);

    }
    ColorPanel colorPanel;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        correctMousePoint(evt);

        if (SwingUtilities.isRightMouseButton(evt)) {
            if (!toolPanel.isDrawing() && getSelectedShape() != null) {
                Context_Menu contextMenue = new Context_Menu(this, evt.getPoint().x, evt.getPoint().y);
            }
        }
        if (toolPanel.isDrawing()) {
            reSetSelectedIndex();
            deSelectAllShapes();
            if (!toolPanel.isDrawing()) {
                return;
            }
            setCtrButton(false);
            currentShape = ShapeFactory.CreateShape(toolPanel.getSelectedShape(), this);
            currentShape.setP1(evt.getPoint());
            currentShape.setP2(evt.getPoint());
            currentShape.setFilled(true);
            currentShape.setSelectedColor2(this.currentColor);
            currentShape.setStroke(this.stokeValue);
            currentShape.strokeColor = currentStrokeColor;
        } else {
            catchColor(evt.getPoint());
            if (isCtrButton() != true && !SwingUtilities.isRightMouseButton(evt)) {
                reSetSelectedIndex();
                deSelectAllShapes();
            }
            Shape selectedShape1 = null;
            if (!SwingUtilities.isRightMouseButton(evt)) {
                selectShape(evt.getPoint());
                selectedShape1 = getSelectedShape();
            }
            if (selectedShape1 == null || SwingUtilities.isRightMouseButton(evt)) {

//                if ((getCursor().getType() == Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR).getType())) {
//                    dragStartPoint = evt.getPoint();
//                } else {
                dragStartPoint = null;
                //   }
                repaint();
                return;
            } else {
                dragStartPoint = evt.getPoint();
            }
        }
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // evt.translatePoint(-x_offScreen, -y_offScreen);
        correctMousePoint(evt);
        setCtrButton(false);
        setShiftButton(false);
        if (dragStartPoint != null && move == true) {
            copyHistory();
            move = false;
        }
        dragStartPoint = null;
        if (!toolPanel.isDrawing()) {
            return;
        } else {

            if (!(currentShape instanceof Pencil)) {
                currentShape.correctPoints();
                allShapes.add(currentShape);
            }
            currentShape = null;
            copyHistory();
            repaint();
        }
    }//GEN-LAST:event_formMouseReleased

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        //evt.translatePoint(-x_offScreen, -y_offScreen);
        correctMousePoint(evt);
        Shape s = getSelectedShape();
        Point temp1 = null;
        Point temp2 = null;
        if (toolPanel.isDrawing()) {

            currentShape.setP2(evt.getPoint());

            if (currentShape instanceof Pencil) {
                for (int i = 0; i < 1; i++) {
                    try {

                        ((Pencil) currentShape).allCircles.add((Circle) ((Pencil) currentShape).circle.clone());
//                        ((Pencil) currentShape).allCircles.get(((Pencil) currentShape).allCircles.size() - 1).setP1(evt.getPoint());
//                       ((Pencil) currentShape).allCircles.get(  ((Pencil) currentShape).allCircles.size()-1).setSize(10);
                        ((Pencil) currentShape).allCircles.get(((Pencil) currentShape).allCircles.size() - 1).setP1(evt.getPoint());
//                        ((Pencil) currentShape).allCircles.get(((Pencil) currentShape).allCircles.size() - 1).getP1().x = evt.getPoint().x+5;
//                        ((Pencil) currentShape).allCircles.get(((Pencil) currentShape).allCircles.size() - 1).getP1().y = evt.getPoint().y+5;
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (!allShapes.contains(currentShape)) {
                    allShapes.add(currentShape);
                    repaint();
                }
            }

        } else {
            if (getSelectedShape() != null) {
                this.propertiesPanel.setAllProperties(s.getAllProperties());
                move = true;
            }
            int dx = 0;
            int dy = 0;
            if (dragStartPoint != null) {
                dx = evt.getPoint().x - dragStartPoint.x;
                dy = evt.getPoint().y - dragStartPoint.y;
                dragStartPoint = evt.getPoint();
            }

            if (dragStartPoint != null && (getCursor().getType() == Cursor.getPredefinedCursor(Cursor.HAND_CURSOR).getType())) {
//                 dx = evt.getPoint().x - dragStartPoint.x;
//                dy = evt.getPoint().y - dragStartPoint.y;

//                if (isGroup() == true) {
//                    for (int i = 0; i < allGroups.size(); i++) {
//
//                        //  if (getSelectedShape() == allShapes.get(allGroups.get(i))) {
//                        if (getSelectedShape() == allGroups.get(i)) {
//                            System.out.println("Shapes : " + getSelectedShape());
//                            insideGroup = true;
//                            break;
//                        }
//                    }
//                } else {
//                    insideGroup = false;
//                }
                // System.out.println("insideGroup : " + insideGroup);
                //   if (s != null && insideGroup == false && allShapes.get(selectedShapesIndex.get(0)).isPointInsideShape(evt.getPoint())) {
                //  if (s != null && insideGroup == false && selectedShapesIndex.get(0).isPointInsideShape(evt.getPoint())) {
                s.moveShapeBy(dx, dy);

//                move = true;
//                    allShapes.get(selectedShapesIndex.get(0)).moveShapeBy(dx, dy);
//                        allShapes.get(selectedShapesIndex.get(0)).moveShapeBy(dx, dy);
                // } else {
//                    if (isGroup() == true) {
////                        Shape Sh=null;
//                        for (int i = 0; i < allGroups.size(); i++) {
//                            if (s != null) {
//                                //   setCompositeShapePorder();
//                                allShapes.get(allGroups.get(i)).moveShapeBy(dx, dy);
//                            }
//                        }
//                    }
                //insideGroup = false;
                // }
                dragStartPoint = evt.getPoint();
            } else if (dragStartPoint != null && (getCursor().getType() == Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR).getType())) {
                if (evt.getPoint().x > s.getP1().x && evt.getPoint().y > s.getP1().y) {
                    s.setP2(evt.getPoint());
                }
            } else if (dragStartPoint != null && (getCursor().getType() == Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR).getType())) {

                if (evt.getPoint().x > s.getP1().x && evt.getPoint().y < s.getP2().y) {

                    s.getP2().x = s.getP2().x + dx;
                    s.getP1().y = s.getP1().y + dy;

//                    temp1 = evt.getPoint();
//                    temp2 = evt.getPoint();
//
//                    temp1.y = evt.getPoint().y;
//                    temp1.x = s.getP1().x;
//                    temp2.x = evt.getPoint().x;
//                    temp2.y = s.getP2().y;
//                    s.setP1(temp1);
//                    s.setP2(temp2);
                }
            } else if (dragStartPoint != null && (getCursor().getType() == Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR).getType())) {

                if (evt.getPoint().x < s.getP2().x && evt.getPoint().y > s.getP1().y) {
                    temp1 = evt.getPoint();
                    temp2 = evt.getPoint();
                    temp1.y = s.getP1().y;

                    temp1.x = evt.getPoint().x;
                    temp2.x = s.getP2().x;
                    temp2.y = evt.getPoint().y;
                    s.setP1(temp1);
                    s.setP2(temp2);

                }
            } else if (dragStartPoint != null && (getCursor().getType() == Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR).getType())) {

                if (evt.getPoint().x < s.getP2().x && evt.getPoint().y < s.getP2().y) {

                    //  System.out.println("Before : " + s.getP1().x);
                    s.getP1().x = s.getP1().x + dx;
                    s.getP1().y = s.getP1().y + dy;
                    //  System.out.println("After : " + s.getP1().x);
//                    temp1 = evt.getPoint();
//                    temp2 = evt.getPoint();
//                    temp1.y = evt.getPoint().y;
//
//                    temp1.x = evt.getPoint().x;
//                    temp2.x = s.getP2().x;
//                    temp2.y = s.getP2().y;
//                    s.setP1(temp1);
//                    s.setP2(temp2);

                }
            }
            //else if (dragStartPoint != null && (getCursor().getType() == Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR).getType())) {

//                System.out.println("cursor");
//                cursorRectangel.setColor(blue);
//                cursorRectangel.drawRect(50, 60, 200, 100);
//             //   cursorRectangel.drawRect(dragStartPoint.x, dragStartPoint.y, evt.getPoint().x - dragStartPoint.x, evt.getPoint().y - dragStartPoint.y);
//            repaint();
            //   }
        }
        repaint();


    }//GEN-LAST:event_formMouseDragged

    public boolean colorPicker = false;
    Color pickedColor;
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked


    }//GEN-LAST:event_formMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

        //    evt.translatePoint(-x_offScreen, -y_offScreen);
        correctMousePoint(evt);

        Shape s = null;
        Point currentPoint = evt.getPoint();
        if (toolPanel.isDrawing()) {

            //   if(toolPanel.text){
            //   this.setCursor(new Cursor(Cursor.TEXT_CURSOR));  
            // }else{
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

            //}
        }
        if (!toolPanel.isDrawing()) {
            if (getSelectedShape() != null && colorPicker == false) {
                s = getSelectedShape();
                if ((currentPoint.x >= s.getP2().x - 15 && currentPoint.x < s.getP2().x + 15) && (currentPoint.y >= s.getP1().y - 15 && currentPoint.y <= s.getP1().y + 15)) {
                    this.setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
                } else if ((currentPoint.x >= s.getP2().x - 15 && currentPoint.x < s.getP2().x + 15) && (currentPoint.y >= s.getP2().y - 15 && currentPoint.y <= s.getP2().y + 15)) {
                    this.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
                } else if ((currentPoint.x >= s.getP1().x - 15 && currentPoint.x < s.getP1().x + 15) && (currentPoint.y >= s.getP1().y - 15 && currentPoint.y <= s.getP1().y + 15)) {
                    this.setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
                } else if ((currentPoint.x >= s.getP1().x - 15 && currentPoint.x < s.getP1().x + 15) && (currentPoint.y >= s.getP2().y - 15 && currentPoint.y <= s.getP2().y + 15)) {
                    this.setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
                } else {
                    if (checkPointIsideShap(evt.getPoint()) == true) {
                        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    } else {
                        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    }
                }
            } else if (colorPicker == false) {
                if (checkPointIsideShap(evt.getPoint()) == true) {
                    this.setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
            } else {
                this.setCursor(colorPickerCursor());
            }
        }

    }//GEN-LAST:event_formMouseMoved

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved

        // System.out.println(offScreenImage.getWidth() + " " + offScreenImage.getHeight());
        zoomer = true;
        //Zoom in
        if (evt.getWheelRotation() < 0) {
            zoomFactor *= 1.1;
            repaint();
        }
        //Zoom out
        if (evt.getWheelRotation() > 0) {
            zoomFactor /= 1.1;
            repaint();
        }
    }//GEN-LAST:event_formMouseWheelMoved

    public void catchColor(Point pt) {
        if (!toolPanel.isDrawing() && colorPicker == true) {
            // customCursor();

            int color = offScreenImage.getRGB(pt.x, pt.y);
            pickedColor = new Color(color, true);
            if (getSelectedShape() != null) {
                getSelectedShape().setFilled(true);
                getSelectedShape().setSelectedColor2(pickedColor);
                repaint();
            }
            colorPicker = false;
            currentColor = pickedColor;
            repaint();
        }
    }

    private Shape selectShape(Point pt) {
        toolPanel.setDrawing(false);
        for (int i = allShapes.size() - 1; i >= 0; i--) {
            Shape s = allShapes.get(i);
            if (s.isPointInsideShape(pt)) {
                if (isCtrButton() == true && s.isSelected() == true) {
                    s.setSelected(false);
                    selectedShapesIndex.remove(s);
                    repaint();
                    return null;
                }
                s.setSelected(true);
                this.propertiesPanel.setAllProperties(s.getAllProperties());
                this.selectedShapesIndex.add(allShapes.get(i));
                repaint();
                return s;
            } else {
                if (ctrButton != true) {
                }
            }
        }
        repaint();
        return null;
    }

    public Shape getSelectedShape() {
        for (Shape s : allShapes) {
            if (s.isSelected()) {
                return s;
            }
        }
        return null;
    }

    public ArrayList getAllSahpes() {
        return allShapes;
    }

    private boolean checkPointIsideShap(Point pt) {
        Shape s = null;
        for (int i = 0; i < allShapes.size(); i++) {
            s = allShapes.get(i);
            if (s.isPointInsideShape(pt) == true) {
                return true;
            }
        }
        return false;
    }

    public void deSelectAllShapes() {
        for (Shape s : allShapes) {
            s.setSelected(false);
        }
        repaint();
    }

    public void reSetSelectedIndex() {
        selectedShapesIndex.clear();
    }

    private int minX = 0;
    private int maxX = 0;
    private int minY = 0;
    private int maxY = 0;
    private Point p3 = null;
    private Point p4 = null;
    int counter = 0;

    int stokeValue = 1;
    public Color currentStrokeColor = Color.black;

    public void copyFromSelectedShapesToArray() {
        counter = 0;
        lastCopy.clear();
        lastCopy.addAll(selectedShapesIndex);
    }

    public void copyFromArrayToShapes() {
        Shape s;
        counter++;
        for (int i = 0; i < lastCopy.size(); i++) {
            p3 = new Point();
            p4 = new Point();
            if (lastCopy.get(i) instanceof CompositeShape) {
                allShapes.add(((CompositeShape) lastCopy.get(i)).copyCompShape(counter));
            } else {
                try {

                    if (allShapes.get(allShapes.size() - 1) instanceof Text) {
                        Shape text = new Text(this);
                        text = (Shape) lastCopy.get(i).clone();
                        //  ((Text) allShapes.get(allShapes.size() - 1)).count = 0;
                        ((Text) text).count = 0;
                        ((Text) text).tf.setVisible(false);
                        allShapes.add(text);
                    } else {
                        allShapes.add((Shape) lastCopy.get(i).clone());
                    }

                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                p3.x = lastCopy.get(i).getP1().x;
                p3.y = lastCopy.get(i).getP1().y;
                p4.x = lastCopy.get(i).getP2().x;
                p4.y = lastCopy.get(i).getP2().y;
                p3.x += 30 * counter;
                p3.y += 30 * counter;
                p4.x += 30 * counter;
                p4.y += 30 * counter;

//                if (allShapes.get(allShapes.size() - 1) instanceof Text) {
//                    Shape text=new Text(this);
//                    ((Text) allShapes.get(allShapes.size() - 1)).count = 0;
//                }
                allShapes.get(allShapes.size() - 1).setP1(p3);
                allShapes.get(allShapes.size() - 1).setP2(p4);
            }
        }
        repaint();
    }

    public Cursor colorPickerCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point point = new Point(0, 25);
        Cursor cursor = toolkit.createCustomCursor(new ImageIcon(getClass().getResource("/paintprush/Icons/ColorPickerCursor.png")).getImage(), point, "ColorPickerCursor");
        return cursor;
    }

    void sortingSelectedShapes() {
        Shape greater;
        Shape smaller;
        for (int i = 0; i < selectedShapesIndex.size(); i++) {
            for (int j = 0; j < selectedShapesIndex.size(); j++) {
                if (allShapes.indexOf(selectedShapesIndex.get(i)) < allShapes.indexOf(selectedShapesIndex.get(j))) {
                    smaller = selectedShapesIndex.get(i);
                    greater = selectedShapesIndex.get(j);
                    selectedShapesIndex.set(i, greater);
                    selectedShapesIndex.set(j, smaller);
                }
            }
        }
    }
    int indexOfBack = -1;

    void copyHistory() {
        indexOfBack++;
        for (int i = back.size() - 1; i >= indexOfBack; i--) {
            back.remove(i);
        }
        tempCopy.clear();
        for (int i = 0; i < allShapes.size(); i++) {
            p3 = new Point();
            p4 = new Point();
            if (allShapes.get(i) instanceof CompositeShape) {
                tempCopy.add(((CompositeShape) allShapes.get(i)).copyCompShape(0));
            } else {
                try {
                    tempCopy.add((Shape) allShapes.get(i).clone());
                    p3.x = allShapes.get(i).getP1().x;
                    p3.y = allShapes.get(i).getP1().y;
                    p4.x = allShapes.get(i).getP2().x;
                    p4.y = allShapes.get(i).getP2().y;
                    tempCopy.get(tempCopy.size() - 1).setP1(p3);
                    tempCopy.get(tempCopy.size() - 1).setP2(p4);
                    if (tempCopy.get(tempCopy.size() - 1) instanceof Text) {
                        ((Text) tempCopy.get(tempCopy.size() - 1)).count = 0;
                    }
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        back.add((ArrayList<Shape>) tempCopy.clone());
    }

    public void deleteText() {
        for (int i = selectedShapesIndex.size() - 1; i >= 0; i--) {
            if (selectedShapesIndex.get(i) instanceof Text) {
                if (((Text) selectedShapesIndex.get(i)).tf.isEditable() == false) {
                    this.remove(((Text) selectedShapesIndex.get(i)).tf);
                }
            }
        }
    }

    public void deleteShape() {

        deSelectAllShapes();

        if (selectedShapesIndex.size() > 0) {
            deleteText();

            //      allShapes.removeAll(selectedShapesIndex);
            for (int i = selectedShapesIndex.size() - 1; i >= 0; i--) {
                if (selectedShapesIndex.get(i) instanceof Text) {
                    if (((Text) selectedShapesIndex.get(i)).tf.isEditable() == false) {
                        allShapes.remove(selectedShapesIndex.get(i));
                        selectedShapesIndex.remove(i);
                    } else {
                        System.out.println("mohame");
                        (selectedShapesIndex.get(i)).setSelected(true);
                        //    selectedShapesIndex.add(( selectedShapesIndex.get(i)));
                    }
                } else {
                    allShapes.remove(selectedShapesIndex.get(i));
                    selectedShapesIndex.remove(i);
                }
            }

            copyHistory();
        }
        //  reSetSelectedIndex();

//        deSelectAllShapes();
        repaint();
    }
    private ToolsPanel toolPanel;
    public PropertiesPanel propertiesPanel;
    private Shape currentShape = null;
    private Point dragStartPoint = null;
    private boolean ctrButton = false;
    private boolean group = false;
    private ShapesEnum selectedShape = ShapesEnum.Line;
    private boolean insideGroup = false;
    Alligment alligment;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
