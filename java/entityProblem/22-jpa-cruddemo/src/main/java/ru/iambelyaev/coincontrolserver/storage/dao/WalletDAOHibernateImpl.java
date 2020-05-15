package ru.iambelyaev.coincontrolserver.storage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

import javax.persistence.EntityManager;

@Repository
public class WalletDAOHibernateImpl implements WalletDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public WalletDAOHibernateImpl(EntityManager theEntityManager) {
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

}







