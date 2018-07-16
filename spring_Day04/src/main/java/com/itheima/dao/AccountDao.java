package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {

    public Account findById(Integer id);

    public List<Account> findAll();

    public void saveAccount(Account account);

    public void updateAccount(Account account);

    public void deleteAccount(Integer id);
}
