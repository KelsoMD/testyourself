package by.nesterenok.testyourself.domain;

import java.io.File;
import java.util.List;

public class User extends Entity{
	
	private static final long serialVersionUID = -6591019673352952065L;
	private String login;
	private String password;
	private String name;
	private String surname;
	private String eMail;
	private File avatar; 
	private String role;
	private String theme;
	private List<Group> group;
	public User() {
		super();
	}
	public User(int id) {
		super(id);
	}
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public User(String name, String surname, String eMail, File avatar, String role,
			String theme, List<Group> group) {
		super();
		this.name = name;
		this.surname = surname;
		this.eMail = eMail;
		this.avatar = avatar;
		this.role = role;
		this.theme = theme;
		this.group = group;
	}
	public User(String login, String password, String name, String surname, String eMail, File avatar, String role) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.eMail = eMail;
		this.avatar = avatar;
		this.role = role;
	}
	
	
	public User(int id, String name, String surname, String eMail, File avatar, String role,
			String theme, List<Group> group) {
		super(id);
		this.name = name;
		this.surname = surname;
		this.eMail = eMail;
		this.avatar = avatar;
		this.role = role;
		this.theme = theme;
		this.group = group;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public File getAvatar() {
		return avatar;
	}
	public void setAvatar(File avatar) {
		this.avatar = avatar;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public List<Group> getGroup() {
		return group;
	}
	public void setGroup(List<Group> group) {
		this.group = group;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (eMail == null) {
			if (other.eMail != null)
				return false;
		} else if (!eMail.equals(other.eMail))
			return false;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
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
		return "User [login=" + login + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", eMail=" + eMail + ", avatar=" + avatar + ", role=" + role + ", theme=" + theme + ", group=" + group
				+ "]";
	}
	
	
	
	
	

}
