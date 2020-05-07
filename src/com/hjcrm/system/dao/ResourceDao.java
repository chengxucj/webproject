package com.hjcrm.system.dao;

import com.hjcrm.publics.utils.PageBean;
import com.hjcrm.system.bean.Dept;
import com.hjcrm.system.bean.Resource;
import com.hjcrm.system.bean.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface ResourceDao {
    List<Resource> queryResources(Map<String, Integer> map);
    List<Resource> selectDetailsResource(int resourceId);
    int queryCountRes();

    int updateResource(Resource resource);

    int addResource(Resource resource);
    List<User> queryAllXiaoShou(int deptid);

    int assigntoResource(Map<String,Object> map);

    int queryDeptidByuserId(int userid);

    List<Resource> querySalesResource(Map<String, Integer> map);

    Resource queryResourceByid(int resourceid);

    int updateStateById(int resourceid);

    Integer queryResourceState(int rid);
    int deleteResources(List<Integer> list);
}
