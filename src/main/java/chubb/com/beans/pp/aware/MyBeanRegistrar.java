package chubb.com.beans.pp.aware;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                                        BeanDefinitionRegistry registry) {
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(AppBean.class);
        gbd.getPropertyValues().addPropertyValue("str", "value set from registrar");
        registry.registerBeanDefinition("appBean", gbd);
    }

    private static class AppBean {
        private String str;

        public void setStr(String str) {
            this.str = str;
        }

        public void process() {
            System.out.println(str);
        }
    }
}
