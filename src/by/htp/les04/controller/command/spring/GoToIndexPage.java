package by.htp.les04.controller.command.spring;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.User;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;

import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToIndexPage {
	
	@Autowired
	private UserService userService;

	@RequestMapping(params = {"command=gotoindexpage"})
	public String execute(Model theModel, Principal principal) throws ServiceException {
		
		User user = new User();
		
		theModel.addAttribute(USER, user);
		
		return REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX;
	}
}
