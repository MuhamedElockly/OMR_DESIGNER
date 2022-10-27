package paintprush.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import paintprush.DrawPanel;
import paintprush.Shape;

public class SmilyFace1 extends Shape {

    Color color = null;

    public void draw(Graphics g, DrawPanel draw) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(getStroke()));

        this.color = strokeColor;
        Color oldColor = getSelectedColor2();
        g.setColor(getDrawColor());

        int x = Math.min(getP1().x, getP2().x);
        int y = Math.min(getP1().y, getP2().y);
        int w = Math.abs(getP1().x - getP2().x);
        int h = Math.abs(getP1().y - getP2().y);
        g.setColor(color);
        w = h;
     
        if (this.getP2().x < this.getP1().x && this.getP2().y > this.getP1().y) {
           
            this.getP2().x = this.getP1().x - w;
            this.getP2().y = this.getP1().y + w;

        } else if (this.getP2().x < this.getP1().x && this.getP2().y < this.getP1().y) {
            this.getP2().x = this.getP1().x - w;
            this.getP2().y = this.getP1().y - w;
        } else if (this.getP2().x > this.getP1().x && this.getP2().y < this.getP1().y) {
            this.getP2().x = this.getP1().x + w;
            this.getP2().y = this.getP1().y - w;
        } else if (this.getP2().x > this.getP1().x && this.getP2().y > this.getP1().y) {
            this.getP2().x = this.getP1().x + w;
            this.getP2().y = this.getP1().y + w;
        }

        g.drawOval(x, y, h, h);

//        g.setColor(color);
//        g.fillOval(x, y, h, h);
        g2.setStroke(new BasicStroke(getStroke() + 5));
        g.drawArc(x + (h / 5), y + (h / 4), h - (2 * (h / 5)), h - (2 * (h / 5)), 0, -175);
        g2.setStroke(new BasicStroke(getStroke()));
        g.drawOval(x + ((h / 3)), y + (h / 3), h / 15, h / 15);
        g.drawOval(x + ((2 * h / 3)) - (h / 15), y + (h / 3), h / 15, h / 15);
        g.setColor(Color.BLACK);
        g.fillOval(x + ((h / 3)), y + (h / 3), h / 15, h / 15);
        g.fillOval(x + ((2 * h / 3)) - (h / 15), y + (h / 3), h / 15, h / 15);
        g2.setStroke(new BasicStroke(1));
        if (isSelected()) {
            g.setColor(Color.red);
            g.drawRect(x - 5, y - 5, 11, 11);
            g.drawRect(x, y, h, h);
            g.drawRect(x + h - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + h - 5, 11, 11);
            g.drawRect(x + (h / 2) - 5, y + h - 5, 11, 11);
            g.drawRect(x + (h / 2) - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + (h / 2) - 5, 11, 11);
            g.drawRect(x + h - 5, y + (h / 2) - 5, 11, 11);
            g.drawRect(x + h - 5, y + h - 5, 11, 11);
            g.setColor(Color.BLACK);
        }
        g.setColor(oldColor);
        g2.setStroke(new BasicStroke(1));
    }

    @Override
    public boolean isPointInsideShape(Point p) {
        int x1 = Math.min(getP1().x, getP2().x);
        int y1 = Math.min(getP1().y, getP2().y);
        int x2 = Math.max(getP1().x, getP2().x);
        int y2 = Math.max(getP1().y, getP2().y);
        int r = (Math.abs(getP1().x - getP2().x)) / 2;
        int xC = x1 + ((Math.abs(getP1().x - getP2().x)) / 2);
        int yC = y1 + (r);
        //   int destance = (int) Math.sqrt((Math.abs(xC - p.x)) * (Math.abs(xC - p.x)) + (Math.abs(p.y - yC)) * (Math.abs(p.y - yC)));

//        if (destance <= r) {
//            return true;
//        } else {
//
//            return false;
//        }
        if ((p.x >= x1 && p.x <= x2 && (p.y >= y1 && p.y <= y2))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public ArrayList<Shape> getLocalShape() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toSVG() {
        int x = Math.min(getP1().x, getP2().x);
        int y = Math.min(getP1().y, getP2().y);
        int w = Math.abs(getP1().x - getP2().x);
        int h = Math.abs(getP1().y - getP2().y);
        String svgString = "";
        svgString = String.format("<circle class=\"smilyFace1\" width=\"%d\" height=\"%d\" cx=\"%d\" cy=\"%d\" r=\"%d\"   fill=\"none\" stroke-width=\"%d\" stroke=\"%s\"/>",
                w, w, x + w / 2, y + w / 2, w / 2, getStroke(), this.converToHexa(strokeColor)
        );
        return svgString;
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

    public static Shape loadSVG(org.w3c.dom.Node node) {
        SmilyFace1 smilyFace1 = new SmilyFace1();
        NamedNodeMap map = node.getAttributes();
        Node widthNode = map.getNamedItem("width");
        Node heightNode = map.getNamedItem("height");
        Node cxNode = map.getNamedItem("cx");
        Node cyNode = map.getNamedItem("cy");
        Node r = map.getNamedItem("r");

        Node stroke = map.getNamedItem("stroke");
        Node stroke_width = map.getNamedItem("stroke-width");
        Node fill = map.getNamedItem("fill");

        smilyFace1.getP1().x = Integer.parseInt(cxNode.getNodeValue()) - Integer.parseInt(r.getNodeValue());
        smilyFace1.getP1().y = Integer.parseInt(cyNode.getNodeValue()) - Integer.parseInt(r.getNodeValue());
        smilyFace1.getP2().x = Integer.parseInt(cxNode.getNodeValue()) + Integer.parseInt(r.getNodeValue());
        smilyFace1.getP2().y = Integer.parseInt(cyNode.getNodeValue()) + Integer.parseInt(r.getNodeValue());

        if (stroke_width != null && stroke_width.getNodeValue() != null) {
            smilyFace1.strokeColor = Color.decode(stroke.getNodeValue());
            smilyFace1.stroke = Integer.parseInt(stroke_width.getNodeValue());
        } else {
            smilyFace1.nonStroke = true;
        }

        return smilyFace1;
    }
}
