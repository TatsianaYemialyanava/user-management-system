package by.htp.les04.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.service.ServiceException;
import static by.htp.les04.controller.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToErrorPage {

	@RequestMapping("/error")
	public String execute() throws ServletException, IOException, ServiceException {

		return GO_TO_ERROR_PAGE;
	}
}
