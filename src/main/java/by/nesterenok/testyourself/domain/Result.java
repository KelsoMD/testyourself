package by.nesterenok.testyourself.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Result extends Entity {

    private static final long serialVersionUID = 3725419100962558729L;
    private Test test;
    private int mark;
    private boolean passed;
    private User user;

    public Result(int id) {
        super(id);
    }
}