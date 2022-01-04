package com.cdnu.baikun.service;


import java.util.Map;

/**
 * @author 白坤
 * @date 2021/8/14
 */
public interface SearchService {
    /**
     * 根据页面与关键词返回结果
     * @param page
     * @param keyword
     * @return
     */
    Map<String,Object> listCoverVo(Integer page, String keyword);
}
