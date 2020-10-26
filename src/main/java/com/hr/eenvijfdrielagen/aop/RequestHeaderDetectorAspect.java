package com.hr.eenvijfdrielagen.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Aspect
@Component
public class RequestHeaderDetectorAspect {

    @Pointcut("@annotation(requestHeaderDetector)")
    private boolean hasRequestHeader(RequestHeaderDetector requestHeaderDetector) {
        HttpServletRequest request = currentRequest();

        if (Objects.isNull(request)) {
            return false;
        }

        String[] headerNames = requestHeaderDetector.headerNames();

        for (String headerName : headerNames) {
            String value = request.getHeader(headerName);
            if (StringUtils.hasText(value)) {
                log.info("De gevraagde header is aanwezig");
                return true;
            }
        }
        return false;
    }

    @Around("hasRequestHeader()")
    public void logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        final long executionTime = System.currentTimeMillis() - start;
        log.trace(joinPoint.getSignature() + " executed in " + executionTime + "ms");
    }

    private HttpServletRequest currentRequest() {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable(servletRequestAttributes)
                .map(ServletRequestAttributes::getRequest)
                .orElse(null);
    }
}
