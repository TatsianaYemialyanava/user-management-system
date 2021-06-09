package by.htp.les04.controller;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
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
public class GoToEditPage {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/{idUser}/edit", method = RequestMethod.GET)
	public String execute(@ModelAttribute("User") UserAccount user, Model theModel, Principal principal) throws ServletException, IOException, ServiceException {

		UserAccount singleUser = userService.getOne(user.getIdUser());

		if (singleUser == null) {
			theModel.addAttribute(MESSAGE, "An error has occurred. Wait a while and try again");
			return REDIRECT_PREFIX + REDIRECT_TO_ERROR_PAGE;
		}

		theModel.addAttribute(SINGLE_USER_ATTRIBUTE, singleUser);
		return GO_TO_EDIT_PAGE;
	}
}
