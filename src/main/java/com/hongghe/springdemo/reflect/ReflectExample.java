package com.hongghe.springdemo.reflect;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.*;

@Service
public class ReflectExample {
    private static  final Logger logger = LoggerFactory.getLogger(ReflectExample.class);

    /**
     * 通过Java反射机制得到类的包名和类名
     */
    public void getClassNameAndPackage() {
        Person person = new Person();
        logger.info("The package name is :" + person.getClass().getPackage().getName());
        logger.info("The class name is : " + person.getClass().getName());
    }

    /**
     * 验证所有的类都是Class类的实例对象
     * @throws ClassNotFoundException
     */
    public void InstanceObject() throws ClassNotFoundException {
        Class<?> claszz = null;
        Class<?> clazzClass = null;

        claszz = Class.forName("com.hongghe.springdemo.reflect.Person");
        logger.info("The package name is :" + claszz.getClass().getPackage().getName());
        logger.info("The class name is : " + claszz.getClass().getName());

        clazzClass = Person.class;
        logger.info("The package name is :" + clazzClass.getClass().getPackage().getName());
        logger.info("The class name is : " + clazzClass.getClass().getName());
    }

    /**
     * 通过Java反射机制，用Class 创建类对象[这也就是反射存在的意义所在
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void setInstanceValue() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> claszz = null;
        claszz = Class.forName("com.hongghe.springdemo.reflect.Person");
        Person person = (Person) claszz.newInstance();
        person.setAge(12);
        person.setName("Hongghe");
        Gson gson = new Gson();
        logger.info("The person information is = {}", gson.toJson(person));
    }

    /**
     * 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void getInstance() throws ClassNotFoundException, IllegalArgumentException, InstantiationException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz = null;
        Person personA = null;
        Person personB = null;
        clazz = Class.forName("com.hongghe.springdemo.reflect.Person");
        Constructor<?>[] constructors = clazz.getConstructors();

        personA = (Person)constructors[0].newInstance();
        personA.setAge(12);
        personA.setName("h");

        personB = (Person)constructors[1].newInstance(11, "sada");

        Gson gson = new Gson();
        logger.info("The person information is = {}", gson.toJson(personA));
        logger.info("The person information is = {}", gson.toJson(personB));
    }

    /**
     * 通过Java反射机制操作成员变量, set 和 get
     * @throws ClassNotFoundException
     * @throws IllegalArgumentException
     * @throws InstantiationException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public void setAndGetReflect() throws ClassNotFoundException, IllegalArgumentException, InstantiationException, InvocationTargetException,
            IllegalAccessException, NoSuchFieldException {
        Class<?> clazz  = null;
        clazz = Class.forName("com.hongghe.springdemo.reflect.Person");
        Object object = clazz.newInstance();

        Field personNameFiled = clazz.getDeclaredField("name");
        personNameFiled.setAccessible(true);
        personNameFiled.set(object, "Mr");

        logger.info("The change properties is :" + personNameFiled.get(object));
    }

    /**
     * 通过Java反射机制得到类的一些属性： 继承的接口，父类，函数信息，成员信息，类型等
     * @throws ClassNotFoundException
     */
    public void implementsProperties() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("com.hongghe.springdemo.reflect.SuperMan");

        //取得父类名称
        Class<?>  superClass = class1.getSuperclass();
        logger.info("The parent class " + superClass.getName());

        Field[] fields = class1.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            logger.info("The fields is " + fields[i]);
        }

        //取得类方法
        Method[] methods = class1.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            logger.info("The parent class method is methodName={} returnType={}",methods[i].getName(), methods[i].getReturnType());
            logger.info("The param={}", Modifier.toString(methods[i].getModifiers()));
            logger.info("The code={}", methods[i]);
        }

        //取得类实现的接口,因为接口类也属于Class,所以得到接口中的方法也是一样的方法得到哈
        Class<?> interfaces[] = class1.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            logger.info("The interface name is " + interfaces[i].getName());
        }
    }

    /**
     * 通过Java反射机制调用类方法
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws NoSuchMethodException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void impMethod() throws ClassNotFoundException, SecurityException, NoSuchMethodException, InstantiationException,
            IllegalAccessException, InvocationTargetException {
        Class<?> clazz = null;
        clazz = Class.forName("com.hongghe.springdemo.reflect.SuperMan");
        Method method = clazz.getMethod("fly");
        method.invoke(clazz.newInstance());
        method = clazz.getMethod("walk", int.class);
        method.invoke(clazz.newInstance(), 100);
    }

    /**
     * 通过Java反射机制得到类加载器信息
     * @throws ClassNotFoundException
     */
    public void getLoader() throws ClassNotFoundException {
        Class<?> clazz = null;
        clazz = Class.forName("com.hongghe.springdemo.reflect.SuperMan");
        String nameString = clazz.getClassLoader().getClass().getName();
        logger.info("The loader name={}", nameString);
    }
}
