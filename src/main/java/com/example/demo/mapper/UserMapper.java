package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author your_author
 * @since 2024-10-31
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    IPage pagec(IPage<User> page);

    IPage pagecc(IPage<User> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
