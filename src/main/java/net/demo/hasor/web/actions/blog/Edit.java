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
import net.demo.hasor.domain.ContentCategoryDO;
import net.demo.hasor.domain.enums.ContentType;
import net.demo.hasor.manager.CategoryManager;
import net.hasor.core.Inject;
import net.hasor.restful.api.MappingTo;
import net.hasor.restful.api.PathParam;
import net.hasor.restful.api.ReqParam;
import org.more.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * blog页面
 * @version : 2016年1月1日
 * @author 赵永春(zyc@hasor.net)
 */
@MappingTo("/blog/edit.{action}")
public class Edit extends Action {
    @Inject
    private CategoryManager categoryManager;
    //
    public void execute(@PathParam("action") String action, @ReqParam("content_id") long contentID) throws IOException {
        if (StringUtils.equalsIgnoreCase(action, "htm")) {
            if (contentID > 0) {
                this.showBlog(contentID);
                return;
            } else {
                this.newBlog();
                return;
            }
        } else {
            if (contentID > 0) {
                this.updateBlog(contentID);
                return;
            } else {
                this.createBlog();
                return;
            }
        }
    }
    //
    /**准备开始写一篇新的Blog*/
    private void newBlog() {
        //
        long curUser = this.getUserID();
        List<ContentCategoryDO> categoryList = categoryManager.queryListByUser(curUser);
        if (categoryList == null || categoryList.isEmpty()) {
            categoryList = new ArrayList<ContentCategoryDO>(0);
        }
        this.putData("csrfToken", this.csrfTokenString());
        this.putData("categoryList", categoryList);
        this.putData("contentTypeList", Arrays.asList(ContentType.values()));
        //
    }
    /**查询Blog并展现到页面上*/
    private void showBlog(long contentID) {
        this.newBlog();
        //
    }
    /**更新Blog内容*/
    private void updateBlog(long contentID) {
    }
    /**保存成一个新的 blog内容*/
    private void createBlog() {
        //
    }
}