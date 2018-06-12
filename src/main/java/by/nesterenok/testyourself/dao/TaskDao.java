package by.nesterenok.testyourself.dao;

import java.util.List;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;

public interface TaskDao extends BaseDao<Task> {

    public List<Task> readGroupTasks(int id);

    List<Task> readComplete4Tasks(User user);
}
