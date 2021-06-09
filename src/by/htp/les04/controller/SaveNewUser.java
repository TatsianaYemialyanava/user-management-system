package by.htp.les04.controller;

import java.io.IOException;
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
public class SaveNewUser {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "user/new", method = RequestMethod.POST)
	public String execute(@ModelAttribute("User") UserAccount user, Model theModel) throws ServletException, IOException, ServiceException {
		try {

			System.out.println(user.toString());

			userService.createUser(user);
			theModel.addAttribute(MESSAGE, "Registration completed successfully");
			return REDIRECT_PREFIX + REDIRECT_AFTER_SAVING_NEW_USER;
			
		} catch (ServiceException e) {
			theModel.addAttribute(MESSAGE, e.getMessage());
			return REDIRECT_PREFIX + REDIRECT_ON_ERROR_WHENSAVING_NEW_USER;	
		}
	}
}

