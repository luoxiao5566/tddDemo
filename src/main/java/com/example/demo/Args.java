package com.example.demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class Args {
    public static <T> T parse(Class<T> optionsClass, String... args) {
        try {
            List<String> argument = Arrays.asList(args);
            Constructor<?> constructor = optionsClass.getDeclaredConstructors()[0];

            Object[] values = Arrays.stream(constructor.getParameters()).map(it -> parseOption(argument, it)).toArray();

            return (T) constructor.newInstance(values);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static Object parseOption(List<String> argument, Parameter parameter) {
        Object value = null;
        Option option = parameter.getAnnotation(Option.class);

        if (parameter.getType() == boolean.class) {
            value = argument.contains("-" + option.value());
        }
        if (parameter.getType() == int.class) {
            int index = argument.indexOf("-" + option.value());
            value = Integer.parseInt(argument.get(index + 1));
        }
        if (parameter.getType() == String.class) {
            int index = argument.indexOf("-" + option.value());
            value = argument.get(index + 1);
        }
        return value;
    }
}
