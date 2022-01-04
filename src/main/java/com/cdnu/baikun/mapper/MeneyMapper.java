package com.cdnu.baikun.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cdnu.baikun.domain.Meney;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * @author 白坤
 * @date 2021/7/20
 * @Entity com.cdnu.baikun.domain.Meney
 */
@Mapper
public interface MeneyMapper extends BaseMapper<Meney> {
    LambdaQueryWrapper<Meney> queryWrapper = new LambdaQueryWrapper<>();

    @Override
    Meney selectById(Serializable id);

}




