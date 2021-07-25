package com.edu.bearjay.dongbao.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.bearjay.dongbao.common.base.enums.StateCodeEnum;
import com.edu.bearjay.dongbao.common.base.result.ResponseResult;
import com.edu.bearjay.dongbao.common.util.utils.JwtUtil;
import com.edu.bearjay.dongbao.ums.api.entity.UmsMember;
import com.edu.bearjay.dongbao.ums.api.entity.dto.UmsMemberLoginParamDTO;
import com.edu.bearjay.dongbao.ums.api.entity.dto.UmsMemberRegisterParamDTO;
import com.edu.bearjay.dongbao.ums.api.entity.response.UserMemberLoginResponse;
import com.edu.bearjay.dongbao.ums.api.service.UmsMemberService;
import com.edu.bearjay.dongbao.ums.mapper.UmsMemberMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author bearjay
 * @since 2021-04-13
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {
    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseResult register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO) {
        UmsMember member = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO, member);

        UmsMember existUms = umsMemberMapper.selectByName(member.getUsername());
        if (null != existUms) {
           return ResponseResult.getFailBuilder()
                   .code(StateCodeEnum.USER_DUPLICATE.getCode())
                   .msg(StateCodeEnum.USER_DUPLICATE.getMsg())
                   .build();
        }
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        umsMemberMapper.insert(member);
        return ResponseResult.getSuccessBuilder().build();
    }

    @Override
    public ResponseResult login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember member = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if (member != null) {
            String passwordDB = member.getPassword();
            if (!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(), passwordDB)) {
                return ResponseResult.getFailBuilder()
                        .code(StateCodeEnum.PASSWORD_ERROR.getCode())
                        .msg(StateCodeEnum.PASSWORD_ERROR.getMsg())
                        .build();
            }
        } else {
            return ResponseResult.getFailBuilder()
                    .code(StateCodeEnum.USER_EMPTY.getCode())
                    .msg(StateCodeEnum.USER_EMPTY.getMsg())
                    .build();
        }

        String token = JwtUtil.createToken(member.getId().toString());
        UserMemberLoginResponse loginResponse = new UserMemberLoginResponse();
        loginResponse.setToken(token);
        member.setPassword("");
        loginResponse.setUmsMember(member);

        return ResponseResult.getSuccessBuilder().data(loginResponse).build();
    }

    @Override
    public ResponseResult edit(UmsMember umsMember) {
        umsMember.setPassword(passwordEncoder.encode(umsMember.getPassword()));
        umsMemberMapper.updateById(umsMember);
        return ResponseResult.getSuccessBuilder().data(umsMember).build();
    }
}
