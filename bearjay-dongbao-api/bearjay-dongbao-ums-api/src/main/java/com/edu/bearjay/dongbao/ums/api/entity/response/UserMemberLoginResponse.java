package com.edu.bearjay.dongbao.ums.api.entity.response;

import com.edu.bearjay.dongbao.ums.api.entity.UmsMember;
import lombok.Data;

/**
 * @author langyixiong
 * @date 2021/5/6 22:31
 */
@Data
public class UserMemberLoginResponse {
    private String token;
    private UmsMember umsMember;
}
