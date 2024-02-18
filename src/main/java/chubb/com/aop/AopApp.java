package chubb.com.aop;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AnnotationAttributes;

@Configuration
//@EnableAspectJAutoProxy
@ComponentScan("chubb.com.aop")
public class AopApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AopApp.class);

        enableAspectManually(context);

        context.refresh();

        MyBean bean = context.getBean(MyBean.class);
        bean.doSt();
    }

    private static void enableAspectManually(AnnotationConfigApplicationContext context) {
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getBeanFactory();
        AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
        AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
//        AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
    }

    @Bean
    MyBean myBean(){
        return new MyBean();
    }
}
