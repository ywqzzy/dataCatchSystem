package com.cuccatch.ubpcp.converter;

import com.cuccatch.ubpcp.dataobject.UserDO;
import com.cuccatch.ubpcp.service.model.UserModel;
import org.springframework.beans.BeanUtils;

public class UserConverter {

    public static UserModel convertFromDataObject(UserDO userDO) {
        if(userDO==null) return null;
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        return userModel;
    }
}
