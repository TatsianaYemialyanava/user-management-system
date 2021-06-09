package by.htp.les04.controller;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.UserAccount;
import static by.htp.les04.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AdminController")
public class GoToRegistrationPage {

	@RequestMapping("/user/new")
	public String execute(Model theModel, Principal principal) throws ServletException, IOException {
		UserAccount user = new UserAccount();
		theModel.addAttribute(USER, user);

		return GO_TO_NEW_PAGE;
	}
}
