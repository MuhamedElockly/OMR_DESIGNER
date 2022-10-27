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
public class Hexagon extends Shape {

    Color color = null;
    int height = 0;
    int width = 0;

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
        width = w;
//        int xH[] = {x, (w / 4) + x, ((3 * w) / 4) + x, w + x, ((3 * w) / 4) + x, (w / 4) + x};
//        int yH[] = {y, (int) (y - (((Math.sqrt(3)) / 4) * w)), (int) (y - (((Math.sqrt(3)) / 4) * w)), y, (int) (y + (((Math.sqrt(3)) / 4) * w)), (int) (y + (((Math.sqrt(3)) / 4) * w))};
        int xH[] = {(w / 4) + x, ((3 * w) / 4) + x, w + x, ((3 * w) / 4) + x, (w / 4) + x, x};
        int yH[] = {y, y, (int) (y + (((Math.sqrt(3)) / 4) * w)), (int) (y + (((Math.sqrt(3)) / 4) * w) * 2),
            (int) (y + (((Math.sqrt(3)) / 4) * w) * 2), (int) (y + (((Math.sqrt(3)) / 4) * w))};

        height = h;

        g.setColor(strokeColor);
        if (!nonStroke) {
            g.drawPolygon(xH, yH, 6);
        }
        //   this.getP1().y=(int) (y - (((Math.sqrt(3)) / 4) * w));

        if (this.getP2().x < this.getP1().x && this.getP2().y > this.getP1().y) {
            this.getP2().x = this.getP1().x - width;
            this.getP2().y = this.getP1().y + width;
        } else if (this.getP2().x < this.getP1().x && this.getP2().y < this.getP1().y) {
            this.getP2().x = this.getP1().x - width;
            this.getP2().y = this.getP1().y - width;
        } else if (this.getP2().x > this.getP1().x && this.getP2().y < this.getP1().y) {
            this.getP2().x = this.getP1().x + width;
//            this.getP2().y = this.getP1().y - width;
            this.getP2().y = this.getP1().y - (int) ((((Math.sqrt(3)) / 4) * w) * 2);
        } else if (this.getP2().x > this.getP1().x && this.getP2().y > this.getP1().y) {
            this.getP2().x = this.getP1().x + width;
            this.getP2().y = (int) (y + (((Math.sqrt(3)) / 4) * w) * 2);
            // this.getP1().y=(int) (y - (((Math.sqrt(3)) / 4) * w));
        }

        g2.setStroke(new BasicStroke(1));
        g.setColor(color);
        if (isFilled()) {
            g.fillPolygon(xH, yH, 6);
        }
        g.setColor(Color.BLACK);
        if (isSelected()) {
            g.setColor(Color.red);
            g.drawRect(x - 5, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2) - 5, 11, 11);
            g.drawRect(x, y, w, (int) ((((Math.sqrt(3)) / 4) * w)) * 2);
            g.drawRect(x + w - 5, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2) - 5, 11, 11);
            g.drawRect(x - 5, y - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, y - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2) - 5, 11, 11);
            g.drawRect(x - 5, (int) (y + (((Math.sqrt(3)) / 4) * w)) - 5, 11, 11);
            g.drawRect(x + w - 5, y - 5, 11, 11);
            g.drawRect(x + w - 5, (int) (y + (((Math.sqrt(3)) / 4) * w)) - 5, 11, 11);
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
        int w = Math.abs(getP1().x - getP2().x);
        if ((p.x >= x1 && p.x <= x2 && (p.y >= y1 && p.y <= (int) (y1 + (((Math.sqrt(3)) / 4) * w) * 2)))) {
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
        int tH = (int) ((w / 2) / (Math.tan(Math.toRadians(30))));

        String svgString = "";
        if (isFilled() && !nonStroke) {
            System.out.println("isFilled && !nonStroke");
            svgString = String.format("<polygon  class=\"hexagon\" points=\"%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d\"    fill=\"%s\" stroke-width=\"%d\" stroke=\"%s\"/>",
                    (w / 4) + x, y, ((3 * w) / 4) + x, y, w + x,
                    ((int) (y + (((Math.sqrt(3)) / 4) * w))), ((3 * w) / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2),
                    (w / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2), x,
                    (int) (y + (((Math.sqrt(3)) / 4) * w)),
                    this.converToHexa(this.getSelectedColor2()), getStroke(), this.converToHexa(strokeColor)
            );
        } else if (!isFilled() && !nonStroke) {

            System.out.println("! isFilled && ! nonStroke");
            svgString = String.format("<polygon class=\"hexagon\" points=\"%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d\"  stroke-width=\"%d\" stroke=\"%s\"   fill=\"none\"  />",
                    (w / 4) + x, y, ((3 * w) / 4) + x, y, w + x,
                    ((int) (y + (((Math.sqrt(3)) / 4) * w))), ((3 * w) / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2),
                    (w / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2), x,
                    (int) (y + (((Math.sqrt(3)) / 4) * w)),
                    getStroke(), this.converToHexa(strokeColor)
            );
        } else if (isFilled() && nonStroke) {

            svgString = String.format("<polygon class=\"hexagon\"  points=\"%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d\"  fill=\"%s\"  />",
                    (w / 4) + x, y, ((3 * w) / 4) + x, y, w + x,
                    ((int) (y + (((Math.sqrt(3)) / 4) * w))), ((3 * w) / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2),
                    (w / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2), x,
                    (int) (y + (((Math.sqrt(3)) / 4) * w)),
                    this.converToHexa(this.getSelectedColor2())
            );
        } else if (!isFilled() && nonStroke) {
            System.out.println("! isFilled &&  nonStroke");
            svgString = String.format("<polygon  class=\"hexagon\" points=\"%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d\" fill=\"none\"    />",
                    (w / 4) + x, y, ((3 * w) / 4) + x, y, w + x,
                    ((int) (y + (((Math.sqrt(3)) / 4) * w))), ((3 * w) / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2),
                    (w / 4) + x, (int) (y + (((Math.sqrt(3)) / 4) * w) * 2), x,
                    (int) (y + (((Math.sqrt(3)) / 4) * w))
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
        Hexagon hexagon = new Hexagon();
        NamedNodeMap map = node.getAttributes();
        Node pointsNode = map.getNamedItem("points");
        Node stroke = map.getNamedItem("stroke");
        Node stroke_width = map.getNamedItem("stroke-width");
        Node fill = map.getNamedItem("fill");

        String[] values = pointsNode.getNodeValue().split(",");

        hexagon.getP1().x = Integer.parseInt(values[10]);
        hexagon.getP1().y = Integer.parseInt(values[1]);
        hexagon.getP2().x = Integer.parseInt(values[4]);
        hexagon.getP2().y = Integer.parseInt(values[7]);

        String temp = "none";
        if (!temp.equals(fill.getNodeValue())) {
            hexagon.setFilled(true);
            hexagon.setSelectedColor2(Color.decode(fill.getNodeValue()));
        } else {
            hexagon.setFilled(false);
        }
        if (stroke_width != null && stroke_width.getNodeValue() != null) {
            hexagon.strokeColor = Color.decode(stroke.getNodeValue());
            hexagon.stroke = Integer.parseInt(stroke_width.getNodeValue());
        } else {
            hexagon.nonStroke = true;
        }
        return hexagon;
    }
}
