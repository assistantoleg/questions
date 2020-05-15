package ru.iambelyaev.coincontrolserver.storage.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.iambelyaev.coincontrolserver.storage.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public UserDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public User findById(int theId) {

		// get wallet
		User theUser =
				entityManager.find(User.class, theId);

		// return wallet
		return theUser;
	}

	@Override
	public void save(User theUser) {

		// save or update the employee
		User dbUser = entityManager.merge(theUser);

		// update with id from db ... so we can get generated id for save/insert
		theUser.setId(dbUser.getId());

	}

	public void update(User user){}

	public void delete(User user){}

}







