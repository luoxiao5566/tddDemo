package com.example.demo;

import java.util.List;
import java.util.function.Function;

class SingleValueOptionParser<T> implements OptionParser {
    Function<String, T> valueParse;

    public SingleValueOptionParser(Function<String, T> valueParse) {
        this.valueParse = valueParse;
    }

    @Override
    public T parse(List<String> argument, Option option) {
        int index = argument.indexOf("-" + option.value());
        String value = argument.get(index + 1);

        return valueParse.apply(value);
    }

}
