package ru.iambelyaev.coincontrolserver.storage.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.iambelyaev.coincontrolserver.storage.entity.User;
import ru.iambelyaev.coincontrolserver.storage.service.UserService;

@RestController
public class UserController {
    private final UserService UserService;

    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> create(@RequestBody User User) {
            return UserService.create(User)
                    ? new ResponseEntity<>(HttpStatus.CREATED)
                    : new ResponseEntity<String>("not found user", HttpStatus.NOT_FOUND);
    }

//    @GetMapping(value = "/wallet/{userId}")
//    public ResponseEntity<List<Wallet>> read(@PathVariable(name = "userId") int userId) {
//        final List<Wallet> wallets = WalletService.readAll(userId);
//        return wallets != null && !wallets.isEmpty()
//                ? new ResponseEntity<>(wallets, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/wallet")
//    public ResponseEntity<?> update(@RequestBody Wallet Wallet) {
//        final boolean updated = WalletService.update(Wallet);
//
//        return updated
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
////    @PutMapping(value = "/Category/{id}")
////    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Category Category) {
////        final boolean updated = CategoryService.update(Category, id);
////
////        return updated
////                ? new ResponseEntity<>(HttpStatus.OK)
////                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
////    }
//
//    @DeleteMapping(value = "/wallet/{userId}/{walletId}")
//    public ResponseEntity<?> delete(@PathVariable Integer userId, @PathVariable Integer walletId) {
//        return WalletService.walletDelete(userId, walletId)
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
////    @DeleteMapping(value = "/category/{id}")
////    public ResponseEntity<?> delete(@PathVariable Integer id) {
////        System.out.println(id.toString());
////        final boolean deleted = CategoryService.categoryDelete(id);
////        return deleted
////                ? new ResponseEntity<>(HttpStatus.OK)
////                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
////    }
}
