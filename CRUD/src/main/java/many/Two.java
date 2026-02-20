package many;

import java.util.List;

public class Two {
    private Integer tid;
    private String tname;
    private String teach;
    private One one;
    public Two() {}
    private List<One> stuList;

    public List<One> getStuList() {
        return stuList;
    }

    public void setStuList(List<One> stuList) {
        this.stuList = stuList;
    }

    public Two(Integer tid, String tname, String teach, One one) {
        this.tid = tid;
        this.tname = tname;
        this.teach = teach;
        this.one = one;
    }

    public One getOne() {
        return one;
    }

    public void setOne(One one) {
        this.one = one;
    }

    public Integer getTid() {
        return tid;
    }
    
    public void setTid(Integer tid) {
        this.tid = tid;
    }
    
    public String getTname() {
        return tname;
    }
    
    public void setTname(String tname) {
        this.tname = tname;
    }
    
    public String getTeach() {
        return teach;
    }
    
    public void setTeach(String teach) {
        this.teach = teach;
    }

    @Override
    public String toString() {
        return "Two{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", teach='" + teach + '\'' +
                ", one=" + one +
                "," + stuList +
                '}';
    }
}