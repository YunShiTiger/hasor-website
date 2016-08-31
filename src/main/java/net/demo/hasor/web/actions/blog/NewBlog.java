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
package net.demo.hasor.web.actions.blog;
import net.demo.hasor.core.Action;
import net.demo.hasor.web.forms.LoginCallBackForm;
import net.hasor.restful.FileItem;
import net.hasor.restful.api.Async;
import net.hasor.restful.api.MappingTo;
import net.hasor.restful.api.Params;
import net.hasor.restful.api.Valid;

import java.io.File;
import java.io.IOException;
/**
 * OAuth : 服务器获取 AccessToken
 * @version : 2016年1月1日
 * @author 赵永春(zyc@hasor.net)
 */
@Async
@MappingTo("/blog/save.do")
public class NewBlog extends Action {
    //
    public void execute() throws IOException {
        //
        FileItem fileItem = this.getOneMultipart("sss");
        if (fileItem == null) {
            return;
        }
        //
        if (fileItem.isFormField()) {
            System.out.println("Form field " + fileItem.getFieldName() + " with value " + fileItem.getString() + " detected.");
        } else {
            String fileName = fileItem.getName();
            String fileDir = this.getAppContext().getEnvironment().getPluginDir(NewBlog.class);
            fileItem.writeTo(new File(fileDir, fileName));
            System.out.println("File field " + fileItem.getFieldName() + " with file name " + fileName + " detected.");
        }
        fileItem.deleteOrSkip();
    }
}