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

    //静态代码块只执行一次。

    //构造代码块在每一次构造对象的开始执行，每构造一次都会执行一次。
    // 其与构造函数的区别是构造代码块无论针对所有的对象初始化都会执行，构造函数只会和相匹配的函数一致时才会执行。


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


interface A {
    public void show();
}

interface B{
    public void show();
}

class C implements A,B{
    public void show(){}
}