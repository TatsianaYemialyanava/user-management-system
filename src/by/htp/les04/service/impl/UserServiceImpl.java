package by.htp.les04.service.impl;

import by.htp.les04.bean.UserAccount;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.UserDAO;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;
import static by.htp.les04.service.impl.validatorIncomingData.ValidationDataForAuthorisation.*;
import static by.htp.les04.service.impl.validatorIncomingData.ValidationDataForRegistration.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDAO userDAO;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername dounload service");
		UserAccount user = null;
		try {
			user = userDAO.loadUser(username);
		}catch (DAOException e) {
			throw new UsernameNotFoundException (e.getMessage(), e);
		}
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(user.getName());
			builder.password(user.getPassword());
			String[] roles = new String[] {user.getRole()};
			builder.roles(roles);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

	@Override
	public UserAccount authorization(String login, String password) throws ServiceException {
		System.out.println("authorization service");

		if (!validateDataForAuthorisation(login, password)) {
			throw new ServiceException("wrong login or password");
		}

		UserAccount user = null;
		try {
			user = userDAO.authorization(login, password);
		}catch (DAOException e) {
			throw new ServiceException (e.getMessage(), e);
		}
		return user;
	}

	@Override
	public void createUser(UserAccount user) throws ServiceException {

		String name = user.getName();
		String surname = user.getSurname();
		String login = user.getLogin();
		String password = user.getPassword();
		String role = user.getRole();
		Boolean status = user.getStatus();
		

		if (!validateDataForRegistration(name, surname, login, password)) {
			throw new ServiceException("incorrect data entered");
		}

		try {
			userDAO.createUser(user);
		}catch (DAOException e) {
			throw new ServiceException (e.getMessage(), e);
		}
	}

	@Override
	public List<UserAccount> takeAll() throws ServiceException  {
		List<UserAccount> users;

		try {
			users = userDAO.all();
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return users;
	}

	@Override
	public UserAccount getOne(int idUser) throws ServiceException {
		UserAccount oneUser = null;

		try {
			oneUser = userDAO.getOne(idUser);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return oneUser;
	}

	@Override
	public void updatePersonalInformation(int idUser, String name, String surname, String login,
			String password, String role, Boolean status) throws ServiceException {
		try {
			userDAO.updatePersonalInformation(idUser, name, surname, login, password, role, status);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}	
	}
}
