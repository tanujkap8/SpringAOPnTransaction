package com.spring.component;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyClass1 {
//@Deprecated

    public void display(){
        System.out.println("MyClass1");
    }

   /* public void display4(int a){
        System.out.println("Argument Intial Value : "+a);
    }*/
/*    @Deprecated
    public void display2(){
        System.out.println("MyClass1 display2");
    }*/
    /*public void display3() throws IOException {
        System.out.println("My class1 display3");
        throw new IOException("Found IOException");
    }*/
}
