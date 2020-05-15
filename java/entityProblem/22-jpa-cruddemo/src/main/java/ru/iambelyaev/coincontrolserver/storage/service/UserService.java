package ru.iambelyaev.coincontrolserver.storage.service;

import ru.iambelyaev.coincontrolserver.storage.entity.User;
import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

import java.util.List;

public interface UserService {

    public boolean create(User user);

    public User findById(int id);

    public void delete(User user);

    public void update(User user);

//    public List<User> findAll();

//    public List<Operation> findOperationAll(int user_id) {
//        return usersDao.findOperationAll(user_id);
//    }

//    public List<Wallet> findWalletAll(int user_id) {
//        return usersDao.findWalletAll(user_id);
//    }

//    public Category findCategoryById(int id) {
//        return usersDao.findCategoryById(id);
//    }
}