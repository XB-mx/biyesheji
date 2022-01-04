package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName comment
 */
@TableName(value = "comment")
public class Comment implements Serializable {
    /**
     * 评论id
     */
    @TableId(type = IdType.AUTO)
    private Integer commentId;

    /**
     * 评论状态
     */
    private Integer commentStatus;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 评论人身份
     */
    private String commentRole;

    /**
     * 评论人昵称
     */
    private String commentUserNickname;

    /**
     * 评论人头像
     */
    private String commentUserAvatar;

    /**
     * 评论人ID
     */
    private Integer commentUserId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 评论id
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     * 评论内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * 评论时间
     */
    public Date getCommentTime() {
        return commentTime;
    }

    /**
     * 评论时间
     */
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 评论人身份
     */
    public String getCommentRole() {
        return commentRole;
    }

    /**
     * 评论人身份
     */
    public void setCommentRole(String commentRole) {
        this.commentRole = commentRole;
    }

    /**
     * 评论人昵称
     */
    public String getCommentUserNickname() {
        return commentUserNickname;
    }

    /**
     * 评论人昵称
     */
    public void setCommentUserNickname(String commentUserNickname) {
        this.commentUserNickname = commentUserNickname;
    }

    /**
     * 评论人头像
     */
    public String getCommentUserAvatar() {
        return commentUserAvatar;
    }

    /**
     * 评论人头像
     */
    public void setCommentUserAvatar(String commentUserAvatar) {
        this.commentUserAvatar = commentUserAvatar;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
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
        Comment other = (Comment) that;
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
                && (this.getCommentStatus() == null ? other.getCommentStatus() == null : this.getCommentStatus().equals(other.getCommentStatus()))
                && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
                && (this.getCommentTime() == null ? other.getCommentTime() == null : this.getCommentTime().equals(other.getCommentTime()))
                && (this.getCommentRole() == null ? other.getCommentRole() == null : this.getCommentRole().equals(other.getCommentRole()))
                && (this.getCommentUserNickname() == null ? other.getCommentUserNickname() == null : this.getCommentUserNickname().equals(other.getCommentUserNickname()))
                && (this.getCommentUserAvatar() == null ? other.getCommentUserAvatar() == null : this.getCommentUserAvatar().equals(other.getCommentUserAvatar()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getCommentStatus() == null) ? 0 : getCommentStatus().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
        result = prime * result + ((getCommentTime() == null) ? 0 : getCommentTime().hashCode());
        result = prime * result + ((getCommentRole() == null) ? 0 : getCommentRole().hashCode());
        result = prime * result + ((getCommentUserNickname() == null) ? 0 : getCommentUserNickname().hashCode());
        result = prime * result + ((getCommentUserAvatar() == null) ? 0 : getCommentUserAvatar().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", commentId=").append(commentId);
        sb.append(", getCommentStatus=").append(commentStatus);
        sb.append(", commentContent=").append(commentContent);
        sb.append(", commentTime=").append(commentTime);
        sb.append(", commentRole=").append(commentRole);
        sb.append(", commentUserNickname=").append(commentUserNickname);
        sb.append(", commentUserAvatar=").append(commentUserAvatar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}