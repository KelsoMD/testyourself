package by.nesterenok.testyourself.service;

import java.util.List;

import by.nesterenok.testyourself.domain.Test;

public interface StartService {
	
	int getQuestionCount();
	
	List<Test> getStartTests();
	
	List<Test> getStartSubscribedTests(String theme);

}
