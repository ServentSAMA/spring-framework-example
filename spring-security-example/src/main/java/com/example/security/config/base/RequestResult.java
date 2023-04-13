package com.example.security.config.base;


import lombok.Data;

/**
 * 通用返回类
 *
 * @param <T>
 * @author 申传彪
 */
@Data
public class RequestResult<T> {

    private Integer code = 0;

    private Object data;

    private Boolean success = true;

    private String message;

    private Long timestamp = System.currentTimeMillis();

    /**
     * 请求成功返回结果
     *
     * @return
     */
    public static <T> RequestResult<T> ok(Integer code, String message, T object, Long timestamp) {
        RequestResult<T> result = new RequestResult<>();
        result.setCode(HttpStatusEnum.STATUS_200.getCode());
        result.setMessage(message);
        result.setData(object);
        result.setTimestamp(timestamp);
        return result;
    }

    /**
     * 请求成功返回结果
     *
     * @return
     */
    public static <T> RequestResult<T> ok() {
        return ok(HttpStatusEnum.STATUS_200.getCode(), HttpStatusEnum.STATUS_200.getMessage(), null, System.currentTimeMillis());
    }

    /**
     * 请求成功返回结果，返回数据
     *
     * @param data
     * @return
     */
    public static <T> RequestResult<T> ok(T data) {
        return ok(HttpStatusEnum.STATUS_200.getCode(), HttpStatusEnum.STATUS_200.getMessage(), data, System.currentTimeMillis());
    }

    /**
     * 请求成功返回结果，返回消息
     *
     * @param message
     * @return
     */
    public static <T> RequestResult<T> ok(String message) {
        RequestResult<T> result = new RequestResult<>();
        result.setCode(HttpStatusEnum.STATUS_200.getCode());
        result.setMessage(message);
        return ok(HttpStatusEnum.STATUS_200.getCode(), message, null, System.currentTimeMillis());
    }

    /**
     * 请求成功返回结果，返回消息和数据
     *
     * @param message
     * @param data
     * @return
     */
    public static <T> RequestResult<T> ok(String message, T data) {
        return ok(HttpStatusEnum.STATUS_200.getCode(), message, data, System.currentTimeMillis());
    }

    /**
     * 失败返回结果，返回消息
     *
     * @return
     */
    public static <T> RequestResult<T> error(String message) {
        RequestResult<T> result = new RequestResult<>();
        result.setCode(HttpStatusEnum.STATUS_500.getCode());
        result.setMessage(message);
        return result;
    }

    /**
     * 错误返回结果，返回错误码和消息
     *
     * @param code
     * @param message
     * @return
     */
    public static <T> RequestResult<T> error(Integer code, String message) {
        RequestResult<T> result = new RequestResult<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 错误返回结果，返回错误码和消息
     *
     * @param httpStatusEnum
     * @return
     */
    public static <T> RequestResult<T> error(HttpStatusEnum httpStatusEnum) {
        RequestResult<T> result = new RequestResult<>();
        result.setCode(httpStatusEnum.getCode());
        result.setMessage(httpStatusEnum.getMessage());
        return result;
    }

    /**
     * 未登录返回结果
     *
     * @param message
     * @return
     */
    public static <T> RequestResult<T> noAuth(String message) {
        return error(HttpStatusEnum.STATUS_401.getCode(), message);
    }

    /**
     * 无权限返回结果
     *
     * @param message
     * @return
     */
    public static <T> RequestResult<T> noPermission(String message) {
        return error(HttpStatusEnum.STATUS_403.getCode(), message);
    }
}
