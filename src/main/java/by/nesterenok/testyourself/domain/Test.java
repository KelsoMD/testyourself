package by.nesterenok.testyourself.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "tests")
public class Test extends Entity {

    private static final long serialVersionUID = 7776414412599268278L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "theme")
    private String theme;
    @Column(name = "level")
    private int lvl;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "author")
    private User author;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Question.class)
    @JoinTable(name = "test_questions", joinColumns = {@JoinColumn(name = "test")}, inverseJoinColumns = {
        @JoinColumn(name = "question")})
    private Set<Question> questions;

    @Column(name = "aprooved")
    private boolean aprooved;

    public Test(int id) {
        super(id);
    }
}
