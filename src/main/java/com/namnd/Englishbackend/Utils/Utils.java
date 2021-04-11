package com.namnd.Englishbackend.Utils;

import java.lang.reflect.Field;

/**
 * @author nam.nd
 * @created 10/04/2021 - 10:12 PM
 */
public class Utils {

    public static void trimStringValuesOfObject(Object model) {
        for (Field field : model.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(model);
//                String fieldName = field.getName();
                if (value != null) {
                    if (value instanceof String) {
                        String trimmed = (String) value;
                        field.set(model, trimmed.trim());
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Long stringToLong(String value) {
        try {
            return Long.parseLong(value);

        } catch (NumberFormatException exception) {
            return null;
        }
    }

    public static String longToString(Long numberValue){
        try{
            return String.valueOf(numberValue);
        }catch (NumberFormatException e){
            return null;
        }
    }

    public static boolean isNullOrEmpty(String value){
        return value == null || value.length() == 0;
    }
}
