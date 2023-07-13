package form;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login {
    login(){
        JFrame frame1=new JFrame("Login");
        frame1.setSize(400,400);
        frame1.setLayout(null);
        //for name
        JLabel label11=new JLabel("Mail");
        label11.setBounds(20,10,50,40);
        frame1.add(label11);
        JTextArea textarea111=new JTextArea();
        textarea111.setBounds(80,10,160,40);
        frame1.add(textarea111);
        //for password
        JLabel label21=new JLabel("Password");
        label21.setBounds(20,60,65,40);
        frame1.add(label21);
        JPasswordField textarea11=new JPasswordField();
        textarea11.setBounds(80,60,160,40);
        frame1.add(textarea11);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        //button
        JButton button11 =new JButton("Submit");
        button11.setBounds(40,110,85,60);
        frame1.add(button11);
        //button
        JButton button22 =new JButton("signup");
        button22.setBounds(190,110,85,60);
        frame1.add(button22);

        button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame1.setVisible(false);
                form obj2=new form();
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a= textarea111.getText();
                String b=String.valueOf(textarea11.getPassword());
               database obj=new database();
               obj.fetchdata();
          if(a.isEmpty()||b.isEmpty()){
              JOptionPane.showMessageDialog(frame1,"Enter all fields");
          }else{
              try {
                  int i=0;
                  while (obj.set.next()) {

                      String a1=obj.set.getString(4);
                      String b2=obj.set.getString(5);

                      if(a1.equals(a)&&b2.equals(b)){
                          frame1.setVisible(false);

                          i++;

                          break;
                      }
                  }
                  if(i==0){

                      JOptionPane.showMessageDialog(frame1,"Wrong id and password");

                  }
              }catch(Exception ef){

              }
          }
            }
        });
    }
}
