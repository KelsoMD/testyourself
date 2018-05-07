package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.ThemeDao;
import by.nesterenok.testyourself.service.ThemeService;

public class ThemeServiceImpl implements ThemeService{
	
	private ThemeDao themeDao;
	
	public void setThemeDao(ThemeDao themeDao) {
		this.themeDao = themeDao;
	}

	@Override
	public List<String> readThemes() {
		return themeDao.readAll();
	}

	@Override
	public void createTheme(String theme) {
		themeDao.create(theme);
	}

}
