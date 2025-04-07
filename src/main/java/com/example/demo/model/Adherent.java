package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.attoparser.dom.Text;

//le model il est une classe annotée avec
// @Entity, qui correspond à une table de la base de données
@Entity
public class Adherent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private Text quotientFamilial;

    @Override
    public String toString() {
        return "Adherent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", quotientFamilial='" + quotientFamilial + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Text getQuotientFamilial() {
        return quotientFamilial;
    }

    public void setQuotientFamilial(Text quotientFamilial) {
        this.quotientFamilial = quotientFamilial;
    }
}
