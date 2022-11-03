package paintprush.Shapes;

import paintprush.InvisibleTextField;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JWindow;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import paintprush.DrawPanel;
import paintprush.Shape;

public class Text extends Shape {

    public int count = 0;

    int fontSize = 50;

    public InvisibleTextField tf;
    DrawPanel draw1;
    Point temp7;
    Point temp6;
    int tempStroke = 0;

    DrawPanel drawPanel;
    Color color = null;
    String text = " Click To Edit ";
    int x1;
    int y1;
    int x2;
    int y2;
    int w = 0;
    int h = 0;
    int defultHeight = 0;
    int defulfWidth = 0;
    int textHeight = 0;
    int textwidth = 0;
    float heightRatio = 1;
    float widthRatio = 1;
    double ratio = 1;
    int firistWidth = 0;
    float areaAfter = 1;
    float areaBefore = 1;
    int tempHeight = 0;

    public Text(DrawPanel draw, String text, int fontsize) {
        this.text = text;
        this.fontSize = fontsize;
         tempStroke = getStroke();
        font = new Font("TimesRoman", Font.BOLD, (int) (fontSize));
        FontMetrics metrics = draw.getOffScreenGraphics().getFontMetrics();
        FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
        textHeight = (int) font.createGlyphVector(metrics.getFontRenderContext(), text).getVisualBounds().getHeight() + 20;
        textwidth = (int) (font.getStringBounds(text, frc).getWidth()) + 10;
        tempHeight = textHeight;
        defulfWidth = textwidth;
    }

    public Text(DrawPanel draw) {
        //      count++;
        //   System.out.println("hfhfhfhhhhhhhhh");
//        fontSize = 70;

        tempStroke = getStroke();
//        int x4 = Math.min(getP1().x, getP2().x);
//        int y4 = Math.min(getP1().y, getP2().y);
////
////        this.drawPanel = draw;
//        //  Color oldColor = getSelectedColor2();
//        //   draw.getOffScreenGraphics().setColor(Color.BLUE);
//        // draw.getOffScreenGraphics().drawRect(300, 100, 50, 60);
//
//        // draw.getOffScreenGraphics().setColor(oldColor);
//        //  System.out.println(draw.getOffScreenGraphics().getColor());
//        fontSize = 60;
//        font = new Font("TimesRoman", Font.BOLD, (int) (fontSize));
//        FontMetrics metrics = draw.getOffScreenGraphics().getFontMetrics();
//        FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
//        textHeight = (int) font.createGlyphVector(metrics.getFontRenderContext(), text).getVisualBounds().getHeight() + 20;
//        textwidth = (int) (font.getStringBounds(text, frc).getWidth()) + 10;
//        tempHeight = textHeight;
//        defulfWidth = textwidth;

////              defultHeight = 63;
////            defulfWidth = 320;
////        textHeight = defultHeight;
////        textwidth = defulfWidth;
//        tf = new InvisibleTextField();
//        tf.setFont(font);
//        temp6 = new Point();
//        temp7 = new Point();
//        temp6 = this.getP1();
//        temp7 = this.getP2();
//        Point tempP1 = new Point();
//        tempP1.x = x4 + draw.x_offScreen;
//        tempP1.y = y4 + draw.y_offScreen;
//        tf.setLocation(tempP1);
//        draw.add(tf);
//        //  tf.setRequestFocusEnabled(true);
//        tf.requestFocusInWindow();
//        tf.setText(this.getText());
//        // tf.selectAll();
//        tf.setVisible(true);
//        tf.setEditable(false);
//        this.getP2().x = this.getP1().x + defulfWidth;
//        this.getP2().y = this.getP1().y + defultHeight;
//        tf.setSize(defulfWidth, defultHeight);
//        System.out.println(temp6);
//        System.out.println(this.getP1()+" "+this.getP2());
    }

    @Override
    public boolean isPointInsideShape(Point p) {
        int x1 = Math.min(getP1().x, getP2().x);
        int y1 = Math.min(getP1().y, getP2().y);
        int x2 = Math.max(getP1().x, getP2().x);
        int y2 = Math.max(getP1().y, getP2().y);
        if ((p.x >= x1 - 5 && p.x <= x2 + 5) && (p.y >= y1 - 5 && p.y <= y2 + 5)) {
            return true;
        } else {
            return false;
        }
    }
    int x4 = Math.min(getP1().x, getP2().x);
    int y4 = Math.min(getP1().y, getP2().y);
    Font font;

