package me.afua.checkboxdemo;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<AppUser,Long> {
    AppUser findAppUserByFirstNameIgnoreCase(String firstName);
}
