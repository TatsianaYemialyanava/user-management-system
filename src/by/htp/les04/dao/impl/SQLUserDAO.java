package by.htp.les04.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import by.htp.les04.bean.UserAccount;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.UserDAO;

@Repository
@Transactional()
public class SQLUserDAO implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserAccount authorization(String login, String password) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from UserAccount where login = '" + login + "' and password = '" + password + "'", UserAccount.class);
		System.out.println("kon");
		UserAccount user = new UserAccount(); 
		user =(UserAccount) theQuery.getSingleResult();
		return user;
	}

	@Override
	public UserAccount loadUser(String login) throws DAOException {
		System.out.println("load user dao");
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from UserAccount where login = '" + login + "' and status = false", UserAccount.class);
		UserAccount user = new UserAccount(); 
		user =(UserAccount) theQuery.getSingleResult();
		return user;
	}

	@Override
	public void createUser(UserAccount user) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		user.setDate(java.time.LocalDateTime.now());
		currentSession.saveOrUpdate(user);
	}

	@Override
	public List<UserAccount> all() throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<UserAccount> theQuery = currentSession.createQuery("from UserAccount", UserAccount.class);
		List<UserAccount> users = theQuery.getResultList();
		return users;
	}

	@Override
	public UserAccount getOne(int idUser) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		UserAccount user = currentSession.get(UserAccount.class, idUser);
		return user;
	}

	@Override
	public void updatePersonalInformation(int idUser, String name, String surname, String login,
			String password, String role, Boolean status) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		UserAccount user = new UserAccount();
		user.setIdUser(idUser);
		user.setName(name);
		user.setSurname(surname);
		user.setLogin(login);
		user.setPassword(password);
		user.setRole(role);
		user.setStatus(status);
		user.setDate(java.time.LocalDateTime.now());
		currentSession.saveOrUpdate(user);
	}
}
