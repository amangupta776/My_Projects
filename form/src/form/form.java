package form;
import form.database;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class form {

   public form(){
        JFrame frame=new JFrame("Sign up");
        frame.setSize(400,400);
        //for name
        JLabel label=new JLabel("Name");
        label.setBounds(20,10,50,40);
        frame.add(label);
        JTextArea textarea=new JTextArea();
        textarea.setBounds(80,10,160,40);
        frame.add(textarea);
        //for age
       JLabel label2=new JLabel("Age");
       label2.setBounds(20,60,50,40);
       frame.add(label2);
       JTextArea textarea4=new JTextArea();
       textarea4.setBounds(80,60,160,40);
       frame.add(textarea4);
       //for gmail
       JLabel label3=new JLabel("Gmail");
       label3.setBounds(20,110,50,40);
       frame.add(label3);
       JTextArea textarea2=new JTextArea();
       textarea2.setBounds(80,110,160,40);
       frame.add(textarea2);
       //for password
       JLabel label4=new JLabel("Password");
       label4.setBounds(20,160,65,40);
       frame.add(label4);
       JPasswordField textarea3=new JPasswordField();
       textarea3.setBounds(80,160,160,40);
       frame.add(textarea3);
        frame.setLayout(null);
        //button
        JButton button =new JButton("Submit");
        button.setBounds(40,210,85,60);
        frame.add(button);
        //actionlistner for button
       button.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               database obj = new database();
               obj.details();
               String s = textarea.getText();
               String s2 = textarea4.getText();
               String s3 = textarea2.getText();
               String s4 = String.valueOf(textarea3.getPassword());

                if(s.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()){
                    JOptionPane.showMessageDialog(frame,"fill All fields for Sign up");
                }else{
                    try {
                        obj.smt.setString(1, s);
                        obj.smt.setString(2,s2);
                        obj.smt.setString(3,s3);
                        obj.smt.setString(4,s4);
                        obj.smt.executeUpdate();
                        System.out.println("inserted");
                    } catch (SQLException ex){
                        throw new RuntimeException(ex);
                    }
                }

           }
       });
       JButton button2=new JButton("Log In");
       button2.setBounds(180,210,85,60);
       frame.add(button2);
       button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               frame.setVisible(false);
             login obj=new login();
           }
       });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}

