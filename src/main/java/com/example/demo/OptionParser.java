package com.example.demo;

import java.util.List;

interface OptionParser<T> {
    T parse(List<String> argument, Option option);
}
