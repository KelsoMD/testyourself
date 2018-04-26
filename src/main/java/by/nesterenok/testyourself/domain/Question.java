package by.nesterenok.testyourself.domain;

public class Question extends Entity{
	
	private static final long serialVersionUID = -733959911225998290L;
	private String theme;
	private int lvl;
	private String text;
	private String image;
	private String correctAnswer;
	private String answer1;
	private String answer2;
	private String answer3;
	private User author;
	public Question() {
		super();
	}
	public Question(int id) {
		super(id);
	}
	public Question(int id, String theme, int lvl, String text, String image, String correctAnswer, String answer1,
			String answer2, String answer3, User author) {
		super(id);
		this.theme = theme;
		this.lvl = lvl;
		this.text = text;
		this.image = image;
		this.correctAnswer = correctAnswer;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.author = author;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((answer1 == null) ? 0 : answer1.hashCode());
		result = prime * result + ((answer2 == null) ? 0 : answer2.hashCode());
		result = prime * result + ((answer3 == null) ? 0 : answer3.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((correctAnswer == null) ? 0 : correctAnswer.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + lvl;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
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
		Question other = (Question) obj;
		if (answer1 == null) {
			if (other.answer1 != null)
				return false;
		} else if (!answer1.equals(other.answer1))
			return false;
		if (answer2 == null) {
			if (other.answer2 != null)
				return false;
		} else if (!answer2.equals(other.answer2))
			return false;
		if (answer3 == null) {
			if (other.answer3 != null)
				return false;
		} else if (!answer3.equals(other.answer3))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (correctAnswer == null) {
			if (other.correctAnswer != null)
				return false;
		} else if (!correctAnswer.equals(other.correctAnswer))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (lvl != other.lvl)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
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
		return "Question [id=" + this.getId() + " theme=" + theme + ", lvl=" + lvl + ", text=" + text + ", image=" + image + ", correctAnswer="
				+ correctAnswer + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", author="
				+ author + "]";
	}
	
	
	
	

}
