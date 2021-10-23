package ru.netology.authorization.controller;

import lombok.Data;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.authorization.model.Authorities;
import ru.netology.authorization.model.User;
import ru.netology.authorization.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@Data
@Validated
@RestController
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {

        System.out.println(user);

        return authorizationService.getAuthorities(user);
    }


}
