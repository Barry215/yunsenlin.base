package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.RafterLogCalculateRecord;

public interface RafterLogCalculateRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RafterLogCalculateRecord record);

    int insertSelective(RafterLogCalculateRecord record);

    RafterLogCalculateRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RafterLogCalculateRecord record);

    int updateByPrimaryKey(RafterLogCalculateRecord record);
}