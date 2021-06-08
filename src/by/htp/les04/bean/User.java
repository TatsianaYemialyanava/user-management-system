package by.htp.les04.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable { 
	private static final long serialVersionUID = -1959040783153783376L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int idUser;

	@Column(name="user_name")
	private String name;

	@Column(name="user_surname")
	private String surname;

	@Column(name="login")
	private String login;

	@Column(name="password")
	private String password;

	@Column(name="role")
	private String role;

	public User() {}

	public User(String name, String surname, String login, String password, String role) {
		super();
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {	
		return "Name: " + this.name + "\n" +
				"Surname:" + this.surname + "\n" +
				"login: " + this.login + "\n" + 
				"role: " + this.role;
	}
}
