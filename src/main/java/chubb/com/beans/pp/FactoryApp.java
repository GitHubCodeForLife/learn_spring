package chubb.com.beans.pp;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class FactoryApp {
    public static void main(String[] args) {
        DefaultListableBeanFactory context =
                new DefaultListableBeanFactory();
//        context.addBeanPostProcessor();

        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(Student.class);

        MutablePropertyValues mpv = new MutablePropertyValues();
        mpv.add("name", "Tran");

        //alternatively we can use:
        // gbd.getPropertyValues().addPropertyValue("date", new Date());
        gbd.setPropertyValues(mpv);
        context.registerBeanDefinition("myBeanName", gbd);
        context.preInstantiateSingletons();
        Student bean = context.getBean(Student.class);
        bean.doSomething();
    }
}
