package com.itheima.test;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {
    @Resource
    private AccountDao accountDao;
    @Test
    public void  findAll(){
        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account.getName());
        }
    }
    @Test
    public void  findById(){
        Account account = accountDao.findById(1);
            System.out.println(account.getName());
    }
    @Test
    public void  save(){
        Account account = new Account();
        account.setName("dddd");
        account.setMoney(100d);
        accountDao.saveAccount(account);
    }
    @Test
    public void update(){
        Account account = new Account();
        account.setId(4);
        account.setName("ddd");
        account.setMoney(1000d);
        accountDao.updateAccount(account);
    }
    @Test
    public void  delete(){
         accountDao.deleteAccount(4);
    }

}
