package by.nesterenok.testyourself.domain;

import java.util.Set;
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
