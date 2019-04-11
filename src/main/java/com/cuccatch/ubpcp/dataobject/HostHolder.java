package com.cuccatch.ubpcp.dataobject;


import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private static ThreadLocal<UserDO> users = new ThreadLocal<>();

    public UserDO getUser() {
        return users.get();
    }

    public void setUser(UserDO userDO) {
        users.set(userDO);
    }

    public void clear() {
        users.remove();
    }
}
