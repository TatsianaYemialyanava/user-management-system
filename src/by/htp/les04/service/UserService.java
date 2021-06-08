package by.htp.les04.service;

import java.util.List;

import by.htp.les04.bean.UserAccount;

public interface UserService {

	UserAccount authorization (String login, String password) throws ServiceException;

	void createUser(UserAccount userInfo) throws ServiceException;

	List<UserAccount> takeAll() throws ServiceException;

	UserAccount getOne(int idUser) throws ServiceException;

	void updatePersonalInformation(int idUser, String name, String surname, String login, String password, String role, Boolean status) throws ServiceException;
}
