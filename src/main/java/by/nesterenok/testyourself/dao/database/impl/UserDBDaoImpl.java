package by.nesterenok.testyourself.dao.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.User;

public class UserDBDaoImpl extends AbstractDBDao implements UserDao {

	private static final UserDBDaoImpl instance = new UserDBDaoImpl();

	public static UserDBDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void create(User t){
		
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_USER_CREATE);) {
			ps.setString(1, t.getLogin());
			ps.setString(2, t.getPassword());
			if (t.getName() != null)
				ps.setString(3, t.getName());
			if (t.getSurname() != null)
				ps.setString(4, t.getSurname());
			if (t.geteMail() != null)
				ps.setString(5, t.geteMail());
			ps.setString(7, t.getRole());
			if (t.getTheme() != null)
				ps.setString(8, t.getTheme());

		} catch (SQLException e) {
			LOGGER.error("SqlException in UserDAO.create", e);
		} 
	}

	@Override
	public User read(int id) {
		User user = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_USER_READ)) {
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = buildObject(rs);
			}

		} catch (SQLException e) {
			LOGGER.error("SqlException in UserDAO.read", e);
		} finally {
			closeResultSet(rs);
		}
		return user;
	}

	@Override
	public void update(User t){
		
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_USER_UPDATE)) {
			ps.setString(1, t.getName());
			ps.setString(2, t.getSurname());
			ps.setString(3, t.geteMail());
			ps.setString(5, t.getRole());
			ps.setString(6, t.getTheme());
		} catch (SQLException e) {
			LOGGER.error("SqlException in UserDAO.update", e);
		}
	}

	@Override
	public void delete(int id) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_USER_DELETE)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("SqlException in UserDAO.delete", e);
		}
	}

	@Override
	public List<User> readAll() {
		ResultSet rs = null;
		List<User> list = new ArrayList<>();
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {
			rs = st.executeQuery(SQL_USER_READ_ALL);
			while (rs.next()) {
				list.add(buildObject(rs));
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException in UserDAO.readAll", e);
		} finally {
			closeResultSet(rs);
		}
		return list;
	}

	private User buildObject(ResultSet rs) {
		User user = null;
		
		try {
			
			user = new User(rs.getInt(DB_ID));
			user.setName(rs.getString(DB_NAME));
			user.setSurname(rs.getString(DB_SURNAME));
			user.seteMail(rs.getString(DB_EMAIL));
			user.setRole(rs.getString(DB_ROLE));
			user.setRole(rs.getString(DB_THEME));
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.read", e);
		}
		return user;
	}
}
