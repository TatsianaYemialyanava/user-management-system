package by.htp.les04.dao;

import java.util.List;

import by.htp.les04.bean.User;

public interface UserDAO {

	User authorization (String login, String password) throws DAOException;

	User loadUser (String login) throws DAOException;

	void createUser(User userInfo) throws DAOException;

	List<User> all() throws DAOException;

	User getOne(int idUser) throws DAOException;

	void updatePersonalInformation(int idUser, String name, String surname, String login, String password, String role, Boolean status) throws DAOException;
}
