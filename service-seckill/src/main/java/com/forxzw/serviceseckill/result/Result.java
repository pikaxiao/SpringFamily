package com.forxzw.serviceseckill.result;

import lombok.Builder;
import lombok.Data;

/**
 * 返回结果封装
 * @param <T> T
 * @date 2019/5/8
 * @author xzw
 */
@Data
@Builder
public class Result<T> {

	/**
	 * 编码
	 */
	private Integer code;

	/**
	 * 信息
	 */
	private String msg;

	/**
	 * 数据
	 */
	private T data;

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

	/**
	 * 成功
	 * @param data 数据
	 * @param <T> T
	 * @return 结果
	 */
	public static <T> Result<T> success(T data){
		return new Result<>(CodeMsg.SUCCESS.getCode(),CodeMsg.SUCCESS.getMsg(),data);
	}

    /**
     * 成功
     * @return 结果
     */
    public static Result success(){
        return new Result<>(CodeMsg.SUCCESS.getCode(),CodeMsg.SUCCESS.getMsg());
    }

	/**
	 * 失败
	 * @param <T> T
	 * @return 结果
	 */
	public static <T> Result<T> error(CodeMsg msg){
		return new Result<>(msg.getCode(),msg.getMsg());
	}

}
