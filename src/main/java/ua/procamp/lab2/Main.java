package ua.procamp.lab2;

import java.lang.reflect.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Date date = new Date();

        Class clss = date.getClass();   // create class object
        System.out.println("Class name: " + clss.getName());   // class name

        Constructor[] constructors = clss.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("Name of constructor: " + constructor.getName());     // Name of constructors
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Name of constructor's parameters: " + parameter.getName());   // Name of constructor's parameters
                System.out.println("Type of constructor's parameters: " + parameter.getType().getName());   // type of constructor's parameters
            }
        }
        Method[] methods = clss.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Name of class method: " + method.getName());   // Name of class method
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("Name of method parameters: " + parameter.getName());   // Name of constructor's parameters
                System.out.println("Type of method parameters: " + parameter.getType().getName());   // type of constructor's parameters
            }
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getName());     // type of returned result
            method.invoke(date, "lab2");
        }
        Field[] fields = clss.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            switch (field.getName()) {
                case "year": field.setInt(date, 2019); break;
                case "month": field.setInt(date, 11); break;
                case "day": field.setInt(date, 4); break;
                default: break;
            }
            System.out.println(field.getInt(date));

//            System.out.println(field.getName());
//            System.out.println(field.getType().getName());
//            System.out.println(Modifier.toString(field.getModifiers()));
        }
        System.out.println(date.year + " " + date.month + " " + date.day);
        StringBuilder sb = new StringBuilder("\n Список анотацій класа: \n");
        for (Method m : Date.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(someMethod.class)) {
                someMethod com = m.getAnnotation(someMethod.class);
                sb.append("#Метод " + m.getName()).append(" | Ім'я:" + com.name());
            }
        }
        System.out.println(sb.toString());

    }
}

class Date {
    public int year;
    public int month;
    public int day;

    public Date() {    // empty constructor
    }

    Date(int year, int month, int day) {    // constructor
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @someMethod(name = "string_annotation")
    public synchronized String someMethod(String s) {     // class method
        System.out.println("this is " + s);
        return s;

    }
}


class Time extends Date {
    private int hours;
    private int minutes;
}
