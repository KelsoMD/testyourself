package by.nesterenok.testyourself.service;

import java.util.List;

import by.nesterenok.testyourself.domain.Task;

public interface TaskService {
	
	public List<Task> readUserTasks(int id);

}
