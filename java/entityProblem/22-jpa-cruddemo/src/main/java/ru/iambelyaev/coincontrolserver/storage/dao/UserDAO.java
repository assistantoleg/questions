package ru.iambelyaev.coincontrolserver.storage.dao;


//import ru.iambelyaev.coincontrolserver.storage.entity.Category;
//import ru.iambelyaev.coincontrolserver.storage.entity.Operation;
import ru.iambelyaev.coincontrolserver.storage.entity.User;
import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

import java.util.List;

public interface UserDAO {

    public User findById(int id);

    public void save(User user);

    public void update(User user);

    public void delete(User user);

//    public Category findCategoryById(int id) {
//        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Category.class, id);
//    }

//    public List<User> findAll();

//    public List<Operation> findOperationAll(int user_id) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        List<Operation> operations = (List<Operation>)
//                session.createQuery("from Operation WHERE user_id = :param_user_id")
//                        .setParameter("param_user_id", user_id)
//                        .list();
//        session.close();
//        return operations;
//    }

//    public List<Wallet> findWalletAll(int user_id) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        List<Wallet> wallets = (List<Wallet>)
//                session.createQuery("from Wallet WHERE user_id = :param_user_id")
//                        .setParameter("param_user_id", user_id)
//                        .list();
//        session.close();
//        return wallets;
//    }

//    public List<Wallet> findWalletAll(int user_id);
}