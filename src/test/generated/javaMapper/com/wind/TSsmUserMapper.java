package com.wind;

import com.wind.TSsmUser;
import com.wind.TSsmUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSsmUserMapper {
    long countByExample(TSsmUserExample example);

    int deleteByExample(TSsmUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSsmUser record);

    int insertSelective(TSsmUser record);

    List<TSsmUser> selectByExample(TSsmUserExample example);

    TSsmUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSsmUser record, @Param("example") TSsmUserExample example);

    int updateByExample(@Param("record") TSsmUser record, @Param("example") TSsmUserExample example);

    int updateByPrimaryKeySelective(TSsmUser record);

    int updateByPrimaryKey(TSsmUser record);
}