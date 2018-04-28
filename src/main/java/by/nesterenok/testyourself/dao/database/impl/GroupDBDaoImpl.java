package by.nesterenok.testyourself.dao.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;

public class GroupDBDaoImpl extends AbstractDBDao implements GroupDao {

	@Override
	public void create(Group t){
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_GROUP_CREATE)) {

			ps.setInt(1, t.getMentor().getId());
			ps.setString(2, t.getTheme());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in GroupDAO.create", e);
		}

	}

	@Override
	public Group read(int id) {
		Group group = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_GROUP_READ)) {

			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				group = buildObject(rs);
			}

		} catch (SQLException e) {
			LOGGER.error("SqlException in GroupDAO.read", e);
		} finally {
			closeResultSet(rs);
		}
		return group;
	}

	@Override
	public void update(Group t){
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_GROUP_UPDATE)) {

			ps.setInt(1, t.getMentor().getId());
			ps.setString(2, t.getTheme());
			ps.setInt(3, t.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in GroupDAO.update", e);
		}

	}

	@Override
	public void delete(int id) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_GROUP_DELETE)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in GroupDAO.delete", e);
		}

	}

	@Override
	public List<Group> readAll() {

		List<Group> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {

			rs = st.executeQuery(SQL_GROUP_READ_ALL);
			while (rs.next()) {
				list.add(buildObject(rs));
			}

		} catch (SQLException e) {
			LOGGER.error("SqlException in GroupDAO.readAll", e);
		} finally {
			closeResultSet(rs);
		}

		return list;
	}

	private Group buildObject(ResultSet rs) {
		Group group = null;
		try {
			
			group = new Group(rs.getInt(DB_ID));
			group.setTheme(rs.getString(DB_THEME));
			group.setMentor(new User(rs.getInt(DB_MENTOR)));
		
		} catch (SQLException e) {
			LOGGER.error("SqlException in GroupDAO.buildObject", e);
		} 
		return group;
	}

	@Override
	public List<Group> readUserGroups(int id) {
		List<Group> list = new ArrayList<>();
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection();
				PreparedStatement ps = cn.prepareStatement(SQL_GROUP_READ_USERS_GROUPS)) {
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Group(rs.getInt(DB_GROUP)));
			}

		} catch (SQLException e) {
			LOGGER.error("SqlException in GroupDAO.readUserGroups", e);
		} finally {
			closeResultSet(rs);
		}

		return list;
	}

}
