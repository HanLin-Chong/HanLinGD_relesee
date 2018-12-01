package com.relesee.framework.sax;

import com.relesee.framework.sax.utils.SaxUtil;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public class AssemblyPlant {

    /**
     * 根据xml装配domains的属性
     * @param cls
     * @param configXmlFile
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public <T> T get(Class<T> cls, String configXmlFile) throws IllegalAccessException, InstantiationException {
        T t = cls.newInstance();
        Map<String,Object> properties = SaxUtil.getObjectFields(configXmlFile);
        Set<String> keySet = properties.keySet();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field f:fields) {
            //System.out.println(f.getType().getName());
            for (String key:keySet) {

                if ( key.equals(f.getName()) ){
                    f.setAccessible(true);
                    /**
                     * 判断类型，分别处理，这里这样子不灵活了，改真名调优？
                     * 下面的if判断决定只支持domains中的int和String类型属性
                     */
                    if ( "int".equals(f.getType().getName()) ) {
                        f.set(t, Integer.parseInt((String) properties.get(key)) );
                    } else if ("java.lang.String".equals(f.getType().getName())){
                        f.set(t, (String) properties.get(key) );
                    } else {
                        //f.set(t, (T));
                    }


                }

            }

        }
        return t;
    }



}
