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
public final class Themes extends Entity {

    private static final long serialVersionUID = -3408505656073783893L;

    private String theme;
    private boolean aprooved;

    public Themes(String theme) {
        this.theme = theme;
    }
}
