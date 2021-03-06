package by.htp.les04.controller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.UserAccount;
import by.htp.les04.service.ServiceException;
import static by.htp.les04.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToIndexPage {

	@RequestMapping("/login")
	public String execute(Model theModel, Principal principal) throws ServiceException {
		
		UserAccount user = new UserAccount();
		
		theModel.addAttribute(USER, user);
		
		return GO_TO_LOGIN_PAGE;
	}
}
