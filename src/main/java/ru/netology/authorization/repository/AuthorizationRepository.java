package ru.netology.authorization.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorization.model.Authorities;
import ru.netology.authorization.model.User;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class AuthorizationRepository {

    private final ConcurrentMap<String, User> users;


    public AuthorizationRepository() {

        users = new ConcurrentHashMap<>();
        generateTestData();

    }

    public List <Authorities> getAuthorities (User user) {
        return users.get(user.getLogin()).getAuthoritiesList();
    }

    public User getUser(String login) {
       return users.get(login);
    }

    private void generateTestData() {

        User admin = new User("admin", "hardpass", new CopyOnWriteArrayList<>());

        admin.getAuthoritiesList().add(Authorities.READ);
        admin.getAuthoritiesList().add(Authorities.WRITE);
        admin.getAuthoritiesList().add(Authorities.DELETE);

        users.put(admin.getLogin(), admin);
        users.put("simpleUser", new User("simpleUser", "simpleUser", new CopyOnWriteArrayList<>()));

    }


}
