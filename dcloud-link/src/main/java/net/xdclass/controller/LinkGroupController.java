package net.xdclass.controller;


import net.xdclass.controller.request.LinkGroupAddRequest;
import net.xdclass.controller.request.LinkGroupUpdateRequest;
import net.xdclass.enums.BizCodeEnum;
import net.xdclass.service.LinkGroupService;
import net.xdclass.util.JsonData;
import net.xdclass.vo.LinkGroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 二当家小D
 * @since 2021-12-09
 */
@RestController
@RequestMapping("/api/group/v1")
public class LinkGroupController {

    @Autowired
    private LinkGroupService linkGroupService;

    /**
     * 创建分组
     * @param addRequest
     * @return
     */
    @PostMapping("/add")
    public JsonData add(@RequestBody LinkGroupAddRequest addRequest){

        int rows = linkGroupService.add(addRequest);

        return rows == 1 ? JsonData.buildSuccess():JsonData.buildResult(BizCodeEnum.GROUP_ADD_FAIL);

    }


    /**
     * 根据id删除分组
     * @param groupId
     * @return
     */
    @DeleteMapping("/del/{group_id}")
    public JsonData del(@PathVariable("group_id") Long groupId){

        int rows = linkGroupService.del(groupId);
        return rows == 1 ? JsonData.buildSuccess():JsonData.buildResult(BizCodeEnum.GROUP_NOT_EXIST);

    }


    /**
     * 根据id找详情
     * @param groupId
     * @return
     */
    @GetMapping("detail/{group_id}")
    public JsonData detail(@PathVariable("group_id") Long groupId){

        LinkGroupVO linkGroupVO = linkGroupService.detail(groupId);
        return JsonData.buildSuccess(linkGroupVO);

    }


    /**
     * 列出用户全部分组
     * @return
     */
    @GetMapping("list")
    public JsonData findUserAllLinkGroup(){

        List<LinkGroupVO> list = linkGroupService.listAllGroup();

        return JsonData.buildSuccess(list);

    }



    /**
     * 列出用户全部分组
     * @return
     */
    @PutMapping("update")
    public JsonData update(@RequestBody LinkGroupUpdateRequest request){


        int rows = linkGroupService.updateById(request);
        return rows == 1 ? JsonData.buildSuccess():JsonData.buildResult(BizCodeEnum.GROUP_OPER_FAIL);

    }





}

