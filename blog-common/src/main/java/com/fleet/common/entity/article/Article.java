package com.fleet.common.entity.article;


import com.fleet.common.entity.Base;

import java.util.Date;

/**
 * @author April Han
 */
public class Article extends Base {

    private static final long serialVersionUID = 3962854874828562308L;

    /**
     * 文章id
     */
    private Integer id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章封面
     */
    private String cover;

    /**
     * 分类/标签id
     */
    private Integer tagId;

    /**
     * 分类/标签
     */
    private String tag;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章标签（多个用,隔开）
     */
    private String tags;

    /**
     * 是否置顶（1：是，0：否）
     */
    private Integer top;

    /**
     * 是否首页推荐（1：是，0：否）
     */
    private Integer rcmd;

    /**
     * 文章状态（1：公布，2：私密，3：草稿，4：收回）
     */
    private Integer state;

    /**
     * 排序（数字越大，越排前）
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Integer creatorId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer editorId;

    /**
     * 修改人
     */
    private String editor;

    /**
     * 修改时间
     */
    private Date editTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getRcmd() {
        return rcmd;
    }

    public void setRcmd(Integer rcmd) {
        this.rcmd = rcmd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getEditorId() {
        return editorId;
    }

    public void setEditorId(Integer editorId) {
        this.editorId = editorId;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }
}
