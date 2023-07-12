package com.example.restfulapplication.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class HighPrioritizedAspect {
}
