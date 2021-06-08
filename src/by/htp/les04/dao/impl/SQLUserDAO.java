package by.htp.les04.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import by.htp.les04.bean.User;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.UserDAO;

@Repository
@Transactional()
public class SQLUserDAO implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User authorization(String login, String password) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User where login = '" + login + "' and password = '" + password + "'", User.class);
		User user = new User(); 
		user =(User) theQuery.getSingleResult();
		return user;
	}

	@Override
	public User loadUser(String login) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User where login = '" + login + "'", User.class);
		User user = new User(); 
		user =(User) theQuery.getSingleResult();
		return user;
	}

	@Override
	public void createUser(User user) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		user.setRole("user");
		currentSession.saveOrUpdate(user);
	}

	@Override
	public List<User> all() throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User", User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}

	@Override
	public User getOne(int idUser) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, idUser);
		return user;
	}

	@Override
	public void updatePersonalInformation(int idUser, String name, String surname, String login,
			String password, String role) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = new User();
		user.setIdUser(idUser);
		user.setName(name);
		user.setSurname(surname);
		user.setLogin(login);
		user.setPassword(password);
		user.setRole(role);
		//user.setDate(java.time.LocalDateTime.now());
		//user.setStatus("active");
		currentSession.saveOrUpdate(user);
	}
}
