package chubb.com.core.utils.reflection_util;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws IllegalAccessException {
        //Ex1: find field
        Student student = new Student();
        student.setName("Tran");

        Field name = ReflectionUtils.findField(student.getClass(), "name");
//        name.setAccessible(true);
        ReflectionUtils.makeAccessible(name);
        System.out.println(name.get(student));

        //Ex2: find method
        Method turnAlarmOn = ReflectionUtils.findMethod(Vehicle.class, "turnAlarmOn");
        System.out.println(turnAlarmOn);

        //Ex3: get declares methods and get methods
        Method[] declaredMethods = ReflectionUtils.getDeclaredMethods(Student.class);
        System.out.println("\n----------- declaredMethods -----");
        for (Method me:declaredMethods) {
            System.out.println(me);
        }
        System.out.println("\n----------- allDeclaredMethods -----");
        Method[] allDeclaredMethods = ReflectionUtils.getAllDeclaredMethods(Student.class);
        for (Method me:allDeclaredMethods) {
            System.out.println(me);
        }
    }
}


class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void privateMethod(){

    }

    public static void staticMethod(){}

}

interface Vehicle {
    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }

    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }
}