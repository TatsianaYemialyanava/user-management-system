package by.htp.les04.controller;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.htp.les04.bean.UserAccount;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;
import static by.htp.les04.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AdminController")
public class SaveEdittedInformation {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{idUser}/edit", method = RequestMethod.POST)
	public String execute(@ModelAttribute("singleUser") UserAccount user, Model theModel, Principal principal, HttpServletRequest request) throws ServletException, IOException, ServiceException {

		int idUser = user.getIdUser();
		String name = user.getName();
		String surname = user.getSurname();
		String login = user.getLogin();
		String password = user.getPassword();
		String role = user.getRole();
		Boolean status = user.getStatus();

		userService.updatePersonalInformation(idUser, name, surname, login, password, role, status);
		
		theModel.addAttribute(MESSAGE, "user details has been saved");
		return REDIRECT_PREFIX + REDIRECT_AFTER_SAVING_NEW_USER_TO_VIEW_PAGE + idUser;
	}
}
