package CRUS;

public class Usee {
    /**
     * create table shuihu
     * (
     *     name      varchar(10) null,
     *     id        int         null comment '工号',
     *     workplace varchar(10) null comment '居住地',
     *     salary    double      null,
     *     job       varchar(10) null comment '岗位',
     *     gender    varchar(10) null
     * )
     *     comment '水浒传';
     */

    // 对应数据库字段: name varchar(10) null
    private String name;

    // 对应数据库字段: id int null comment '工号'
    private Integer id;

    // 对应数据库字段: workplace varchar(10) null comment '居住地'
    private String workplace;

    // 对应数据库字段: salary double null
    private Double salary;

    // 对应数据库字段: job varchar(10) null comment '岗位'
    private String job;

    // 对应数据库字段: gender varchar(10) null
    private String gender;

    // Getter和Setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    public Usee() {
    }

    public Usee(String name, Integer id, String workplace, Double salary, String job, String gender) {
        this.name = name;
        this.id = id;
        this.workplace = workplace;
        this.salary = salary;
        this.job = job;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "config.Usee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", workplace='" + workplace + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
