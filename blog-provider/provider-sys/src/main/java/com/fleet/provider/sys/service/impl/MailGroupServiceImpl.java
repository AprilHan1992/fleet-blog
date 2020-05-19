package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.mail.MailGroup;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.mail.MailGroupService;
import com.fleet.provider.sys.dao.MailGroupDao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class MailGroupServiceImpl extends BaseServiceImpl<MailGroup> implements MailGroupService {

    @Autowired
    private MailGroupDao mailGroupDao;

    @Override
    public BaseDao<MailGroup> baseDao() {
        return mailGroupDao;
    }
}
