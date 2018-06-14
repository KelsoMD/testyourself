package by.nesterenok.testyourself.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "themes")
public final class Themes extends Entity {

    private static final long serialVersionUID = -7907443202866931694L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "aprooved")
    private boolean aprooved;

    public Themes(int id) {
        super(id);
    }

    public Themes(String theme) {
        this.theme = theme;
    }
}