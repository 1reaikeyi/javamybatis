package many;

public class One {
    private Integer sid;
    private String sname;
    private String subject;
    private Two two;
    public One() {}

    public One(Integer sid, Two two, String subject, String sname) {
        this.sid = sid;
        this.two = two;
        this.subject = subject;
        this.sname = sname;
    }



    public Two getTwo() {
        return two;
    }

    public void setTwo(Two two) {
        this.two = two;
    }

    public Integer getSid() {
        return sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    public String getSname() {
        return sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }
    
    public String getSubject() {
        return subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "One{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", subject='" + subject + '\'' +
                ", two=" + two +
                '}';
    }
}