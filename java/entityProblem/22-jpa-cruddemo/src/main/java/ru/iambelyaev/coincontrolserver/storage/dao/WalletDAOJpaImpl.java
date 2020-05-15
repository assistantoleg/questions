package ru.iambelyaev.coincontrolserver.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

import javax.persistence.EntityManager;
import javax.persistence.Query;


@Repository
public class WalletDAOJpaImpl implements WalletDAO {

	private EntityManager entityManager;

	@Autowired
	public WalletDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public Wallet findById(int theId) {

		// get wallet
		Wallet theWallet =
				entityManager.find(Wallet.class, theId);
		
		// return wallet
		return theWallet;
	}

	@Override
	public void save(Wallet theWallet) {

		// save or update the employee
		Wallet dbWallet = entityManager.merge(theWallet);
		
		// update with id from db ... so we can get generated id for save/insert
		theWallet.setId(dbWallet.getId());
		
	}

	public void update(Wallet wallet){}

	public void delete(Wallet wallet){}

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










