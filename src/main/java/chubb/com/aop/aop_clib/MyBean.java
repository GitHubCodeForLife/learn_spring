package chubb.com.aop.aop_clib;

public class MyBean {

    public void doSt(){
        this.doSt(10);
    }

    public void doSt(int n){
        System.out.println("MyBean -- DO ST");
        System.out.println("Input n: "+ n);
    }
}
