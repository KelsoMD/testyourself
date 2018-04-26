package by.nesterenok.testyourself.domain;

public class Result extends Entity{
	

	private static final long serialVersionUID = 3725419100962558729L;
	private Test test;
	private int mark;
	private boolean passed;
	private User user;
	public Result() {
		super();
	}
	public Result(int id) {
		super(id);
	}
	
	public Result(int mark, boolean passed) {
		super();
		this.mark = mark;
		this.passed = passed;
	}
	public Result(Test test, int mark, boolean passed, User user) {
		super();
		this.test = test;
		this.mark = mark;
		this.passed = passed;
		this.user = user;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + mark;
		result = prime * result + (passed ? 1231 : 1237);
		result = prime * result + ((test == null) ? 0 : test.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Result other = (Result) obj;
		if (mark != other.mark)
			return false;
		if (passed != other.passed)
			return false;
		if (test == null) {
			if (other.test != null)
				return false;
		} else if (!test.equals(other.test))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Result [test=" + test + ", mark=" + mark + ", passed=" + passed +  ", user="
				+ user + "]";
	}
	
	
	

}
