package by.nesterenok.testyourself.web.util;

public final class WebConstantPool {
	
	private WebConstantPool() {
		
	}
	
	public static final String REQUEST_PARAM_QUESTION_COUNT =  "question_count";
	public static final String REQUEST_PARAM_LIST =  "list";
	public static final String REQUEST_PARAM_TEST_ID =  "test_id";
	public static final String REQUEST_PARAM_TEST_QUESTIONS = "test_questions";
	public static final String REQUEST_PARAM_ANSWER = "answer";
	public static final String REQUEST_PARAM_ANSWER1 = "answer1";
	public static final String REQUEST_PARAM_ANSWER2 = "answer2";
	public static final String REQUEST_PARAM_ANSWER3 = "answer3";
	public static final String REQUEST_PARAM_CORRECT_ANSWER = "correct_answer";
	public static final String REQUEST_PARAM_ANSWER_MAP = "answer_map";
	public static final String REQUEST_PARAM_MARK = "mark";
	public static final String REQUEST_PARAM_PASS_MSG = "pass_msg";
	public static final String REQUEST_PARAM_ROLE = "role";
	public static final String REQUEST_PARAM_TASK = "task";
	public static final String REQUEST_PARAM_TEST = "test";
	public static final String REQUEST_PARAM_USER = "user";
	public static final String REQUEST_PARAM_TESTS = "tests";
	public static final String REQUEST_PARAM_THEMES = "themes";
	public static final String REQUEST_PARAM_THEME = "theme";
	public static final String REQUEST_PARAM_LVL = "lvl";
	public static final String REQUEST_PARAM_TEXT = "text";
	public static final String REQUEST_PARAM_IMAGE = "image";
	public static final String REQUEST_PARAM_THEME_MSG = "theme_msg";
	public static final String REQUEST_PARAM_QUESTIONS_TO_CHOOSE = "testQuestionsToChoose";
	public static final String REQUEST_PARAM_QUESTIONS_ID = "question_id";
	public static final String REQUEST_PARAM_QUESTIONS_RECENT = "recentTestQuestions";
	public static final String REQUEST_PARAM_SHUFFLED = "shuffled";
	public static final String REQUEST_PARAM_NEW_QUESTIONS_COUNT = "new_questions";
	public static final String REQUEST_PARAM_NEW_TESTS_COUNT = "new_tests";
	public static final String REQUEST_PARAM_NEW_THEME_COUNT = "new_theme";
	public static final String REQUEST_PARAM_QUESTIONS = "questions";
	public static final String REQUEST_PARAM_IMAGE_LINK = "image_link";
	public static final String REQUEST_PARAM_GROUPS =  "groups";
	
	public static final String REQUEST_MSG_PASSED = "Test passed";
	public static final String REQUEST_MSG_NOT_PASSED = "Test not passed";
	public static final String REQUEST_MSG_THEME_EXISTS = "Theme already exists";
	
	public static final String SESSION_PARAM_USER = "user";
	public static final String SESSION_PARAM_TEST = "test";
	
	
	public static final String REQUEST_MAPPING_TEMP_START = "/temp_start_new";
	public static final String REQUEST_MAPPING_START_USER = "/start_user_new";
	
	public static final String REQUEST_MAPPING_MENTOR = "mentor";
	public static final String REQUEST_MAPPING_MENTOR_GROUPS = "/groups";
	public static final String REQUEST_MAPPING_MENTOR_TESTS = "/tests";
	public static final String REQUEST_MAPPING_MENTOR_GROUPS_ETC = "mentor/groups";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_ETC = "mentor/tests";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_CREATE_THEME = "/create_theme";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_CREATE_QUESTION = "/create_question";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_CREATE_TEST = "/create_test";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_START_TEST = "/start_test";

	public static final String REQUEST_MAPPING_USER = "user";

	
	public static final String PAGE_INDEX =  "/WEB-INF/index.jsp";
	public static final String PAGE_TEST = "/WEB-INF/jsp/user/test_page.jsp";
	public static final String PAGE_RESULT = "/WEB-INF/jsp/user/result_page.jsp";
	public static final String PAGE_INDEX_TEMP = "/indextemp.jsp";
	public static final String PAGE_USER_MAIN = "/WEB-INF/jsp/user/main.jsp";
	public static final String PAGE_USER_SEARCH = "/WEB-INF/jsp/user/search.jsp";
	public static final String PAGE_USER_CREATE_QUESTION = "/WEB-INF/jsp/user/create_question.jsp";
	public static final String PAGE_USER_CREATE_THEME = "/WEB-INF/jsp/user/create_theme.jsp";
	public static final String PAGE_USER_CREATE_TEST_ST_ONE = "/WEB-INF/jsp/user/start_build_test.jsp";
	public static final String PAGE_USER_CREATE_TEST_ST_TWO = "/WEB-INF/jsp/user/build_test.jsp";
	public static final String PAGE_USER_PREVIEW = "/WEB-INF/jsp/user/preview.jsp";
	public static final String PAGE_MODERATOR_MAIN = "/WEB-INF/moderator_main.jsp";
	public static final String PAGE_MODERATOR_QUESTIONS = "/WEB-INF/moderate_questions.jsp";
	public static final String PAGE_MODERATOR_PREVIEW = "/WEB-INF/preview_moderator.jsp";
	
	
	public static final String PAGE_NOT_IMPL = "notimplemented";

	public static final String PAGE_MENTOR_MAIN = "jsp/mentor/main";
	public static final String PAGE_MENTOR_GROUPS = "jsp/mentor/groups";
	public static final String PAGE_MENTOR_TESTS = "jsp/mentor/tests";
	public static final String PAGE_MENTOR_TESTS_CREATE_THEME = "jsp/mentor/create_theme";
	public static final String PAGE_MENTOR_TESTS_CREATE_QUESTION = "jsp/mentor/create_question";
	public static final String PAGE_MENTOR_TESTS_CREATE_TEST = "jsp/mentor/start_build_test";
	public static final String PAGE_MENTOR_TESTS_TEST = "jsp/mentor/test_page";
	
	public static final String REDIRECT_URL_SEARCH_PAGE = "http://localhost:8080/testyourself/MainServlet?action=switch_search_page";
	public static final String REDIRECT_URL_MAIN_USER_PAGE = "http://localhost:8080/testyourself/MainServlet?action=start_user";
	public static final String REDIRECT_URL_MODERATOR_QUESTIONS = "http://localhost:8080/testyourself/MainServlet?action=moderate_questions";
	public static final String REDIRECT_URL_SEARCH_PAGE_CLOUD = "http://testyourself.mycloud.by/MainServlet?action=switch_search_page";
	public static final String REDIRECT_URL_MAIN_USER_PAGE_CLOUD = "http://testyourself.mycloud.by/MainServlet?action=start_user";
	public static final String REDIRECT_URL_MODERATOR_QUESTIONS_CLOUD = "http://testyourself.mycloud.by/MainServlet?action=moderate_questions";

}
