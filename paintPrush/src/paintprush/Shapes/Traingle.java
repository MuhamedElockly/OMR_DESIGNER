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

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import paintprush.Shapes.Traingle;

import paintprush.Shape;

public class Traingle extends Shape {

    Color color = null;
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
        // int tH = (int) (w / (Math.tan(Math.toRadians(30))));
        int tH = (int) ((w / 2) / (Math.tan(Math.toRadians(30))));
//        int xT[] = {x, x + w, (x - w)};
//        int yT[] = {y, y + tH, y + tH};
        int xT[] = {x + w / 2, (x + w), x};
        int yT[] = {y, y + tH, y + tH};

        g.setColor(strokeColor);
        if (!nonStroke) {

            g.drawPolygon(xT, yT, 3);
        }
        g2.setStroke(new BasicStroke(1));
        g.setColor(color);

        if (this.getP2().x < this.getP1().x && this.getP2().y > this.getP1().y) {
            this.getP2().x = this.getP1().x - width;
            this.getP2().y = this.getP1().y + width;
        } else if (this.getP2().x < this.getP1().x && this.getP2().y < this.getP1().y) {
            this.getP2().x = this.getP1().x - width;
            this.getP2().y = this.getP1().y - width;
        } else if (this.getP2().x > this.getP1().x && this.getP2().y < this.getP1().y) {
            this.getP2().x = this.getP1().x + width;
            this.getP2().y = this.getP1().y - width;
        } else if (this.getP2().x > this.getP1().x && this.getP2().y > this.getP1().y) {
            this.getP2().x = this.getP1().x + width;
            this.getP2().y = this.getP1().y + tH;
        }

        if (isFilled()) {
            g.fillPolygon(xT, yT, 3);
        }
        g.setColor(Color.BLACK);

        if (isSelected()) {
            g.setColor(Color.red);
            g.drawRect(x, y, w, tH);

            g.drawRect(x - 5, y - 5, 11, 11);
            g.drawRect(x + w / 2 - 5, y - 5, 11, 11);
            g.drawRect(x + w / 2 - 5, y + tH - 5, 11, 11);
            g.drawRect(x + (w) - 5, y + tH - 5, 11, 11);
            g.drawRect(x + (w) - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + tH - 5, 11, 11);
            g.drawRect(x + w - 5, y + tH / 2 - 5, 11, 11);
            g.drawRect(x - 5, y + tH / 2 - 5, 11, 11);
            g.setColor(Color.BLACK);
        }
        g.setColor(oldColor);
        g2.setStroke(new BasicStroke(1));
    }

    @Override
    public boolean isPointInsideShape(Point p) {

        int w1 = Math.abs(getP1().x - getP2().x);

        int x1 = Math.min(getP1().x, getP2().x);
        int y1 = Math.min(getP1().y, getP2().y);
        int x2 = Math.max(getP1().x, getP2().x);
        int y2 = Math.max(getP1().y, getP2().y);
        int w = Math.abs(getP1().x - getP2().x);
        // int trH=(int) (w1 / (Math.tan(Math.toRadians(30))));
        int tH = (int) ((w / 2) / (Math.tan(Math.toRadians(30))));

//       int x5=x1-w1;
//       int n=(p.x)-x5;
//       int f=(int) (n*(Math.tan(Math.toRadians(60))));
//       int z=y1+trH-f;
//       int x6=x1+w1;
//       int n2=x6-p.x;
//       int f2=(int) (n2*(Math.tan(Math.toRadians(60))));
//       
//       int r=y1+trH-f2;
//    
//        if (p.y>=y1&&p.y<=(y1+trH))
//        {
//            System.out.println("Truue YYYY");
//        }
//        if (p.y>=z&&p.y>=r)
//        {
//            System.out.println("Truue XXXX");
//        }
//        if((p.y>=y1&&p.y<=(y1+trH))&&(p.y>=z&&p.y>=r))
//        {
//            return true;
//        } else {
//
//            return false;
//        }
        if ((p.x >= x1 && p.x <= x2 && (p.y >= y1 && p.y <= y1 + tH))) {
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

            svgString = String.format("<polygon class=\"triangle\" points=\"%d,%d,%d,%d,%d,%d\" fill=\"%s\" stroke-width=\"%d\" stroke=\"%s\"/>",
                    x + w / 2, y, x + w, y + tH, x, y + tH, this.converToHexa(this.getSelectedColor2()), getStroke(), this.converToHexa(strokeColor)
            );
        } else if (!isFilled() && !nonStroke) {

            svgString = String.format("<polygon class=\"triangle\" points=\"%d,%d,%d,%d,%d,%d\"  stroke-width=\"%d\" stroke=\"%s\"   fill=\"none\"  />",
                    x + w / 2, y, x + w, y + tH, x, y + tH, getStroke(), this.converToHexa(strokeColor)
            );
        } else if (isFilled() && nonStroke) {

            svgString = String.format("<polygon class=\"triangle\" points=\"%d,%d,%d,%d,%d,%d\"  fill=\"%s\"  />",
                    x + w / 2, y, x + w, y + tH, x, y + tH, this.converToHexa(this.getSelectedColor2())
            );
        } else if (!isFilled() && nonStroke) {
            svgString = String.format("<polygon class=\"triangle\" points=\"%d,%d,%d,%d,%d,%d\" fill=\"none\"    />",
                    x + w / 2, y, x + w, y + tH, x, y + tH
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
        Traingle triangle = new Traingle();
        NamedNodeMap map = node.getAttributes();
        Node pointsNode = map.getNamedItem("points");
        Node stroke = map.getNamedItem("stroke");
        Node stroke_width = map.getNamedItem("stroke-width");
        Node fill = map.getNamedItem("fill");

        String[] values = pointsNode.getNodeValue().split(",");
  

        triangle.getP1().x = Integer.parseInt(values[4]);
        triangle.getP1().y = Integer.parseInt(values[1]);
        triangle.getP2().x = Integer.parseInt(values[2]);
        triangle.getP2().y = Integer.parseInt(values[3]);

        String temp = "none";
        if (!temp.equals(fill.getNodeValue())) {
            triangle.setFilled(true);
            triangle.setSelectedColor2(Color.decode(fill.getNodeValue()));
        } else {
            triangle.setFilled(false);
        }
        if (stroke_width != null && stroke_width.getNodeValue() != null) {
            triangle.strokeColor = Color.decode(stroke.getNodeValue());
            triangle.stroke = Integer.parseInt(stroke_width.getNodeValue());
        } else {
            triangle.nonStroke = true;
        }
        return triangle;
    }
}
