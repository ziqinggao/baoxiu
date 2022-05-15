package com.spb.houqin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spb.houqin.admin.entity.Maintain;
import com.spb.houqin.admin.mapper.MaintainMapper;
import com.spb.houqin.admin.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class MaintainServiceImpl extends ServiceImpl<MaintainMapper, Maintain> implements MaintainService {

    @Autowired
    private MaintainMapper maintainMapper;
    @Override
    public List<Map> getStatics1(String userId) {
        return maintainMapper.getStatics1(userId);
    }

    @Override
    public List<Map> getStatics2(String userId) {
        return maintainMapper.getStatics2(userId);
    }

    @Override
    public List<Map> getStatics3(String userId) {
        return maintainMapper.getStatics3(userId);
    }

    @Override
    public List<Map> getStatics4(String userId) {
        return maintainMapper.getStatics4(userId);
    }

    @Override
    public List<Map> getStatics5() {
        return maintainMapper.getStatics5();
    }

    @Override
    public Map<String,List> getStatics6() {
        Map<String,List> resultMap = new HashMap<>();
        List<Map> list = maintainMapper.getStatics6();
        List<Integer> result1 = new ArrayList(12);
        for (int i = 0;i<12;i++){
            result1.add(0);
        }
        for (int i =1;i<=12;i++){
            for (int j = 0;j<list.size();j++){
                if (i == Integer.parseInt(list.get(j).get("month").toString())){
                    result1.add(i-1,Integer.parseInt(list.get(j).get("num").toString()));
                }
            };
        }

        List<Map> list2 = maintainMapper.getStatics7();
        List<Integer> result2 = new ArrayList(12);
        for (int i = 0;i<12;i++){
            result2.add(0);
        }
        for (int i =1;i<=12;i++){
            for (int j = 0;j<list2.size();j++){
                if (i == Integer.parseInt(list2.get(j).get("month").toString())){
                    result2.add(i-1,Integer.parseInt(list2.get(j).get("num").toString()));
                }
            };
        }

        List<Map> list3 = maintainMapper.getStatics77();
        List<Integer> result3 = new ArrayList(12);
        for (int i = 0;i<12;i++){
            result3.add(0);
        }
        for (int i =1;i<=12;i++){
            for (int j = 0;j<list3.size();j++){
                if (i == Integer.parseInt(list3.get(j).get("month").toString())){
                    result3.add(i-1,Integer.parseInt(list3.get(j).get("num").toString()));
                }
            };
        }

        resultMap.put("data1",result1);
        resultMap.put("data2",result2);
        resultMap.put("data3",result3);

        return resultMap;
    }

    @Override
    public List<Map> getStatics7() {
        return maintainMapper.getStatics7();
    }

    @Override
    public List<Map> getStatics8() {
        return maintainMapper.getStatics8();
    }

    @Override
    public List<Map> getStatics66(String name) {
        return maintainMapper.getStatics66(name);
    }
}
