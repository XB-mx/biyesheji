package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 
 * @TableName collection
 */
@TableName(value ="collection")
public class Collection implements Serializable {
    /**
     * 收藏用户id
     */
    private Integer userId;

    /**
     * 资源id
     */
    private Integer resourceId;

    /**
     * 新闻id
     */
    private Integer newsId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 收藏用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 收藏用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 资源id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * 资源id
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * 新闻id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 新闻id
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
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
        Collection other = (Collection) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
            && (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", newsId=").append(newsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}