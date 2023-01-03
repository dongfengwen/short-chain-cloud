package net.xdclass.manager;

import net.xdclass.model.AccountDO;

import java.util.List;

public interface AccountManager {

    int insert(AccountDO accountDO);


    List<AccountDO> findByPhone(String phone);


    AccountDO detail(long accountNo);
}
