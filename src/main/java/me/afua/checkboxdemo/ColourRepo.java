package me.afua.checkboxdemo;

import org.springframework.data.repository.CrudRepository;

public interface ColourRepo extends CrudRepository<Colour,Long> {

    Colour findByNameIgnoreCase(String colour);
}
