package by.nesterenok.testyourself.domain;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
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
