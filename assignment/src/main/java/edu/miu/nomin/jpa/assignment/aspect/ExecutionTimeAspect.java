package edu.miu.nomin.jpa.assignment.aspect;

import edu.miu.nomin.jpa.assignment.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    LoggerService loggerService;

    @Around("@annotation(edu.miu.nomin.jpa.assignment.annotation.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        String methodName = joinPoint.getSignature().toShortString();
        String logMessage = methodName + " executed in " + duration + " nanoseconds";

        loggerService.logOperation(logMessage);

        return result;
    }
}
