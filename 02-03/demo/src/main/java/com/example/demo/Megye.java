package src.main.java.com.example.demo;
import javax.persistence.*;
@Entity
@Table(name="megyek")

public class Megye {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Megye(int id, String nev) {
        this.id = id;
        this.nev = nev;
    }

    public Megye() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)	// AUTO_INCREMENT
    private int id;
    private String nev;
}
