# user-management-system
##Prerequisite

- Install MySQL server Version 8.0.23

- Download user_management.sql near by

- Create database and restore it from backup, use command line:

```
echo create database user_management | mysql -u root -p
mysql -u root -p user_management < user_management.sql
```

- Create database user (name "user") and some password:


```
echo CREATE USER 'user' IDENTIFIED BY 'your_password_here' | mysql -u root -p
echo GRANT ALL PRIVILEGES ON user_management.* TO 'user' | mysql -u root -p
```

##Compile
- Check out java code and use command line

```
mvn clean install
```
	
##Run
- Use command line for running application:

```
java -Ddb.password=[Password from prerequisite.4] -jar user-management-0.0.1-SNAPSHOT.war
```

##Manual testing
- Use Chrome for testing application:
	Use URL:
	
```	
http://localhost:8080
```
		
- use admin:

```
login: tanch
password: tanch001
```

- use user:

```
login: voladimirQ
password: vonandDeMor1 	
	