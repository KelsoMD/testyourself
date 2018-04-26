package by.nesterenok.testyourself.dao.database.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.User;

public class QuestionDBDaoImpl extends AbstractDBDao implements QuestionDao {

	private static final QuestionDBDaoImpl instance = new QuestionDBDaoImpl();

	public static QuestionDBDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void create(Question t) throws IOException {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_QUESTION_CREATE)) {

			ps.setString(1, t.getTheme());
			ps.setInt(2, t.getLvl());
			ps.setString(3, t.getText());
			ps.setString(4, t.getImage());
			ps.setString(5, t.getCorrectAnswer());
			ps.setString(6, t.getAnswer1());
			ps.setString(7, t.getAnswer2());
			ps.setString(8, t.getAnswer3());
			ps.setInt(9, t.getAuthor().getId());
			ps.executeQuery();

		} catch (SQLException e) {
			LOGGER.error("SqlException in QuestionDAO.create", e);
		}

	}

	@Override
	public Question read(int id) {
		Question question = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_QUESTION_READ)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				question = buildObject(rs);
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException in QuestionDAO.read", e);
		} finally {
			closeResultSet(rs);
		}
		return question;
	}

	@Override
	public void update(Question t) throws IOException {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_QUESTION_UPDATE)) {

			ps.setString(1, t.getTheme());
			ps.setInt(2, t.getLvl());
			ps.setString(3, t.getText());
			ps.setString(4, t.getImage());
			ps.setString(5, t.getCorrectAnswer());
			ps.setString(6, t.getAnswer1());
			ps.setString(7, t.getAnswer2());
			ps.setString(8, t.getAnswer3());
			ps.setInt(9, t.getAuthor().getId());
			ps.setInt(10, t.getId());
			ps.executeQuery();

		} catch (SQLException e) {
			LOGGER.error("SqlException in QuestionDAO.update", e);
		} 
	}

	@Override
	public void delete(int id) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_QUESTION_DELETE)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in QuestionDAO.delete", e);
		}

	}

	@Override
	public List<Question> readAll() {
		List<Question> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {
			rs = st.executeQuery(SQL_QUESTION_READ_ALL);
			while (rs.next()) {
				list.add(buildObject(rs));
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException in QuestionDAO.readAll", e);
		} finally {
			closeResultSet(rs);
		}
		return list;
	}

	private Question buildObject(ResultSet rs) {
		Question question = null;
			try {
				
				question = new Question(rs.getInt(DB_ID));
				question.setTheme(rs.getString(DB_THEME));
				question.setLvl(rs.getInt(DB_LEVEL));
				question.setText(rs.getString(DB_TEXT));
				question.setImage(rs.getString(DB_IMAGE));
				question.setCorrectAnswer(rs.getString(DB_ANSWER_CORRECT));
				question.setAnswer1(rs.getString(DB_ANSWER_1));
				question.setAnswer2(rs.getString(DB_ANSWER_2));
				question.setAnswer3(rs.getString(DB_ANSWER_3));
				question.setAuthor(new User(rs.getInt(DB_AUTHOR)));
				
			} catch (SQLException e) {
				LOGGER.error("SqlException in QuestionDAO.buildObject", e);
			}
		return question;
	}

	@Override
	public int counter() {
		int count = 0;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {

			rs = st.executeQuery(SQL_QUESTION_COUNTER);
			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			LOGGER.error("SqlException in QuestionDAO.counter", e);
		} finally {
			closeResultSet(rs);
		}
		return count;
	}

	@Override
	public List<Question> readTestQuestions(int id) {
		List<Question> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_QUESTION_READ_TEST)){
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {	
				list.add(new Question(rs.getInt(DB_QUESTION)));	
			}
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in QuestionDAO.readTest", e);
		} finally {	
			closeResultSet(rs);
		}
		return list;
	}
}
