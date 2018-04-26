package by.nesterenok.testyourself.dao;

import java.util.List;

import by.nesterenok.testyourself.domain.Task;

public interface TaskDao extends BaseDao<Task>{
	
	public List<Task> readGroupTasks(int id);

}
