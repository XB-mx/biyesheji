package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @TableName tag_news_resource_ref
 */
@TableName(value = "tag_news_resource_ref")
public class TagNewsResourceRef implements Serializable {
    /**
     * 标签id
     */
    @TableId
    private Integer tagId;

    /**
     * 资源id
     */
    private Integer resourceId;

    /**
     * 资讯id
     */
    private Integer newsId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 标签id
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * 标签id
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
     * 资讯id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 资讯id
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
        TagNewsResourceRef other = (TagNewsResourceRef) that;
        return (this.getTagId() == null ? other.getTagId() == null : this.getTagId().equals(other.getTagId()))
                && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
                && (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTagId() == null) ? 0 : getTagId().hashCode());
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
        sb.append(", tagId=").append(tagId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", newsId=").append(newsId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}