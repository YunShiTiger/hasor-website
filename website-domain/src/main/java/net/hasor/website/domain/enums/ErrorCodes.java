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
package net.hasor.website.domain.enums;
import net.hasor.website.domain.MessageTemplateString;
import org.more.bizcommon.Message;
import org.more.bizcommon.MessageTemplate;
/**
 *
 * @version : 2016年1月1日
 * @author 赵永春(zyc@hasor.net)
 */
public enum ErrorCodes {
    // .用户系统
    U_SAVE_USER_EXIST(1, "登陆账号已经被占用，请更换一个再试。"),//
    U_GET_USER_NOT_EXIST(2, "对不起错误的用户ID，该用户不存在。"),//
    U_GET_USER_FAILED(3, "用户数据查询失败，请重试。"),//
    U_SAVE_USER_FAILED(4, "保存或更新用户失败。"),//
    U_SAVE_SOURCE_FAILED(5, "保存或更新登陆方式失败。"),//
    U_PROIVTER_EXIST(6, "您已经绑定了同类型账号，或者您先行解绑在重新绑定。"),//
    U_PROIVTER_MAST_UNBIND(7, "另账号正在使用它，请先解除绑定之后在操作。"),//
    U_PROIVTER_REBIND_FAILED(8, "绑定登陆方式失败，请重试或联系管理员。"),//
    U_UPDATE_FAILED(9, "账号更新失败，请重试或联系管理员。"),//
    U_NEED_LOGIN(10, "请先登录。"),//
    //
    // .外部登陆接入
    OA_PROIVTER_NOT_EXIST(101, "抱歉我们不支持这种方式的第三方登陆。"),//
    OA_TOKEN_EXT_ERROR(102, "OAuth方式登陆，登陆失败。"),//
    OA_TOKEN_EXT_EMPTY(103, "OAuth方式登陆，第三方合作网站没有结果。请重试或联系管理员。"),//
    OA_TOKEN_EXT_FAILED(104, "OAuth方式登陆，第三方合作网站验证失败，请重试。"),//
    OA_ERROR(105, "OAuth登陆系统内部错误，请重试或联系管理员。"),//
    //
    //
    LOGIN_ERROR(106, "登陆出错，请重试或联系管理员。"),//
    //
    // .表单验证
    V_OAUTH_CALLBACK_FAILED(201, "合作网站登陆回调验证失败。"),//
    V_TOKEN_NEED_LOGIN(202, "token已过期,请重新登录。"),//
    V_CSRF_INVALID(203, "请重新登陆，或者这是一个非法的请求。"),//
    //
    BAD_REQUEST(901, "错误的请求。"),//
    BAD_UNKNOWN(902, "未知类型异常: %s");
    //
    //
    private MessageTemplate temp = null;
    ErrorCodes(int errorCode, String message) {
        this.temp = new MessageTemplateString(errorCode, message);
    }
    //
    public Message getMsg(Object... params) {
        return new Message(this.temp, params);
    }
}