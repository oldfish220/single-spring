package cn.oldfish.springframework.beans;

import cn.oldfish.springframework.beans.facotry.*;
import cn.oldfish.springframework.context.ApplicationContext;
import cn.oldfish.springframework.context.ApplicationContextAware;

public class UserService {

    private String uId;
    private String company;
    private String location;
    private String scale;
    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + ", " + company + ", " + location + ", " + scale;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}