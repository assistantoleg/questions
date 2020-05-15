package ru.iambelyaev.coincontrolserver.storage.service;

import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

public interface WalletService {

    public Wallet findWallet(int id);

    public void saveWallet(Wallet wallet);

    public void deleteWallet(Wallet wallet);

    public void updateWallet(Wallet wallet);

    public boolean create(Wallet wallet);
}
