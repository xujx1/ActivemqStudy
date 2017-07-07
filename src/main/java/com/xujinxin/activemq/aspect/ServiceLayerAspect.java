package com.xujinxin.activemq.aspect;

import com.xujinxin.activemq.commons.exception.handler.ExceptionHandlerUtil;
import com.xujinxin.activemq.utils.JsonUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by xujinxin on 2017/7/7.
 * 切面日志打印
 */
@Component
@Aspect
public class ServiceLayerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLayerAspect.class);


    /*Module层统一切面，做事务，执行时间统计，异常处理*/
    @Pointcut(value = "execution(* com.xujinxin.activemq.service..*.impl.*.*(..)) " +
            "&& !@annotation(com.xujinxin.activemq.annotation.IgnoreLog)")
    public void performance() {

    }


    /*前置通知，打印入参信息*/
    @Before(value = "performance()")
    public void before(JoinPoint joinPoint) {
        StringBuilder logMsg = new StringBuilder(128);
        logMsg.append("===").append(joinPoint.getTarget().getClass().getSimpleName());
        logMsg.append(".").append(joinPoint.getSignature().getName());
        logMsg.append("[params]==>");

        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            logMsg.append("no param");
        } else {
            for (int index = 0; index < args.length; index++) {
                try {
                    logMsg.append(JsonUtil.toString(args[index]));
                } catch (Exception e) {
                    logMsg.append("convert to json error,error msg:").append(e.getMessage());
                }
                if (index < (args.length - 1)) {
                    logMsg.append(",");
                }
            }
        }
        logMsg.append(")");
        LOGGER.info(logMsg.toString());
    }

    /*环绕通知，统计执行时间*/
    @Around(value = "performance()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // Module执行后的返回参数
        Object result;

        // 记录Module执行时间
        long start = 0;
        long end;

        // 执行时长日志
        StringBuilder logMsg = new StringBuilder(128);
        try {
            logMsg.append("===").append(pjp.getTarget().getClass().getSimpleName());
            logMsg.append(".").append(pjp.getSignature().getName());

            start = System.currentTimeMillis();
            result = pjp.proceed();
            end = System.currentTimeMillis();

            logMsg.append("[finish,cost]==>").append(end - start).append("ms.");
            LOGGER.info(logMsg.toString());
        } catch (Throwable e) {
            end = System.currentTimeMillis();
            logMsg.append("[error,cost]==>").append(end - start).append("ms.");
            LOGGER.error(logMsg.toString());
            throw e;
        }
        return result;
    }

    /*参数返回通知，打印返回参数*/
    @AfterReturning(value = "performance()", returning="returnArg")
    public void afterReturning(JoinPoint joinPoint, Object returnArg) {
        StringBuilder logMsg = new StringBuilder(128);
        logMsg.append("===").append(joinPoint.getTarget().getClass().getSimpleName());
        logMsg.append(".").append(joinPoint.getSignature().getName());
        logMsg.append("[returnValue]==>");
        try {
            logMsg.append(JsonUtil.toString(returnArg));
            LOGGER.info(logMsg.toString());
        } catch (Exception e) {
            logMsg.append("convert to json error,error msg:").append(e.getMessage());
            LOGGER.error(logMsg.toString());
        }
    }

   /*异常通知，打印异常信息，统一转换异常*/
    @AfterThrowing(value ="performance()", throwing="cause")
    public void afterThrowing(JoinPoint joinPoint, Throwable cause) {
        String logMsg = "===" + joinPoint.getTarget().getClass().getSimpleName() +
                "." + joinPoint.getSignature().getName() +
                "[exception]==>";
        LOGGER.error(logMsg, cause);
        ExceptionHandlerUtil.wrapAndThrowServiceException(cause);
    }
}
