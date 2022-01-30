package com.week7;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

// Utility class for getting the class details
public class ClassUtil {

    public static Class getUserClass(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }
    public static Method[] getUserMethods(String className) throws ClassNotFoundException {
        return getUserClass(className).getMethods();
    }
    public static Constructor[] getConstructors(String className) throws ClassNotFoundException {
        return getUserClass(className).getConstructors();
    }
    public static Field[] getFields(String className) throws ClassNotFoundException {
        return getUserClass(className).getFields();
    }
    public static String getParentClasses(String className) throws ClassNotFoundException {
        return getUserClass(className).getSuperclass().getName();
    }
    public static Set<Class<?>> getSubClasses(String className) throws ClassNotFoundException {
        Reflections reflection = new Reflections();
        Class userClass = getUserClass(className);
        return reflection.getSubTypesOf(userClass);
    }
}