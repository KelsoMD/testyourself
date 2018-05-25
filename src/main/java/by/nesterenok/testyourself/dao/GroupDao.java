package by.nesterenok.testyourself.dao;

import java.util.List;

import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;

public interface GroupDao extends BaseDao<Group>{
	
	public List<Group> readUserGroups(int id);
	
	public List<Group> readMentorGroups(User user);

}
