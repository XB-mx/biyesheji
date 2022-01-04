package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @TableName resource_category_ref
 */
@TableName(value = "resource_category_ref")
public class ResourceCategoryRef implements Serializable {
    /**
     * 资源id
     */
    @TableId
    private Integer resourcesId;

    /**
     * 分类id
     */
    private Integer categoryId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 资源id
     */
    public Integer getResourcesId() {
        return resourcesId;
    }

    /**
     * 资源id
     */
    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    /**
     * 分类id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 分类id
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
        ResourceCategoryRef other = (ResourceCategoryRef) that;
        return (this.getResourcesId() == null ? other.getResourcesId() == null : this.getResourcesId().equals(other.getResourcesId()))
                && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResourcesId() == null) ? 0 : getResourcesId().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourcesId=").append(resourcesId);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}