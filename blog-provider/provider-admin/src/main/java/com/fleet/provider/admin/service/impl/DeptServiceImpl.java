package com.fleet.provider.admin.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.enums.Deleted;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.admin.dao.DeptDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author April Han
 */
@Transactional
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public BaseDao<Dept> baseDao() {
        return deptDao;
    }

    @Override
    public Dept get(Dept dept) {
        dept = deptDao.get(dept);
        if (dept != null) {
            dept.setNames(getNames(dept.getId()));
        }
        return dept;
    }

    @Override
    public Boolean delete(Dept dept) {
        List<Long> idList = deptDao.idList(dept);
        if (idList != null && idList.size() != 0) {
            deptDao.delete(dept);
            for (Long id : idList) {
                Dept d = new Dept();
                d.setUpperId(id);
                delete(d);
            }
        }
        return true;
    }

    @Override
    public Boolean deletes(Long[] ids) {
        for (Long id : ids) {
            Dept dept = new Dept();
            dept.setId(id);
            delete(dept);
        }
        return true;
    }

    @Override
    public List<Long> idList(Long id) {
        List<Long> rList = new ArrayList<>();
        rList.add(id);

        Dept dept = new Dept();
        dept.setUpperId(id);
        List<Long> idList = deptDao.idList(dept);
        if (idList != null) {
            for (Long i : idList) {
                rList.addAll(idList(i));
            }
        }
        return rList;
    }

    @Override
    public Long getId(String names) {
        if (StringUtils.isEmpty(names)) {
            return null;
        }
        String[] ns = names.split("/");
        List<Long> upperIds = new ArrayList<>();
        upperIds.add(0L);
        for (String n : ns) {
            List<Long> newUpperIds = new ArrayList<>();
            for (Long upperId : upperIds) {
                Map<String, Object> map = new HashMap<>();
                map.put("deleted", Deleted.NO);
                map.put("upperId", upperId);
                map.put("name", n);
                List<Dept> list = deptDao.list(map);
                if (list != null) {
                    for (Dept dept : list) {
                        newUpperIds.add(dept.getId());
                    }
                }
            }
            if (newUpperIds.size() == 0) {
                return null;
            }
            upperIds = newUpperIds;
        }
        if (upperIds.size() == 1) {
            return upperIds.get(0);
        }
        return null;
    }

    @Override
    public String getNames(Long id) {
        String names = "";
        if (id == 0) {
            return names;
        }
        Dept dept = new Dept();
        dept.setId(id);
        dept = deptDao.get(dept);
        if (dept != null) {
            String upperName = getNames(dept.getUpperId());
            if ("".equals(upperName)) {
                names = dept.getName();
            } else {
                names = upperName + "/" + dept.getName();
            }
        }
        return names;
    }

    @Override
    public List<Dept> buildTree(List<Dept> deptList) {
        List<Dept> tree = new ArrayList<>();
        if (deptList == null || deptList.isEmpty()) {
            return tree;
        }

        Map<Long, Dept> map = new HashMap<>();
        for (Dept dept : deptList) {
            map.put(dept.getId(), dept);
        }

        for (Long id : map.keySet()) {
            Dept dept = map.get(id);
            if (map.containsKey(dept.getUpperId())) {
                Dept upper = map.get(dept.getUpperId());
                if (upper.getChildren() == null) {
                    upper.setChildren(new ArrayList<>());
                }
                upper.getChildren().add(dept);
            } else {
                tree.add(dept);
            }
        }
        return tree;
    }
}
