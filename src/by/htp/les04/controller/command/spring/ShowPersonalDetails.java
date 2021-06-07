package by.htp.les04.controller.command.spring;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.News;
import by.htp.les04.bean.User;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;

import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class ShowPersonalDetails {

	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(params = {"command=go_to_full_news_page"})
	public String execute(@ModelAttribute("News") User user, Model theModel, Principal principal) throws ServletException, IOException, ServiceException {
		
		User singleUser = userService.getOne(user.getIdUser());
		
		if (singleUser == null) {
			theModel.addAttribute(MESSAGE, "An error has occurred. Wait a while and try again");
			return REDIRECT_PREFIX + REDIRECT_TO_ERROR_PAGE;
		}
		
		theModel.addAttribute(SINGLE_NEWS_ATTRIBUTE, singleUser);
		return REQUESTDISPATCHER_FROM_GO_TO_FULL_NEWS_PAGE_TO_FUII_NEWS_PAGE;
	}
}
