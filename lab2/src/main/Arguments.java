package main;

import java.util.Arrays;

// Генератор универсальных аргументов под любой список параметров
public enum Arguments {
    BOOLEAN(boolean.class, Boolean.class), BYTE(byte.class, Byte.class),
    SHORT(short.class, Short.class),       INT(int.class, Integer.class),
    LONG(long.class, Long.class),          FLOAT(float.class, Float.class),
    DOUBLE(double.class, Double.class),    CHAR(char.class, Character.class),
    STRING(String.class), ARRAY, ENUM, OBJECT;

    private final Class<?>[] types;

    Arguments(Class<?>... types) { this.types = types; }

    public static Arguments of(Class<?> t) {
        if (t.isArray()) return ARRAY;
        if (t.isEnum())  return ENUM;
        for (Arguments k : values())
            if (Arrays.asList(k.types).contains(t)) return k;
        return OBJECT;
    }
}