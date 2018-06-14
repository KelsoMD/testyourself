package by.nesterenok.testyourself.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@javax.persistence.Entity
@Table(name = "questions")
public class Question extends Entity {

    private static final long serialVersionUID = 8325647133116232242L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "level")
    private int lvl;

    @Column(name = "text")
    private String text;

    @Column(name = "image")
    private String image;

    @Column(name = "answer_correct")
    private String correctAnswer;

    @Column(name = "answer_1")
    private String answer1;

    @Column(name = "answer_2")
    private String answer2;

    @Column(name = "answer_3")
    private String answer3;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    private User author;

    @Column(name = "aprooved")
    private boolean aprooved;

    private List<String> shuffledAnswers;

    public Question(int id) {
        super(id);
    }
}
