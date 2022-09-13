package com.liyijun.jk.log;

import com.alibaba.fastjson.JSON;
import com.liyijun.jk.common.CommonBizException;
import com.liyijun.jk.common.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Aspect
@Component
public class LogAspect {


    /** 定义切入点为：@RestController中所有的public方法*/
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController) && execution(public * *(..) )")
    public void pointcut(){}

    /** 切入方式为 环绕*/
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point){
        Object object;
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(
                RequestContextHolder.getRequestAttributes())).getRequest();
        String num = String.valueOf(RandomUtils.nextInt(1, 1000000000));
        log.info("[{}] method--{}",num,request.getRequestURI());
        Object[] args = point.getArgs();
        logParam(args,num,request);
        try {
            // 校验请求参数
//            if(args!=null&&args.length==1){
//                Validation.valid(args[0]);
//            }
            object = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            if(e instanceof CommonBizException){
                object = R.failed(e.getMessage());
            } else{
                object = R.failed(e.getMessage());
//                object = R.failed("data error");
                log.error("[{}]  request error: {}\n{}",num,e.getCause(),e);
            }
        }
        log.info("[{}] result--{}",num, JSON.toJSONString(object));
        return object;
    }

    private void logParam(Object[] args,String num, HttpServletRequest request){
        Stream<Object> stream = ArrayUtils.isEmpty(args) ? Stream.empty() : Arrays.stream(args);
        List<Object> logArgs = stream
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        try{
            log.info("[{}] param---{} {}",num,JSON.toJSONString(logArgs),request.getQueryString());
        }catch (Exception e){
            log.info("[{}] param---{}",num,request.getQueryString());
        }

    }
}

