package com.edu.bearjay.dongbao.portal.web.controller;


import com.edu.bearjay.dongbao.common.base.annotation.TokenCheck;
import com.edu.bearjay.dongbao.common.base.result.ResponseResult;
import com.edu.bearjay.dongbao.ums.api.entity.UmsMember;
import com.edu.bearjay.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.edu.bearjay.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;
import com.edu.bearjay.dongbao.ums.api.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author bearjay
 * @since 2021-04-13
 */

@Api(tags = "UmsMemberController", description = "用户管理")
@RestController
@RequestMapping("/ums-member")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public ResponseResult register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        return umsMemberService.register(umsMemberRegisterParamDTO);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        return umsMemberService.login(umsMemberLoginParamDTO);
    }

    @TokenCheck
    @ApiOperation("修改用户信息")
    @PostMapping("/edit")
    public ResponseResult edit(@RequestBody UmsMember umsMember) {
        return umsMemberService.edit(umsMember);
    }
}

