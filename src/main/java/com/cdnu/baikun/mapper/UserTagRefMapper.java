package com.cdnu.baikun.mapper;

import com.cdnu.baikun.domain.UserTagRef;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 白坤
 * @Entity com.cdnu.baikun.domain.UserTagRef
 */
@Mapper
public interface UserTagRefMapper extends BaseMapper<UserTagRef> {
    List<Integer> listTagIdsByUserId(@Param("userId") Integer userId);
}




