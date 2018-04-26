package by.nesterenok.testyourself.domain;

import java.util.List;

public class Test extends Entity {

	private static final long serialVersionUID = 6928342305542890474L;
	
	private String theme;
	private int lvl;
	private User author;
	private List<Question> questions;

	public Test() {
		super();
	}

	public Test(int id) {
		super(id);
	}

	public Test(String theme, int lvl, User author, List<Question> questions) {
		super();
		this.theme = theme;
		this.lvl = lvl;
		this.author = author;
		this.questions = questions;
	}

	public Test(int id, String theme, int lvl, User author, List<Question> questions) {
		super(id);
		this.theme = theme;
		this.lvl = lvl;
		this.author = author;
		this.questions = questions;
		
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + lvl;
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + ((theme == null) ? 0 : theme.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (lvl != other.lvl)
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (theme == null) {
			if (other.theme != null)
				return false;
		} else if (!theme.equals(other.theme))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Test [theme=" + theme + ", lvl=" + lvl + ", author=" + author + ", questions=" + questions + "]";
	}

}
