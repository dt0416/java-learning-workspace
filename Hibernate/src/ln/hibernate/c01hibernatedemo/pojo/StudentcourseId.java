package ln.hibernate.c01hibernatedemo.pojo;
// Generated 2013/12/6 下午 03:03:08 by Hibernate Tools 3.4.0.CR1



/**
 * StudentcourseId generated by hbm2java
 */
public class StudentcourseId  implements java.io.Serializable {


     private int sid;
     private int cid;

    public StudentcourseId() {
    }

    public StudentcourseId(int sid, int cid) {
       this.sid = sid;
       this.cid = cid;
    }
   
    public int getSid() {
        return this.sid;
    }
    
    public void setSid(int sid) {
        this.sid = sid;
    }
    public int getCid() {
        return this.cid;
    }
    
    public void setCid(int cid) {
        this.cid = cid;
    }




}


