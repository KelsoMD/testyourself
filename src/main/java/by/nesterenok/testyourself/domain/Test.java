package by.nesterenok.testyourself.domain;

import java.util.Set;

public class Test extends Entity {

	private static final long serialVersionUID = 6962669619833702311L;
	
	private String theme;
	private int lvl;
	private User author;
	private Set<Question> questions;
	private boolean aprooved;

	public Test() {
		super();
	}

	public Test(int id) {
		super(id);
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

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	public boolean isAprooved() {
		return aprooved;
	}

	public void setAprooved(boolean aprooved) {
		this.aprooved = aprooved;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (aprooved ? 1231 : 1237);
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
		if (aprooved != other.aprooved)
			return false;
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
		return "[Test id=" + this.getId()+ ", theme " + theme + ", lvl=" + lvl + ", number of questions =" + questions.size() + "]";
	}

}
