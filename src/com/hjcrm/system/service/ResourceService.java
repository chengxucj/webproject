package com.hjcrm.system.service;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Resource;
import com.hjcrm.system.bean.User;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface ResourceService {
    List<Resource> queryResource(Map<String,Integer> map);
    int queryCountRes();

    int addOrUpdateResource(Resource resource);
    List<User> queryAllXiaoShou(int deptid);

    int assigntoResource(String resourceIds, int belongid);
    List<Resource> selectDetailsResource(int resourceId);

    List<Resource> querySalesResource(Map<String, Integer> map);

    Integer queryResourceState(int rid);
    int deleteResources(List<Integer> list);
}
