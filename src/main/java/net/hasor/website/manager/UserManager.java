/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.website.manager;
import net.hasor.core.Inject;
import net.hasor.core.Singleton;
import net.hasor.db.Transactional;
import net.hasor.website.datadao.UserDAO;
import net.hasor.website.datadao.UserSourceDAO;
import net.hasor.website.domain.UserDO;
import net.hasor.website.domain.UserSourceDO;
import org.more.bizcommon.log.LogUtils;
import org.more.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;
/**
 * 用户Manager
 * @version : 2016年1月10日
 * @author 赵永春(zyc@hasor.net)
 */
@Singleton
public class UserManager {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Inject
    private UserSourceDAO userSourceDAO;
    @Inject
    private UserDAO       userDAO;
    //
    public UserDO getUserByProvider(String provider, String uniqueID) throws SQLException {
        UserSourceDO sourceDO = this.userSourceDAO.queryByUnique(provider, uniqueID);
        if (sourceDO == null || sourceDO.getUserID() <= 0) {
            return null;
        }
        UserDO userDO = this.userDAO.queryById(sourceDO.getUserID());
        if (userDO == null) {
            return null;
        }
        return userDO;
    }
    public UserDO getUserByID(long userID) {
        if (userID <= 0) {
            return null;
        }
        try {
            return this.userDAO.queryById(userID);
        } catch (Exception e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("UserManager : getUserByID error -> " + e.getMessage()).toJson());
            return null;
        }
    }
    //
    public UserDO queryByLogin(String login) {
        if (StringUtils.isBlank(login)) {
            return null;
        }
        try {
            return this.userDAO.queryByLogin(login);
        } catch (Exception e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("UserManager : queryByLogin error -> " + e.getMessage()).toJson());
            return null;
        }
    }
    public UserDO getFullUserDataByID(long userID) {
        UserDO userDO = getUserByID(userID);
        if (userDO == null) {
            return null;
        }
        try {
            List<UserSourceDO> sourceList = this.userSourceDAO.queryListByUserID(userID);
            if (sourceList != null) {
                userDO.setUserSourceList(sourceList);
            }
        } catch (Exception e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("UserManager : getFullUserDataByID error -> " + e.getMessage()).toJson());
        }
        return userDO;
    }
    //
    //
    @Transactional
    public long newUser(UserDO userDO) throws SQLException {
        // 1. 保存用户数据 2. 保存携带的外部登录信息数据
        int userResult = this.userDAO.insertUser(userDO);
        if (userResult > 0) {
            List<UserSourceDO> sourceList = userDO.getUserSourceList();
            if (sourceList != null) {
                for (UserSourceDO sourceDO : sourceList) {
                    sourceDO.setUserID(userDO.getUserID());
                    //
                    int sourceResult = this.userSourceDAO.insertUserSource(sourceDO);
                    if (sourceResult <= 0) {
                        throw new IllegalStateException("登录信息保存失败。");
                    }
                }
            }
        }
        return userDO.getUserID();
    }
    @Transactional
    public int updateAccessInfo(UserDO userDO, String provider, UserSourceDO result) throws SQLException {
        return this.userSourceDAO.updateUserSource(provider, userDO.getUserID(), result);
    }
    @Transactional
    public void loginUpdate(UserDO userDO, String provider) {
        try {
            this.userDAO.loginUpdate(userDO.getUserID());
            if (StringUtils.isNotBlank(provider)) {
                this.userSourceDAO.loginUpdateByUserID(provider, userDO.getUserID());
            }
        } catch (Exception e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("loginUpdate : " + e.getMessage()).toJson());
        }
    }
}