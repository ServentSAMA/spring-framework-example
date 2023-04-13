package com.example.security.config.util;


import com.alibaba.fastjson.JSON;
import com.example.security.config.base.HttpStatusEnum;
import com.example.security.config.base.RequestResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author Shen
 * @date 2022/6/8 11:10
 **/
public class ResponseUtil {

    public static void response(HttpServletResponse response, HttpStatusEnum httpStatusEnum) throws IOException {
        RequestResult requestResult = RequestResult.error(httpStatusEnum);
        String jsonObject = JSON.toJSONString(requestResult);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jsonObject);
        response.setStatus(httpStatusEnum.getCode());
    }
}
