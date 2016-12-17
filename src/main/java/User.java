

/**
 * Created by Денис on 28.10.2016.
 */
public class User {

    private int id;
    private int role;
    private String name;
    private String second_Name;
    private String login;
    private String password;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, int role,  String name, String second_Name, String login, String password) {
        this.id = id;
        this.name = name;
        this.second_Name = second_Name;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole() { return role; }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSecond_Name() { return second_Name; }

    public void setSecond_Name(String second_Name) { this.second_Name = second_Name; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + id + ", name " + name + ", login " + login + ", password " + password + "}";
    }



}
