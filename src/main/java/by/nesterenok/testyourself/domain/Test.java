package by.nesterenok.testyourself.domain;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Test extends Entity {

    private static final long serialVersionUID = 1284463822482349681L;

    private String theme;
    private int lvl;
    private User author;
    private Set<Question> questions;
    private boolean aprooved;

    public Test(int id) {
        super(id);
    }

}
