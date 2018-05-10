package me.afua.checkboxdemo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Colour {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    @ManyToMany(mappedBy="myColours")
    private Set<AppUser> users;


    public Colour() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }
}
