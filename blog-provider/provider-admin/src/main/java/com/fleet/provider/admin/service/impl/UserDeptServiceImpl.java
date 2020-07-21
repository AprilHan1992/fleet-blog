package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.user.UserDept;
import com.fleet.common.enums.Identity;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.common.service.user.UserDeptService;
import com.fleet.provider.admin.dao.UserDeptDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author April Han
 */
@Transactional
@Service
public class UserDeptServiceImpl extends BaseServiceImpl<UserDept> implements UserDeptService {

    @Resource
    private UserDeptDao userDeptDao;

    @Override
    public BaseDao<UserDept> baseDao() {
        return userDeptDao;
    }

    @Override
    public Boolean insert(UserDept userDept) {
        UserDept ud = new UserDept();
        ud.setUserId(userDept.getUserId());
        ud = userDeptDao.get(ud);
        if (ud != null) {
            userDept.setId(ud.getId());
        }
        if (StringUtils.isNotEmpty(userDept.getIdentity())) {
            if (userDept.getIdentity().equals(Identity.SUPERIOR)) {
                ud = new UserDept();
                ud.setDeptId(userDept.getDeptId());
                ud.setIdentity(Identity.SUPERIOR);
                ud = userDeptDao.get(ud);
                if (ud != null) {
                    if (userDept.getId() == null || !userDept.getId().equals(ud.getId())) {
                        ud.setIdentity(Identity.NORMAL);
                        userDeptDao.update(ud);
                    }
                }
            }
        } else {
            userDept.setIdentity(Identity.NORMAL);
        }
        if (userDept.getId() != null) {
            return userDeptDao.update(userDept) != 0;
        } else {
            return userDeptDao.insert(userDept) != 0;
        }
    }

    @Override
    public Boolean update(UserDept userDept) {
        UserDept ud = new UserDept();
        ud.setUserId(userDept.getUserId());
        ud = userDeptDao.get(ud);
        if (ud != null) {
            userDept.setId(ud.getId());
        }
        if (StringUtils.isNotEmpty(userDept.getIdentity())) {
            if (userDept.getIdentity().equals(Identity.SUPERIOR)) {
                ud = new UserDept();
                ud.setDeptId(userDept.getDeptId());
                ud.setIdentity(Identity.SUPERIOR);
                ud = userDeptDao.get(ud);
                if (ud != null && !ud.getId().equals(userDept.getId())) {
                    if (!userDept.getId().equals(ud.getId())) {
                        ud.setIdentity(Identity.NORMAL);
                        userDeptDao.update(ud);
                    }
                }
            }
        }
        if (userDept.getId() != null) {
            return userDeptDao.update(userDept) != 0;
        } else {
            return userDeptDao.insert(userDept) != 0;
        }
    }
}
