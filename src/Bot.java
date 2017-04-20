import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
/**
 * Created by Ilya on 17.04.2017.
 */
public class Bot extends JFrame implements ActionListener {
    final String TITLE_OF_PROGRAM="ChatBot";
    final int START_LOCATION=200;
    final int WINDOW_WIDTH=350;
    final int WINDOW_HEIGHT=450;

    JTextArea dialogue;
    JCheckBox ai;
    JTextField message;
    SimpleBot sbot;
    public static void main(String[] args) {
        new Bot();
    }

    Bot(){
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION,START_LOCATION,WINDOW_WIDTH,WINDOW_HEIGHT);
        dialogue=new JTextArea();
        dialogue.setLineWrap(true);
        JScrollPane scrollBar=new JScrollPane(dialogue);
        JPanel bp=new JPanel();
        bp.setLayout(new BoxLayout(bp,BoxLayout.X_AXIS));
        ai=new JCheckBox("AI");
        ai.doClick();
        message=new JTextField();
        message.addActionListener(this);
        JButton enter=new JButton("Enter");
        enter.addActionListener( this);
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER,scrollBar);
        add(BorderLayout.SOUTH,bp);
        setVisible(true);
        sbot=new SimpleBot();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(message.getText().trim().length()>0){
            dialogue.append(message.getText()+"\n");
            dialogue.append(TITLE_OF_PROGRAM.substring(0,0)+sbot.sayInReturn(message.getText(),ai.isSelected())+"\n");
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}
