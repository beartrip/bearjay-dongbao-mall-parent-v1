package com.edu.bearjay.dongbao.ums.api.entity.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author langyixiong
 * @date 2021/4/27 16:37
 */
@Data
@ToString
public class UmsMemberLoginParamDTO {
    private String username;
    private String password;
}
