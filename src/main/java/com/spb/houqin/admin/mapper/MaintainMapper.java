package com.spb.houqin.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spb.houqin.admin.entity.Maintain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface MaintainMapper extends BaseMapper<Maintain> {
    @Select("<script>" +
            "select count(1) as num,date_format(create_date,'%m')as 'month'\n" +
            "from sys_maintain\n" +
            "where 1=1\n" +
            "\n" +
            "and userid2 = #{userId}   and del_flag = 0\n" +
            "\n" +
            "group by date_format(create_date,'%m')" +
            "</script>")
    List<Map> getStatics1(String userId);

    @Select("<script> " +
            "select count(1) as num,satus as status\n" +
            "from sys_maintain\n" +
            "where userid2 = #{userId}   and del_flag = 0\n" +
            "group by satus" +
            "</script>")
    List<Map> getStatics2(String userId);


    @Select("<script>" +
            "select count(1) as num,date_format(create_date,'%m')as 'month'\n" +
            "from sys_maintain\n" +
            "where 1=1  and del_flag = 0\n" +
            "\n" +
            "and userid = #{userId}\n" +
            "\n" +
            "group by date_format(create_date,'%m')" +
            "</script>")
    List<Map> getStatics3(String userId);

    @Select("<script> " +
            "select count(1) as num,satus as status\n" +
            "from sys_maintain\n" +
            "where userid = #{userId}   and del_flag = 0\n" +
            "group by satus" +
            "</script>")
    List<Map> getStatics4(String userId);

    @Select("<script> " +
            "select count(1) as num,satus as status\n" +
            "from sys_maintain where    del_flag= 0\n" +
            "group by satus" +
            "</script>")
    List<Map> getStatics5();

    @Select("<script>" +
            "select count(1) as num,date_format(create_date,'%m')as 'month'\n" +
            "from sys_maintain\n" +
            "where 1=1  and del_flag = 0 and satus = 4 \n" +
            "group by date_format(create_date,'%m')" +
            "</script>")
    List<Map> getStatics6();

    @Select("<script>" +
            "select count(1) as num,date_format(create_date,'%m')as 'month'\n" +
            "from sys_maintain\n" +
            "where 1=1 and satus = 2  and del_flag = 0\n" +
            "group by date_format(create_date,'%m')" +
            "</script>")
    List<Map> getStatics7();

    @Select("select AVG(score) num ,username as name\n" +
            "FROM sys_maintain where  del_flag = 0\n" +
            "group by username " +
            "order by num desc")
    List<Map> getStatics8();


    @Select("<script>" +
            "select count(1) as num,date_format(create_date,'%m')as 'month'\n" +
            "from sys_maintain\n" +
            "where 1=1 and satus = 3  and del_flag = 0\n" +
            "group by date_format(create_date,'%m')" +
            "</script>")
    List<Map> getStatics77();

    @Select("<script> " +
            "select count(1) as num,satus as status\n" +
            "from sys_maintain where  del_flag= 0 and username like concat('%',concat(#{name},'%'))\n" +
            "group by satus" +
            "</script>")
    List<Map> getStatics66(@Param("name") String name);
}
