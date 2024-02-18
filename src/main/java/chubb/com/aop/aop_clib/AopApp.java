package chubb.com.aop.aop_clib;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AopApp {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(AopApp.class);
//        context.refresh();
//
//        MyBean bean = context.getBean(MyBean.class);
//        bean.doSt();
//        ProxyFactoryBean
        MyBean myBean = new MyBean();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new TracingInterceptor());
        proxyFactory.setTarget(myBean);

        MyBean proxy = (MyBean) proxyFactory.getProxy();
        proxy.doSt();

    }
}
