package me.afua.checkboxdemo;


import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany()
    private Set<Colour> myColours;

    private String firstName;


    public AppUser() {
        this.myColours = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Colour> getMyColours() {
        return myColours;
    }

    public void setMyColours(Set<Colour> myColours) {
        this.myColours = myColours;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void addColour(Colour c)
    {
        this.myColours.add(c);
    }


}
