package chubb.com.beans.registra;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext("chubb.com.beans.registra");
        MyBean bean = context.getBean(MyBean.class);
        System.out.println(bean);
    }

    @Bean
    MyBean myBean(){
        return new MyBean();
    }

    @Bean
    MyCustomEditorRegistrar myCustomEditorRegistrar(){
        return new MyCustomEditorRegistrar();
    }
}
