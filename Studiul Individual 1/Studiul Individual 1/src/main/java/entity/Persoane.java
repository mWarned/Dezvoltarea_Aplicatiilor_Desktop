package entity;

import jakarta.persistence.*;
import utils.HelperInterface;

import java.sql.Date;

@Entity
@NamedQuery(name = "Persoane.All", query = "SELECT p FROM Persoane p")
@NamedQuery(name = "Persoane.Oldest", query = "SELECT p FROM Persoane p WHERE p.dataNasterii = (SELECT MIN(p2.dataNasterii) FROM Persoane p2)")
@NamedQuery(name = "Persoane.Youngest", query = "SELECT p FROM Persoane p WHERE p.dataNasterii = (SELECT MAX(p2.dataNasterii) FROM Persoane p2)")
@NamedQuery(name = "Persoane.OrderByBirthday", query = "SELECT p FROM Persoane p ORDER BY p.dataNasterii ASC")
@NamedQuery(name = "Persoane.DivorcedNr", query = "SELECT (COUNT(*)) FROM Persoane WHERE divortat = 1")
@NamedQuery(name = "Persoane.TotalNr", query = "SELECT (COUNT(*)) FROM Persoane")
@NamedQuery(name = "Persoane.AgeRange", query = "SELECT p FROM Persoane p WHERE p.dataNasterii BETWEEN ?1 AND ?2")
@NamedQuery(name = "Persoane.SelectM18", query = "SELECT p FROM Persoane p WHERE p.dataNasterii <= ?1 AND p.sex = 'm'")
@NamedQuery(name = "Persoane.SelectF18", query = "SELECT p FROM Persoane p WHERE p.dataNasterii <= ?1 AND p.sex = 'f'")
@NamedQuery(name = "Persoane.MarriedUnder20", query = "SELECT p FROM Persoane p WHERE p.dataNasterii >= ?1 AND p.casatorit = 1")
@NamedQuery(name = "Persoane.DeletePID", query = "DELETE FROM Persoane p WHERE p.pid = ?1")
public class Persoane implements HelperInterface {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "PID")
    private int pid;
    @Basic
    @Column(name = "Nume")
    private String nume;
    @Basic
    @Column(name = "Prenume")
    private String prenume;
    @Basic
    @Column(name = "sex")
    private char sex;
    @Basic
    @Column(name = "nrTelefon")
    private String nrTelefon;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "dataNasterii")
    private Date dataNasterii;
    @Basic
    @Column(name = "casatorit")
    private byte casatorit;
    @Basic
    @Column(name = "divortat")
    private byte divortat;

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

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNasterii() {
        return dataNasterii;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public byte getCasatorit() {
        return casatorit;
    }

    public void setCasatorit(byte casatorit) {
        this.casatorit = casatorit;
    }

    public byte getDivortat() {
        return divortat;
    }

    public void setDivortat(byte divortat) {
        this.divortat = divortat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persoane persoane = (Persoane) o;

        if (id != persoane.id) return false;
        if (pid != persoane.pid) return false;
        if (casatorit != persoane.casatorit) return false;
        if (nume != null ? !nume.equals(persoane.nume) : persoane.nume != null) return false;
        if (prenume != null ? !prenume.equals(persoane.prenume) : persoane.prenume != null) return false;
        if (nrTelefon != null ? !nrTelefon.equals(persoane.nrTelefon) : persoane.nrTelefon != null) return false;
        if (email != null ? !email.equals(persoane.email) : persoane.email != null) return false;
        if (dataNasterii != null ? !dataNasterii.equals(persoane.dataNasterii) : persoane.dataNasterii != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pid;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (nrTelefon != null ? nrTelefon.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dataNasterii != null ? dataNasterii.hashCode() : 0);
        result = 31 * result + (int) casatorit;
        return result;
    }

    @Override
    public String toString() {
        return "Persoane{" +
                "pid=" + pid +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", sex=" + sex + "\'" +
                ", nrTelefon='" + nrTelefon + '\'' +
                ", email='" + email + '\'' +
                ", dataNasterii=" + dataNasterii +
                ", casatorit=" + casatorit +
                ", divortat=" + divortat +
                '}';
    }

    @Override
    public int getPID() {
        return pid;
    }
}
