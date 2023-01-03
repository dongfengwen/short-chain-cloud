package net.xdclass.controller;


import net.xdclass.controller.request.AccountLoginRequest;
import net.xdclass.controller.request.AccountRegisterRequest;
import net.xdclass.enums.BizCodeEnum;
import net.xdclass.service.AccountService;
import net.xdclass.service.FileService;
import net.xdclass.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 二当家小D
 * @since 2021-11-09
 */
@RestController
@RequestMapping("/api/account/v1")
public class AccountController {

    @Autowired
    private FileService fileService;


    @Autowired
    private AccountService accountService;

    /**
     * 文件上传 最大默认1M
     *  文件格式、拓展名等判断
     * @param file
     * @return
     */
    @PostMapping("upload")
    public JsonData uploadUserImg(@RequestPart("file")MultipartFile file){

        String result = fileService.uploadUserImg(file);

        return result !=null ? JsonData.buildSuccess(result):JsonData.buildResult(BizCodeEnum.FILE_UPLOAD_USER_IMG_FAIL);

    }


    /**
     * 用户注册
     * @param registerRequest
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody AccountRegisterRequest registerRequest){

        JsonData jsonData = accountService.register(registerRequest);
        return jsonData;
    }


    /**
     * 用户登录
     * @param request
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody AccountLoginRequest request){

        JsonData jsonData = accountService.login(request);
        return jsonData;
    }


    /**
     * 查询个人信息
     * @return
     */
    @GetMapping("detail")
    public JsonData detail(){

        JsonData jsonData = accountService.detail();
        return jsonData;
    }


}

