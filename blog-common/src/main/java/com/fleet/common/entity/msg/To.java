package com.fleet.common.entity.msg;

import com.fleet.common.entity.Base;

import java.util.Date;

/**
 * @author April Han
 */
public class To extends Base {

    private static final long serialVersionUID = 4115146960165874556L;

    /**
     * 消息接收id
     */
    private Integer id;

    /**
     * 消息id
     */
    private Integer msgId;

    /**
     * 消息接收人
     */
    private Integer to;

    /**
     * 消息阅读状态（0：未读，1：已读）
     */
    private Integer readState;

    /**
     * 阅读时间
     */
    private Date readTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Integer getReadState() {
        return readState;
    }

    public void setReadState(Integer readState) {
        this.readState = readState;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
}
