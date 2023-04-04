package com.compact.info.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class AopLogging {

    // 서비스 이하 패키지의 모든 클래스 메서드 적용
    @Pointcut("execution(* com.compact.info.*.service..*.*(..))")
    private void cut(){}

    @Before("cut()")
    public void beforeParameterLog(JoinPoint joinPoint){
        Method method = getMethod(joinPoint);
        log.info("============== Method Call : {} ==============", method.getName());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("Parameter Info : ({}) {}", arg.getClass().getSimpleName(), arg);
        }
    }

    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturnLog(JoinPoint joinPoint, Object returnObj) {
        if (returnObj != null) {
            log.info("Return Value Info : ({}) {}", returnObj.getClass().getSimpleName(), returnObj);
        }
        Method method = getMethod(joinPoint);
        log.info("============== Method End : {} ==============", method.getName());
    }

    private Method getMethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        return signature.getMethod();
    }
}
