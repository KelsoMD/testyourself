package by.nesterenok.testyourself.service;

import java.util.List;

import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;

public interface TaskService {
	
	public List<Task> readUserTasks(User user);

}
