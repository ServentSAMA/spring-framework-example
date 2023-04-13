package com.example.security.config.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Http返回状态类
 *
 * @author 申传彪
 */
@Getter
@AllArgsConstructor
public enum HttpStatusEnum {
    /**
     * Http200请求
     */
    STATUS_200(200, "请求成功"),
    /**
     * Http302请求
     */
    STATUS_302(302, "重定向"),
    /**
     * Http401请求
     */
    STATUS_401(401, "请先登录！"),
    /**
     * Http401请求
     */
    STATUS_401_TOKEN(401, "Token过期，请重新登录！"),
    /**
     * Http403请求
     */
    STATUS_403(403, "权限不足，请联系管理员！"),
    /**
     * Http404请求
     */
    STATUS_404(404, "找不到页面！"),
    /**
     * Http500请求
     */
    STATUS_500(500, "服务器错误！"),
    /**
     * 用户未注册
     */
    AUTH_USER_NOTFOUND(401, "用户未注册！"),
    /**
     * 用户密码错误
     */
    AUTH_USER_PASSWORD_FAIL(401, "用户密码错误！");
    private Integer code;
    private String message;


}
