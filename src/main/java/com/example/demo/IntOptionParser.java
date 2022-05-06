package com.example.demo;

import java.util.List;

class IntOptionParser implements OptionParser {
    @Override
    public Object parse(List<String> argument, Option option) {
        int index = argument.indexOf("-" + option.value());
        return Integer.parseInt(argument.get(index + 1));
    }
}
