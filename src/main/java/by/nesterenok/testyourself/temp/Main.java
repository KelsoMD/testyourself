package by.nesterenok.testyourself.temp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		
		Test test = testDao.read(5);
		System.out.println(test);
		
		
		
	}

}
