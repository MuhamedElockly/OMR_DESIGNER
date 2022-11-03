package paintprush.Shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.codegen.CompilerConstants;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import paintprush.DrawPanel;
import paintprush.Shape;

public class Line extends Shape {

    private Color color;

    public Line() {
        this(0, 0, 0, 0);
    }

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y2, x2, y2);
    }

    @Override
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
        //   g.drawLine(x, y, x + w, y + h);
        g2.setPaint(color);
        g2.setStroke(new BasicStroke(getStroke(),
                BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        //  g.setColor(this.color);
        g2.drawLine(getP1().x, getP1().y, getP2().x, getP2().y);

        g2.setStroke(new BasicStroke(1));

        if (isSelected()) {
            g.setColor(Color.red);
            g.drawRect(x, y, w, h);
            g.drawRect(x - 5, y - 5, 11, 11);

            g.drawRect(x + w - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + h - 5, 11, 11);
//            g.drawRect(x + (w / 2) - 5, y + h - 5, 11, 11);
//            g.drawRect(x + (w / 2) - 5, y - 5, 11, 11);
//            g.drawRect(x - 5, y + (h / 2) - 5, 11, 11);
//            g.drawRect(x + w - 5, y + (h / 2) - 5, 11, 11);
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

        int r = 0;
        if (Math.abs(getP1().x - getP2().x) != 0) {
            r = ((p.x - x1) * (Math.abs(getP1().y - getP2().y))) / (Math.abs(getP1().x - getP2().x));
        } else {
            r = ((p.x - x1) * (Math.abs(getP1().y - getP2().y)));
        }
        System.out.println(" r : " + r);
        if ((p.y >= ((y1 + r - 20)) && p.y <= ((y1 + r + 20)))) {

        }
        if ((p.x >= x1 && p.x <= x2) && (p.y >= (y1 + r - 5) && p.y <= (y1 + r + 5))) {

            return true;
        } else {

            return false;
        }

    }

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        System.out.println("is filled && ! nonstroke");

        svgString = String.format("<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" stroke=\"%s\"  stroke-width=\"%d\" />",
                getP1().x, getP1().y, getP2().x, getP2().y, this.converToHexa(strokeColor), getStroke()
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

//    public static Color hexaToRgb(String colorStr) {
//        return new Color(
//                Integer.valueOf(colorStr.substring(1, 3), 16),
//                Integer.valueOf(colorStr.substring(3, 5), 16),
//                Integer.valueOf(colorStr.substring(5, 7), 16));
//    }
    public static Shape loadSVG(org.w3c.dom.Node node) {
        Line line = new Line();
        NamedNodeMap map = node.getAttributes();
        Node x1Node = map.getNamedItem("x1");
        Node y1Node = map.getNamedItem("y1");
        Node x2Node = map.getNamedItem("x2");
        Node y2Node = map.getNamedItem("y2");
        Node stroke = map.getNamedItem("stroke");
        Node stroke_width = map.getNamedItem("stroke-width");

        line.getP1().x = Integer.parseInt(x1Node.getNodeValue());
        line.getP1().y = Integer.parseInt(y1Node.getNodeValue());
        line.getP2().x = Integer.parseInt(x2Node.getNodeValue());
        line.getP2().y = Integer.parseInt(y2Node.getNodeValue());
        line.strokeColor = Color.decode(stroke.getNodeValue());
        line.stroke = Integer.parseInt(stroke_width.getNodeValue());
        return line;
    }
}
