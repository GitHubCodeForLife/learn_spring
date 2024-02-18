package chubb.com.aop.dynamic_proxy;

public class Employee  implements IEmployee{
    @Override
    public void doST() {
        System.out.println("DO ST");
    }
}
