package com.example.demo;

import java.util.List;

class StringOptionParser implements OptionParser {

    @Override
    public Object parse(List<String> argument, Option option) {
        int index = argument.indexOf("-" + option.value());
        return argument.get(index + 1);
    }
}
