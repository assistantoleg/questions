package ru.iambelyaev.coincontrolserver.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.iambelyaev.coincontrolserver.storage.dao.UserDAO;
import ru.iambelyaev.coincontrolserver.storage.entity.User;

//import ru.iambelyaev.coincontrolserver.storage.dao.UserDao;
//import ru.iambelyaev.coincontrolserver.storage.entity.User;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
//    private UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDAOJpaImpl") UserDAO theUserDAO) {
        userDAO = theUserDAO;
    }

    @Override
    @Transactional
    public boolean create(User user) {
//        User dbUser = userDao.findById(wallet.getUser().getId());
//        if(dbUser != null) {
//            wallet.setUser(dbUser);
            userDAO.save(user);
            return true;
//        }
//        return false;
    }

    @Override
    @Transactional
    public User findById(int id){return new User();}

    @Override
    @Transactional
    public void delete(User user){}

    @Override
    @Transactional
    public void update(User user){}

//    @Override
//    public List<Wallet> readAll(int userId) {
//        ru.iambelyaev.coincontrolserver.storage.services.UserService userService =
//                new ru.iambelyaev.coincontrolserver.storage.services.UserService();
//        ru.iambelyaev.coincontrolserver.storage.dao.models.User dbUser =
//                userService.findUser(userId);
//
//        List<Wallet> list = new ArrayList<>();
//        if(dbUser != null) {
//            List<ru.iambelyaev.coincontrolserver.storage.dao.models.Wallet> dbWallets = userService.findWalletAll(userId);
//            for (ru.iambelyaev.coincontrolserver.storage.dao.models.Wallet i : dbWallets) {
//                list.add(new Wallet(i.getId(), dbUser.getId(), i.getName(), i.getMoney()));
//            }
//        }
//        return list;
//    }
//
//    @Override
//    public boolean update(Wallet Wallet) {
//        ru.iambelyaev.coincontrolserver.storage.services.WalletService walletService =
//                new ru.iambelyaev.coincontrolserver.storage.services.WalletService();
//        ru.iambelyaev.coincontrolserver.storage.dao.models.Wallet dbWallet =
//                walletService.findWallet(Wallet.getId());
//        if( dbWallet.getUser().getId() == Wallet.getUser()){
//            dbWallet.setName(Wallet.getName());
//            walletService.updateWallet(dbWallet);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean walletDelete(Integer userId, Integer walletId) {
//        ru.iambelyaev.coincontrolserver.storage.services.WalletService walletService =
//                new ru.iambelyaev.coincontrolserver.storage.services.WalletService();
//        ru.iambelyaev.coincontrolserver.storage.dao.models.Wallet dbWallet =
//                walletService.findWallet(walletId);
//        if( dbWallet.getUser().getId() == userId){
//            walletService.deleteWallet(dbWallet);
//            return true;
//        }
//        return false;
//    }
}
