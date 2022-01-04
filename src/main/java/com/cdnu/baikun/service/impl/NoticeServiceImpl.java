package com.cdnu.baikun.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdnu.baikun.domain.Notice;
import com.cdnu.baikun.service.NoticeService;
import com.cdnu.baikun.mapper.NoticeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice>
        implements NoticeService {

    @Override
    public Boolean addNotice(Notice notice) {
        notice.setNoticeCreateTime(new Date());
        notice.setNoticeUpdataTime(new Date());
        return save(notice);
    }

    @Override
    public Boolean updateNotice(Notice notice) {
        if (notice == null) return false;
        UpdateWrapper<Notice> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("notice_id",notice.getNoticeId());
        if (!notice.getNoticeTitle().equals("")) updateWrapper.set("notice_title",notice.getNoticeTitle());
        if (!notice.getNoticeContent().equals("")) updateWrapper.set("notice_content",notice.getNoticeContent());
        updateWrapper.set("notice_updata_time",new Date());
        return this.update(updateWrapper);
    }

    @Override
    public Boolean deleteNoticeById(Integer noticeId) {
        if (noticeId == null) return false;
        return removeById(noticeId);
    }

    @Override
    public Page<Notice> getNotice(Integer page, Integer limit, Integer status) {
        Page<Notice> noticePage = query().eq("notice_status", 1).page(new Page<>(page, limit));
        return noticePage;
    }

    @Override
    public Page<Notice> getAllNotice(Integer page, Integer limit) {
        Page<Notice> noticePage = query().page(new Page<>(page, limit));
        return noticePage;
    }

    @Override
    public Notice getNotice() {
        Notice one = query().eq("notice_status", 0).one();
        if (one==null) one=query().orderByDesc("notice_updata_time").last("limit 1").one();
        return one;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean setNotice(Integer id) {
        boolean update = update().eq("notice_status", 0).set("notice_status", 1).update();
        boolean update1 = update().eq("notice_id", id).set("notice_status", 0).update();
        return update&&update1;
    }
}




