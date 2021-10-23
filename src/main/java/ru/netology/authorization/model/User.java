package ru.netology.authorization.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.concurrent.CopyOnWriteArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    @Setter(AccessLevel.NONE)
    private CopyOnWriteArrayList<Authorities> authoritiesList;

}
