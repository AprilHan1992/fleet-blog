package com.fleet.common.entity.msg;

import com.fleet.common.entity.Base;

import java.util.Date;

public class MsgTo extends Base {

    private static final long serialVersionUID = 1L;

    /**
     * 消息id
     */
    private Integer msgId;

    /**
     * 消息接收人
     */
    private Integer msgTo;

    /**
     * 消息阅读状态（0：未读，1：已读）
     */
    private Integer readState;

    /**
     * 阅读时间
     */
    private Date readTime;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getMsgTo() {
        return msgTo;
    }

    public void setMsgTo(Integer msgTo) {
        this.msgTo = msgTo;
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
