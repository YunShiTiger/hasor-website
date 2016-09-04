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
package net.demo.hasor.manager;
import net.demo.hasor.core.Service;
import net.hasor.core.Inject;
import net.hasor.core.InjectSettings;
import net.hasor.core.Singleton;
import org.more.util.StringUtils;

import javax.servlet.ServletContext;
/**
 *
 * @version : 2016年1月10日
 * @author 赵永春(zyc@hasor.net)
 */
@Singleton
@Service("env")
public class EnvironmentConfig {
    @InjectSettings("appExample.curentVersion")
    private String         curentVersion;
    @InjectSettings("appExample.envType")
    private String         envType;
    @InjectSettings("appExample.hostName")
    private String         hostName;
    @InjectSettings("aliyun.bucketPath")
    private String         bucketPath;
    @InjectSettings("aliyun.bucketName")
    private String         bucketName;
    @InjectSettings("uploader.maxSize")
    private int            maxSize;
    @Inject
    private ServletContext servletContext;
    //
    /**当前软件最近版本*/
    public String getCurentVersion() {
        return this.curentVersion;
    }
    //
    /**当前所属环境*/
    public String getEnvType() {
        return this.envType;
    }
    //
    /**是否为日常开发环境*/
    public boolean isDaily() {
        return StringUtils.equalsBlankIgnoreCase("daily", this.envType);
    }
    //
    /**主机地址*/
    public String getHostName() {
        return this.hostName;
    }
    //
    /**Bucket名称*/
    public String getBucketName() {
        return this.bucketName;
    }
    //
    /**保存上传文件的基础地址*/
    public String getBucketPath() {
        return this.bucketPath;
    }
    //
    /**获取静态文件host地址*/
    public String getStaticFilesHost() {
        if (this.isDaily()) {
            //
            return "//files.hasor.net";
        } else {
            //
            return "//files.hasor.net";
        }
    }
    //
    /**文件上传最大大小*/
    public int getMaxSize() {
        return this.maxSize;
    }
}