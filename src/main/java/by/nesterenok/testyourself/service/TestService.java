package by.nesterenok.testyourself.service;

import java.util.List;

import by.nesterenok.testyourself.domain.Test;

public interface TestService {
	
	public Test readTest(int id);
	
	public List<Test> readAll();

}
