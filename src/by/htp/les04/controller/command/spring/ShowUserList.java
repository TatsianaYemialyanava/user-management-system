package by.htp.les04.controller.command.spring;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.News;
import by.htp.les04.bean.User;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;

import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class ShowUserList {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;

	@RequestMapping(params = {"command=gotomainpage"})
	public String execute(Model theModel, Principal principal) throws ServletException, IOException, ServiceException {

		//List<News> news = newsService.takeAll();
		List<User> users = userService.takeAll();
		
		theModel.addAttribute(NEWS_ATTRIBUTE, users);
		
		return REQUESTDISPATCHER_FROM_GO_TO_MAIN_PAGE_TO_MAIN;
	}
}
