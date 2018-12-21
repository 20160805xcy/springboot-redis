package com.xcy.springbootredis.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;
import java.util.Map;


/**
 * @author xcy
 * @date 2018/12/21 13:58
 * @description FastJsonUtils工具类
 * @since V1.0.0
 */
public class FastJsonUtils {

    private static final SerializeConfig config;

    static {
        config = new SerializeConfig();
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer()); // 使用和json-lib兼容的日期输出格式
    }

    private static final SerializerFeature[] features = {
            SerializerFeature.WriteMapNullValue,      // 输出空值字段
            SerializerFeature.WriteNullListAsEmpty,    // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullNumberAsZero,   // 数值字段如果为null，输出为0，而不是null
            SerializerFeature.WriteNullBooleanAsFalse, // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullStringAsEmpty   // 字符类型字段如果为null，输出为""，而不是null
    };


    /**
     * 将对象转化成json字符串(携带特定规则: 空值不丢失且list-->[];num-->0;boolean-->false;str-->"")
     *
     * @param object
     * @return
     */
    public static String toJSONStringWithFeatures(Object object) {
        return JSON.toJSONString(object, config, features);
    }

    /**
     * 将对象转化成json字符串(使用fastJson默认的转化规则)
     * 对象里面数值类型字段为null-->该字段不显示(丢失)
     * 对象里面字符类型字段为null-->该字段不显示(丢失)
     * ...空字段丢失
     *
     * @param object
     * @return
     */
    public static String toJSONStringNoFeatures(Object object) {
        return JSON.toJSONString(object, config);
    }


    /**
     * 将json格式的字符串转化成json对象
     *
     * @param text "{\"address\":\"\",\"id\":4,\"passWord\":123,\"userName\":\"jerry\"}"
     * @return
     */
    public static Object toBean(String text) {
        return JSON.parse(text);
    }

    /**
     * 将json格式的字符串转化成对应的实体对象
     *
     * @param text  "{\"address\":\"\",\"id\":4,\"passWord\":123,\"userName\":\"jerry\"}"
     * @param clazz UserWeb
     * @param <T>
     * @return
     */
    public static <T> T toBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * 将数组格式的Json字符串转化成Json字符串的数组(即数组里面存的是json字符串)
     *
     * @param text "[{"address":"","id":4,"passWord":123,"userName":"jerry"}]"
     * @param <T>
     * @return
     */
    public static <T> Object[] toArray(String text) {
        return toArray(text, null);
    }

    /**
     * 将数组格式的Json字符串转化成Json对象的数组(即数组里面存的是json实体对象)
     *
     * @param text  "[{"address":"","id":4,"passWord":123,"userName":"jerry"}]"
     * @param clazz UserWeb
     * @param <T>
     * @return
     */
    public static <T> Object[] toArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    /**
     * 将list格式的json对象字符串转换成对应的对象list
     *
     * @param text  "[{"address":"深圳","id":1,"passWord":"123","userName":"xcy"},{"address":"江西","id":2,"passWord":"123","userName":"jerry"}]"
     * @param clazz UserWeb
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }

    /**
     * json字符串转化为map
     *
     * @param "{"address":"","id":4,"passWord":123,"userName":"jerry"}"
     * @return
     */
    public static <K, V> Map<K, V> toMap(String s) {
        Map<K, V> m = (Map<K, V>) JSONObject.parseObject(s);
        return m;
    }

    /**
     * 将map转化为json字符串
     *
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> String mapToString(Map<K, V> map) {
        String s = JSONObject.toJSONString(map);
        return s;
    }


}


