package com.portal.aop.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Artem Karnov @date 25.01.2017.
 *         artem.karnov@t-systems.com
 **/
@Component
@Aspect
public class GetAllLoggingAspectHandler {
    private static Logger logger = LogManager.getLogger(GetAllLoggingAspectHandler.class);

    @Pointcut("execution(* com.portal.services.api.*.getAll())")
    public void getEntityPointcut() {
    }


    @Before("getEntityPointcut()")
    public void loggingBeforeGettingAllEntities(JoinPoint joinPoint) {
        logger.info(String.format("A method: {%s} is invoking, arguments: {%s}",
                joinPoint.toString(), Arrays.toString(joinPoint.getArgs())));
    }

}
