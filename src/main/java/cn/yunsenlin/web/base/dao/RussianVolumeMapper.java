package cn.yunsenlin.web.base.dao;

import cn.yunsenlin.web.base.model.RussianVolume;
import cn.yunsenlin.web.base.model.RussianVolumeKey;

public interface RussianVolumeMapper {
    int deleteByPrimaryKey(RussianVolumeKey key);

    int insert(RussianVolume record);

    int insertSelective(RussianVolume record);

    RussianVolume selectByPrimaryKey(RussianVolumeKey key);

    int updateByPrimaryKeySelective(RussianVolume record);

    int updateByPrimaryKey(RussianVolume record);
}