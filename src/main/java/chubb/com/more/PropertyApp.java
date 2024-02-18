package chubb.com.more;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyApp {
    public static void main(String[] args) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", Student.class);

        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(student, "Tran");

        Method readMethod = propertyDescriptor.getReadMethod();
        System.out.println(readMethod.invoke(student));


        System.out.println(propertyDescriptor.getPropertyType());
    }
}

class Student{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}