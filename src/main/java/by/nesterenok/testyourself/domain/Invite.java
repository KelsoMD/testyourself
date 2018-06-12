package by.nesterenok.testyourself.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Invite extends Entity {

    private static final long serialVersionUID = -9009350671599623118L;
    private User user;
    private Group group;

    public Invite(int id) {
        super(id);
    }
}
