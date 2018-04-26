package by.nesterenok.testyourself.dao.database.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.Test;

public class TaskDBDaoImpl extends AbstractDBDao implements TaskDao {
	
private static final  TaskDBDaoImpl instance = new TaskDBDaoImpl();
	
	public static TaskDBDaoImpl getInstance() {
		return instance;
	}

	@Override
	public void create(Task t) throws IOException {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TASK_CREATE)) {
			
			ps.setInt(1, t.getGroup().getId());
			ps.setInt(2, t.getTest().getId());
			ps.setString(3, t.getFinishTo().toString());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TaskDAO.create", e);
		}

	}

	@Override
	public Task read(int id) {
		ResultSet rs = null;
		Task task = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TASK_READ)) {
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				task = buildObject(rs);
			}
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TaskDAO.read", e);
		} finally {
			closeResultSet(rs);
		}
		return task;
	}

	@Override
	public void update(Task t) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TASK_UPDATE)) {

			ps.setInt(1, t.getGroup().getId());
			ps.setInt(2, t.getTest().getId());
			ps.setString(3, t.getFinishTo().toString());
			ps.setInt(4, t.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in TaskDAO.update", e);
		}

	}

	@Override
	public void delete(int id) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_TASK_DELETE)) {

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in TaskDAO.delete", e);
		}

	}

	@Override
	public List<Task> readAll() {
		List<Task> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection();Statement st = cn.createStatement()){
			
			rs = st.executeQuery(SQL_TASK_READ_ALL);
			
			while(rs.next()) {
				list.add(buildObject(rs));
			}
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TaskDAO.readAll", e);
		} finally {
			closeResultSet(rs);
		}
		return list;
	}

	private Task buildObject(ResultSet rs){
		Task task = null;
		try {
			
			task = new Task(rs.getInt(DB_ID));
			task.setTest(new Test(rs.getInt(DB_TEST)));
			task.setGroup(new Group(rs.getInt(DB_GROUP)));
			task.setFinishTo(rs.getDate(DB_FINISH_TO));
			
		} catch (SQLException e) {
			LOGGER.error("SqlException in TaskDAO.buildobject", e);
		}
		return task;
	}

	@Override
	public List<Task> readGroupTasks(int id) {
		List<Task> list = new ArrayList<>();
		ResultSet rs = null;
		try(Connection cn = wcn.getConnection();PreparedStatement ps = cn.prepareStatement(SQL_TASK_READ_GROUP_TASKS)){
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(buildObject(rs));
			}
		} catch (SQLException e) {
			LOGGER.error("SqlException in TaskDAO.readGroupTask", e);
		} finally {
			closeResultSet(rs);
		}
		return list;
	}

}
