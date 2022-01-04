package com.cdnu.baikun.dto;

/**
 * @author 白坤
 * @date 2021/7/12
 */
public class CoverVo {
    private String src;
    private String title;
    private String content;
    private Integer id;
    private String category;

    public CoverVo(String src, String title) {
        this.src = src;
        this.title = title;
    }

    public CoverVo(String src, String title, String content) {
        this.src = src;
        this.title = title;
        this.content = content;
    }

    public CoverVo(String src, String title, String content, Integer id) {
        this.src = src;
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public CoverVo() {
    }

    public CoverVo(String src, String title, String content, Integer id, String category) {
        this.src = src;
        this.title = title;
        this.content = content;
        this.id = id;
        this.category = category;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
