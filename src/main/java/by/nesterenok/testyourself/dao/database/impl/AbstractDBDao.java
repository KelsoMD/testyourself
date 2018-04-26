package by.nesterenok.testyourself.dao.database.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.nesterenok.testyourself.dao.database.util.ConnectionWrap;

public abstract class AbstractDBDao {
	
	protected static final Logger LOGGER = LogManager.getLogger();
	
	ConnectionWrap wcn;
	
	public AbstractDBDao() {
		wcn = new ConnectionWrap();
	}
	
	protected void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("SqlException in closeResultSet", e);
			}
		}
	}
	
	protected static final String DB_ID = "id";
	protected static final String DB_LOGIN = "login";
	protected static final String DB_PASS = "pass";
	protected static final String DB_NAME = "name";
	protected static final String DB_SURNAME = "surname";
	protected static final String DB_EMAIL = "e_mail";
	protected static final String DB_AVATAR = "avatar";
	protected static final String DB_ROLE = "role";
	protected static final String DB_THEME = "theme";
	protected static final String DB_GROUP = "group";
	protected static final String DB_MENTOR = "mentor";
	protected static final String DB_MEMBER = "member";
	protected static final String DB_TEST = "test";
	protected static final String DB_FINISH_TO = "finish_to";
	protected static final String DB_LEVEL = "level";
	protected static final String DB_TEXT = "text";
	protected static final String DB_IMAGE = "image";
	protected static final String DB_ANSWER_CORRECT = "answer_correct";
	protected static final String DB_ANSWER_1 = "answer_1";
	protected static final String DB_ANSWER_2 = "answer_2";
	protected static final String DB_ANSWER_3 = "answer_3";
	protected static final String DB_AUTHOR = "author";
	protected static final String DB_MARK = "mark";
	protected static final String DB_PASSED = "passed";
	protected static final String DB_CORRECT = "correct";
	protected static final String DB_QUESTION = "question";
	protected static final String DB_USER_ANSWER = "user_answers";
	protected static final String DB_RESULT = "result";
	protected static final String DB_TASK = "task";
	protected static final String DB_DATE = "date";
	protected static final String DB_USER = "user";

	protected static final String SQL_USER_CREATE = "INSERT INTO users (login, pass, name, surname, e_mail, role, theme) VALUES (?, ?, ?, ?, ?, ?, ?);";
	protected static final String SQL_USER_READ = "SELECT id, login, pass, name, surname, e_mail, role, theme FROM users WHERE id = ?;";
	protected static final String SQL_USER_UPDATE = "UPDATE users SET name = ?, surname =?, e_mail = ?, role = ?, theme = ? WHERE id =?";
	protected static final String SQL_USER_DELETE = "DELETE FROM users WHERE id = ?";
	protected static final String SQL_USER_READ_ALL = "SELECT login, pass, name, surname, e_mail, role, theme FROM users WHERE role = 'user' AND role = 'mentor';";
	
	protected static final String SQL_QUESTION_CREATE = "INSERT INTO questions (theme, level, text, image, answer_correct, answer_1, answer_2, answer_3, author) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
	protected static final String SQL_QUESTION_READ = "SELECT id, theme, level, text, image, answer_correct, answer_1, answer_2, answer_3, author FROM questions WHERE id = ?;";
	protected static final String SQL_QUESTION_UPDATE = "UPDATE questions SET theme = ?, level = ?, text = ?, image = ?, answer_correct = ?, answer_1 = ?, answer_2 = ?, answer_3 = ?, author = ? WHERE id = ?;";
	protected static final String SQL_QUESTION_DELETE = "DELETE FROM questions WHERE id = ?";
	protected static final String SQL_QUESTION_READ_ALL = "SELECT id, theme, level, text, image, answer_correct, answer_1, answer_2, answer_3, author FROM questions;";
	protected static final String SQL_QUESTION_COUNTER = "SELECT count(id) FROM questions;";
	protected static final String SQL_QUESTION_READ_TEST = "SELECT question FROM `test-questions` WHERE test = ?;";
	
	protected static final String SQL_TEST_CREATE = "INSERT INTO tests (theme, level, author) VALUES (?, ?, ?);";
	protected static final String SQL_TEST_READ = "SELECT id, theme, level, author FROM tests WHERE id = ?;";
	protected static final String SQL_TEST_UPDATE = "UPDATE tests SET theme = ?, level = ?, author = ? WHERE id = ?;";
	protected static final String SQL_TEST_DELETE = "DELETE FROM tests WHERE id = ?";
	protected static final String SQL_TEST_READ_ALL = "SELECT id, theme, level, author FROM tests;";
	protected static final String SQL_TEST_READ_QUESTIONS = "SELECT question FROM `test-questions` where test = ?;";
	protected static final String SQL_TEST_READ_LAST = "SELECT id, theme, level, author FROM tests ORDER by id DESC LIMIT 4";
	protected static final String SQL_TEST_READ_LAST_SUB = "SELECT id, theme, level, author FROM tests WHERE theme = ? ORDER by id DESC LIMIT 4";
	
	protected static final String SQL_TASK_CREATE = "INSERT INTO `group-task` (group, test, finish_to) VALUES (?, ?, ?);";
	protected static final String SQL_TASK_READ = "SELECT id, group, test, finish_to FROM `group-task` WHERE id = ?;";
	protected static final String SQL_TASK_UPDATE = "UPDATE `group-task` SET group = ?, test = ?, finish_to = ? WHERE id = ?;";
	protected static final String SQL_TASK_DELETE = "DELETE FROM `group-task` WHERE id = ?";
	protected static final String SQL_TASK_READ_ALL = "SELECT id, group, test, finish_to FROM `group-task`;";
	protected static final String SQL_TASK_READ_GROUP_TASKS = "SELECT `id`, `group`, `test`, `finish_to` FROM `group-task` WHERE `group` = ?;";
	
	protected static final String SQL_GROUP_CREATE = "INSERT INTO group (mentor, theme) VALUES (?, ?);";
	protected static final String SQL_GROUP_READ = "SELECT id, mentor, theme FROM group WHERE id = ?;";
	protected static final String SQL_GROUP_UPDATE = "UPDATE group SET mentor = ?, theme = ? WHERE id = ?;";
	protected static final String SQL_GROUP_DELETE = "DELETE FROM group WHERE id = ?";
	protected static final String SQL_GROUP_READ_ALL = "SELECT id, mentor, theme FROM group;";
	protected static final String SQL_GROUP_READ_TASKS = "SELECT id FROM `group-task` WHERE `group` = ?;";
	protected static final String SQL_GROUP_READ_MEMBERS = "SELECT user FROM `users-group` WHERE `group` = ?;";
	protected static final String SQL_GROUP_READ_USERS_GROUPS = "SELECT `group` FROM `users-group` WHERE user = ?;";
	
	protected static final String SQL_RESULT_CREATE = "INSERT INTO result (test, mark, passed, user) VALUES (?, ?, ?, ?);";
	protected static final String SQL_RESULT_READ = "SELECT id, test, mark, passed, user FROM result WHERE id = ?;";
	protected static final String SQL_RESULT_READ_ALL = "SELECT id, test, mark, passed, user FROM result;";
}
