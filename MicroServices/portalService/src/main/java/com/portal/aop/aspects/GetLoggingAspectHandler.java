package com.portal.aop.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
@Component
@Aspect
public class GetLoggingAspectHandler {
    private static Logger logger = LogManager.getLogger(GetLoggingAspectHandler.class);

    @Pointcut("execution(* com.portal.services.api.*.getAll())")
    public void getAllEntitiesPointcut() {
    }

    @Pointcut("execution(* com.portal.services.api.*.createEntity())")
    public void getCreateEntityPointcut() {
    }

    @Pointcut("execution(* com.portal.services.api.*.getEntityById())")
    public void getEntityByIdPointcut() {
    }

    @Pointcut("execution(* com.portal.services.api.*.updateEntity())")
    public void getUpdateEntityPointcut() {
    }

    @Pointcut("execution(* com.portal.services.api.*.deleteEntity())")
    public void getDeleteEntityPointcut() {
    }

    @Pointcut("execution(* com.portal.services.api.*.get*By*())")
    public void getEntityByPointcut() {
    }


    @Before("getAllEntitiesPointcut()")
    public void loggingBeforeGettingAllEntities(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

    @Around("getAllEntitiesPointcut()")
    public Object loggingAroundGettingAllEntities(ProceedingJoinPoint proceedingJoinPoint) {
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info(String.format("After invoking {%s} method. Return value=" + value,
                proceedingJoinPoint.getSignature()));
        return value;
    }

}
