package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName news
 */
@TableName(value = "news")
public class News implements Serializable {
    /**
     * 游戏资讯id
     */
    @TableId(type = IdType.AUTO)
    private Integer newsId;

    /**
     * 游戏资讯标题
     */
    private String newsTitle;

    /**
     * 游戏资讯内容
     */
    private String newsContent;

    /**
     * 游戏资讯发布时间
     */
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newsCreateTime;

    /**
     * 游戏资讯更改时间
     */
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date newsLastUpdataTime;

    /**
     * 游戏资讯发布者id
     */
    private Integer newsUserId;

    /**
     * 游戏资讯访问量
     */
    private Integer newsViewCount;

    /**
     * 游戏资讯点赞量
     */
    private Integer newsLikeCount;

    /**
     * 游戏资讯是否允许评论
     */
    private Integer newsAllowComment;

    /**
     * 游戏资讯状态
     */
    private Integer newsStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 游戏资讯id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 游戏资讯id
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 游戏资讯标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * 游戏资讯标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * 游戏资讯内容
     */
    public String getNewsContent() {
        return newsContent;
    }

    /**
     * 游戏资讯内容
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    /**
     * 游戏资讯发布时间
     */
    public Date getNewsCreateTime() {
        return newsCreateTime;
    }

    /**
     * 游戏资讯发布时间
     */
    public void setNewsCreateTime(Date newsCreateTime) {
        this.newsCreateTime = newsCreateTime;
    }

    /**
     * 游戏资讯更改时间
     */
    public Date getNewsLastUpdataTime() {
        return newsLastUpdataTime;
    }

    /**
     * 游戏资讯更改时间
     */
    public void setNewsLastUpdataTime(Date newsLastUpdataTime) {
        this.newsLastUpdataTime = newsLastUpdataTime;
    }

    /**
     * 游戏资讯发布者id
     */
    public Integer getNewsUserId() {
        return newsUserId;
    }

    /**
     * 游戏资讯发布者id
     */
    public void setNewsUserId(Integer newsUserId) {
        this.newsUserId = newsUserId;
    }

    /**
     * 游戏资讯访问量
     */
    public Integer getNewsViewCount() {
        return newsViewCount;
    }

    /**
     * 游戏资讯访问量
     */
    public void setNewsViewCount(Integer newsViewCount) {
        this.newsViewCount = newsViewCount;
    }

    /**
     * 游戏资讯点赞量
     */
    public Integer getNewsLikeCount() {
        return newsLikeCount;
    }

    /**
     * 游戏资讯点赞量
     */
    public void setNewsLikeCount(Integer newsLikeCount) {
        this.newsLikeCount = newsLikeCount;
    }

    /**
     * 游戏资讯是否允许评论
     */
    public Integer getNewsAllowComment() {
        return newsAllowComment;
    }

    /**
     * 游戏资讯是否允许评论
     */
    public void setNewsAllowComment(Integer newsAllowComment) {
        this.newsAllowComment = newsAllowComment;
    }

    /**
     * 游戏资讯状态
     */
    public Integer getNewsStatus() {
        return newsStatus;
    }

    /**
     * 游戏资讯状态
     */
    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        News other = (News) that;
        return (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
                && (this.getNewsTitle() == null ? other.getNewsTitle() == null : this.getNewsTitle().equals(other.getNewsTitle()))
                && (this.getNewsContent() == null ? other.getNewsContent() == null : this.getNewsContent().equals(other.getNewsContent()))
                && (this.getNewsCreateTime() == null ? other.getNewsCreateTime() == null : this.getNewsCreateTime().equals(other.getNewsCreateTime()))
                && (this.getNewsLastUpdataTime() == null ? other.getNewsLastUpdataTime() == null : this.getNewsLastUpdataTime().equals(other.getNewsLastUpdataTime()))
                && (this.getNewsUserId() == null ? other.getNewsUserId() == null : this.getNewsUserId().equals(other.getNewsUserId()))
                && (this.getNewsViewCount() == null ? other.getNewsViewCount() == null : this.getNewsViewCount().equals(other.getNewsViewCount()))
                && (this.getNewsLikeCount() == null ? other.getNewsLikeCount() == null : this.getNewsLikeCount().equals(other.getNewsLikeCount()))
                && (this.getNewsAllowComment() == null ? other.getNewsAllowComment() == null : this.getNewsAllowComment().equals(other.getNewsAllowComment()))
                && (this.getNewsStatus() == null ? other.getNewsStatus() == null : this.getNewsStatus().equals(other.getNewsStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getNewsTitle() == null) ? 0 : getNewsTitle().hashCode());
        result = prime * result + ((getNewsContent() == null) ? 0 : getNewsContent().hashCode());
        result = prime * result + ((getNewsCreateTime() == null) ? 0 : getNewsCreateTime().hashCode());
        result = prime * result + ((getNewsLastUpdataTime() == null) ? 0 : getNewsLastUpdataTime().hashCode());
        result = prime * result + ((getNewsUserId() == null) ? 0 : getNewsUserId().hashCode());
        result = prime * result + ((getNewsViewCount() == null) ? 0 : getNewsViewCount().hashCode());
        result = prime * result + ((getNewsLikeCount() == null) ? 0 : getNewsLikeCount().hashCode());
        result = prime * result + ((getNewsAllowComment() == null) ? 0 : getNewsAllowComment().hashCode());
        result = prime * result + ((getNewsStatus() == null) ? 0 : getNewsStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", newsId=").append(newsId);
        sb.append(", newsTitle=").append(newsTitle);
        sb.append(", newsContent=").append(newsContent);
        sb.append(", newsCreateTime=").append(newsCreateTime);
        sb.append(", newsLastUpdataTime=").append(newsLastUpdataTime);
        sb.append(", newsUserId=").append(newsUserId);
        sb.append(", newsViewCount=").append(newsViewCount);
        sb.append(", newsLikeCount=").append(newsLikeCount);
        sb.append(", newsAllowComment=").append(newsAllowComment);
        sb.append(", newsStatus=").append(newsStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}