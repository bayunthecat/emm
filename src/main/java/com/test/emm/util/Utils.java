package com.test.emm.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> extractFieldsNames(Object object) {
        return object != null ? Arrays.stream(object.getClass().getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.toList()) : Collections.EMPTY_LIST;
    }
}
