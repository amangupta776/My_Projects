package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panel {
     static  String city;
   public panel(){

        JFrame frame=new JFrame("weather application");
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.CYAN);
        JTextField field=new JTextField("Enter your city Name");
        field.setBounds(20,20,300,60);
        frame.add(field);
        JButton sbutton=new JButton("search");
        sbutton.setBounds(350,20,120,60);
        frame.add(sbutton);
        ImageIcon icon=new ImageIcon("C:\\Users\\aman2\\Downloads\\dc7f8cdb406dc7704cccb5188ddc28c1.png");
        JLabel label=new JLabel(icon);
        label.setBounds(150,110,250,200);
        frame.add(label);
        JLabel label1=new JLabel("N/A");
        frame.add(label1);
        label1.setBounds(250,300,250,120);
        label1.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel label2=new JLabel("N/A");
        frame.add(label2);
        label2.setBounds(250,350,250,120);
        label2.setFont(new Font("Arial", Font.BOLD, 24));

//        ImageIcon icon2=new ImageIcon("C:\\Users\\aman2\\Downloads\\2nd.jpg");
//        Image image = icon2.getImage();
//        int desiredWidth = 200; // Customize the width as per your requirement
//        int desiredHeight = 150; // Customize the height as per your requirement
//        Image resizedImage = image.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
//        ImageIcon customIcon = new ImageIcon(resizedImage);
        JLabel label3=new JLabel("Humidity:");
        label3.setBounds(1,400,200,100);
        label3.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(label3);
        JLabel label4=new JLabel("WindSpeed:");
        label4.setBounds(320,400,250,100);
        label4.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(label4);


//        label3.setFont(new Font("Arial", Font.BOLD, 24));

        apiuse obj=new apiuse();

sbutton.addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
          city=field.getText();
          obj.CITY_NAME=city;
          obj.retrieveWeatherData();
           label1.setText(obj.temperature);
          label2.setText(String.valueOf(obj.CITY_NAME));
          label3.setText("Humidity:"+(obj.humidity));
          label4.setText("WindSpeed:"+(obj.windSpeed));
     }
});


        frame.setVisible(true);
    }
}
