package com.hjcrm.system.dao;

import com.hjcrm.system.bean.Patter;
import com.hjcrm.system.bean.PatterType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyPatterDao {
    List<Patter> queryPatter(Patter patter);
    List<PatterType> queryPatterType(Patter patter);

    int updatePatter(Patter patter);
    int addPatter(Patter patter);
    int deletePatter(@Param("list") List<Integer> list, @Param("userid") int userid);

    int updatePatterIsShare(int patterid);
}
