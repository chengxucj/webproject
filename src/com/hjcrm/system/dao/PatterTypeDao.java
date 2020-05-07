package com.hjcrm.system.dao;

import com.hjcrm.system.bean.PatterType;

import java.util.List;

public interface PatterTypeDao {

    List<PatterType> queryPattertype();

    int addPattertype(PatterType patterType);

    int updatePattertype(PatterType patterType);

    int deletepatterType(List<Integer> list);
}
