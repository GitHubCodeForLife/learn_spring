package chubb.com.core.utils.class_utils;

import org.springframework.util.ClassUtils;

import java.util.ServiceLoader;

public class App{
    public static void main(String[] args) {
        //ex1: getPackageName
        String packageName = ClassUtils.getPackageName(App.class);
        System.out.println("------ Ex1: getPackageName ----");
        System.out.println(packageName);

        //ex2: getAllInterfaces
        Class<?>[] allInterfacesForClass = ClassUtils.getAllInterfacesForClass(Test.class);
        System.out.println("------ Ex2: allInterfacesForClass ----");
        for (Class cls:allInterfacesForClass) {
            System.out.println(cls);
        }

        //Ex3: getDefaultClassLoader
        System.out.println("------ Ex3: getDefaultClassLoader ----");
        System.out.println(ClassUtils.getDefaultClassLoader());
        System.out.println(ClassUtils.getDefaultClassLoader());

        //Ex4: getShortName
        System.out.println("------ Ex4: getShortName ----");
        System.out.println(ClassUtils.getShortName("chubb.com.core.utils.class_utils.App$$"));

        //Ex5: isAssignable
        System.out.println("------ Ex5: isAssignable ----");
        System.out.println(ClassUtils.isAssignable(I1.class, I2.class));
        System.out.println(ClassUtils.isAssignable(Test.class, I2.class));
        System.out.println(ClassUtils.isAssignable(I2.class, Test.class));

        //Ex6: get all implement off type
        System.out.println("------ Ex6: get all implement off type----");

        //1
//        Reflections reflections = new Reflections(" chubb.com.core.utils.class_utils");
//        Set<Class<? extends Pet>> classes = reflections.getSubTypesOf(Pet.class);
        //2
        ServiceLoader<I2> loader = ServiceLoader.load(I2.class);
        for (I2 implClass : loader) {
            System.out.println(implClass.getClass().getSimpleName()); // prints Dog, Cat
        }

    }
}

interface I1{

}

interface I2{

}

class Test implements I2, I1{

}
