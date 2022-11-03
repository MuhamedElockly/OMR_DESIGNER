package paintprush;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import paintprush.Shapes.Rectangle;

public class CompositeShape extends Shape {

    Color color = null;

    private int minX = Integer.MAX_VALUE;
    private int maxX = Integer.MIN_VALUE;
    private int minY = Integer.MAX_VALUE;
    private int maxY = Integer.MIN_VALUE;
    private double constDisOfXP1 = 0;
    private double constDisOfYP1 = 0;
    private double constDisOfXP2 = 0;
    private double constDisOfYP2 = 0;

    private ArrayList<Shape> localShape;
    private double[][] arr;
    DrawPanel drawPanel;

    public CompositeShape(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        localShape = new ArrayList<>();

        for (int i = 0; i < localShape.size(); i++) {
            newPoint1 = new Point();
            newPoint1 = new Point();
            newPoint1 = localShape.get(i).getP1();
            newPoint2 = localShape.get(i).getP2();
            localShape.get(i).setP1(newPoint1);
            localShape.get(i).setP2(newPoint2);
        }

    }
    private Point compP1;
    private Point compP2;
    private Point shapeP1NewPos = null;
    private Point shapeP2NewPos = null;
    private Point newPoint1;
    private Point newPoint2;

    public void addShapes(ArrayList<Shape> newGroup) {
        localShape.addAll(newGroup);
        arr = new double[4][getLocalShape().size()];
        intializeCompoShape();
        compP1 = new Point();
        compP2 = new Point();
        compP1.setLocation(minX, minY);
        compP2.setLocation(maxX, maxY);
        this.setP1(compP1);
        this.setP2(compP2);
        intializeConstant();
    }

    public void addShape(Shape s) {
        getLocalShape().add(s);
    }

    public void intializeConstant() {

        arr = new double[4][getLocalShape().size()];
        for (int i = 0; i < getLocalShape().size(); i++) {
            arr[0][i] = ((double) (getLocalShape().get(i).getP1().x - this.getP1().x)) / ((double) (this.getP2().x - this.getP1().x));
            arr[1][i] = ((double) (getLocalShape().get(i).getP1().y - this.getP1().y)) / ((double) (this.getP2().y - this.getP1().y));
            arr[2][i] = ((double) (getLocalShape().get(i).getP2().x - this.getP1().x)) / ((double) (this.getP2().x - this.getP1().x));
            arr[3][i] = ((double) (getLocalShape().get(i).getP2().y - this.getP1().y)) / ((double) (this.getP2().y - this.getP1().y));
        }
    }

    void deleteGroups() {
        getLocalShape().removeAll(getLocalShape());

    }

    public void intializeCompoShape() {
        minX = Integer.MAX_VALUE;
        minY = Integer.MAX_VALUE;

        for (int i = 0; i < getLocalShape().size(); i++) {

            if (getLocalShape().get(i).getP2().x > maxX) {
                maxX = getLocalShape().get(i).getP2().x;
                if (getLocalShape().get(i).getP1().x < minX) {
                    minX = getLocalShape().get(i).getP1().x;
                }
            } else if (getLocalShape().get(i).getP1().x < minX) {
                minX = getLocalShape().get(i).getP1().x;
            }
            if (getLocalShape().get(i).getP2().y > maxY) {

                maxY = getLocalShape().get(i).getP2().y;
                if (getLocalShape().get(i).getP1().y < minY) {
                    minY = getLocalShape().get(i).getP1().y;
                }
            } else if (getLocalShape().get(i).getP1().y < minY) {
                minY = getLocalShape().get(i).getP1().y;
            }
        }

    }

