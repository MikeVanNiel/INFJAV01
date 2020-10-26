package com.hr.eenvijfdrielagen.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;


@Slf4j
@Aspect
@Component
public class RequestHeaderDetectorAspect {

    @Around("@annotation(requestHeaderDetector) && args(request)")
    public void logExecutionTime(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable {

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();

            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            RequestHeaderDetector myAnnotation = method.getAnnotation(RequestHeaderDetector.class);
            String value = myAnnotation.value();

            if (StringUtils.hasText(value)) {
                final long start = System.currentTimeMillis();
                Object proceed = joinPoint.proceed();
                final long executionTime = System.currentTimeMillis() - start;
                log.trace(joinPoint.getSignature() + " executed in " + executionTime + "ms");
            }
        }
    }

}
