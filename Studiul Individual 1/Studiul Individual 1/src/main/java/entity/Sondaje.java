package entity;

import jakarta.persistence.*;
import utils.HelperInterface;

@Entity
@NamedQuery(name = "Sondaje.All", query = "SELECT s FROM Sondaje s")
public class Sondaje implements HelperInterface {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "PID")
    private int pid;
    @Basic
    @Column(name = "poll1")
    private String poll1;
    @Basic
    @Column(name = "poll2")
    private String poll2;
    @Basic
    @Column(name = "poll3")
    private String poll3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPoll1() {
        return poll1;
    }

    public void setPoll1(String poll1) {
        this.poll1 = poll1;
    }

    public String getPoll2() {
        return poll2;
    }

    public void setPoll2(String poll2) {
        this.poll2 = poll2;
    }

    public String getPoll3() {
        return poll3;
    }

    public void setPoll3(String poll3) {
        this.poll3 = poll3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sondaje sondaje = (Sondaje) o;

        if (id != sondaje.id) return false;
        if (pid != sondaje.pid) return false;
        if (poll1 != null ? !poll1.equals(sondaje.poll1) : sondaje.poll1 != null) return false;
        if (poll2 != null ? !poll2.equals(sondaje.poll2) : sondaje.poll2 != null) return false;
        if (poll3 != null ? !poll3.equals(sondaje.poll3) : sondaje.poll3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (poll1 != null ? poll1.hashCode() : 0);
        result = 31 * result + (poll2 != null ? poll2.hashCode() : 0);
        result = 31 * result + (poll3 != null ? poll3.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sondaje{" +
                "id=" + id +
                ", pid=" + pid +
                ", poll1='" + poll1 + '\'' +
                ", poll2='" + poll2 + '\'' +
                ", poll3='" + poll3 + '\'' +
                '}';
    }

    @Override
    public int getPID() {
        return pid;
    }
}
