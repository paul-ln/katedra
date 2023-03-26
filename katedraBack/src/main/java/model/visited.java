package model;
import javax.persistence.*;

@Entity
public class visited {
    private int id;
    private user user;
    private String departement;

    public visited(final int id, final user user, final String departement){
        this.id=id;
        this.user=user;
        this.departement=departement;
    }

    public visited() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", nullable = false)
    public user getUser() {
        return this.user;
    }

    public void setUser(final user user) {
        this.user = user;
    }

    @Column(name = "departement", nullable = false)
    public String getDepartement() {
        return this.departement;
    }

    public void setDepartement(final String departement) {
        this.departement = departement;
    }
}