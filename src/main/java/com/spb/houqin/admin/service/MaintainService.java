package com.spb.houqin.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.spb.houqin.admin.entity.Maintain;

import java.util.List;
import java.util.Map;


public interface MaintainService extends IService<Maintain> {

    List<Map> getStatics1(String userId);

    List<Map> getStatics2(String userId);

    List<Map> getStatics3(String userId);

    List<Map> getStatics4(String userId);

    List<Map> getStatics5();

    Map<String,List> getStatics6();

    List<Map> getStatics7();

    List<Map> getStatics8();

    List<Map> getStatics66(String name);
}
