package by.nesterenok.testyourself.temp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.nesterenok.testyourself.dao.QuestionDao;

public class Main {
	
	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");
		QuestionDao dao = (QuestionDao) context.getBean("questionDao");
//		List<Question> list = dao.readAll();
//		
//		for(Question q : list) {
//			System.out.println(q);
//		}
		System.out.println(dao.read(14));
		System.out.println(dao.read(10));
	}

}
