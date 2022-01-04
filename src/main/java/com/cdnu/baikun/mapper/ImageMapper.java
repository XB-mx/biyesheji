package com.cdnu.baikun.mapper;

import com.cdnu.baikun.domain.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Entity com.cdnu.baikun.domain.Image
 * @author 白坤
 * @date 2021/8/10
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    List<Image> getImageListByIds(List<Integer> ids);
    List<Image> listImgByNewsIds(List<Integer> ids);
}




