package chubb.com.aop.dynamic_proxy;

import java.lang.reflect.Proxy;

public class App {
    public static void main(String[] args) {
        IEmployee employeeObj = new Employee();

        EmployeeHandler<IEmployee> handler = new EmployeeHandler<>(employeeObj);

        IEmployee proxyInstance = (IEmployee) Proxy.newProxyInstance(
                App.class.getClassLoader(),
                new Class[] { IEmployee.class },
                handler);

        proxyInstance.doST();
    }
}
