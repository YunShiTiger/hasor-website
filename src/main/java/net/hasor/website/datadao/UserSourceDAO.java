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
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.website.datadao;
import net.hasor.website.core.AbstractDao;
import net.hasor.website.domain.UserSourceDO;
import org.more.bizcommon.log.LogUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @version : 2016年08月08日
 * @author 赵永春(zyc@hasor.net)
 */
public class UserSourceDAO extends AbstractDao {
    //
    /** 新增登录类型 */
    public int insertUserSource(UserSourceDO sourceDO) throws SQLException {
        try {
            int result = this.getSqlExecutor().insert("userSource_insert", sourceDO);
            return result;
        } catch (SQLException e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("user_source_dao : insertUserSource error -> " + e.getMessage()).toJson());
            throw e;
        }
    }
    //
    /** 根据提供商和外部唯一ID,查询登录信息 */
    public UserSourceDO queryByUnique(String provider, String uniqueID) throws SQLException {
        try {
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("provider", provider);
            parameter.put("uniqueID", uniqueID);
            UserSourceDO result = this.getSqlExecutor().selectOne("userSource_queryByUnique", parameter);
            return result;
        } catch (SQLException e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("user_source_dao : queryByUnique error -> " + e.getMessage()).toJson());
            throw e;
        }
    }
    //
    /** 登录更新 */
    public int loginUpdateByUserID(String provider, long userID) throws SQLException {
        try {
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("provider", provider);
            parameter.put("userID", userID);
            int result = this.getSqlExecutor().update("userSource_loginUpdateByUserID", parameter);
            return result;
        } catch (SQLException e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("user_source_dao : loginUpdateByUserID error -> " + e.getMessage()).toJson());
            throw e;
        }
    }
    //
    /** 更新基础信息 */
    public int updateUserSource(String provider, long userID, UserSourceDO sourceDO) throws SQLException {
        try {
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("provider", provider);
            parameter.put("userID", userID);
            parameter.put("sourceInfo", sourceDO);
            int result = this.getSqlExecutor().update("userSource_updateInfo", parameter);
            return result;
        } catch (SQLException e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("user_source_dao : updateUserSource error -> " + e.getMessage()).toJson());
            throw e;
        }
    }
    //
    /** 获取帐号绑定的所有第三方帐号*/
    public List<UserSourceDO> queryListByUserID(long userID) throws SQLException {
        try {
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("userID", userID);
            List<UserSourceDO> result = this.getSqlExecutor().selectList("userSource_queryListByUserID", parameter);
            return result;
        } catch (SQLException e) {
            logger.error(LogUtils.create("ERROR_999_0003").logException(e) //
                    .addString("user_source_dao : updateUserSource error -> " + e.getMessage()).toJson());
            throw e;
        }
    }
}
