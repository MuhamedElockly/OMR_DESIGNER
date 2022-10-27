package paintprush;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Shape implements Cloneable {

    public int stroke = 1;
    public Color strokeColor;
    public boolean nonStroke = false;

    private Color drawColor;

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract String toSVG();

    public abstract boolean isPointInsideShape(Point p);

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    private boolean selected;

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }
    private Point p1;
    private Point p2;

    public Shape() {

        this(new Point(), new Point());

    }

    public Shape(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));

    }

    public Shape(Point p1, Point p2) {

        this.p1 = new Point(p1);
        this.p2 = new Point(p2);

        this.drawColor = Color.BLACK;
    }
    private boolean filled;

    public void correctPoints() {
        int x_min = Math.min(p1.x, p2.x);
        int y_min = Math.min(p1.y, p2.y);

        int x_max = Math.max(p1.x, p2.x);
        int y_max = Math.max(p1.y, p2.y);
        p1.setLocation(x_min, y_min);
        p2.setLocation(x_max, y_max);
    }

    public Map<String, String> getAllProperties() {
        Map<String, String> allProperties = new HashMap<>();
        allProperties.put("     X1", this.p1.x + "");
        allProperties.put("     Y1", this.p1.y + "");
        allProperties.put("     X2", this.p2.x + "");
        allProperties.put("     Y2", this.p2.y + "");
        allProperties.put("     Filled", this.filled + "");
        return allProperties;
    }

    public void moveShapeBy(int dx, int dy) {
        p1.setLocation(p1.x + dx, p1.y + dy);
        p2.setLocation(p2.x + dx, p2.y + dy);
    }

    public abstract void draw(Graphics g, DrawPanel draw);

    public abstract Color getColor();

    public abstract ArrayList<Shape> getLocalShape();
    private Color selectedColor2 = null;

    public Color getSelectedColor2() {
        return selectedColor2;
    }

    public void setSelectedColor2(Color selectedColor2) {
        this.selectedColor2 = selectedColor2;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public String converToHexa(Color c) {
        String hex = String.format("#%02X%02X%02X", c.getRed(), c.getGreen(), c.getBlue());
        return hex;
    }

   

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape shape = null;
        shape = (Shape) super.clone();
        return shape;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public abstract Shape copyCompShape(int counter);
}
