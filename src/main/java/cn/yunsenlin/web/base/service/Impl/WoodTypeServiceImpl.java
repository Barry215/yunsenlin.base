package cn.yunsenlin.web.base.service.Impl;

import cn.yunsenlin.web.base.dao.WoodTypeMapper;
import cn.yunsenlin.web.base.model.WoodType;
import cn.yunsenlin.web.base.service.WoodTypeService;


public class WoodTypeServiceImpl implements WoodTypeService {
    private final WoodTypeMapper woodTypeMapper;

    public WoodTypeServiceImpl(WoodTypeMapper woodTypeMapper) {
        this.woodTypeMapper = woodTypeMapper;
    }

    @Override
    public boolean hasTypeCode(String typeCode) {
        WoodType woodType = woodTypeMapper.selectByPrimaryKey(typeCode);
        return woodType!=null;
    }
}
