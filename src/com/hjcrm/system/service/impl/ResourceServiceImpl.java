package com.hjcrm.system.service.impl;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.publics.utils.SplitIdsUtil;
import com.hjcrm.system.bean.Resource;
import com.hjcrm.system.bean.User;
import com.hjcrm.system.dao.ResourceDao;
import com.hjcrm.system.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;
    @Override
    public List<Resource> queryResource(Map<String,Integer> map) {
        return resourceDao.queryResources(map);
    }

    @Override
    public int queryCountRes() {
        return resourceDao.queryCountRes();
    }

    @Override
    public int addOrUpdateResource(Resource resource) {
        if(resource.getResourceId()!=0) {
            return resourceDao.updateResource(resource);
        }else{
            return resourceDao.addResource(resource);
        }
    }

    @Override
    public List<User> queryAllXiaoShou(int deptid) {
        return resourceDao.queryAllXiaoShou(deptid);
    }

    @Override
    public int assigntoResource(String resourceIds, int belongid) {
        List<Integer> list=SplitIdsUtil.SplitIdstoList(resourceIds);
        Map<String,Object> map=new HashMap<>();
        map.put("list",list);
        map.put("assigntime",new Timestamp(new Date().getTime()));
        map.put("belongid",belongid);
        map.put("deptid",resourceDao.queryDeptidByuserId(belongid));
        return resourceDao.assigntoResource(map);
    }

    @Override
    public List<Resource> selectDetailsResource(int resourceId) {
        return resourceDao.selectDetailsResource(resourceId);
    }

    @Override
    public List<Resource> querySalesResource(Map<String, Integer> map) {
        return resourceDao.querySalesResource(map);
    }

    @Override
    public Integer queryResourceState(int rid) {
        return resourceDao.queryResourceState(rid);
    }

    @Override
    public int deleteResources(List<Integer> list) {
        return resourceDao.deleteResources(list);
    }
}
