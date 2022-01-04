package com.cdnu.baikun.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdnu.baikun.domain.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 白坤
 * @date 2021/7/26
 */
public interface NoticeService extends IService<Notice> {
    /**
     * 添加公告
     *
     * @param notice
     * @return
     */
    Boolean addNotice(Notice notice);

    /**
     * 更新公告
     *
     * @param notice
     * @return
     */
    Boolean updateNotice(Notice notice);

    /**
     * 根据公告id删除公告
     *
     * @param noticeId
     * @return
     */
    Boolean deleteNoticeById(Integer noticeId);

    /**
     * 根据公告状态获取公告列表
     *
     * @param status
     * @return
     */
    Page<Notice> getNotice(Integer page, Integer limit, Integer status);

    /**
     * 获取所有公告
     *
     * @return
     */
    Page<Notice> getAllNotice(Integer page, Integer limit);

    /**
     * 得到公告,如果没有正在设为显示的就显示最近更新过的公告。
     * @return
     */
    Notice getNotice();

    /**
     * 设置公告
     * @param id
     * @return
     */
    Boolean setNotice(Integer id);
}
