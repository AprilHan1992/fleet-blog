package com.fleet.provider.sys.service.impl;

import com.fleet.common.dao.BaseDao;
import com.fleet.common.entity.dept.Dept;
import com.fleet.common.service.dept.DeptService;
import com.fleet.common.service.impl.BaseServiceImpl;
import com.fleet.provider.sys.dao.DeptDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public BaseDao<Dept> baseDao() {
        return deptDao;
    }

    @Override
    public Dept get(Dept dept) {
        dept = deptDao.get(dept);
        if (dept != null) {
            String upperDeptNames = getDeptNames(dept.getUpperId());
            dept.setDeptNames(dept.getDeptName());
            if (!upperDeptNames.equals("")) {
                dept.setDeptNames(upperDeptNames + "/" + dept.getDeptName());
            }
        }
        return dept;
    }

    @Override
    public Boolean delete(Dept dept) {
        List<Integer> deptIdList = deptDao.deptIdList(dept);
        if (deptIdList != null && deptIdList.size() != 0) {
            deptDao.delete(dept);
            for (Integer deptId : deptIdList) {
                Dept d = new Dept();
                d.setUpperId(deptId);
                delete(d);
            }
        }
        return true;
    }

    @Override
    public List<Integer> deptIdList(Integer deptId) {
        List<Integer> rList = new ArrayList<>();
        rList.add(deptId);

        Dept dept = new Dept();
        dept.setUpperId(deptId);
        List<Integer> deptIdList = deptDao.deptIdList(dept);
        if (deptIdList != null) {
            for (Integer id : deptIdList) {
                rList.addAll(deptIdList(id));
            }
        }
        return rList;
    }

    @Override
    public Integer getDeptId(String deptNames) {
        if (StringUtils.isEmpty(deptNames)) {
            return null;
        }
        String[] dns = deptNames.split("/");
        List<Integer> upperIds = new ArrayList<>();
        for (String dn : dns) {
            List<Integer> newUpperIds = new ArrayList<>();
            if (upperIds.size() != 0) {
                for (Integer upperId : upperIds) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("upperId", upperId);
                    map.put("deptName", dn);
                    List<Dept> list = deptDao.list(map);
                    if (list != null && list.size() != 0) {
                        for (Dept dept : list) {
                            newUpperIds.add(dept.getDeptId());
                        }
                    }
                }
            } else {
                Map<String, Object> map = new HashMap<>();
                map.put("deptName", dn);
                List<Dept> list = deptDao.list(map);
                if (list != null && list.size() != 0) {
                    for (Dept dept : list) {
                        newUpperIds.add(dept.getDeptId());
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
    public String getDeptNames(Integer deptId) {
        String deptNames = "";
        if (deptId == 0) {
            return deptNames;
        }
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        dept = deptDao.get(dept);
        if (dept != null) {
            String upperDeptName = getDeptNames(dept.getUpperId());
            if (upperDeptName.equals("")) {
                deptNames = dept.getDeptName();
            } else {
                deptNames = upperDeptName + "/" + dept.getDeptName();
            }
        }
        return deptNames;
    }

    @Override
    public List<Dept> buildTree(List<Dept> deptList) {
        List<Dept> tree = new ArrayList<>();
        if (deptList == null || deptList.isEmpty()) {
            return tree;
        }

        Map<Integer, Dept> map = new HashMap<>();
        for (Dept dept : deptList) {
            map.put(dept.getDeptId(), dept);
        }

        for (Integer deptId : map.keySet()) {
            Dept dept = map.get(deptId);
            if (map.containsKey(dept.getUpperId())) {
                Dept upperDept = map.get(dept.getUpperId());
                if (upperDept.getDeptList() == null) {
                    upperDept.setDeptList(new ArrayList<>());
                }
                upperDept.getDeptList().add(dept);
            } else {
                tree.add(dept);
            }
        }

        return tree;
    }
}
