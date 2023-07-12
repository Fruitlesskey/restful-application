package com.example.restfulapplication.aspects;

import com.example.restfulapplication.entity.Employee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class EmployeeAspect {
    @Pointcut("execution(* getEmployeeById(..))")
    public void getEmployeeByIdPointCut() {

    }

    @Before("target(com.example.restfulapplication.controller.EmployeeController)")
    public void adviceGetEmployeeById(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println(signature.getName());
    }

    @After("getEmployeeByIdPointCut()")
    public void adviceAfterGetEmployeeById() {
        System.out.println("This advice after method getByID()");
    }

    @AfterReturning(value = "getEmployeeByIdPointCut()", returning = "employee")
    public void afterGettingEmployee(Employee employee) {
        System.out.println("First name: " + employee.getFirstName());
    }

    @AfterThrowing(value = "getEmployeeByIdPointCut()", throwing = "exception")
    public void adviceWithThrowing(Throwable exception) {
        System.out.println(exception.getMessage());
    }

    @Around("getEmployeeByIdPointCut()")
    public Object aroundAdviceTest(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Before getting Employee");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("After getting Employee");
        return proceed;

    }
}
