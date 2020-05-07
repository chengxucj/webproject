package com.hjcrm.system.service;

import com.hjcrm.system.bean.PatterType;

import java.util.List;

public interface PatterTypeService {
    List<PatterType> queryPattertype();

    int addOrupdatePattertype(PatterType patterType);

    int deletepatterType(String patterTypeIds);
}
