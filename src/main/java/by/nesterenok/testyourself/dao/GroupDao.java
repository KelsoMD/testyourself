package by.nesterenok.testyourself.dao;

import java.util.List;

import by.nesterenok.testyourself.domain.Group;

public interface GroupDao extends BaseDao<Group>{
	
	public List<Group> readUserGroups(int id);

}
