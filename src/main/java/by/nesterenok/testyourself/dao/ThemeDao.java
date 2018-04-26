package by.nesterenok.testyourself.dao;

import java.util.List;

public interface ThemeDao {
	
	void create(String theme);
	String read(String theme);
	void delete(String theme);
	List<String> readAll();

}
