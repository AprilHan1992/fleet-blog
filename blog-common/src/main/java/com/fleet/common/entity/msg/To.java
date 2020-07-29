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
    private Long id;

    /**
     * 消息id
     */
    private Long msgId;

    /**
     * 消息接收人
     */
    private Integer toId;

    /**
     * 消息阅读状态（0：未读，1：已读）
     */
    private Integer readState;

    /**
     * 阅读时间
     */
    private Date readTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
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
