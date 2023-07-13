package group.chatting.application;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public class UserOne implements ActionListener, Runnable {

    JTextField text;
    JPanel a1;
    static JPanel vertical = new JPanel();
    static JScrollPane scrollPane;
    static JFrame f = new JFrame();
    static DataOutputStream dout;

    BufferedReader reader;
    BufferedWriter writer;
    String name = "user1";

    UserOne() {

        f.setLayout(null);

        JPanel p1 = new JPanel();

        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/22.jpg"));
        Image i5 = i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 5, 60, 60);
        p1.add(profile);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);

        JLabel nameLabel = new JLabel("Group chat ");
        nameLabel.setBounds(110, 15, 100, 18);
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(nameLabel);

        JLabel status = new JLabel("User1");
        status.setBounds(110, 35, 160, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        a1.setBackground(Color.WHITE);
        a1.setLayout(new BorderLayout());

        vertical.setLayout(new BoxLayout(vertical, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(vertical);
        scrollPane.setBounds(5, 75, 440, 570);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        a1.add(scrollPane, BorderLayout.CENTER);

        f.add(a1);

        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);

        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(send);
        f.setSize(450, 700);
        f.setLocation(20, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);


        try {
            Socket socket = new Socket("localhost", 2003);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent ae) {
        String message = text.getText();
        text.setText("");
        try {

            String out = "<html><p>" + name + "</p><p>" + message + "</p></html>";

            JPanel p2 = formatLabel(out);

            JPanel right = new JPanel(new BorderLayout());
            right.setBackground(Color.WHITE);
            right.add(p2, BorderLayout.LINE_END);
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.revalidate();
            a1.repaint();

            try {
                writer.write(out);
                writer.write("\r\n");
                writer.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

            text.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userName = "user1";
        String insertQuery = "INSERT INTO message (user_name, message) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app", "root", "123456");
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            stmt.setString(1, userName);
            stmt.setString(2, message);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error inserting message into database: " + ex.getMessage());
        }
    }
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(0, 15, 0, 50));

        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));

        panel.add(time);

        return panel;
    }
    public static JPanel formatLabel(String out, String time) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(0, 15, 0, 50));

        panel.add(output);

        JLabel timeLabel = new JLabel(time);
        panel.add(timeLabel);

        return panel;
    }


    public void run() {
        try {
            // Retrieve messages from the database
            String selectQuery = "SELECT user_name,created_at, message FROM message";
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_app", "root", "123456");
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectQuery)) {

                while (rs.next()) {
                    String userName = rs.getString("user_name");
                    String message = rs.getString("message");
                    String time = rs.getString("created_at");

if(userName.equals("user1")){
//    String out = "<html><p>" + name + "</p><p>" + message + "</p></html>";
//
//    JPanel p2 = formatLabel(out);
//
//    JPanel right = new JPanel(new BorderLayout());
//    right.setBackground(Color.WHITE);
//    right.add(p2, BorderLayout.LINE_END);
//    vertical.add(right);
//    vertical.add(Box.createVerticalStrut(15));
    String msg = "<html><p>" + userName + "</p><p>" + message + "</p></html>";

    JPanel panel = formatLabel(msg, time);

    JPanel right = new JPanel(new BorderLayout());
    right.setBackground(Color.WHITE);
    right.add(panel, BorderLayout.LINE_END);
    vertical.add(right);

}else{
//    String msg = "<html><p>" + userName + "</p><p>" + message + "</p></html>";
//
//    JPanel panel = formatLabel(msg);
//
//    JPanel left = new JPanel(new BorderLayout());
//    left.setBackground(Color.WHITE);
//    left.add(panel, BorderLayout.LINE_START);
//    vertical.add(left);
    String msg = "<html><p>" + userName + "</p><p>" + message + "</p></html>";

    JPanel panel = formatLabel(msg, time);

    JPanel left = new JPanel(new BorderLayout());
    left.setBackground(Color.WHITE);
    left.add(panel, BorderLayout.LINE_START);
    vertical.add(left);
}
                }

                vertical.revalidate();
                vertical.repaint();

                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
            } catch (SQLException ex) {
                System.out.println("Error retrieving messages from database: " + ex.getMessage());
            }

            // Start listening for new messages
            String msg;
            while (true) {
                msg = reader.readLine();
                if (msg.contains(name)) {
                    continue;
                }
                JPanel panel = formatLabel(msg);

                JPanel left = new JPanel(new BorderLayout());
                left.setBackground(Color.WHITE);
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);

                vertical.revalidate();
                vertical.repaint();

                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        UserOne one = new UserOne();
        Thread t1 = new Thread(one);
        t1.start();
    }
}