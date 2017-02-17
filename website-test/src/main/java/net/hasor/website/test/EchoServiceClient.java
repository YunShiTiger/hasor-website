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
package net.hasor.website.test;
import hprose.common.ByRef;
import hprose.common.HproseResultMode;
import hprose.common.MethodName;
import hprose.common.ResultMode;

import java.util.List;
/**
 * 服务接口
 * @version : 2017年02月11日
 * @author 赵永春(zyc@hasor.net)
 */
public interface EchoServiceClient {
    @ByRef
    @MethodName("call://[RSF]net.hasor.website.client.EchoService-1.0.0/sortList")
    @ResultMode(HproseResultMode.Normal)
    public void sort(List<String> stringList);
}