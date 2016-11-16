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
package net.hasor.website.utils;
import com.alibaba.fastjson.JSON;

import java.util.Map;
/**
 * @version : 2016年1月10日
 * @author 赵永春(zyc@hasor.net)
 */
public class JsonUtils {
    //
    /** json结果输出在一行中 */
    public static String toJsonStringSingleLine(Object obj) {
        return JSON.toJSONString(obj);
    }
    //
    /**  */
    public static <T> T toObject(String jsonData, Class<T> targetClass) {
        return JSON.parseObject(jsonData, targetClass);
    }
    /**  */
    public static Map<String, Object> toMap(String jsonData) {
        return JSON.parseObject(jsonData);
    }
}
