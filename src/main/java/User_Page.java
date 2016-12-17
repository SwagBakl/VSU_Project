import javax.swing.*;

/**
 * Created by Денис on 22.11.2016.
 */
public class User_Page extends JPanel {

    public static void User_Page_Start() {

        final JFrame jf = new JFrame("User page");
        jf.setSize(640, 480);
        jf.setVisible(true);

        JButton button = new JButton("Swag");

        jf.setLayout(null);

        button.setBounds(100,100,100,50);

        jf.add(button);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

}
