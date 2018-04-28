package by.nesterenok.testyourself.dao;

import java.util.List;

import by.nesterenok.testyourself.domain.Entity;

public interface BaseDao<T extends Entity> {
	
	
	void create(T t);
	
	T read(int id);
	
	void update(T t);
	
	void delete(int id);
	
	List<T> readAll();
	
}