    @Override
    public void draw(Graphics g, DrawPanel draw) {
        draw1 = draw;
        int x4 = Math.min(getP1().x, getP2().x);
        int y4 = Math.min(getP1().y, getP2().y);
        if (count < 1) {
            //   System.out.println(fontSize);
            Font font = new Font("TimesRoman", Font.BOLD, (int) (fontSize));
            FontMetrics metrics = g.getFontMetrics();
            FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
            textHeight = (int) font.createGlyphVector(metrics.getFontRenderContext(), text).getVisualBounds().getHeight() + 20;
            textwidth = (int) (font.getStringBounds(text, frc).getWidth()) + 10;
            defultHeight = textHeight;
            defulfWidth = textwidth;
//              defultHeight = 63;
//            defulfWidth = 320;
//            textHeight = defultHeight;
//            textwidth = defulfWidth;
            tf = new InvisibleTextField();
            temp6 = new Point();
            temp7 = new Point();
            temp6 = this.getP1();
            temp7 = this.getP2();
            Point tempP1 = new Point();
            tempP1.x = x4 + draw.x_offScreen;
            tempP1.y = y4 + draw.y_offScreen;
            tf.setLocation(tempP1);
            draw.add(tf);
            //  tf.setFont(font);
            //  tf.setRequestFocusEnabled(true);
            tf.requestFocusInWindow();
            tf.setText(this.getText());
            // tf.selectAll();
            tf.setVisible(true);
            tf.setEditable(false);
            this.getP2().x = this.getP1().x + defulfWidth;
            this.getP2().y = this.getP1().y + defultHeight;
            tf.setSize(defulfWidth, defultHeight);
            //    System.out.println(this.getP1() + " " + this.getP2());
        }
        if (draw.isShiftButton() == true && ((!draw.allShapes.contains(this) && draw.getToolPanel().isDrawing() == true) || (draw.allShapes.contains(this) && draw.getToolPanel().isDrawing() == false)) && (draw.getSelectedShape() == this)) {
            this.getP2().x = this.getP1().x + Math.min(w, h);
            //   this.getP2().y = this.getP1().y + Math.min(w, h);
        }
        tf.setHorizontalAlignment(JTextField.RIGHT);
        defultHeight = tf.getHeight();
        defulfWidth = tf.getWidth();
        w = Math.abs(getP1().x - getP2().x);
        h = Math.abs(getP1().y - getP2().y);
//System.out.println(getP1()+" "+getP2());
        Point tempP2 = new Point();
        tempP2.x = x4 + draw.x_offScreen;
        tempP2.y = y4 + draw.y_offScreen;
        tf.setLocation(tempP2);
        count++;
        this.setText(tf.getText());
        //  System.out.println(fontSize);
        font = new Font("TimesRoman", Font.BOLD, (int) (fontSize));
        FontMetrics metrics = g.getFontMetrics();
        FontRenderContext frc = new FontRenderContext(new AffineTransform(), true, true);
        textHeight = (int) font.createGlyphVector(metrics.getFontRenderContext(), text).getVisualBounds().getHeight() + 20;
        textwidth = (int) (font.getStringBounds(text, frc).getWidth()) + 10;
        tf.setFont(font);
        tf.setForeground(strokeColor);
        // areaBefore = textwidth * textHeight;
        tf.setSize(new Dimension(w, h));
        //   areaAfter = tf.getWidth() * tf.getHeight();
        if (this.getP2().x < (this.getP1().x + textwidth) || this.getP2().y < (this.getP1().y + textHeight)) {
            if ((this.getP2().x < (this.getP1().x + textwidth)) && (this.getP2().y < (this.getP1().y + textHeight))) {
                //   fontSize--;
                //System.out.println("font : " + font.getSize());
                //     areaAfter = Math.abs((this.getP2().x - this.getP1().x) * (this.getP2().y - this.getP1().y));
//                      System.out.println("areaAfter : " + areaAfter);
            }

            //   this.getP2().x = this.getP1().x + textwidth;
            //this.getP2().y = this.getP1().y + textHeight;
        } else if (this.getP2().x > (this.getP1().x + tf.getWidth()) || this.getP2().y > (this.getP1().y + tf.getHeight())) {

            if (this.getP2().x > (this.getP1().x + tf.getWidth()) && this.getP2().y > (this.getP1().y + tf.getHeight())) {
                //    areaAfter = Math.abs((this.getP2().x - this.getP1().x) * (this.getP2().y - this.getP1().y));
                //  fontSize++;
//               System.out.println("areaBefore : " + areaBefore);
            }
        }
        heightRatio = (float) tf.getHeight() / (float) textHeight;
        widthRatio = (float) tf.getWidth() / (float) textwidth;
        //   System.out.println("textwidth " + textwidth);
        // ratio = (float) areaAfter / (float) areaBefore;
        //    ratio = ratio = Math.min(heightRatio, widthRatio);

        if (getStroke() != tempStroke) {
            tempStroke = getStroke();
            fontSize = tempStroke * 20;

            font = new Font("TimesRoman", Font.BOLD, (int) (fontSize));
            metrics = g.getFontMetrics();
            frc = new FontRenderContext(new AffineTransform(), true, true);
            textHeight = (int) font.createGlyphVector(metrics.getFontRenderContext(), text).getVisualBounds().getHeight() + 20;
            textwidth = (int) (font.getStringBounds(text, frc).getWidth()) + 10;

            this.getP2().x = this.getP1().x + textwidth;
            this.getP2().y = this.getP1().y + textHeight;
            w = Math.abs(getP1().x - getP2().x);
            h = Math.abs(getP1().y - getP2().y);
            tf.setSize(new Dimension(w, h));
            //  System.out.println("yess  : " + fontSize);
        }

        ratio = widthRatio;
        //  System.out.println("ratio  : " + ratio);
        if (font.getSize() > 1) {
            // ratio=1;
            fontSize *= ratio;
        } else if (font.getSize() == 1) {
            fontSize++;
        }

        Graphics2D g2 = (Graphics2D) g;
        this.color = getSelectedColor2();
        Color oldColor = getSelectedColor2();
        g.setColor(getDrawColor());
        g.setFont(font);
        g.setColor(strokeColor);
        if (!this.isSelected()) {
            tf.setVisible(false);
            g.drawString(this.getText(), this.getP1().x + 10, this.getP1().y + tf.getHeight() / 2 + textHeight / 2 - 10);
        } else {
            tf.setVisible(true);
            this.setText(tf.getText());
            draw.repaint();
        }
        g.setColor(Color.BLACK);
        if (isSelected()) {
            w = Math.abs(getP1().x - getP2().x);
            h = Math.abs(getP1().y - getP2().y);
            int x = x4;
            int y = y4;
            g.setColor(Color.red);
            g.drawRect(x - 5, y - 5, 11, 11);
            g.drawRect(x + w - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + h - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, y + h - 5, 11, 11);
            g.drawRect(x + (w / 2) - 5, y - 5, 11, 11);
            g.drawRect(x - 5, y + (h / 2) - 5, 11, 11);
            g.drawRect(x + w - 5, y + (h / 2) - 5, 11, 11);
            g.drawRect(x + w - 5, y + h - 5, 11, 11);
            g.drawRect(x, y, tf.getWidth(), tf.getHeight());
            g.setColor(Color.BLACK);
        }
        g.setColor(oldColor);
        g2.setStroke(new BasicStroke(1));
    }

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setText(String edatableText) {
        this.text = edatableText;
    }

