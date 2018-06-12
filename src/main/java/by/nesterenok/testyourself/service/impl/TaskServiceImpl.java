package by.nesterenok.testyourself.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private GroupDao groupDao;
	
	@Autowired
	private TaskDao taskDao;
	
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}

	@Override
	public List<Task> readUserTasks(User user) {
		List<Task> taskList = new ArrayList<>();
		for(Group group : user.getGroup()) {
			taskList.addAll(group.getTasks());
		}
		return taskList;
	}

}
