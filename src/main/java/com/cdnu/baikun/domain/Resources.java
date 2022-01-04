package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @TableName resources
 */
@TableName(value = "resources")
public class Resources implements Serializable {
    /**
     * 游戏资源id
     */
    @TableId(type = IdType.AUTO)
    private Integer resourcesId;

    /**
     * 游戏资源标题
     */
    private String resourcesTitle;

    /**
     * 游戏资源内容
     */
    private String resourcesContent;

    /**
     * 游戏资源创建时间
     */
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date resourcesCreateTime;

    /**
     * 游戏资源更新时间
     */
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date resourcesLastUpdataTime;

    /**
     * 游戏资源发布者id
     */
    private Integer resourcesUserId;

    /**
     * 游戏资源访问量
     */
    private Integer resourcesViewsCount;

    /**
     * 游戏资源点赞量
     */
    private Integer resourcesLikeCount;

    /**
     * 游戏资源状态
     */
    private Integer resourcesStatus;

    /**
     * 游戏资源访问组
     */
    private String resourcesUserGroup;
    /**
     * 资源的分类
     */
    @TableField(exist = false)
    private List<Category> categorieList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 游戏资源id
     */
    public Integer getResourcesId() {
        return resourcesId;
    }

    /**
     * 游戏资源id
     */
    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    /**
     * 游戏资源标题
     */
    public String getResourcesTitle() {
        return resourcesTitle;
    }

    /**
     * 游戏资源标题
     */
    public void setResourcesTitle(String resourcesTitle) {
        this.resourcesTitle = resourcesTitle;
    }

    /**
     * 游戏资源内容
     */
    public String getResourcesContent() {
        return resourcesContent;
    }

    /**
     * 游戏资源内容
     */
    public void setResourcesContent(String resourcesContent) {
        this.resourcesContent = resourcesContent;
    }

    /**
     * 游戏资源创建时间
     */
    public Date getResourcesCreateTime() {
        return resourcesCreateTime;
    }

    /**
     * 游戏资源创建时间
     */
    public void setResourcesCreateTime(Date resourcesCreateTime) {
        this.resourcesCreateTime = resourcesCreateTime;
    }

    /**
     * 游戏资源更新时间
     */
    public Date getResourcesLastUpdataTime() {
        return resourcesLastUpdataTime;
    }

    /**
     * 游戏资源更新时间
     */
    public void setResourcesLastUpdataTime(Date resourcesLastUpdataTime) {
        this.resourcesLastUpdataTime = resourcesLastUpdataTime;
    }

    /**
     * 游戏资源发布者id
     */
    public Integer getResourcesUserId() {
        return resourcesUserId;
    }

    /**
     * 游戏资源发布者id
     */
    public void setResourcesUserId(Integer resourcesUserId) {
        this.resourcesUserId = resourcesUserId;
    }

    /**
     * 游戏资源访问量
     */
    public Integer getResourcesViewsCount() {
        return resourcesViewsCount;
    }

    /**
     * 游戏资源访问量
     */
    public void setResourcesViewsCount(Integer resourcesViewsCount) {
        this.resourcesViewsCount = resourcesViewsCount;
    }

    /**
     * 游戏资源点赞量
     */
    public Integer getResourcesLikeCount() {
        return resourcesLikeCount;
    }

    /**
     * 游戏资源点赞量
     */
    public void setResourcesLikeCount(Integer resourcesLikeCount) {
        this.resourcesLikeCount = resourcesLikeCount;
    }

    /**
     * 游戏资源状态
     */
    public Integer getResourcesStatus() {
        return resourcesStatus;
    }

    /**
     * 游戏资源状态
     */
    public void setResourcesStatus(Integer resourcesStatus) {
        this.resourcesStatus = resourcesStatus;
    }

    /**
     * 游戏资源访问组
     */
    public String getResourcesUserGroup() {
        return resourcesUserGroup;
    }

    /**
     * 游戏资源访问组
     */
    public void setResourcesUserGroup(String resourcesUserGroup) {
        this.resourcesUserGroup = resourcesUserGroup;
    }

    public List<Category> getCategorieList() {
        return categorieList;
    }

    public void setCategorieList(List<Category> categorieList) {
        this.categorieList = categorieList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
        Resources other = (Resources) that;
        return (this.getResourcesId() == null ? other.getResourcesId() == null : this.getResourcesId().equals(other.getResourcesId()))
                && (this.getResourcesTitle() == null ? other.getResourcesTitle() == null : this.getResourcesTitle().equals(other.getResourcesTitle()))
                && (this.getResourcesContent() == null ? other.getResourcesContent() == null : this.getResourcesContent().equals(other.getResourcesContent()))
                && (this.getResourcesCreateTime() == null ? other.getResourcesCreateTime() == null : this.getResourcesCreateTime().equals(other.getResourcesCreateTime()))
                && (this.getResourcesLastUpdataTime() == null ? other.getResourcesLastUpdataTime() == null : this.getResourcesLastUpdataTime().equals(other.getResourcesLastUpdataTime()))
                && (this.getResourcesUserId() == null ? other.getResourcesUserId() == null : this.getResourcesUserId().equals(other.getResourcesUserId()))
                && (this.getResourcesViewsCount() == null ? other.getResourcesViewsCount() == null : this.getResourcesViewsCount().equals(other.getResourcesViewsCount()))
                && (this.getResourcesLikeCount() == null ? other.getResourcesLikeCount() == null : this.getResourcesLikeCount().equals(other.getResourcesLikeCount()))
                && (this.getResourcesStatus() == null ? other.getResourcesStatus() == null : this.getResourcesStatus().equals(other.getResourcesStatus()))
                && (this.getResourcesUserGroup() == null ? other.getResourcesUserGroup() == null : this.getResourcesUserGroup().equals(other.getResourcesUserGroup()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResourcesId() == null) ? 0 : getResourcesId().hashCode());
        result = prime * result + ((getResourcesTitle() == null) ? 0 : getResourcesTitle().hashCode());
        result = prime * result + ((getResourcesContent() == null) ? 0 : getResourcesContent().hashCode());
        result = prime * result + ((getResourcesCreateTime() == null) ? 0 : getResourcesCreateTime().hashCode());
        result = prime * result + ((getResourcesLastUpdataTime() == null) ? 0 : getResourcesLastUpdataTime().hashCode());
        result = prime * result + ((getResourcesUserId() == null) ? 0 : getResourcesUserId().hashCode());
        result = prime * result + ((getResourcesViewsCount() == null) ? 0 : getResourcesViewsCount().hashCode());
        result = prime * result + ((getResourcesLikeCount() == null) ? 0 : getResourcesLikeCount().hashCode());
        result = prime * result + ((getResourcesStatus() == null) ? 0 : getResourcesStatus().hashCode());
        result = prime * result + ((getResourcesUserGroup() == null) ? 0 : getResourcesUserGroup().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourcesId=").append(resourcesId);
        sb.append(", resourcesTitle=").append(resourcesTitle);
        sb.append(", resourcesContent=").append(resourcesContent);
        sb.append(", resourcesCreateTime=").append(resourcesCreateTime);
        sb.append(", resourcesLastUpdataTime=").append(resourcesLastUpdataTime);
        sb.append(", resourcesUserId=").append(resourcesUserId);
        sb.append(", resourcesViewsCount=").append(resourcesViewsCount);
        sb.append(", resourcesLikeCount=").append(resourcesLikeCount);
        sb.append(", resourcesStatus=").append(resourcesStatus);
        sb.append(", resourcesUserGroup=").append(resourcesUserGroup);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}