package adata;

public class Usee {
    /**
     * `name` varchar(10) DEFAULT NULL,
     *   `id` int DEFAULT NULL COMMENT '工号',
     *   `workplace` varchar(10) DEFAULT NULL COMMENT '居住地',
     *   `salary` double DEFAULT NULL,
     *   `job` varchar(10) DEFAULT NULL COMMENT '岗位',
     *   `gender` varchar(3) DEFAULT NULL COMMENT '性别'
     */
    private String name;
    private int id;
    private String workplace;
    private double salary;
    private String job;
    private String gender;

    @Override
    public String toString() {
        return "Usee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", workplace='" + workplace + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Usee(String name, int id, String workplace, double salary, String job, String gender) {
        this.name = name;
        this.id = id;
        this.workplace = workplace;
        this.salary = salary;
        this.job = job;
        this.gender = gender;
    }

    public Usee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
