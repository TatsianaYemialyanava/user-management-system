package by.htp.les04.service;

import java.util.List;

import by.htp.les04.bean.User;

public interface UserService {

	User authorization (String login, String password) throws ServiceException;

	void createUser(User userInfo) throws ServiceException;

	List<User> takeAll() throws ServiceException;

	User getOne(int idUser) throws ServiceException;
}
