package ru.iambelyaev.coincontrolserver.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.iambelyaev.coincontrolserver.storage.entity.User;
import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UserDAOJpaImpl implements UserDAO {

	private EntityManager entityManager;

	@Autowired
	public UserDAOJpaImpl(EntityManager theEntityManager) {
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


//	@Override
//	public void deleteById(int theId) {
//
//		// delete object with primary key
//		Query theQuery = entityManager.createQuery(
//							"delete from Employee where id=:employeeId");
//
//		theQuery.setParameter("employeeId", theId);
//
//		theQuery.executeUpdate();
//	}

}










