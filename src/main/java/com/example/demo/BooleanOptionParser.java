package com.example.demo;

import java.util.List;

class BooleanOptionParser implements OptionParser {
    @Override
    public Object parse(List<String> argument, Option option) {
        return argument.contains("-" + option.value());
    }
}
