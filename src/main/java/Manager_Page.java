import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * Created by Денис on 22.11.2016.
 */
public class Manager_Page extends JPanel {

    public static void Manager_Page_Start() throws SQLException {
    final JFrame jf = new JFrame("Manager page");
    jf.setSize(390, 130);
    jf.setVisible(true);

    JButton add_customer_button = new JButton("Add customer");
    JButton add_project_button = new JButton("Add project");


    add_customer_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        Customer_Page cp = new Customer_Page();
            try {
                cp.Customer_Page_Start();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    });

    add_project_button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Project_Page pp = new Project_Page();
            try{
            pp.Project_Page_Start();
            }
            catch (Exception p )
            {
                p.printStackTrace();
            }
        }
    });
    jf.setLayout(null);

    add_customer_button.setBounds(20,20,150,50);
    add_project_button.setBounds(200,20,150,50);


    jf.add(add_customer_button);
    jf.add(add_project_button);


    jf.setVisible(true);
    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
