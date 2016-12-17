

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Денис on 28.10.2016.
 */
public class Login_Window extends JPanel {

    public void Start_Login_Window() {

        final DBWorker dbWorker = new DBWorker();

        final JFrame jf = new JFrame("Login");
        jf.add(new Login_Window());
        jf.setSize(300, 200);

        JLabel loginLabel = new JLabel("Login: ");
        final JTextField loginField = new JTextField(10);
        JLabel passLabel = new JLabel("Password: ");
        final JTextField passField = new JTextField(10);
        final JButton loginButton = new JButton("Login");
        JButton cancelButton = new JButton("Cancel");
        final JLabel error_1_Label = new JLabel("Incorrect login or password");
        error_1_Label.setVisible(false);

        jf.setLayout(null);
        loginLabel.setBounds(80, 40, 40, 20);
        loginField.setBounds(150, 40, 90, 20);
        passLabel.setBounds(80, 60, 65, 20);
        passField.setBounds(150, 60, 90, 20);
        loginButton.setBounds(80, 90, 70, 30);
        cancelButton.setBounds(159, 90, 80, 30);
        error_1_Label.setBounds(81, 110, 190, 40);

        error_1_Label.setForeground(Color.RED);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String password = passField.getText();
                try {
                    User user = dbWorker.checkUser(login, password);
                    if (user != null && user.getRole() == 1) {
                        jf.setVisible(false);
                        User_Page.User_Page_Start();
                    }
                    if (user != null && user.getRole() == 2){
                        jf.setVisible(false);
                        Admin_Page.Admin_Page_Start();
                    }
                    if (user != null && user.getRole() == 3){
                        jf.setVisible(false);
                        Manager_Page.Manager_Page_Start();
                    }
                    else {
                        System.out.print("Fuck:(");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        jf.add(loginLabel);
        jf.add(loginField);
        jf.add(passLabel);
        jf.add(passField);
        jf.add(loginButton);
        jf.add(cancelButton);
        jf.add(error_1_Label);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
/*// просто пример. это запилишь, естественно, куда-нибудь в другое место
                        List<User> userList = dbWorker.getAllUser();
                        for (User u : userList) {
                            System.out.println("Вот и я, ахуительный Юзер: " + u.toString());
                        }*/