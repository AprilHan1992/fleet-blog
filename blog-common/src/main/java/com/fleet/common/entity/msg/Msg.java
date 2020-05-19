package com.fleet.common.entity.msg;

import com.fleet.common.entity.Base;

import java.util.Date;
import java.util.List;

public class Msg extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 消息id
     */
    private Integer msgId;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 消息摘要
     */
    private String msgExcerpt;

    /**
     * 网址
     */
    private String msgUrl;

    /**
     * 消息状态（0：未发布，1：已发布）
     */
    private Integer msgState;

    /**
     * 创建人
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private Date createTime;

    private List<MsgTo> msgToList;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public String getMsgExcerpt() {
        return msgExcerpt;
    }

    public void setMsgExcerpt(String msgExcerpt) {
        this.msgExcerpt = msgExcerpt;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public Integer getMsgState() {
        return msgState;
    }

    public void setMsgState(Integer msgState) {
        this.msgState = msgState;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<MsgTo> getMsgToList() {
        return msgToList;
    }

    public void setMsgToList(List<MsgTo> msgToList) {
        this.msgToList = msgToList;
    }
}