    public String getText() {
        return this.text;
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
        svgString = String.format("<text x=\"%d\" y=\"%d\" font-family=\"TimesRoman\" class=\"%s\" font-size=\"%d\" fill=\"%s\" text-anchor=\"start\" >" + this.getText() + "</text>",
                //     x1, y2 + h, this.getStroke() * 22, this.converToHexa(this.strokeColor)
                this.getP1().x + 10,this.getP1().y + tf.getHeight() / 2 + textHeight / 2 - 10, this.getText(), fontSize, this.converToHexa(this.strokeColor)
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
            ((Text) s).count = 0;
            ((Text) s).setText(((Text) s).getText());
            return s;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Circle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Shape loadSVG(org.w3c.dom.Node node, DrawPanel drawPanel) {

        NamedNodeMap map = node.getAttributes();

        Node xNode = map.getNamedItem("x");
        Node yNode = map.getNamedItem("y");
        Node font_size = map.getNamedItem("font-size");
        Node text = map.getNamedItem("class");
        //     Node stroke_width = map.getNamedItem("stroke-width");
        Node fill = map.getNamedItem("fill");
        Text text1 = new Text(drawPanel, text.getNodeValue(), Integer.parseInt(font_size.getNodeValue()));
        // text1.text = text.getNodeValue();
        //  text1.setText(text.getNodeValue());
        //   text1.fontSize = Integer.parseInt(font_size.getNodeValue());
        //  System.out.println("font : " + text1.fontSize);
        System.out.println("t : " + text1.text + " font : " + text1.fontSize);
        text1.getP1().x = Integer.parseInt(xNode.getNodeValue()) - 10;
        text1.getP1().y = Integer.parseInt(yNode.getNodeValue()) - (text1.tempHeight )+10 ;
        System.out.println("defalut : " + text1.tempHeight);
        //  text1.getP1().y = Integer.parseInt(yNode.getNodeValue()) - (text1.defultHeight / 2 + text1.defultHeight / 2 - 10);
        // System.out.println(text.getNodeValue());
        String temp = "none";
        if (!temp.equals(fill.getNodeValue())) {
            text1.setFilled(true);
            text1.strokeColor = Color.decode(fill.getNodeValue());
        } else {
            text1.setFilled(false);
        }

        return text1;
    }
}
