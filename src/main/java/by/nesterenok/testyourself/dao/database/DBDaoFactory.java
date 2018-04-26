package by.nesterenok.testyourself.dao.database;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.dao.database.impl.GroupDBDaoImpl;
import by.nesterenok.testyourself.dao.database.impl.QuestionDBDaoImpl;
import by.nesterenok.testyourself.dao.database.impl.ResultDBDaoImpl;
import by.nesterenok.testyourself.dao.database.impl.TaskDBDaoImpl;
import by.nesterenok.testyourself.dao.database.impl.TestDBDaoImpl;
import by.nesterenok.testyourself.dao.database.impl.UserDBDaoImpl;

public class DBDaoFactory {
	
	private DBDaoFactory() {
		
	}
	
	public GroupDao getGroupDao() {
		return new GroupDBDaoImpl();
	}
	
	public QuestionDao getQuestionDao() {
		return new QuestionDBDaoImpl();
	}
	
	public TaskDao getTaskDao() {
		return new TaskDBDaoImpl();
	}
	
	public TestDao getTestDao() {
		return new TestDBDaoImpl();
	}
	
	public UserDao getUserDao() {
		return new UserDBDaoImpl();
	}
	
	public ResultDao getResultDao() {
		return new ResultDBDaoImpl();
	}

}
