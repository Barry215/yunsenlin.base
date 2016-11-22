package cn.yunsenlin.web.base.service;

import cn.yunsenlin.web.base.dto.calculate.android.*;
import cn.yunsenlin.web.base.dto.tongBu.android.IndexReturn;
import cn.yunsenlin.web.base.model.BillUserRecord;
import cn.yunsenlin.web.base.model.BillUserRecordKey;

import java.util.List;

public interface UserRecordSaveService {
    void save(CalculateMoreReturn calculateMoreReturn,CalculateMore calculateMore);
    CalculateMoreReturn get(BillUserRecordKey userRecordKey);
    void saveLogList(List<LogReturn> logReturnList,BillUserRecord userRecordKey);
    void saveWeightReturnList(List<WeightReturn> weightReturnList,BillUserRecord userRecordKey);
    void saveTimberReturnList(List<TimberReturn> timberReturnList,BillUserRecord userRecordKey);
    void saveValidationReturnList(List<ValidationReturn> validationReturnList,BillUserRecord userRecordKey);
    void delete(BillUserRecordKey userRecordKey);
    IndexReturn getIndexReturn(int userId);
}
