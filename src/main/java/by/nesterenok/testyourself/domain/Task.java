package by.nesterenok.testyourself.domain;

import java.util.Date;

public class Task extends Entity{
	
	
	private static final long serialVersionUID = 7190483808747881843L;
	
	private Group group;
	private Test test;
	private Date finishTo;
	public Task() {
		super();
	}
	public Task(int id) {
		super(id);
	}
	public Task(Group group, Test test, Date finishTo) {
		super();
		this.group = group;
		this.test = test;
		this.finishTo = finishTo;
	}
	
	public Task(int id, Group group, Test test, Date finishTo) {
		super(id);
		this.group = group;
		this.test = test;
		this.finishTo = finishTo;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Date getFinishTo() {
		return finishTo;
	}
	public void setFinishTo(Date finishTo) {
		this.finishTo = finishTo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((finishTo == null) ? 0 : finishTo.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((test == null) ? 0 : test.hashCode());
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
		Task other = (Task) obj;
		if (finishTo == null) {
			if (other.finishTo != null)
				return false;
		} else if (!finishTo.equals(other.finishTo))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (test == null) {
			if (other.test != null)
				return false;
		} else if (!test.equals(other.test))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Task [group=" + group + ", test=" + test + ", finishTo=" + finishTo + "]";
	}
	
	
	
	

}
