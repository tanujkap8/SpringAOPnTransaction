package com.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;

@Aspect
public class MyAspect {

/*  //Question 1
    @Before("execution(* *(..))")
    void beforeAdvice1(){
        System.out.println("Running before 1 ");
    }

    //Question 2
    @Before("execution(* display(..))")
    void beforeAdvice2(){
        System.out.println("Running before 2");
    }
    @After("within(com.spring.component.*)")
    void afterAdvice(){
        System.out.println("runs after all methods");
    }

    //Question 3
    @AfterThrowing(pointcut= "execution(void display3())",throwing = "e")
    void afterthrowing(IOException e){
        System.out.println("Running after throwing"+e);
    }

    //Question 4
    @Around("@annotation(Deprecated)")
    void display3(){
        System.out.println("DEPRECATED METHOD");
    }*/

    //Question 5
    /*
    @Before("execution(* *(..))")
    void beforeAdvice1(){
        System.out.println("Running before execution");
    }
    @Before("within(com.spring.component.*)")
    void beforeAdvice2(){
        System.out.println("Running before within");
    }
    @Before("args(int)")
    void beforeAdvice3(){
        System.out.println("Running before args");
    }
    @Before("this(com.spring.component.MyClass1)")
    void beforeAdvice4(){
    System.out.println("Running before this");
    }
    @After("execution(* *(..))")
    void afterAdvice1(){
        System.out.println("Running after execution");
    }
    @After("within(com.spring.component.*)")
    void afterAdvice2(){
        System.out.println("Running after within");
    }
    @After("args(int)")
    void afterAdvice3(){
        System.out.println("Running after args");
    }
    @After("this(com.spring.component.MyClass1)")
    void afterAdvice4(){
        System.out.println("Running after this");
    }*/

/* //Question 6
 @Pointcut("execution(void display())")
 void displayAdvice(){ }
 @Before("execution(* display())")
    void beforeAdvice(){
     System.out.println("Before display");
 }*/

//Question 7

    @Before("execution(* display())")
    void displayAdvice(JoinPoint joinPoint){
        System.out.println(joinPoint.getThis());
        System.out.println("display  invoked for ::"+joinPoint.getSignature());
    }
//    @AfterReturning(pointcut = "execution(* display())",returning = "returnValue")
//    void afterReturning(Integer returnValue){
//        System.out.println("return value "+returnValue);
//    }

//    @AfterThrowing(pointcut = "execution(void display())",throwing = "ex")
//    void afterThrowing(Exception ex){
//        System.out.println("Exception raised "+ ex);
//    }

//    @Around("execution(void display())")
//    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//        System.out.println("Before");
//            proceedingJoinPoint.proceed();
//        System.out.println("After");
//    }

}
