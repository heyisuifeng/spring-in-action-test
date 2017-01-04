package com.ace;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;

/**
 * Created by yecanyi on 2016/12/22.
 */
public class Test {
    private int i = 10;

    //构造块
    {
        System.out.print("ddd");
    }
    class A {
        private int i =20;

        public void a(){
            System.out.println(Test.this.i);
        }
    }
    public static void main(String [] args){
        Test test = new Test();
        A a = test.new A();
        a.a();
    }
}
