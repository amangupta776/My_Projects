import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {
    static int counter = 1;
    static JFrame frame;
    static JButton button1;
    static JButton button2;
    static JButton button3;
    static JButton button4;
    static JButton button5;
    static JButton button6;
    static JButton button7;
    static JButton button8;
    static JButton button9;
static  JButton button;
    class MyAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            button = (JButton) e.getSource();
            String bb = button.getText();
            if (bb.isEmpty()) {
                counter++;
                if (counter % 2 == 0) {
                    button.setText("X");
                    frame.setTitle(" Now O Turn");
                } else {
                    button.setText("O");
                    frame.setTitle("Now X Turn");
                }
            } else {
                JOptionPane.showMessageDialog(frame, "already filled");
            }

            String a = button1.getText();
            String b = button2.getText();
            String c = button3.getText();
            String d = button4.getText();
            String ee = button5.getText();
            String f = button6.getText();
            String g = button7.getText();
            String h = button8.getText();
            String j = button9.getText();

            if (a.equals("O") && b.equals("O") && c.equals("O") ||
                    d.equals("O") && ee.equals("O") && f.equals("O") ||
                    g.equals("O") && h.equals("O") && j.equals("O") ||
                    a.equals("O") && ee.equals("O") && j.equals("O") ||
                    c.equals("O") && ee.equals("O") && g.equals("O") ||
                    a.equals("O") && d.equals("O") && g.equals("O") ||
                    b.equals("O") && ee.equals("O") && h.equals("O") ||
                    c.equals("O") && f.equals("O") && j.equals("O")

            ) {

                Options("O is win");
            }

            else if (a.equals("X") && b.equals("X") && c.equals("X") ||
                    d.equals("X") && ee.equals("X") && f.equals("X") ||
                    g.equals("X") && h.equals("X") && j.equals("X") ||
                    a.equals("X") && ee.equals("X") && j.equals("X") ||
                    c.equals("X") && ee.equals("X") && g.equals("X") ||
                    a.equals("X") && d.equals("X") && g.equals("X") ||
                    b.equals("X") && ee.equals("X") && h.equals("X") ||
                    c.equals("X") && f.equals("X") && j.equals("X")

            ) {
Options("X is win");
            }
          else  if (!a.isEmpty()&&!b.isEmpty()&&!c.isEmpty()&&!d.isEmpty()&&!ee.isEmpty()&&
                    !f.isEmpty()&&!g.isEmpty()&&!h.isEmpty()&&!j.isEmpty()

            ) {
              Options("Game is Draw");

            }
        }
public void Options(String s){
    JOptionPane.showMessageDialog(frame, s);
    button1.setEnabled(false);
    button2.setEnabled(false);
    button3.setEnabled(false);
    button4.setEnabled(false);
    button5.setEnabled(false);
    button6.setEnabled(false);
    button7.setEnabled(false);
    button8.setEnabled(false);
    button9.setEnabled(false);
    Object[] options = {"Restart Game", "Exit"};
    int result = JOptionPane.showOptionDialog(frame, s, "Message", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    switch (result) {
        case 0:
            restart();
            break;
        case 1:
            frame.dispose();
            break;
    }
}
        public void restart() {
            counter=1;
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            button4.setEnabled(true);
            button5.setEnabled(true);
            button6.setEnabled(true);
            button7.setEnabled(true);
            button8.setEnabled(true);
            button9.setEnabled(true);
            frame.setTitle("Now X turn");
            button1.setText("");
            button2.setText("");
            button3.setText("");
            button4.setText("");
            button5.setText("");
            button6.setText("");
            button7.setText("");
            button8.setText("");
            button9.setText("");
        }
    }

        public static void main(String[] args) {
            frame = new JFrame("Tic Tac Toe ");
            frame.setBounds(560,220,400,400);
            GridLayout layout = new GridLayout(3, 3);
            frame.setLayout(layout);
            Object[] options = {"X", "O"};
            int result = JOptionPane.showOptionDialog(frame, "Choose :","Message", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (result) {
                case 0:
                    counter=1;
                    break;
                case 1:
                   counter=2;
                    break;
            }

            button1 = new JButton();
            frame.add(button1);
            button2 = new JButton();
            frame.add(button2);
            button3 = new JButton();
            frame.add(button3);
            button4 = new JButton();
            frame.add(button4);
            button5 = new JButton();
            frame.add(button5);
            button6 = new JButton();
            frame.add(button6);
            button7 = new JButton();
            frame.add(button7);
            button8 = new JButton();
            frame.add(button8);
            button9 = new JButton();
            frame.add(button9);
            Main main = new Main();
            MyAction myAction = main.new MyAction();
            button1.addActionListener(myAction);
            button2.addActionListener(myAction);
            button3.addActionListener(myAction);
            button4.addActionListener(myAction);
            button5.addActionListener(myAction);
            button6.addActionListener(myAction);
            button7.addActionListener(myAction);
            button8.addActionListener(myAction);
            button9.addActionListener(myAction);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }
