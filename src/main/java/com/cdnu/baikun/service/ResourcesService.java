package com.cdnu.baikun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Resources;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/27
 */
public interface ResourcesService extends IService<Resources> {
    /**
     * 添加资源方法
     *
     * @param resources
     * @return
     */
    Boolean addResources(Resources resources);

    /**
     * 添加资源方法，有封面
     * @param resources
     * @param src
     * @return
     */
    Boolean addResources(Resources resources,String src);

    /**
     * 获取正常的资源数，分页获取
     * @deprecated
     * @return
     */
    IPage<Resources> getResourcesByPage(Integer page,Integer pageSize);

    /**
     * 获取封禁的资源数，分页获取
     * @deprecated
     * @return
     */
    IPage<Resources> getResourcesBanByPage(Integer page,Integer pageSize);

    /**
     * 进行资源的更改
     *
     * @param resources
     * @return
     */
    Boolean updateResource(Resources resources);

    /**
     * 根据资源id删除资源
     *
     * @param resourceId
     * @return
     */
    Boolean deleteResourceById(Integer resourceId);

    /**
     * 根据资源id获取资源
     * @param resourceId
     * @return
     */
    Resources getResourceByResourceId(Integer resourceId);

    /**
     * 根据id集合分页获取文章集合
     * @param ids
     * @return
     */
    IPage<Resources> getResourceListByResourceIds(List<Integer> ids,Integer page,Integer pageSize);

    IPage<Resources> getResourceListByUserId(int  userId,Integer page,Integer pageSize);

    /**
     * 点赞量增加
     * @return
     */
    Boolean addResourceLike(Integer resourceId);

    /**
     * 浏览量增加
     * @return
     */
    Boolean addResourceView(Integer resourceId);

    /**
     * 根据id封禁/解封资源
     * @param id
     * @return
     */
    Boolean banResource(Integer id);

    /**
     * 根据搜索关键词返回集合
     * @param keyword
     * @return
     */
    Page<Resources> search(Integer page, String keyword);
}
