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

/**
 *
 * @author dell
 */
public class Circle extends Shape {

    private Color color = null;

    int width = 0;

    public void draw(Graphics g, DrawPanel draw) {
        //    System.out.println("circle : " + this.getP1());
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(getStroke()));

        this.color = getSelectedColor2();
        Color oldColor = getSelectedColor2();
        g.setColor(getDrawColor());

        int x = Math.min(getP1().x, getP2().x);
        int y = Math.min(getP1().y, getP2().y);
        int w = Math.abs(getP1().x - getP2().x);

        //   int w = (getP1().x - getP2().x);
        int h = Math.abs(getP1().y - getP2().y);
        width = w;

//        
//         Graphics2D g2d = (Graphics2D) g;
//            g2d.setPaint(color);
//            g2d.setStroke(new BasicStroke(getStroke(),
//                              BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//            g2d.drawLine(this.getP1().x,this.getP1().y, widthOfPencil, widthOfPencil);
//            g2d.setStroke(new BasicStroke(1));
        //  int min=Math.min(w, h);
//        this.getP2().x=this.getP1().x+w;
//        this.getP2().y=this.getP1().y+w;
//             g.drawOval(x, y, w, w);
//        this.getP2().x = this.getP1().x + widthOfPencil;
//        this.getP2().y = this.getP1().y + widthOfPencil;

        g.setColor(this.getSelectedColor2());
      //  g.fillOval(x + 5, y + 5, w, w);
        // g2.setStroke(new BasicStroke(2));
        g2.drawLine(this.getP1().x, this.getP1().y, this.getP2().x, this.getP2().y);
        // g2.fillOval(x, y, w, w);
//        g.setColor(strokeColor);
//        g.setColor(Color.RED);
//        //     if (!nonStroke) {
//        //   g.drawOval(x, y, w, w);
//        }
//
//        if (this.getP2().x < this.getP1().x && this.getP2().y > this.getP1().y) {
//            this.getP2().x = this.getP1().x - width;
//            this.getP2().y = this.getP1().y + width;
//        } else if (this.getP2().x < this.getP1().x && this.getP2().y < this.getP1().y) {
//            this.getP2().x = this.getP1().x - width;
//            this.getP2().y = this.getP1().y - width;
//        } else if (this.getP2().x > this.getP1().x && this.getP2().y < this.getP1().y) {
//            this.getP2().x = this.getP1().x + width;
//            this.getP2().y = this.getP1().y - width;
//        } else if (this.getP2().x > this.getP1().x && this.getP2().y > this.getP1().y) {
//            this.getP2().x = this.getP1().x + width;
//            this.getP2().y = this.getP1().y + width;
//        }
//
//        g2.setStroke(new BasicStroke(1));
//        g.setColor(color);
//            g.setColor(Color.RED);
//        if (isFilled()) {
//            g.fillOval(x, y, w, w);
//        }
//        g.setColor(Color.BLACK);
//    g.setColor(Color.RED);
//        if (isSelected()) {
//            g.setColor(Color.red);
//            g.drawRect(x - 5, y - 5, 11, 11);
//            g.drawRect(x, y, w, w);
//            g.drawRect(x + w - 5, y - 5, 11, 11);
//            g.drawRect(x - 5, y + w - 5, 11, 11);
//            g.drawRect(x + (w / 2) - 5, y + w - 5, 11, 11);
//            g.drawRect(x + (w / 2) - 5, y - 5, 11, 11);
//            g.drawRect(x - 5, y + (w / 2) - 5, 11, 11);
//            g.drawRect(x + w - 5, y + (w / 2) - 5, 11, 11);
//            g.drawRect(x + w - 5, y + w - 5, 11, 11);
//            g.setColor(Color.BLACK);
//        }
        g.setColor(oldColor);
        g2.setStroke(new BasicStroke(1));
    }

    @Override
    public boolean isPointInsideShape(Point p) {

//          this.getP2().x=this.getP1().x+width;
//        this.getP2().y=this.getP1().y+width;
//        
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
        if ((p.x >= x1 && p.x <= x1 + width && (p.y >= y1 && p.y <= y1 + width))) {
            return true;
        } else {
            return false;
        }

    }

//    public Color getColor() {
//
//        return color;
//    }
//
//    public Color setColor(Color selectedColor) {
//        color = selectedColor;
//        return color;
//    }
    @Override
    public Color getColor() {

        return color;
    }
    int widthOfPencil = 0;

    public void setSize(int width) {
        this.getP2().x = this.getP1().x + width;
        this.getP2().y = this.getP1().y + width;

    }

    public void setWidthOfPencil(int width) {
        this.widthOfPencil = width;
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

            svgString = String.format("<circle width=\"%d\" height=\"%d\" cx=\"%d\" cy=\"%d\" r=\"%d\"   fill=\"%s\" stroke-width=\"%d\" stroke=\"%s\"/>",
                    w, w, x + w / 2, y + w / 2, w / 2, this.converToHexa(this.getSelectedColor2()), getStroke(), this.converToHexa(strokeColor)
            );
        } else if (!isFilled() && !nonStroke) {

            svgString = String.format("<circle width=\"%d\" height=\"%d\" cx=\"%d\" cy=\"%d\" r=\"%d\"  fill=\"none\" stroke-width=\"%d\" stroke=\"%s\"/>",
                    w, w, x + w / 2, y + w / 2, w / 2, getStroke(), this.converToHexa(strokeColor)
            );
        } else if (isFilled() && nonStroke) {
            svgString = String.format("<circle width=\"%d\" height=\"%d\" cx=\"%d\" cy=\"%d\" r=\"%d\"   fill=\"%s\" />",
                    w, w, x + w / 2, y + w / 2, w / 2, this.converToHexa(this.getSelectedColor2())
            );
            System.out.println("w : " + w);
        } else if (!isFilled() && nonStroke) {
            svgString = String.format("<circle width=\"%d\" height=\"%d\" cx=\"%d\" cy=\"%d\" r=\"%d\"  fill=\"none\" />",
                    w, w, x + w / 2, y + w / 2, w / 2
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

}
