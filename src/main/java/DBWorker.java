import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Денис on 14.12.2016.
 */

    public class DBWorker {

        private static final  String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login = ? AND password = ?";
        private static final  String SQL_SELECT_ALL_USERS = "SELECT * FROM users";
        private static final String URL = "jdbc:mysql://localhost:3306/bank_roll";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";
        private static final String SQL_INSERT_NEW_USER = "INSERT INTO users (name, second_name, login, password,role) VALUES(?,?,?,?,?)";
        private static final  String SQL_UPDATE_USER = "UPDATE users SET name = ? , second_name = ?, login = ?, password = ?, role = ? WHERE id = ?";
        private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id=?";
        private static final String SQL_PROJECT_INSERT = "INSERT INTO projects (name, date_begin, date_planned_finish, date_finish, project_seccess) VALUES(?,?,?,?,?)";
        private static final String SQL_DELETE_PROJECT = "DELETE FROM projects WHERE id=?";
        private static final String SQL_INSERT_CUSTOMER = "INSERT INTO customers (name, adress, number_of_projects, finished_projects) VALUES(?,?,?,?)";
        private static final String SQL_DELETE_CUSTOMER = "DELETE FROM customers WHERE id=?";

        public User checkUser(String login, String password) throws SQLException {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = null;
            User user = null;
            try {
                statement = connection.prepareStatement(FIND_BY_LOGIN_AND_PASSWORD);
                statement.setString(1, login);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    user.setRole(resultSet.getInt("role"));


                } else {
                    JOptionPane.showMessageDialog(null, "SOMETHING INCORRECT!");
                }
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                connection.close();
                statement.close();
            }
            return user;
        }

        public List<User> getAllUser() throws SQLException {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = null;
            List<User> users = new ArrayList<User>();
            try {
                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_USERS);
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setLogin(resultSet.getString("login"));
                    user.setPassword(resultSet.getString("password"));
                    users.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.close();
                statement.close();
            }
            return users;
        }

        public void addUser(String name, String secondName, String login, String passwd, int role) throws SQLException {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement(SQL_INSERT_NEW_USER);
                statement.setString(1, name);
                statement.setString(2, secondName);
                statement.setString(3, login);
                statement.setString(4, passwd);
                statement.setInt(5, role);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                connection.close();
                statement.close();
            }
        }

    public void AddProject(String name, String date_begin, String date_planned_finish, String date_finish, String project_seccess) throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_PROJECT_INSERT);
            statement.setString(1, name);
            statement.setString(2, date_begin);
            statement.setString(3, date_planned_finish);
            statement.setString(4, date_finish);
            statement.setString(5, date_finish);
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
        connection.close();
        statement.close();
        }

    }

    public void AddCustomer(String name, String adress, int number_of_projects, int finished_projects) throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(SQL_INSERT_CUSTOMER);
            statement.setString(1, name);
            statement.setString(2, adress);
            statement.setInt(3, number_of_projects);
            statement.setInt(4, finished_projects);
            statement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    public void DeleteUser(int id) throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(SQL_DELETE_USER);
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeleteProject(int id) throws  SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_PROJECT);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    public void DeleteCustomer(int id) throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_DELETE_CUSTOMER);
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    public void UpdateUser(String name, String secondName, String login, String passwd, int role) throws SQLException{
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(SQL_UPDATE_USER);
            statement.setString(1, name);
            statement.setString(2, secondName);
            statement.setString(3, login);
            statement.setString(4, passwd);
            statement.setInt(5, role);
            statement.executeUpdate();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    }

