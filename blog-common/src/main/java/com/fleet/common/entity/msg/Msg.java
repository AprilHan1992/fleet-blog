package com.fleet.common.entity.msg;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fleet.common.entity.Base;
import com.fleet.common.entity.user.User;

import java.util.Date;
import java.util.List;

/**
 * @author April Han
 */
public class Msg extends Base {

    private static final long serialVersionUID = -4736591895618842716L;

    /**
     * 消息id
     */
    private Long id;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息摘要
     */
    private String excerpt;

    /**
     * 网址
     */
    private String url;

    /**
     * 消息状态（0：未发布，1：已发布）
     */
    private Integer state;

    /**
     * 创建人
     */
    private Long creatorId;

    /**
     * 创建人
     */
    private User creator;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<To> toList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<To> getToList() {
        return toList;
    }

    public void setToList(List<To> toList) {
        this.toList = toList;
    }
}
