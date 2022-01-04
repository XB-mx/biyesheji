package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @TableName image
 */
@TableName(value = "image")
public class Image implements Serializable {
    /**
     * 图片id
     */
    @TableId(type = IdType.AUTO)
    private Integer imgId;

    /**
     * 资源id
     */
    private Integer resourceId;

    /**
     * 资讯id
     */
    private Integer newsId;

    /**
     * 图片地址
     */
    private String imgSrc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 图片id
     */
    public Integer getImgId() {
        return imgId;
    }

    /**
     * 图片id
     */
    public void setImgId(Integer imgId) {
        this.imgId = imgId;
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

    /**
     * 图片地址
     */
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     * 图片地址
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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
        Image other = (Image) that;
        return (this.getImgId() == null ? other.getImgId() == null : this.getImgId().equals(other.getImgId()))
                && (this.getResourceId() == null ? other.getResourceId() == null : this.getResourceId().equals(other.getResourceId()))
                && (this.getNewsId() == null ? other.getNewsId() == null : this.getNewsId().equals(other.getNewsId()))
                && (this.getImgSrc() == null ? other.getImgSrc() == null : this.getImgSrc().equals(other.getImgSrc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getImgId() == null) ? 0 : getImgId().hashCode());
        result = prime * result + ((getResourceId() == null) ? 0 : getResourceId().hashCode());
        result = prime * result + ((getNewsId() == null) ? 0 : getNewsId().hashCode());
        result = prime * result + ((getImgSrc() == null) ? 0 : getImgSrc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", imgId=").append(imgId);
        sb.append(", resourceId=").append(resourceId);
        sb.append(", newsId=").append(newsId);
        sb.append(", imgSrc=").append(imgSrc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public Image(Integer imgId, Integer resourceId, Integer newsId, String imgSrc) {
        this.imgId = imgId;
        this.resourceId = resourceId;
        this.newsId = newsId;
        this.imgSrc = imgSrc;
    }

    public Image() {
    }
}