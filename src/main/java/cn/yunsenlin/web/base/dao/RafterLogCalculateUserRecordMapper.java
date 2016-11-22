package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.RafterLogCalculateUserRecord;
import cn.yunsenlin.web.base.model.RafterLogCalculateUserRecordKey;

public interface RafterLogCalculateUserRecordMapper {
    int deleteByPrimaryKey(RafterLogCalculateUserRecordKey key);

    int insert(RafterLogCalculateUserRecord record);

    int insertSelective(RafterLogCalculateUserRecord record);

    RafterLogCalculateUserRecord selectByPrimaryKey(RafterLogCalculateUserRecordKey key);

    int updateByPrimaryKeySelective(RafterLogCalculateUserRecord record);

    int updateByPrimaryKey(RafterLogCalculateUserRecord record);
}