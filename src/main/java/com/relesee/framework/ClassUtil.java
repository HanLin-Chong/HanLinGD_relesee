package com.relesee.framework;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileFilter;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassUtil {
    private static final Logger logger = Logger.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     */
    public static ClassLoader getClassLoder(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     *加载类
     */
    public static Class<?> loadClass(String className, boolean isInitialized){
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoder());
        } catch (ClassNotFoundException e){
            logger.error("(cannot find class)无法找到类["+className+"]",e);
            throw new RuntimeException(e);
        }

        return cls;
    }

    /**
     * 获取指定包名下的所有类
     */
    public static Set<Class<?>> getClassesIn(String packageName){
        Set<Class<?>> classes = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls = getClassLoder().getResources(packageName.replace(".", "/"));
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if (url != null){
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")){
                        String packagePath = url.getPath().replaceAll("%20", " ");
                        addClass(classes, packagePath, packageName);
                    } else if (protocol.equals("jar")){
                        JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                        if (jarURLConnection != null){
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if (jarFile != null){
                                Enumeration<JarEntry> jarEntries = jarFile.entries();
                                while (jarEntries.hasMoreElements()){
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if (jarEntryName.endsWith(".class")){
                                        String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replaceAll("/", ".");
                                        doAddClass(classes, className);
                                    }
                                }
                            }
                        }
                    }
                }


            }



        } catch (Exception e){
            logger.error("(error occurs while loding class in package|获取:"+packageName+"包下的所有类时出现错误)",e);
            throw new RuntimeException(e);
        }
        return classes;
    }

    /**
     * 私有方法，向set中添加class
     */
    private static void addClass(Set<Class<?>> classes, String packagePath, String packageName){
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
        for (File file : files){
            String fileName = file.getName();
            if (file.isFile()){
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if (StringUtils.isNotEmpty(packageName)){
                    className = packageName +"."+className;
                }
                doAddClass(classes, className);
            } else {
                String subPackagePath = fileName;
                if (StringUtils.isNotEmpty(packageName)){
                    packageName = packageName+"."+packageName;
                }
                addClass(classes, subPackagePath, packageName);
            }
        }

    }

    /**
     * 顾名思义
     * @param classes
     * @param className
     */
    private static void doAddClass(Set<Class<?>> classes, String className){
        Class<?> cls = loadClass(className, false);
        classes.add(cls);
    }


    public static <T> T getBean(Class<T> cls){
        return null;
    }

}
