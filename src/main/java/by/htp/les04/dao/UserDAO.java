package by.htp.les04.dao;

import java.util.List;

import by.htp.les04.bean.UserAccount;

public interface UserDAO {

	UserAccount authorization (String login, String password) throws DAOException;

	UserAccount loadUser (String login) throws DAOException;

	void createUser(UserAccount userInfo) throws DAOException;

	List<UserAccount> all() throws DAOException;

	UserAccount getOne(int idUser) throws DAOException;

	void updatePersonalInformation(int idUser, String name, String surname, String login, String password, String role, Boolean status) throws DAOException;
}
