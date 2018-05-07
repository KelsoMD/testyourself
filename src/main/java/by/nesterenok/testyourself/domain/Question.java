package by.nesterenok.testyourself.domain;

public class Question extends Entity{
	
	private static final long serialVersionUID = -2645907839017881701L;
	
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
	public Question() {
		super();
	}
	public Question(int id) {
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
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
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Question other = (Question) obj;
		if (text == null) {
			if (other.text != null) {
				return false;
			}
		} else if (!text.equals(other.text)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "Question [id=" + this.getId() + " theme=" + theme + ", lvl=" + lvl + ", text=" + text + ", image=" + image + ", correctAnswer="
				+ correctAnswer + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", author="
				+ author + "]";
	}
	
	
	
	

}
