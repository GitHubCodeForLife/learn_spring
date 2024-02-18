package chubb.com.beans.pp.processor;

import chubb.com.beans.pp.Person;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyCustomBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (bean instanceof Person) {
            ProxyFactory proxyFactory = new ProxyFactory(bean);
            proxyFactory.addAdvice(new LoggingInterceptor());
            return proxyFactory.getProxy();
        }
        return bean;
    }

    private static class LoggingInterceptor implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation methodInvocation) throws Throwable {
            System.out.println("Before sayHello() method called");
            Object returnValue = methodInvocation.proceed();
            System.out.println("After sayHello() method called");
            return returnValue;
        }
    }
}