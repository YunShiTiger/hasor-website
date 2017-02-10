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
import net.hasor.plugins.junit.ContextConfiguration;
import net.hasor.plugins.junit.HasorUnitRunner;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @version : 2016年1月10日
 * @author 赵永春(zyc@hasor.net)
 */
@ContextConfiguration(value = "hasor-config.xml", loadModules = TestModule.class)
@RunWith(HasorUnitRunner.class)
public class AbstractTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Before
    public void init() {
        //
    }
}