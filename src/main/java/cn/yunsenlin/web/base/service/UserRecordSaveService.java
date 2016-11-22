package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.model.BillUserRecord;
import cn.yunsenlin.web.base.model.inter.UserRecordKey;

import java.util.List;

public interface UserRecordSaveService {
    void save(CalculateMoreReturn calculateMoreReturn,CalculateMore calculateMore);
    CalculateMoreReturn get(UserRecordKey userRecordKey);
    void saveLogList(List<LogReturn> logReturnList,BillUserRecord userRecordKey);
    void saveWeightReturnList(List<WeightReturn> weightReturnList,BillUserRecord userRecordKey);
    void saveTimberReturnList(List<TimberReturn> timberReturnList,BillUserRecord userRecordKey);
    void saveValidationReturnList(List<ValidationReturn> validationReturnList,BillUserRecord userRecordKey);
}
