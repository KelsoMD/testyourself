package by.nesterenok.testyourself.domain;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Question extends Entity {

    private static final long serialVersionUID = -2620731943808722423L;

    private String theme;
    private int lvl;
    private String text;
    private String image;
    private String correctAnswer;
    private String answer1;
    private String answer2;
    private String answer3;
    private User author;
    private boolean aprooved;
    private List<String> shuffledAnswers;

    public Question(int id) {
        super(id);
    }
}
