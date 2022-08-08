package com.ym.admin.util;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author Fengzl
 * @Date 2022/8/5 20:27
 * @Desc
 **/
public class ClassCompareUtil {


    /**
     * 同类型实体类属性值对比输出差异
     * @param oldObj 原实体类
     * @param newObj 变更后实体类
     * @param compareFields 参与对比的属性名称,为空或null-默认所有属性参与对比
     * @return
     */
    public static List<Map<String, Object>> compareFields(Object oldObj, Object newObj, String[] compareFields) {
        //存放改变前后结果
        List<Map<String, Object>> list = new ArrayList<>();
        list.add(0, new HashMap<>(16));
        list.add(1, new HashMap<>(16));
        try {
            //做对比属性
            List<String> compareList = null;

            if (compareFields != null && compareFields.length > 0) {
                compareList = Arrays.asList(compareFields);
            }
            //同类型做对比
            if (oldObj.getClass() == newObj.getClass()) {
                Class<?> clazz = oldObj.getClass();
                PropertyDescriptor[] pds = Introspector.getBeanInfo(clazz, Object.class).getPropertyDescriptors();

                Map<String, Object> oldMap = new HashMap<>(16);
                Map<String, Object> newMap = new HashMap<>(16);
                //对比所有属性
                for (PropertyDescriptor pd : pds) {
                    String name = pd.getName();
                    //如果指定对比属性,只对比指定的属性值,如果不指定,默认对比全部
                    if (compareList != null && !compareList.contains(name)) {
                        continue;
                    }
                    Method readMethod = pd.getReadMethod();
                    //获取对应属性值
                    Object oldValue = readMethod.invoke(oldObj);
                    Object newValue = readMethod.invoke(newObj);
                    //Timestamp类型转换
                    if (oldValue instanceof Timestamp) {
                        oldValue = new Date(((Timestamp) oldValue).getTime());
                        newValue = new Date(((Timestamp) newValue).getTime());
                    }

                    if (oldValue instanceof BigDecimal) {
                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                        oldValue = decimalFormat.format(oldValue);
                        newValue = decimalFormat.format(newValue);
                    }

                    //对比
                    if (oldValue == null && newValue != null) {
                        oldMap.put(name, "");
                        newMap.put(name, newValue);
                    } else if (newValue == null && oldValue != null) {
                        oldMap.put(name, oldValue);
                        newMap.put(name, "");
                    } else if (oldValue != null && !oldValue.equals(newValue)) {
                        oldMap.put(name, oldValue);
                        newMap.put(name, newValue);
                    }
                }
                list.set(0, oldMap);
                list.set(1, newMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }

        return list;
    }
}
