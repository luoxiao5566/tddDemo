package com.example.demo;

import java.util.List;

interface OptionParser {
    Object parse(List<String> argument, Option option);
}
