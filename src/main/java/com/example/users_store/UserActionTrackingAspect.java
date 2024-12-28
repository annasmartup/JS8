package com.example.users_store;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class UserActionTrackingAspect {
    private static final Logger logger = LoggerFactory.getLogger(UserActionTrackingAspect.class);

    @Before("@annotation(com.example.users_store.TrackUserAction)")
    public void trackUserAction(JoinPoint joinPoint) {
        String user = "currentUser";
        String methodName = joinPoint.getSignature().toString();
        Object[] args = joinPoint.getArgs();

        logger.info("User {} invoked method {} with arguments: {}", user, methodName, Arrays.toString(args));
    }
}
