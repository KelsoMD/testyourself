package by.nesterenok.testyourself.domain;

import lombok.*;

import java.io.File;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User extends Entity {

    private static final long serialVersionUID = -1402640880243152460L;

    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private File avatar;
    private String role;
    private String theme;
    private Set<Group> group;

    public User(int id) {
        super(id);
    }
}
