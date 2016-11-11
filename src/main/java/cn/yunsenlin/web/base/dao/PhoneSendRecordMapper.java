package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.PhoneSendRecord;

import java.util.List;

public interface PhoneSendRecordMapper {
    int deleteByPrimaryKey(String phone);

    int insert(PhoneSendRecord record);

    int insertSelective(PhoneSendRecord record);

    List<PhoneSendRecord> selectByPrimaryKey(String phone);

    int updateByPrimaryKeySelective(PhoneSendRecord record);

    int updateByPrimaryKey(PhoneSendRecord record);
}