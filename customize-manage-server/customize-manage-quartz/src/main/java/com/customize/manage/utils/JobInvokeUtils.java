package com.customize.manage.utils;

import com.customize.common.utils.StringUtils;
import com.customize.manage.domain.TaskSource;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 任务执行工具类
 */
public class JobInvokeUtils {

    /**
     * 执行任务源指向的方法
     *
     * @param source 任务源
     */
    public static void invokeMethod(TaskSource source) throws Exception {
        Object bean = isValidClassName(source.getBeanName()) ? Class.forName(source.getBeanName()).newInstance() : SpringUtils.getBean(source.getBeanName());
        invokeMethod(bean, source.getMethodName(), source.getMethodParams());
    }

    private static void invokeMethod(Object bean, String methodName, List<Object[]> methodParams) throws Exception {
        if (methodParams != null && methodParams.size() > 0) {
            // 调用有参方法，传入参数
            Method method = bean.getClass().getDeclaredMethod(methodName, getMethodParamsType(methodParams));
            method.invoke(bean, getMethodParamsValue(methodParams));
        } else {
            // 调用无参方法
            Method method = bean.getClass().getDeclaredMethod(methodName);
            method.invoke(bean);
        }
    }

    /**
     * 获取方法参数类型，Object[]的1下标值
     *
     * @param methodParams 方法参数集
     * @return 返回参数类型数组
     */
    private static Class<?>[] getMethodParamsType(List<Object[]> methodParams) {
        Class<?>[] clazz = new Class<?>[methodParams.size()];
        int index = 0;
        for (Object[] os : methodParams) {
            clazz[index] = (Class<?>) os[1];
            index++;
        }
        return clazz;
    }

    /**
     * 获取方法参数值，Object[]的0下标值
     *
     * @param methodParams 方法参数集
     * @return 返回参数值数组
     */
    private static Object[] getMethodParamsValue(List<Object[]> methodParams) {
        Object[] values = new Object[methodParams.size()];
        int index = 0;
        for (Object[] os : methodParams) {
            values[index] = os[0];
            index++;
        }
        return values;
    }

    /**
     * 验证是否为class的path
     * @param beanName 类名
     * @return true 表示为类的path，例如com.xxx.xxx，false代表为类名
     */
    private static boolean isValidClassName(String beanName) {
        return StringUtils.countMatches(beanName, ".") > 1;
    }
}
