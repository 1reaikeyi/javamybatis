package many;

public class There {
    private Integer id;
    private Integer tid;
    private Integer sid;
    
    public There() {}
    
    public There(Integer id, Integer tid, Integer sid) {
        this.id = id;
        this.tid = tid;
        this.sid = sid;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getTid() {
        return tid;
    }
    
    public void setTid(Integer tid) {
        this.tid = tid;
    }
    
    public Integer getSid() {
        return sid;
    }
    
    public void setSid(Integer sid) {
        this.sid = sid;
    }
    
    @Override
    public String toString() {
        return "There{" +
                "id=" + id +
                ", tid=" + tid +
                ", sid=" + sid +
                '}';
    }
}