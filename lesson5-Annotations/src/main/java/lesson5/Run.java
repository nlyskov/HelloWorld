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
        Object object1 = constructor.newInstance(10, 20, "Вася");
        Object object2 = constructor.newInstance(60, 50, "Алеша");


        List<Object> objects = new ArrayList<>();
        objects.add(object1);
        objects.add(object2);

        List<Method> beforeList = new ArrayList<>();
        List<Method> testList = new ArrayList<>();
        List<Method> afterList = new ArrayList<>();
        List<List<Method>> annotations = new ArrayList<>();

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
        annotations.add(beforeList);
        annotations.add(testList);
        annotations.add(afterList);

        //Вызываем все методы с аннотациями
        for (List<Method> list : annotations){
            for (Method method : list) {
                objects.forEach(object -> {
                    try {
                        method.invoke(object);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        //Считаем количество неуспешных тестов
        for (Object object : objects) {
            Field field = object.getClass().getDeclaredField("failedTestCounter");
            field.setAccessible(true);
            errorTests = (int) field.get(object)+errorTests;

        }

        //Статистика
        System.out.printf("Итоги прогона тестов: %n%n");
        System.out.printf("Всего было запущено тестов: %s%n", testList.size()*objects.size());
        System.out.printf("Успешных тестов: %s%n", testList.size()*objects.size()-errorTests);
        System.out.printf("Неуспешных тестов: %s%n", errorTests);

    }


}
