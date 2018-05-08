package by.nesterenok.testyourself.dao.database.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;

public class TestDBDaoImpl extends AbstractDBDao implements TestDao {
	
private static final  TestDBDaoImpl instance = new TestDBDaoImpl();
	
	public static TestDBDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void create(Test t){
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TEST_CREATE)) {

			ps.setString(1, t.getTheme());
			ps.setInt(2, t.getLvl());
			ps.setInt(3, t.getAuthor().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.create", e);
		}

	}

	@Override
	public Test read(int id) {
		ResultSet rs = null;
		Test test = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TEST_READ)) {
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				test = buildObject(rs);
			}
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.read", e);
		} finally {
			closeResultSet(rs);
		}
		return test;
	}

	@Override
	public void update(Test t){
		try (Connection cn = wcn.getConnection();
				PreparedStatement ps = cn.prepareStatement(SQL_TEST_UPDATE);) {
			
			ps.setString(1, t.getTheme());
			ps.setInt(2, t.getLvl());
			ps.setInt(3, t.getAuthor().getId());
			ps.setInt(4, t.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.update", e);
		}

	}

	@Override
	public void delete(int id) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TEST_DELETE)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.delete", e);
		}
	}

	@Override
	public List<Test> readAll() {
		ResultSet rs = null;
		List<Test> list = new ArrayList<>();
		try(Connection cn = wcn.getConnection();Statement st = cn.createStatement()){
			rs = st.executeQuery(SQL_TEST_READ_ALL);
			while (rs.next()) {
				list.add(buildObject(rs));
			}
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.readAll", e);
		} finally {
			closeResultSet(rs);
		}
		
		return list;
	}

	private Test buildObject(ResultSet rs) {

		Test test = null;
		try {
			
			 test = new Test(rs.getInt(DB_ID));
			 test.setTheme(rs.getString(DB_THEME));
			 test.setLvl(rs.getInt(DB_LEVEL));
			 test.setAuthor(new User(rs.getInt(DB_AUTHOR)));
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.buildObject", e);
		} 
		return test;
	}


	@Override
	public List<Test> readLast() {
		List<Test> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection(); Statement st = cn.createStatement()){

			rs = st.executeQuery(SQL_TEST_READ_LAST);
			while(rs.next()) {
				list.add(buildObject(rs));
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.readLast", e);
		} finally {
			closeResultSet(rs);
		}
		return list;
	}

	@Override
	public List<Test> readSubscribed(String theme) {
		List<Test> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TEST_READ_LAST_SUB)){
	
			ps.setString(1, theme);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(buildObject(rs));
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException in TestDAO.readSubscribed", e);
		} finally {
			closeResultSet(rs);
		}
		return list;
	}

	@Override
	public List<Test> searchTheme(String theme) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> searchLvl(int lvl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> searchThemeLvl(String theme, int lvl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> readNotAprooved() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int newTestsCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
