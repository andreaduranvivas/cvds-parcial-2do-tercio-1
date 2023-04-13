package edu.eci.cvds.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "USUARIOS")
public class User {

    @Id
    @Column(name = "USER")
    private String id;
    @Column(name = "PASSWORD")
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}