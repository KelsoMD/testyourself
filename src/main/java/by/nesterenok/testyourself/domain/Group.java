package by.nesterenok.testyourself.domain;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Group extends Entity {

    private static final long serialVersionUID = -7113150935056952534L;

    private User mentor;
    private String theme;
    private Set<Task> tasks;
    private Set<User> members;
    private String title;

    public Group(int id) {
        super(id);
    }
}
