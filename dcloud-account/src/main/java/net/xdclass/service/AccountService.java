package net.xdclass.service;

import net.xdclass.controller.request.AccountLoginRequest;
import net.xdclass.controller.request.AccountRegisterRequest;
import net.xdclass.util.JsonData;

public interface AccountService {
    /**
     * 用户注册
     * @param registerRequest
     * @return
     */
    JsonData register(AccountRegisterRequest registerRequest);

    /**
     * 登录
     * @param request
     * @return
     */
    JsonData login(AccountLoginRequest request);

    JsonData detail();

}
