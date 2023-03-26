package model;


import javax.persistence.*;

@Entity
public class user {
    private int id;
    private String pseudo;

    private String password;


    public user(final int id, final String pseudo, final String password){
        this.id=id;
        this.pseudo=pseudo;
        this.password=password;

    }

    public user() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    @Column(name = "pseudo", nullable = false)
    /**
     * @return the _name
     */
    public String getPseudo() {
        return this.pseudo;
    }

    /**
     * @param _name the _name to set
     */
    public void setPseudo(final String pseudo) {
        this.pseudo= pseudo;
    }


    @Column(name = "password", nullable = false)
    /**
     * @return the _name
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * @param _name the _name to set
     */
    public void setPassword(final String password) {
        this.password= password;
    }




}
