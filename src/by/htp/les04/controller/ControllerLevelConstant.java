package by.htp.les04.controller;

public interface ControllerLevelConstant {
	//PARAMS
	//String ID_PARAM = "id";
	//String COMMAND_REDIRECT_PARAM = "commandRedirect";
	//String LOGIN_PARAM = "login";
	//String PASSWORD_PARAM = "password";
	//String NAME_PARAM = "name";
	//String SURNAME_PARAM = "surname";
	
	//ATTRIBUTES
	String SINGLE_USER_ATTRIBUTE = "singleUser";
	String USER_ATTRIBUTE = "users";
	String MESSAGE = "message";
	String USER = "user";
	
	//PATHS
	String REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE = "/Controller/user";
	String REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE = "Controller/user";
	String REDIRECT_TO_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_USER_INFORMATION_PAGE = "/Controller/user/";
	String REDIRECT_TO_ERROR_PAGE = "AnonymousController?command=go_to_error_page";

	String GO_TO_EDIT_PAGE = "edit";
	String GO_TO_ERROR_PAGE = "error_page";
	String GO_TO_VIEW_PAGE = "view";
	String GO_TO_LOGIN_PAGE = "login";
	String GO_TO_LIST_PAGE = "list";
	String GO_TO_NEW_PAGE = "new";
	String  REDIRECT_PREFIX = "redirect:";	
}
