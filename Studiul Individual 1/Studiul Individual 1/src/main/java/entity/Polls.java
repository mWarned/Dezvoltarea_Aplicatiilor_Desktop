package entity;

import jakarta.persistence.*;
import utils.HelperInterface;

@Entity
@NamedQuery(name = "Polls.All", query = "SELECT p FROM Polls p")
@NamedQuery(name = "Polls.AnonymousCount", query = "SELECT COUNT(*) FROM Polls p WHERE person = null")
public class Polls implements HelperInterface {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "PID")
    private int pid;
    @Basic
    @Column(name = "Person")
    private Integer person;
    @Basic
    @Column(name = "Poll")
    private int poll;

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

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public int getPoll() {
        return poll;
    }

    public void setPoll(int poll) {
        this.poll = poll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Polls polls = (Polls) o;

        if (id != polls.id) return false;
        if (pid != polls.pid) return false;
        if (poll != polls.poll) return false;
        if (person != null ? !person.equals(polls.person) : polls.person != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + poll;
        return result;
    }

    @Override
    public String toString() {
        return "Sondajele si Persoanele:{" +
                "PID = " + pid +
                ", ID_Persoana = " + person +
                ", ID_Sondaj = " + poll +
                '}';
    }


    @Override
    public int getPID() {
        return pid;
    }
}
