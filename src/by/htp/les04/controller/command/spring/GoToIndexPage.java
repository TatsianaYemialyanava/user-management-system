package by.htp.les04.controller.command.spring;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.UserAccount;
import by.htp.les04.service.ServiceException;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToIndexPage {

	@RequestMapping(params = {"command=gotoindexpage"})
	public String execute(Model theModel, Principal principal) throws ServiceException {
		
		UserAccount user = new UserAccount();
		
		theModel.addAttribute(USER, user);
		
		return REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX;
	}
}
