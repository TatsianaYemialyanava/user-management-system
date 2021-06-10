package by.htp.les04.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.UserAccount;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;
import static by.htp.les04.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class ShowUserList {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/user")
	public String execute(Model theModel, Principal principal) throws ServletException, IOException, ServiceException {

		List<UserAccount> users = userService.takeAll();
		
		theModel.addAttribute(USER_ATTRIBUTE, users);
		
		return GO_TO_LIST_PAGE;
	}
}
