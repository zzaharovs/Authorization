package ru.netology.authorization.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.authorization.model.Authorities;
import ru.netology.authorization.model.InvalidCredentials;
import ru.netology.authorization.model.UnauthorizedUser;
import ru.netology.authorization.model.User;
import ru.netology.authorization.repository.AuthorizationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {

    private final AuthorizationRepository userRepository;

    public List<Authorities> getAuthorities (User user) {

        access(user);
        List <Authorities> resultList = userRepository.getAuthorities(user);

        if (resultList.isEmpty()) {
            throw new InvalidCredentials("Unknown user " + user.getLogin());
        }

        return resultList;

    }

    private void access (User user) {

        User currentUser = userRepository.getUser(user.getLogin());

        if (currentUser == null || !currentUser.getPassword().equals(user.getPassword())) {
            throw new UnauthorizedUser("Wrong username or password");
        }

    }

}
