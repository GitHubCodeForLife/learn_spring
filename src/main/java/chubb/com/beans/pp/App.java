package chubb.com.beans.pp;

import chubb.com.beans.pp.aware.MyBeanFactory;
import chubb.com.beans.pp.aware.MyBeanName;
import chubb.com.beans.pp.aware.MyBeanRegistrar;
import chubb.com.beans.pp.processor.MyCustomBeanFactoryPostProcessor;
import chubb.com.beans.pp.processor.MyCustomBeanPostProcessor;
import org.springframework.context.annotation.*;

@Configuration
@Import(MyBeanRegistrar.class)
public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addBeanFactoryPostProcessor(new MyCustomBeanFactoryPostProcessor());
        context.getBeanFactory().addBeanPostProcessor(new MyCustomBeanPostProcessor());
        context.register(App.class);
        context.refresh();
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Student st = context.getBean(Student.class);
        Person ps = context.getBean(Person.class);
        ps.sayHello();
        System.out.println("end");
//        context.getRe
    }

    @Bean
    public Student student(){
        return new Student("Tran");
    }

    @Bean
    public Person person(){
        return new Person();
    }


//    @Bean
//    public MyCustomBeanPostProcessor myCustomBeanPostProcessor(){
//        return new MyCustomBeanPostProcessor();
//    }

    @Bean(name = "myCustomBeanName")
    public MyBeanName getMyBeanName() {
        return new MyBeanName();
    }

    @Bean
    public MyBeanFactory myBeanFactory(){
        return new MyBeanFactory();
    }
}
