package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.EmailSendRecord;

import java.util.List;

public interface EmailSendRecordMapper {
    int deleteByPrimaryKey(String email);

    int insert(EmailSendRecord record);

    int insertSelective(EmailSendRecord record);

    List<EmailSendRecord> selectByPrimaryKey(String email);

    int updateByPrimaryKeySelective(EmailSendRecord record);

    int updateByPrimaryKey(EmailSendRecord record);
}