package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author 白坤
 * @TableName category
 */
@TableName(value = "category")
public class Category implements Serializable {
    /**
     * 分类id
     */
    @TableId(type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 分类父id
     */
    private Integer categoryPid;

    /**
     * 分类名
     */
    private String categoryName;

    /**
     * 分类描述
     */
    private String categoryDescription;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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

    /**
     * 分类父id
     */
    public Integer getCategoryPid() {
        return categoryPid;
    }

    /**
     * 分类父id
     */
    public void setCategoryPid(Integer categoryPid) {
        this.categoryPid = categoryPid;
    }

    /**
     * 分类名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 分类名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 分类描述
     */
    public String getCategoryDescription() {
        return categoryDescription;
    }

    /**
     * 分类描述
     */
    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
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
        Category other = (Category) that;
        return (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
                && (this.getCategoryPid() == null ? other.getCategoryPid() == null : this.getCategoryPid().equals(other.getCategoryPid()))
                && (this.getCategoryName() == null ? other.getCategoryName() == null : this.getCategoryName().equals(other.getCategoryName()))
                && (this.getCategoryDescription() == null ? other.getCategoryDescription() == null : this.getCategoryDescription().equals(other.getCategoryDescription()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCategoryPid() == null) ? 0 : getCategoryPid().hashCode());
        result = prime * result + ((getCategoryName() == null) ? 0 : getCategoryName().hashCode());
        result = prime * result + ((getCategoryDescription() == null) ? 0 : getCategoryDescription().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categoryId=").append(categoryId);
        sb.append(", categoryPid=").append(categoryPid);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", categoryDescription=").append(categoryDescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}