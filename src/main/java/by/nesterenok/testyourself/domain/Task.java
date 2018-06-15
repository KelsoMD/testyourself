package by.nesterenok.testyourself.domain;

import java.util.Date;
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
public class Task extends Entity {

    private static final long serialVersionUID = 563246732327679119L;

    private Group group;
    private Test test;
    private Date finishTo;

    public Task(int id) {
        super(id);
    }
}
