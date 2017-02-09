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
package net.hasor.website.domain.beans;
/**
 *
 * @version : 2016年1月11日
 * @author 赵永春(zyc@hasor.net)
 */
public interface AppConstant {
    public static final String DB_HSQL                     = "HSQL";
    public static final String DB_MYSQL                    = "MYSQL";
    //
    public static final String CACHE_USER                  = "CACHE_USER";
    //
    public static final String SESSION_KEY_USER            = "user_id";
    public static final String SESSION_KEY_USER_AVATAR     = "user_avatar";
    public static final String SESSION_KEY_CSRF_TOKEN      = "csrfTokenString";
    public static final String SESSION_KEY_TARGET_USER_ID  = "target_user_id";
    public static final String SESSION_KEY_TARGET_PROVIDER = "target_privider";
    //
    public static final String REQ_PARAM_KEY_CSRF_TOKEN    = "csrfToken";
    //
    public static final String VAR_CONTEXT_PATH            = "ctx_path";
    public static final String VAR_REQUEST                 = "request";
    //
    public static final long   OneHourTime                 = 1 * 60 * 60 * 1000;
    public static final long   SevenDaysTime               = 7 * 24 * OneHourTime;
}
