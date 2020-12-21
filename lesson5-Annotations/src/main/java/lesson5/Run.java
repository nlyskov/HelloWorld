package lesson5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Run {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {


        int errorTests = 0;
        Class<?> clazz = ClassTest.class;
        var constructor = clazz.getDeclaredConstructor(int.class, int.class, String.class);


        List<Method> beforeList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();
        List<Method> afterList = new ArrayList<>();

        for (Method method : clazz.getDeclaredMethods()){
            if (method.isAnnotationPresent(Before.class)) {
                beforeList.add(method);
            }
            if (method.isAnnotationPresent(Test.class)) {
                testList.add(method);
            }
            if (method.isAnnotationPresent(After.class)) {
                afterList.add(method);
            }
        }

        //Вызываем все методы с аннотациями
            for (Method method : testList) {
                Object object = constructor.newInstance(10, 20, method.getName());
                beforeList.forEach(beforeMethod -> {
                    try {
                        beforeMethod.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
                method.invoke(object);
                afterList.forEach(afterMethod -> {
                    try {
                        afterMethod.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
                Field field = object.getClass().getDeclaredField("failedTestCounter");
                field.setAccessible(true);
                errorTests = (int) field.get(object)+errorTests;
            }


        //Статистика
        System.out.printf("Итоги прогона тестов: %n%n");
        System.out.printf("Всего было запущено тестов: %s%n", testList.size());
        System.out.printf("Успешных тестов: %s%n", testList.size()-errorTests);
        System.out.printf("Неуспешных тестов: %s%n", errorTests);

    }


}
