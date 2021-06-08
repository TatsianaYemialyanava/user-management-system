package by.htp.les04.controller.command.spring;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.User;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;

import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AdminController")
public class SaveEdittedInformation {

	@Autowired
	private UserService userService;

	@RequestMapping(params = {"command=save_new_information"})
	public String execute(@ModelAttribute("singleNews") User user, Model theModel, Principal principal) throws ServletException, IOException, ServiceException {

		int idUser = user.getIdUser();
		String name = user.getName();
		String surname = user.getSurname();
		String email = user.getEmail();
		String login = user.getLogin();
		String password = user.getPassword();
		String role = user.getRole();

		userService.updatePersonalInformation(idUser, name, surname, email, login, password, role);
		
		theModel.addAttribute(MESSAGE, "user details has been saved");
		return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_NEWS_PAGE + idUser;
	}
}
