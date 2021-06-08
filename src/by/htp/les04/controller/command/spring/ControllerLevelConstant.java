package by.htp.les04.controller.command.spring;

public interface ControllerLevelConstant {
	//PARAMS
	String ID_PARAM = "id";
	String COMMAND_REDIRECT_PARAM = "commandRedirect";
	String LOGIN_PARAM = "login";
	String PASSWORD_PARAM = "password";
	String NAME_PARAM = "name";
	String SURNAME_PARAM = "surname";
	
	//ATTRIBUTES
	String SINGLE_USER_ATTRIBUTE = "singleUser";
	String USER_ATTRIBUTE = "users";
	String MESSAGE = "message";
	String USER = "user";
	
	//PATHS
	String REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE = "Controller?command=gotomainpage";
	String REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE = "Controller?command=gotomainpage";
	String REDIRECT_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_USER_INFORMATION_PAGE = "Controller?command=go_to_full_user_information_page&idUser=";
	String REDIRECT_TO_ERROR_PAGE = "AnonymousController?command=go_to_error_page";

	String REQUESTDISPATCHER_FROM_GO_TO_EDIT_PAGE_TO_EDIT_PAGE = "edit_page";
	String REQUESTDISPATCHER_FROM_GO_TO_ERROR_PAGE_TO_ERROR_PAGE = "error_page";
	String REQUESTDISPATCHER_FROM_GO_TO_FULL_USER_INFORMATION_PAGE_TO_FUll_USER_INFORMATION_PAGE = "full_user_information_page";
	String REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX = "main_index";
	String REQUESTDISPATCHER_FROM_GO_TO_MAIN_PAGE_TO_MAIN = "main";
	String REQUESTDISPATCHER_FROM_GO_TO_REGISTRATION_PAGE_TO_REGISTRATION = "registration";
	String  REDIRECT_PREFIX = "redirect:";	
}
