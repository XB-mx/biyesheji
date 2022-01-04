package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Image;
import com.cdnu.baikun.domain.News;
import com.cdnu.baikun.utils.GetImgSrc;
import com.cdnu.baikun.service.ImageService;
import com.cdnu.baikun.service.NewsService;
import com.cdnu.baikun.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News>
        implements NewsService {
    @Autowired
    private ImageService imageService;
    @Autowired
    private NewsMapper newsMapper;
    @Override
    public Boolean addNews(News news) {
        //设置时间
        news.setNewsCreateTime(new Date());
        news.setNewsLastUpdataTime(new Date());

        return save(news);
    }

    @Override
    public Boolean addNews(News news, String src) {
        System.out.println(src);
        if ("".equals(src)){
            src= GetImgSrc.getFirstImgSrc(news.getNewsContent());
        }
        Boolean addNews = addNews(news);
        if (src!=null){
            Boolean addImage = imageService.addImage(new Image(null, null, news.getNewsId(), src));
            return addNews&&addImage;
        }
        return addNews;
    }

    @Override
    public IPage<News> getNewsByPage(Integer page,Integer pageSize) {

        IPage<News> iPage = new Page<>(page,pageSize);
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(News::getNewsStatus,1)
                .orderByDesc(News::getNewsCreateTime);
        IPage<News> newsIPage = page(iPage, queryWrapper);

        return newsIPage;
    }

    @Override
    public IPage<News> getNewsByPageByUserId(int userId, Integer page, Integer pageSize) {
        IPage<News> iPage=new Page<>(page,pageSize);
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(News::getNewsUserId,userId)
                .orderByDesc(News::getNewsLastUpdataTime);
        IPage<News> resourcesIPage = this.page(iPage,queryWrapper);
        return resourcesIPage;
    }

    @Override
    public IPage<News> getNewsBanByPage(Integer page, Integer pageSize) {
        IPage<News> iPage = new Page<>(page,pageSize);
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(News::getNewsStatus,0);
        IPage<News> newsIPage = page(iPage, queryWrapper);

        return newsIPage;
    }

    @Override
    public Boolean banNews(Integer id) {
        News news = this.getById(id);
        UpdateWrapper<News> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("news_id",id);
        switch (news.getNewsStatus()){
            case 0:
                //封禁
                updateWrapper.set("news_status",1);
                break;
            case 1:
                //解禁
                updateWrapper.set("news_status",0);
                break;
        }
        return this.update(updateWrapper);
    }

    @Override
    public Boolean updateNews(News news) {
        news.setNewsLastUpdataTime(new Date());

        //更改资源
        UpdateWrapper<News> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda()
                .eq(News::getNewsId, news.getNewsId())
                .set(News::getNewsLastUpdataTime, news.getNewsLastUpdataTime())
                .set(News::getNewsTitle, news.getNewsTitle())
                .set(News::getNewsContent, news.getNewsContent())
                .set(News::getNewsViewCount,news.getNewsViewCount())
                .set(News::getNewsLikeCount,news.getNewsLikeCount());

        return this.update(updateWrapper);
    }

    @Override
    public Boolean deleteNewsById(Integer newsId) {
        return this.removeById(newsId);
    }

    @Override
    public Boolean addNewsView(Integer newsId) {
        News news = getById(newsId);
        int viewCount = newsMapper.getNewsViewCount(newsId);
        viewCount++;
        news.setNewsViewCount(viewCount);
        return this.updateById(news);
    }

    @Override
    public Boolean addNewsLike(Integer newsId) {
        News news = getById(newsId);
        int likeCount = newsMapper.getNewsLikeCount(newsId);
        likeCount++;
        news.setNewsViewCount(likeCount);
        return this.updateById(news);
    }

    @Override
    public Page<News> search(Integer page,String keyword) {
        if (keyword==null||"".equals(keyword)) return null;
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.lambda()
                .like(News::getNewsTitle,keyword);
        Page<News> newsPage = page(new Page<News>(page, 5));
        return newsPage;
    }

    @Override
    public Page<News> collection(Integer page, List<Integer> ids) {
        if (ids.size()<=0) return null;
        return query().in("news_id", ids).page(new Page<>(1, 5));
    }
}




