package paintprush.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import paintprush.DrawPanel;
import paintprush.Shape;

public class Pencil extends Shape {

    public Circle circle;
    public ArrayList<Circle> allCircles = new ArrayList<>();
    private double[][] arr;
    private Point shapeP1NewPos = null;
    private Point shapeP2NewPos = null;

    public Pencil() {
//        System.out.println("pencil : " + this.getP1());
        circle = new Circle();
//        circle.setP1(this.getP1());
//        circle.setSize(10);

    }

    Color color = null;

    @Override
    public void draw(Graphics g, DrawPanel draw) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(getStroke()));

        //  System.out.println("pencil : " + allCircles.size());
        //   circle.setP1(this.getP1());
        //  circle.setSize(10);
        this.color = getSelectedColor2();
        Color oldColor = getSelectedColor2();
        g.setColor(getDrawColor());

        int x = Math.min(getP1().x, getP2().x);
        int y = Math.min(getP1().y, getP2().y);

        for (int i = 0; i < allCircles.size(); i++) {
            // allCircles.get(i).setP1(this.getP1());
            allCircles.get(i).setSize(this.getStroke() + 2);
            allCircles.get(i).getP2().x = allCircles.get(i).getP1().x + this.getStroke() + 2;
            allCircles.get(i).getP2().y = allCircles.get(i).getP1().y + this.getStroke() + 2;
            allCircles.get(i).draw(g, draw);
            allCircles.get(i).setSelectedColor2(this.strokeColor);
            allCircles.get(i).setFilled(true);
            allCircles.get(i).nonStroke = true;

        }

        this.setBorder();
        int w = max_X - min_X;
        int h = max_Y - min_Y;
        if (isSelected()) {
            g.setColor(Color.red);
            g.drawRect(x, y, max_X - min_X, max_Y - min_Y);
            g.drawRect(x - 5, y - 5, 11, 11);
            g.drawRect(x + w - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + h - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, y + h - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + (h / 2) - 5, 11, 11);
            g.drawRect(x + w - 5, y + (h / 2) - 5, 11, 11);
            g.drawRect(x + w - 5, y + h - 5, 11, 11);
            g.setColor(Color.BLACK);
        }
        g.setColor(oldColor);

        g2.setStroke(new BasicStroke(1));
    }
    //}

    @Override
    public boolean isPointInsideShape(Point p) {
        for (int i = 0; i < allCircles.size(); i++) {
            if (allCircles.get(i).isPointInsideShape(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Color getColor() {

        return color;
    }

    int min_X = Integer.MAX_VALUE;
    int max_X = Integer.MIN_VALUE;
    int min_Y = Integer.MAX_VALUE;
    int max_Y = Integer.MIN_VALUE;

    @Override
    public void moveShapeBy(int dx, int dy) {
        super.moveShapeBy(dx, dy);
        for (Shape s : allCircles) {
            s.moveShapeBy(dx, dy);
        }
    }

    public void setBorder() {

        for (int i = 0; i < allCircles.size(); i++) {
            if (allCircles.get(i).getP1().x < min_X) {
                min_X = allCircles.get(i).getP1().x;
            }
            if (allCircles.get(i).getP1().x > max_X) {
                max_X = allCircles.get(i).getP1().x;
            }
            if (allCircles.get(i).getP1().y < min_Y) {
                min_Y = allCircles.get(i).getP1().y;
            }
            if (allCircles.get(i).getP1().y > max_Y) {
                max_Y = allCircles.get(i).getP1().y;
            }
        }
    }

    @Override
    public ArrayList<Shape> getLocalShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSVG() {
        String pencil = "";

        for (int i = 0; i < allCircles.size(); i++) {
            //  comp+=localShape.get(i).toSVG();
            pencil += allCircles.get(i).toSVG() + "\n";
        }
        return pencil;
    }
    Point p3;
    Point p4;

    @Override
    public Shape copyCompShape(int counter) {
        try {
            Shape s = (Shape) this.clone();
            p3 = new Point();
            p4 = new Point();
            p3.x = s.getP1().x;
            p3.y = s.getP1().y;
            p4.x = s.getP2().x;
            p4.y = s.getP2().y;
            p3.x += 30 * counter;
            p3.y += 30 * counter;
            p4.x += 30 * counter;
            p4.y += 30 * counter;
            s.setP1(p3);
            s.setP2(p4);

            return s;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
