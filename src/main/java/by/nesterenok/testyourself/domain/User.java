package by.nesterenok.testyourself.domain;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@javax.persistence.Entity
@Table(name = "users", uniqueConstraints =
@UniqueConstraint(columnNames = {"id", "login"}))
public class User extends Entity{

	private static final long serialVersionUID = -1581370722830911563L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "login", unique = true)
	private String login;

	@Column(name = "pass")
	private String password;

	@Column(name = "name")
	private String name;

	@Column(name = "surname")
	private String surname;

	@Column(name = "e_mail")
	private String eMail;

	@Column(name = "role")
	private String role;

	@Column(name = "theme")
	private String theme;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Group.class)
	@JoinTable(name = "user_groups", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "group_id")})
	private Set<Group> group;

	public User(int id) {
		super(id);
	}
	public User(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	
	
	
	
	

}
