package by.nesterenok.testyourself.domain;

import java.util.Date;
import java.util.Map;

public class TaskResult extends Entity{
	
	
	private static final long serialVersionUID = 8478820334966840218L;
	
	private User member;
	private Task task;
	private Date passDate;
	private int mark;
	private boolean passed;
	private Map<Question, String> answerMap;
	public TaskResult() {
		super();
	}
	public TaskResult(int id) {
		super(id);
	}
	public TaskResult(User member, Task task, Date passDate, int mark, boolean passed,
			Map<Question, String> answerMap) {
		super();
		this.member = member;
		this.task = task;
		this.passDate = passDate;
		this.mark = mark;
		this.passed = passed;
		this.answerMap = answerMap;
	}
	public User getMember() {
		return member;
	}
	public void setMember(User member) {
		this.member = member;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public Date getPassDate() {
		return passDate;
	}
	public void setPassDate(Date passDate) {
		this.passDate = passDate;
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
	public Map<Question, String> getAnswerMap() {
		return answerMap;
	}
	public void setAnswerMap(Map<Question, String> answerMap) {
		this.answerMap = answerMap;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((answerMap == null) ? 0 : answerMap.hashCode());
		result = prime * result + mark;
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((passDate == null) ? 0 : passDate.hashCode());
		result = prime * result + (passed ? 1231 : 1237);
		result = prime * result + ((task == null) ? 0 : task.hashCode());
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
		TaskResult other = (TaskResult) obj;
		if (answerMap == null) {
			if (other.answerMap != null)
				return false;
		} else if (!answerMap.equals(other.answerMap))
			return false;
		if (mark != other.mark)
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (passDate == null) {
			if (other.passDate != null)
				return false;
		} else if (!passDate.equals(other.passDate))
			return false;
		if (passed != other.passed)
			return false;
		if (task == null) {
			if (other.task != null)
				return false;
		} else if (!task.equals(other.task))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TaskResult [member=" + member + ", task=" + task + ", passDate=" + passDate + ", mark=" + mark
				+ ", passed=" + passed + ", answerMap=" + answerMap + "]";
	}
	
	
	
	

}
