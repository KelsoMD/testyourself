package by.nesterenok.testyourself.dao;

import java.io.IOException;
import java.util.List;

import by.nesterenok.testyourself.domain.Entity;

public interface BaseDao<T extends Entity> {
	
	
	void create(T t) throws IOException;
	
	T read(int id);
	
	void update(T t) throws IOException;
	
	void delete(int id);
	
	List<T> readAll();
	
}
