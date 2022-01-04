package com.cdnu.baikun.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName notice
 */
@TableName(value = "notice")
public class Notice implements Serializable {
    /**
     * 公告id
     */
    @TableId(type = IdType.AUTO)
    private Integer noticeId;

    /**
     * 公告标题
     */
    private String noticeTitle;

    /**
     * 公告内容
     */
    private String noticeContent;

    /**
     * 公告状态
     */
    private Integer noticeStatus;

    /**
     * 公告时间
     */
    private Date noticeCreateTime;

    /**
     * 公告更新时间
     */
    @JsonFormat(locale = "zh",timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date noticeUpdataTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 公告id
     */
    public Integer getNoticeId() {
        return noticeId;
    }

    /**
     * 公告id
     */
    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * 公告标题
     */
    public String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * 公告标题
     */
    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * 公告内容
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * 公告内容
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    /**
     * 公告状态
     */
    public Integer getNoticeStatus() {
        return noticeStatus;
    }

    /**
     * 公告状态
     */
    public void setNoticeStatus(Integer noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    /**
     * 公告时间
     */
    public Date getNoticeCreateTime() {
        return noticeCreateTime;
    }

    /**
     * 公告时间
     */
    public void setNoticeCreateTime(Date noticeCreateTime) {
        this.noticeCreateTime = noticeCreateTime;
    }

    /**
     * 公告更新时间
     */
    public Date getNoticeUpdataTime() {
        return noticeUpdataTime;
    }

    /**
     * 公告更新时间
     */
    public void setNoticeUpdataTime(Date noticeUpdataTime) {
        this.noticeUpdataTime = noticeUpdataTime;
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
        Notice other = (Notice) that;
        return (this.getNoticeId() == null ? other.getNoticeId() == null : this.getNoticeId().equals(other.getNoticeId()))
                && (this.getNoticeTitle() == null ? other.getNoticeTitle() == null : this.getNoticeTitle().equals(other.getNoticeTitle()))
                && (this.getNoticeContent() == null ? other.getNoticeContent() == null : this.getNoticeContent().equals(other.getNoticeContent()))
                && (this.getNoticeStatus() == null ? other.getNoticeStatus() == null : this.getNoticeStatus().equals(other.getNoticeStatus()))
                && (this.getNoticeCreateTime() == null ? other.getNoticeCreateTime() == null : this.getNoticeCreateTime().equals(other.getNoticeCreateTime()))
                && (this.getNoticeUpdataTime() == null ? other.getNoticeUpdataTime() == null : this.getNoticeUpdataTime().equals(other.getNoticeUpdataTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoticeId() == null) ? 0 : getNoticeId().hashCode());
        result = prime * result + ((getNoticeTitle() == null) ? 0 : getNoticeTitle().hashCode());
        result = prime * result + ((getNoticeContent() == null) ? 0 : getNoticeContent().hashCode());
        result = prime * result + ((getNoticeStatus() == null) ? 0 : getNoticeStatus().hashCode());
        result = prime * result + ((getNoticeCreateTime() == null) ? 0 : getNoticeCreateTime().hashCode());
        result = prime * result + ((getNoticeUpdataTime() == null) ? 0 : getNoticeUpdataTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noticeId=").append(noticeId);
        sb.append(", noticeTitle=").append(noticeTitle);
        sb.append(", noticeContent=").append(noticeContent);
        sb.append(", noticeStatus=").append(noticeStatus);
        sb.append(", noticeCreateTime=").append(noticeCreateTime);
        sb.append(", noticeUpdataTime=").append(noticeUpdataTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}