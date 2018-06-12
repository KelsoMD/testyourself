package by.nesterenok.testyourself.web.action.implmvc.user;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_USER_TASK_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_GROUPS_ETC;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_GROUPS_FINISH_TASK;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_GROUPS_START_TASK;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MSG_NOT_PASSED;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MSG_PASSED;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER_MAP;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_MARK;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_PASS_MSG;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTIONS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TASK;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.service.ResultService;
import by.nesterenok.testyourself.service.TaskService;

@Controller
@RequestMapping(value = REQUEST_MAPPING_USER_GROUPS_ETC)
public class UserGroupsController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ResultService resultService;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_GROUPS_START_TASK)
    public ModelAndView startTask(@RequestParam(REQUEST_PARAM_TASK) int id) {
        ModelAndView mnv = new ModelAndView(PAGE_USER_TASK_PAGE);
        Task task = taskService.readTask(id);
        mnv.addObject(REQUEST_PARAM_QUESTIONS, task.getTest()
            .getQuestions());
        return mnv;
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = REQUEST_MAPPING_USER_GROUPS_FINISH_TASK)
    public ModelAndView finishTask(@RequestParam(REQUEST_PARAM_ANSWER) String[] answers,
                                   @RequestParam(REQUEST_PARAM_TASK) int taskId) {
        ModelAndView mvn = new ModelAndView(PAGE_USER_TASK_PAGE);
        Map<Question, String> answerMap = resultService.parseAnswers(answers);
        mvn.addObject(REQUEST_PARAM_ANSWER_MAP, answerMap);
        int mark = resultService.getMark(answerMap);
        mvn.addObject(REQUEST_PARAM_MARK, resultService.getMark(answerMap));
        if (resultService.isPassed(mark)) {
            mvn.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_PASSED);
        } else {
            mvn.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_NOT_PASSED);
        }
        mvn.addObject(REQUEST_PARAM_TASK, taskId);
        return mvn;
    }
}
