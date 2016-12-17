import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Денис on 14.12.2016.
 */
public class Project_Page {
    public static final String SQL_SELECT_ALL_PROJECTS = "SELECT * FROM projects";
    private static final String URL = "jdbc:mysql://localhost:3306/bank_roll";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static DBWorker dbWorker = new DBWorker();

    public static void Project_Page_Start() throws SQLException {

        final JFrame jf = new JFrame("Projects page");
        jf.setSize(640, 480);
        jf.setVisible(true);

        List<Project> projects = new ArrayList<Project>();
        String[] truefalse = {"true", "false"};
        JButton add_project_button = new JButton("Add project");
        JButton remove_project_button = new JButton("Delete project");
        JButton edit_project_button = new JButton("Edit project");
        JButton update_project_button = new JButton("Update project");
        final JTextField name_field = new JTextField();
        final JTextField date_begin_field = new JTextField();
        final JTextField date_planned_finish_field = new JTextField();
        final JTextField date_finish_field = new JTextField();
       // final JTextField project_seccess_field = new JTextField();
        final JTextField id_field = new JTextField();
        final JComboBox success_box = new JComboBox(truefalse);

        JLabel name_label = new JLabel("Name: ");
        JLabel date_begin_label = new JLabel("Begin's date: ");
        JLabel date_planned_finish_label = new JLabel("Finish plan date: ");
        JLabel date_finish_label = new JLabel("Finish date: ");
        JLabel project_seccess_label = new JLabel("Project success: ");


        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;


        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        statement = connection.createStatement();
        rs = statement.executeQuery(SQL_SELECT_ALL_PROJECTS);
        ResultSetMetaData rsmd = rs.getMetaData();
        int c = rsmd.getColumnCount();
        Vector column = new Vector(c);
        for(int i=1;i<=c;i++){
            column.add(rsmd.getCatalogName(i));
        }
        Vector data = new Vector();
        Vector row;
        while (rs.next()){
            row = new Vector(c);
            for(int i =1; i <= c; i++){
                row.add(rs.getString(i));
            }
            data.add(row);

        }

        final JTable project_list_table = new JTable(data, column);
        JScrollPane scrollPane = new JScrollPane(project_list_table);

        add_project_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String name = name_field.getText();
                    String date_begin = date_begin_field.getText();
                    String date_planned = date_planned_finish_field.getText();
                    String date_finish = date_finish_field.getText();
                    String project_seccess = (String)success_box.getSelectedItem();
                    dbWorker.AddProject(name, date_begin, date_planned, date_finish, project_seccess);
                    project_list_table.updateUI();
                }catch (Exception p){
                    p.printStackTrace();
                }

                name_field.setText("");
                date_begin_field.setText("");
                date_planned_finish_field.setText("");
                date_finish_field.setText("");
                //project_seccess_field.setText("");

            }
        });

        edit_project_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = project_list_table.getSelectedRow();
                TableModel model = project_list_table.getModel();
                id_field.setText(model.getValueAt(i,0).toString());
                name_field.setText(model.getValueAt(i,1).toString());
                date_begin_field.setText(model.getValueAt(i,2).toString());
                date_planned_finish_field.setText(model.getValueAt(i,3).toString());
                date_finish_field.setText(model.getValueAt(i,4).toString());
                //project_seccess_field.setText(model.getValueAt(i,5).toString());
            }
        });

        remove_project_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int i = project_list_table.getSelectedRow();
                TableModel model = project_list_table.getModel();

                int id = Integer.parseInt(id_field.getText());
                try {
                    dbWorker.DeleteProject(id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });

       /* update_project_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = name_field.getText();
                String secondName = date_begin_field.getText();
                String login = date_planned_finish_field.getText();
                String passwd = date_finish_field.getText();
                int role = Integer.parseInt(project_seccess_field.getText());
                try {
                    dbWorker.UpdateUser(name, secondName, login, passwd, role);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });*/

        jf.setLayout(null);

        name_label.setBounds(96, 40, 50, 25);
        name_field.setBounds(140, 40, 150, 25);
        date_begin_label.setBounds(50, 70, 100, 25);
        date_begin_field.setBounds(140, 70, 150, 25);
        date_planned_finish_label.setBounds(370, 40, 50, 25);
        date_planned_finish_field.setBounds(410, 40, 150, 25);
        date_finish_label.setBounds(343, 70, 100, 25);
        date_finish_field.setBounds(410, 70, 150, 25);
        project_list_table.setBounds(0, 200, 640, 239);
        project_seccess_label.setBounds(376, 100, 50, 25);
        //project_seccess_field.setBounds(410, 100, 50, 25);
        success_box.setBounds(410, 100, 70, 25);
        id_field.setBounds(40, 70, 150, 25);
        add_project_button.setBounds(90,170,130,25);
        remove_project_button.setBounds(220,170,130,25);
        edit_project_button.setBounds(350,170, 130, 25);
        update_project_button.setBounds(480,170,130,25);

        jf.add(add_project_button);
        jf.add(remove_project_button);
        jf.add(edit_project_button);
        jf.add(name_label);
        jf.add(date_begin_label);
        jf.add(date_planned_finish_label);
        jf.add(date_finish_label);
        jf.add(name_field);
        jf.add(date_begin_field);
        jf.add(date_planned_finish_field);
        jf.add(date_finish_field);
        jf.add(project_list_table);
        jf.add(scrollPane);
        jf.add(project_seccess_label);
        //jf.add(project_seccess_field);
        jf.add(update_project_button);
        jf.add(success_box);
        //jf.add(id_field);



        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

}
}


