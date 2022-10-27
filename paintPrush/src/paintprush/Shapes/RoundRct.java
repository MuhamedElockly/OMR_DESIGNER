/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author dell
 */
public class RoundRct extends Shape {

    Color color = null;

    public void draw(Graphics g, DrawPanel draw) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(getStroke()));
        this.color = getSelectedColor2();
        Color oldColor = getSelectedColor2();
        g.setColor(getDrawColor());

        int x = Math.min(getP1().x, getP2().x);
        int y = Math.min(getP1().y, getP2().y);
        int w = Math.abs(getP1().x - getP2().x);
        int h = Math.abs(getP1().y - getP2().y);
        g.setColor(strokeColor);

        if (!nonStroke) {
            g.drawRoundRect(x, y, w, h, h / 5, h / 5);
        }
        g.setColor(color);
        g2.setStroke(new BasicStroke(1));
        if (isFilled()) {
            g.fillRoundRect(x + 1, y + 1, w - 1, h - 1, h / 5, h / 5);
        }
        g.setColor(Color.BLACK);
        if (isSelected()) {

            g.setColor(Color.red);
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

    @Override
    public boolean isPointInsideShape(Point p) {
        int x1 = Math.min(getP1().x, getP2().x);
        int y1 = Math.min(getP1().y, getP2().y);
        int x2 = Math.max(getP1().x, getP2().x);
        int y2 = Math.max(getP1().y, getP2().y);
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
        if (isFilled() && !nonStroke) {

            svgString = String.format("<rect class=\"roundRect\" width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\" rx=\"%d\"  ry=\"%d\" fill=\"%s\" stroke-width=\"%d\" stroke=\"%s\"/>",
                    w, h, x, y, h / 5, h / 5, this.converToHexa(this.getSelectedColor2()), getStroke(), this.converToHexa(strokeColor)
            );
        } else if (!isFilled() && !nonStroke) {

            svgString = String.format("<rect  class=\"roundRect\" width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\" rx=\"%d\"  ry=\"%d\"  fill=\"none\"  stroke-width=\"%d\" stroke=\"%s\"/>",
                    w, h, x, y, h / 5, h / 5, getStroke(), this.converToHexa(strokeColor)
            );
        } else if (isFilled() && nonStroke) {

            svgString = String.format("<rect class=\"roundRect\"  width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\" rx=\"%d\"  ry=\"%d\" fill=\"%s\"  />",
                    w, h, x, y, h / 5, h / 5, this.converToHexa(this.getSelectedColor2())
            );
        } else if (!isFilled() && nonStroke) {

            svgString = String.format("<rect class=\"roundRect\" width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\" rx=\"%d\"  ry=\"%d\"  fill=\"none\"    />",
                    w, h, x, y, h / 5, h / 5
            );
        }
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
        RoundRct roundRect = new RoundRct();
        NamedNodeMap map = node.getAttributes();
        Node widthNode = map.getNamedItem("width");
        Node heightNode = map.getNamedItem("height");
        Node xNode = map.getNamedItem("x");
        Node yNode = map.getNamedItem("y");
        Node stroke = map.getNamedItem("stroke");
        Node stroke_width = map.getNamedItem("stroke-width");
        Node fill = map.getNamedItem("fill");

        System.out.println(node.getTextContent());

        roundRect.getP1().x = Integer.parseInt(xNode.getNodeValue());
        roundRect.getP1().y = Integer.parseInt(yNode.getNodeValue());
        roundRect.getP2().x = roundRect.getP1().x + Integer.parseInt(widthNode.getNodeValue());
        roundRect.getP2().y = roundRect.getP1().y + Integer.parseInt(heightNode.getNodeValue());

        String temp = "none";
        if (!temp.equals(fill.getNodeValue())) {
            roundRect.setFilled(true);
            roundRect.setSelectedColor2(Color.decode(fill.getNodeValue()));
        } else {
            roundRect.setFilled(false);
        }
        if (stroke_width != null && stroke_width.getNodeValue() != null) {
            roundRect.strokeColor = Color.decode(stroke.getNodeValue());
            roundRect.stroke = Integer.parseInt(stroke_width.getNodeValue());
        } else {
            roundRect.nonStroke = true;
        }

        return roundRect;
    }
}
