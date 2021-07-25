package com.edu.bearjay.dongbao.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edu.bearjay.dongbao.ums.api.entity.UmsMember;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author bearjay
 * @since 2021-04-13
 */
@Mapper
public interface UmsMemberMapper extends BaseMapper<UmsMember> {
    UmsMember selectByName(String username);
}