    @Override
    public void draw(Graphics g, DrawPanel draw) {

        this.color = getSelectedColor2();
        Color oldColor = getSelectedColor2();

        int w = Math.abs(getP1().x - getP2().x);
        int h = Math.abs(getP1().y - getP2().y);
        g.setColor(getDrawColor());
        if (draw.isShiftButton() == true && ((!draw.allShapes.contains(this) && draw.getToolPanel().isDrawing() == true) || (draw.allShapes.contains(this) && draw.getToolPanel().isDrawing() == false)) && (draw.getSelectedShape() == this)) {
            this.getP2().x = this.getP1().x + Math.min(w, h);
            this.getP2().y = this.getP1().y + Math.min(w, h);
        }
        for (int i = 0; i < getLocalShape().size(); i++) {
            //Calculate The Constant Posation For Shapes Related To Composite Shape

            shapeP1NewPos = new Point();
            shapeP2NewPos = new Point();
            shapeP1NewPos.x = (int) (this.getP1().x + (arr[0][i] * (this.getP2().x - this.getP1().x)));
            shapeP2NewPos.x = (int) (this.getP1().x + (arr[2][i] * (this.getP2().x - this.getP1().x)));
            shapeP1NewPos.y = (int) (this.getP1().y + (arr[1][i] * (this.getP2().y - this.getP1().y)));
            shapeP2NewPos.y = (int) (this.getP1().y + (arr[3][i] * (this.getP2().y - this.getP1().y)));

            getLocalShape().get(i).setP1(shapeP1NewPos);
            getLocalShape().get(i).setP2(shapeP2NewPos);
            getLocalShape().get(i).draw(g, draw);

        }
        if (isSelected()) {
            g.setColor(Color.red);
            g.drawRect(getP1().x, getP1().y, getP2().x - getP1().x, getP2().y - getP1().y);
            g.drawRect(getP1().x - 5, getP1().y - 5, 11, 11);
            g.drawRect(getP2().x - 5, getP1().y - 5, 11, 11);
            g.drawRect(getP1().x - 5, getP2().y - 5, 11, 11);
//            g.drawRect(x + (w / 2) - 5, y + h - 5, 11, 11);
//            g.drawRect(x + (w / 2) - 5, y - 5, 11, 11);
//            g.drawRect(x - 5, y + (h / 2) - 5, 11, 11);
//            g.drawRect(x + w - 5, y + (h / 2) - 5, 11, 11);
            g.drawRect(getP2().x - 5, getP2().y - 5, 11, 11);
            g.setColor(Color.BLACK);
        }
        g.setColor(oldColor);
    }

    @Override
    public boolean isPointInsideShape(Point p) {

//           for (int i = 0; i < localShape.size(); i++) {
//            if (localShape.get(i).isPointInsideShape(p)) {
//                return true;
//            }
//        }
//        return false;
        if ((p.x >= getP1().x && p.x <= getP2().x) && (p.y >= getP1().y && p.y <= getP2().y)) {

            return true;
        } else {
            return false;
        }
    }

    public Color getColor() {
        return this.color;
    }

    public ArrayList<Shape> getLocalShape() {
        return localShape;
    }

    public void setLocalShape(ArrayList<Shape> localShape) {
        this.localShape = localShape;
    }

    @Override
    public String toSVG() {
        String comp = "";
        comp += " <g id=\"comp\">\n";
        for (int i = 0; i < localShape.size(); i++) {
            //  comp+=localShape.get(i).toSVG();
            comp += localShape.get(i).toSVG() + "\n";
        }
        comp += " </g>\n";
        return comp;
    }

    @Override
    public Shape copyCompShape(int counter) {
        ArrayList<Shape> temp = new ArrayList<>();
        for (int i = 0; i < localShape.size(); i++) {
            temp.add(localShape.get(i).copyCompShape(counter));
        }
        Shape compShape = ShapeFactory.CreateShape(ShapesEnum.CompositShape, drawPanel);
        ((CompositeShape) compShape).addShapes(temp);
        return compShape;

    }

    public static Shape loadSVG(org.w3c.dom.Node node, DrawPanel drawPanel) {
        CompositeShape comp = new CompositeShape(drawPanel);
        NamedNodeMap map = node.getAttributes();
        //   NamedNodeMap map1 = node.
        Node widthNode = map.getNamedItem("width");
        Node heightNode = map.getNamedItem("height");
        Node xNode = map.getNamedItem("x");
        Node yNode = map.getNamedItem("y");
        Node stroke = map.getNamedItem("stroke");
        Node stroke_width = map.getNamedItem("stroke-width");
        Node fill = map.getNamedItem("fill");

        System.out.println(node.getTextContent());

        comp.getP1().x = Integer.parseInt(xNode.getNodeValue());
        comp.getP1().y = Integer.parseInt(yNode.getNodeValue());
        comp.getP2().x = comp.getP1().x + Integer.parseInt(widthNode.getNodeValue());
        comp.getP2().y = comp.getP1().y + Integer.parseInt(heightNode.getNodeValue());

//        String temp = "none";
//        if (!temp.equals(fill.getNodeValue())) {
//            rect.setFilled(true);
//            rect.setSelectedColor2(Color.decode(fill.getNodeValue()));
//        } else {
//            rect.setFilled(false);
//        }
//        if (stroke_width != null && stroke_width.getNodeValue() != null) {
//            rect.strokeColor = Color.decode(stroke.getNodeValue());
//            rect.stroke = Integer.parseInt(stroke_width.getNodeValue());
//        } else {
//            rect.nonStroke = true;
//        }
        return comp;
    }
}
