package com.edu.bearjay.dongbao.ums.api.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.edu.bearjay.dongbao.common.base.result.ResponseResult;
import com.edu.bearjay.dongbao.ums.api.entity.UmsMember;
import com.edu.bearjay.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.edu.bearjay.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author bearjay
 * @since 2021-04-13
 */
public interface UmsMemberService extends IService<UmsMember> {
    ResponseResult register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO);

    ResponseResult login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);

    ResponseResult edit(UmsMember umsMember);
}
