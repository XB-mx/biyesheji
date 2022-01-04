package com.cdnu.baikun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.News;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdnu.baikun.domain.Resources;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/24
 * @description 对资讯的增删改查
 */
public interface NewsService extends IService<News> {
    /**
     * 添加资讯方法
     *
     * @param news
     * @return
     */
    Boolean addNews(News news);

    /**
     * 添加资讯方法，封面
     * @param news
     * @param src
     * @return
     */
    Boolean addNews(News news,String src);

    /**
     * 获取正常资讯数，分页获取
     *
     * @return
     */
    IPage<News> getNewsByPage(Integer page,Integer pageSize);

    IPage<News> getNewsByPageByUserId(int userId,Integer page,Integer pageSize);

    /**
     * 获取封禁资讯数，分页获取
     *
     * @return
     */
    IPage<News> getNewsBanByPage(Integer page,Integer pageSize);

    /**
     * 根据资讯id封禁/解禁
     * @param id
     * @return
     */
    Boolean banNews(Integer id);

    /**
     * 进行资讯的更改
     *
     * @param news
     * @return
     */
    Boolean updateNews(News news);

    /**
     * 根据资讯id删除资讯
     *
     * @param newsId
     * @return
     */
    Boolean deleteNewsById(Integer newsId);

    /**
     * 添加浏览量
     * @param newsId
     * @return
     */
    Boolean addNewsView(Integer newsId);

    /**
     * 添加点赞量
     * @param newsId
     * @return
     */
    Boolean addNewsLike(Integer newsId);

    /**
     * 根据搜索关键词返回集合
     * @param keyword
     * @return
     */
    Page<News> search(Integer page,String keyword);

    /**
     * 根据ids返回新闻集合
     * @param page
     * @param ids
     * @return
     */
    Page<News> collection(Integer page,List<Integer> ids);
}
