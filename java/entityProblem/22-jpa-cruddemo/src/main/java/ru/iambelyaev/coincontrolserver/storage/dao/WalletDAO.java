package ru.iambelyaev.coincontrolserver.storage.dao;

import ru.iambelyaev.coincontrolserver.storage.entity.Wallet;

public interface WalletDAO {

    public Wallet findById(int id);

    public void save(Wallet wallet);

    public void update(Wallet wallet);

    public void delete(Wallet wallet);
}
