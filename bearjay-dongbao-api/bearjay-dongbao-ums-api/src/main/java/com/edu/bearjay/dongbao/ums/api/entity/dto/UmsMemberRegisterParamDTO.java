package com.edu.bearjay.dongbao.ums.api.entity.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author langyixiong
 * @date 2021/4/18 14:56
 */
@Data
@ToString
public class UmsMemberRegisterParamDTO {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    private String password;
    private String icon;
    @Email
    private String email;
    private String nickName;
    private String note;
}
