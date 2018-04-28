package by.nesterenok.testyourself.temp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;

public class Main {
	
	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");
		QuestionDao dao = (QuestionDao) context.getBean("questionDao");
		TestDao testDao = (TestDao) context.getBean("testDao");
		UserDao userDao = (UserDao) context.getBean("userDao");
		GroupDao groupDao = (GroupDao) context.getBean("groupDao");
		TaskDao taskDao = (TaskDao) context.getBean("taskDao");
//		Test test = new Test();
//		List<Question> questionList = new ArrayList();
//		questionList.add(new Question(1));
//		questionList.add(new Question(3));
//		questionList.add(new Question(4));
//		questionList.add(new Question(5));
//		test.setAuthor(new User(2));
//		test.setLvl(1);
//		test.setTheme("java");
//		testDao.create(test);
		//System.out.println(userDao.read(1));
//		Test test = (Test) testDao.read(1);
//		System.out.println(test);
		Group group = groupDao.read(1);
		List<Task> taskList = group.getTasks();
		System.out.println(taskList);		
//		Task task = taskDao.read(1);
//		System.out.println(task);
		
		
	}

}
