package paintprush;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

public class InvisibleTextField extends JTextField
        implements ActionListener, FocusListener, MouseListener, DocumentListener {

    public InvisibleTextField() {
        // setPreferredSize(new Dimension(120, 50));

        setOpaque(false);
        setColumns(1);
        // setBorder(null);
        setSize(getPreferredSize());
        setColumns(0);
        addActionListener(this);
        addFocusListener(this);
        addMouseListener(this);
        getDocument().addDocumentListener(this);
        //  setSelectionColor(Color.red);
        //  setBackground(null);
        //   setSize(new Dimension(520, 50));
        //  setMargin(new Insets(20, 20, 20, 20));
//      BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY),
//                BorderFactory.createEmptyBorder(50, 50, 50, 50));
      //  Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
        Border empty = new EmptyBorder(5, 10, 5, 0);
        CompoundBorder border = new CompoundBorder(null, empty);
        this.setBorder(border);

        //  setMargin(new Insets(20, 20, 20, 20));
    }

//  Implement ActionListener
    public void actionPerformed(ActionEvent e) {
        setEditable(false);
        //  setEditable(true);
    }

//  Implement FocusListener
    public void focusLost(FocusEvent e) {
        setEditable(false);
        //  setEditable(true);
    }

    public void focusGained(FocusEvent e) {
    }

//  Implement MouseListener
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            setEditable(true);

        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

//  Implement DocumentListener
    public void insertUpdate(DocumentEvent e) {
        updateSize();
    }

    public void removeUpdate(DocumentEvent e) {
        updateSize();
    }

    public void changedUpdate(DocumentEvent e) {
    }

    private void updateSize() {
        setSize(getPreferredSize());
    }
}
