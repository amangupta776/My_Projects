import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    static int a;
 static  Random random=new Random();
   static int b=random.nextInt(3);


    public static void main(String[] args) {

        JFrame frame=new JFrame("Stone Paper scissors");
        frame.setLayout(null);
        frame.setSize(500,800);
        JLabel label=new JLabel("Stone Paper Scissors Game VS Computer");
        label.setBounds(40,0,300,20);
        ImageIcon icon=new ImageIcon("C:\\Users\\aman2\\IdeaProjects\\stone paper scissors\\out\\production\\stone paper scissors\\img.png");
        JButton button=new JButton();
        button.setIcon(icon);
        button.setBounds(1,60,150,270);
        frame.add(button);
        frame.add(label);
        ImageIcon icon2=new ImageIcon("C:\\Users\\aman2\\IdeaProjects\\stone paper scissors\\out\\production\\stone paper scissors\\img_1.png");
        JButton button2=new JButton();
        button2.setIcon(icon2);
        button2.setBounds(157,60,150,270);
        frame.add(button2);
        ImageIcon icon3=new ImageIcon("C:\\Users\\aman2\\IdeaProjects\\stone paper scissors\\out\\production\\stone paper scissors\\img_2.png");
        JButton button3=new JButton();
        button3.setIcon(icon3);
        button3.setBounds(313,60,150,270);
        frame.add(button3);
        JButton button5=new JButton();
        button5.setBounds(157,400,150,270);
        frame.add(button5);
        JLabel label2=new JLabel("");
        label2.setBounds(40,700,300,20);
        frame.add(label2);
        JLabel label3=new JLabel("Computer choise--");
        label3.setBounds(20,300,150,270);
frame.add(label3);
button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        a=0;
        System.out.println(b);
        System.out.println(a);
        if(a==b){
            label2.setText("Game is draw");
           if(a==0){
             button5.setIcon(icon);
           } else if (a==1) {
              button5.setIcon(icon2);
           }else{
               button5.setIcon(icon3);
           }
        } else if (a==0&&b==2||a==1&&b==0||a==2&&b==1 ) {
            if (b==0){
                button5.setIcon(icon);
            } else if (b==1) {
                button5.setIcon(icon2);
            }else {
                button5.setIcon(icon3);
            }
            label2.setText("compuer wins");
        }else{
            if (b==0){
                button5.setIcon(icon);
            } else if (b==1) {
                button5.setIcon(icon2);
            }else {
                button5.setIcon(icon3);
            }
            label2.setText("You are win");
        }

    }
});
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=1;
                if(a==b){
                    label2.setText("Game is draw");
                    if(a==0){
                        button5.setIcon(icon);
                    } else if (a==1) {
                        button5.setIcon(icon2);
                    }else{
                        button5.setIcon(icon3);
                    }
                } else if (a==0&&b==2||a==1&&b==0||a==2&&b==1) {
                    if (b==0){
                        button5.setIcon(icon);
                    } else if (b==1) {
button5.setIcon(icon2);
                    }else {
                        button5.setIcon(icon3);
                    }
                    label2.setText("compuer wins");
                }else{
                    if (b==0){
                        button5.setIcon(icon);
                    } else if (b==1) {
                        button5.setIcon(icon2);
                    }else {
                        button5.setIcon(icon3);
                    }
                    label2.setText("You are win");
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a=2;
                if(a==b){
                    label2.setText("Game is draw");
                    if(a==0){
                        button5.setIcon(icon);
                    } else if (a==1) {
                        button5.setIcon(icon2);
                    }else{
                        button5.setIcon(icon3);
                    }
                } else if (a==0&&b==2||a==1&&b==0||a==2&&b==1) {
                    if (b==0){
                        button5.setIcon(icon);
                    } else if (b==1) {
                        button5.setIcon(icon2);
                    }else {
                        button5.setIcon(icon3);
                    }
                    label2.setText("compuer wins");
                }else{
                    if (b==0){
                        button5.setIcon(icon);
                    } else if (b==1) {
                        button5.setIcon(icon2);
                    }else {
                        button5.setIcon(icon3);
                    }
                    label2.setText("You are win");
                }
            }
        });


// Create a restart button
        JButton restartButton = new JButton("Restart");
        restartButton.setBounds(313, 700, 150, 50);
        frame.add(restartButton);


        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                label2.setText("");
                button5.setIcon(null);


                b = random.nextInt(3);
            }
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}