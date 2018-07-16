package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao{

    @Override
    public Account findById(Integer id) {
        List<Account> list = getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class),id);
        return list!=null ? list.get(0):null;
    }

    @Override
    public List<Account> findAll() {
        List<Account> list = getJdbcTemplate().query("select * from account",
                new BeanPropertyRowMapper<Account>(Account.class));
        return list;
    }

    @Override
    public void saveAccount(Account account) {
        getJdbcTemplate().update("INSERT INTO account (name,money) values (?,?)", account.getName(),account.getMoney());

    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name = ?,money = ? where id = ?", account.getName(),account.getMoney(),account.getId());


    }

    @Override
    public void deleteAccount(Integer id) {
        getJdbcTemplate().update("delete from account where id = ?",id);
    }
}
