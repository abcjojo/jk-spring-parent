package com.liyijun.jk.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

/**
 * 业务异常
 * @author wl
 * @date 2022/6/21 19:37
 */
public class CommonBizException extends RuntimeException {

    /** 是否包含msg*/
    public static final int HAS_MSG = 1;

    /** 异常编号*/
    private int exceptionCode = 0;

    //构造方法
    public CommonBizException() {
        super();
    }
    public CommonBizException(String message, Throwable cause) {
        super(message, cause);
    }
    public CommonBizException(Integer exCode, String message) {
        super(message);
        this.exceptionCode = exCode;
    }
    public CommonBizException(String message) {
        this(HAS_MSG, message);
    }
    public CommonBizException(Throwable cause) {
        super(cause);
    }

    /**
     *
     * @param message 如果消息内容格式化，格式如：{0}是主体消息{1}
     * @param arguments 消息内容填充参数
     */
    public CommonBizException(String message, Object... arguments) {
        super(formatMessage(message, arguments));
    }

    /**
     *
     * @param message 如果消息内容格式化，格式如：{0}是主体消息{1}
     * @param cause 异常原因
     * @param arguments 消息内容填充参数
     */
    private CommonBizException(String message, Throwable cause, Object... arguments) {
        super(formatMessage(message, arguments), cause);
    }

    /**
     *
     * @param pattern 格式如：消息内容为:{0}{1}
     * @param arguments 其他参数
     * @return String
     */
    private static String formatMessage(String pattern,Object... arguments){
        if(pattern==null||pattern.length()==0){
            return pattern;
        }
        return MessageFormat.format(pattern, arguments);
    }

    /**
     * 默认值为空字符串""
     * @return 异常编号
     */
    public int getExceptionCode() {
        return exceptionCode;
    }

    /**
     * @param exceptionCode 异常编号
     */
    public void setExceptionCode(Integer exceptionCode) {
        this.exceptionCode = exceptionCode==null?0:exceptionCode;
    }

    /**
     * 获取异常的堆栈信息
     * @param e Exception
     * @return String
     */
    public static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            return sw.toString();
        }
    }
}
