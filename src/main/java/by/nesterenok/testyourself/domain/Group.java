package by.nesterenok.testyourself.domain;

import java.util.Set;

public class Group extends Entity {

    private static final long serialVersionUID = 2882018151077326629L;
    private User mentor;
    private String theme;
    private Set<Task> tasks;
    private Set<User> members;
    private String title;

    public Group() {
        super();
    }

    public Group(int id) {
        super(id);
    }

    public Group(User mentor, String theme) {
        super();
        this.mentor = mentor;
        this.theme = theme;
    }

    public Group(int id, User mentor, String theme, Set<Task> tasks) {
        super(id);
        this.mentor = mentor;
        this.theme = theme;
        this.tasks = tasks;
    }

    public User getMentor() {
        return mentor;
    }

    public void setMentor(User mentor) {
        this.mentor = mentor;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((mentor == null) ? 0 : mentor.hashCode());
        result = prime * result + ((theme == null) ? 0 : theme.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        Group other = (Group) obj;
        if (members == null) {
            if (other.members != null) {
                return false;
            }
        } else if (!members.equals(other.members)) {
            return false;
        }
        if (mentor == null) {
            if (other.mentor != null) {
                return false;
            }
        } else if (!mentor.equals(other.mentor)) {
            return false;
        }
        if (tasks == null) {
            if (other.tasks != null) {
                return false;
            }
        } else if (!tasks.equals(other.tasks)) {
            return false;
        }
        if (theme == null) {
            if (other.theme != null) {
                return false;
            }
        } else if (!theme.equals(other.theme)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Group [mentor=" + mentor + ", theme=" + theme + ", tasks=" + tasks + ", members=" + members + ", title="
            + title + "]";
    }
}
