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

public class Square extends Shape {

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
        // int min=Math.min(w, h);

        g.setColor(strokeColor);
        if (!nonStroke) {
            g.drawRect(x, y, w, w);
        }

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
            this.getP2().y = this.getP1().y + width;
        }

        g2.setStroke(new BasicStroke(1));
        g.setColor(color);
        if (isFilled()) {
            g.fillRect(x + 1, y + 1, w - 1, w - 1);
        }
        g.setColor(Color.BLACK);
        if (isSelected()) {
            g.setColor(Color.red);
            g.drawRect(x - 5, y - 5, 11, 11);

            g.drawRect(x + w - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + w - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, y + w - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + (w / 2) - 5, 11, 11);
            g.drawRect(x + w - 5, y + (w / 2) - 5, 11, 11);
            g.drawRect(x + w - 5, y + w - 5, 11, 11);
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
        if ((p.x >= x1 && p.x <= x2 && (p.y >= y1 && p.y <= y1 + x2 - x1))) {
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

            svgString = String.format("<rect width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\"  fill=\"%s\" stroke-width=\"%d\" stroke=\"%s\"/>",
                    w, w, x, y, this.converToHexa(this.getSelectedColor2()), getStroke(), this.converToHexa(strokeColor)
            );
        } else if (!isFilled() && !nonStroke) {

            svgString = String.format("<rect width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\" fill=\"none\"  stroke-width=\"%d\" stroke=\"%s\"/>",
                    w, w, x, y, getStroke(), this.converToHexa(strokeColor)
            );
        } else if (isFilled() && nonStroke) {

            svgString = String.format("<rect width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\"  fill=\"%s\"  />",
                    w, w, x, y, this.converToHexa(this.getSelectedColor2())
            );
        } else if (!isFilled() && nonStroke) {

            svgString = String.format("<rect width=\"%d\" height=\"%d\" x=\"%d\" y=\"%d\" fill=\"none\"    />",
                    w, w, x, y
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
