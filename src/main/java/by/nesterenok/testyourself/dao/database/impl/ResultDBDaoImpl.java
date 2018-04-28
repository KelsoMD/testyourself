package by.nesterenok.testyourself.dao.database.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;

public class ResultDBDaoImpl extends AbstractDBDao implements ResultDao {

	@Override
	public void create(Result t) {
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_RESULT_CREATE)) {

			ps.setInt(1, t.getTest().getId());
			ps.setInt(2, t.getMark());
			ps.setBoolean(3, t.isPassed());
			ps.setInt(4, t.getUser().getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			LOGGER.error("SqlException in ResultDAO.create", e);
		}

	}

	@Override
	public Result read(int id) {

		Result result = null;
		ResultSet rs = null;
		try (Connection cn = wcn.getConnection(); PreparedStatement ps = cn.prepareStatement(SQL_RESULT_READ);) {

			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = buildObject(rs);
			}

		} catch (SQLException e) {
			LOGGER.error("SqlException in ResultDAO.read", e);
		} finally {
			closeResultSet(rs);
		}
		return result;
	}

	@Override
	public void update(Result t){
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Result> readAll() {
		List<Result> list = new ArrayList<>();
		ResultSet rs = null;

		try (Connection cn = wcn.getConnection(); Statement st = cn.createStatement()) {

			rs = st.executeQuery(SQL_RESULT_READ_ALL);
			while (rs.next()) {
				list.add(buildObject(rs));
			}

		} catch (SQLException e) {
			LOGGER.error("SqlException in ResultDAO.readAll", e);
		} finally {
			closeResultSet(rs);
		}
		return list;
	}

	private Result buildObject(ResultSet rs) {
		Result result = null;
		try {

			result = new Result(rs.getInt(DB_ID));
			result.setMark(rs.getInt(DB_MARK));
			result.setPassed(rs.getBoolean(DB_PASSED));
			result.setTest(new Test(rs.getInt(DB_TEST)));
			result.setUser(new User(rs.getInt(DB_USER)));

		} catch (SQLException e) {
			LOGGER.error("SqlException in ResultDAO.buildObject", e);
		}

		return result;

	}

}
