package by.nesterenok.testyourself.dao;

import java.util.List;

import by.nesterenok.testyourself.domain.Test;

public interface TestDao extends BaseDao<Test>{
	
	List<Test> readLast();
	
	List<Test> readSubscribed(String theme);
	
}
