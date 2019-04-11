package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.UserBrowseDO;
import com.cuccatch.ubpcp.service.model.UserBrowseModel;
import org.springframework.beans.BeanUtils;

public class UserBrowseConverter {
    public static UserBrowseDO convertFromModel(UserBrowseModel UserBrowseModel) {
        if(UserBrowseModel==null) return null;
        UserBrowseDO UserBrowseDO = new UserBrowseDO();
        BeanUtils.copyProperties(UserBrowseModel,UserBrowseDO);
        return UserBrowseDO;
    }
}
