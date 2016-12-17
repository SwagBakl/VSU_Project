/**
 * Created by Денис on 14.12.2016.
 */
public class Project {

    private int id;
    private String name;
    private String date_begin;
    private String date_planned_finish;
    private String date_finish;
    private String project_seccess;

    public Project(){

    }
    public Project(int id, String date_begin, String date_planned_finish, String date_finish, String project_seccess){
        this.setId(id);
        this.setDate_begin(date_begin);
        this.setDate_planned_finish(date_planned_finish);
        this.setDate_finish(date_finish);
        this.setProject_seccess(project_seccess);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(String date_begin) {
        this.date_begin = date_begin;
    }

    public String getDate_planned_finish() {
        return date_planned_finish;
    }

    public void setDate_planned_finish(String date_planned_finish) {
        this.date_planned_finish = date_planned_finish;
    }

    public String getDate_finish() {
        return date_finish;
    }

    public void setDate_finish(String date_finish) {
        this.date_finish = date_finish;
    }

    public String getProject_seccess() {
        return project_seccess;
    }

    public void setProject_seccess(String project_seccess) {
        this.project_seccess = project_seccess;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id: " + id + ", name " + name + ", date_begin " + date_begin + ", date_finish " + date_finish + ", date_planned_finish" + date_planned_finish + ", project_seccess" + project_seccess +"}";
    }
}
