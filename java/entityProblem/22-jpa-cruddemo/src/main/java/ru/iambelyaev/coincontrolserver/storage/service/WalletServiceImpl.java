package ru.iambelyaev.coincontrolserver.storage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.iambelyaev.coincontrolserver.storage.dao.UserDAO;
import org.springframework.transaction.annotation.Transactional;
import ru.iambelyaev.coincontrolserver.storage.dao.WalletDAO;
import ru.iambelyaev.coincontrolserver.storage.entity.User;
import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

@Service
public class WalletServiceImpl implements WalletService {

    private WalletDAO walletDAO;
    private UserDAO userDAO;

    @Autowired
    public WalletServiceImpl(
            @Qualifier("walletDAOJpaImpl") WalletDAO theWalletDAO,
            @Qualifier("userDAOJpaImpl") UserDAO theUserDAO
            ) {
        walletDAO = theWalletDAO;
        userDAO = theUserDAO;
    }

    @Override
    @Transactional
    public boolean create(Wallet wallet) {
        System.out.println("+++ ");
        System.out.println(wallet.getUser());

        User dbUser = userDAO.findById(wallet.getUser().getId());
        System.out.println("+-+ ");
        if(dbUser != null) {
            wallet.setUser(dbUser);
            walletDAO.save(wallet);
            return true;
        }
        return false;
    }


    @Override
    @Transactional
    public Wallet findWallet(int id){return new Wallet();}

    @Override
    @Transactional
    public void saveWallet(Wallet wallet){}

    @Override
    @Transactional
    public void deleteWallet(Wallet wallet){}

    @Override
    @Transactional
    public void updateWallet(Wallet wallet){}

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
