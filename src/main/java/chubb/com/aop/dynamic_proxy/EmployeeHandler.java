package chubb.com.aop.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EmployeeHandler<T> implements InvocationHandler {
    public T target;
    private final Map<String, Method> methods = new HashMap<>();
    public EmployeeHandler(T target) {
        this.target = target;
        for(Method method: target.getClass().getDeclaredMethods()) {
            this.methods.put(method.getName(), method);
        }
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy Invoke");
        long start = System.nanoTime();
        Object result = methods.get(method.getName()).invoke(target, args);
        long elapsed = System.nanoTime() - start;
        System.out.println("Executing " + method.getName() + " finished in " + elapsed + " ns");
        return result;
    }
}
