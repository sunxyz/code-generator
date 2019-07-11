package com.yangrd.codegenerator.clazz.support;

/**
 * ColumnDataTypeConverter
 *
 * @author yangrd
 * @date 2019/07/10
 */
public interface ColumnDataTypeMapper {

    /**
     * 获取字段类型
     *
     * @param dataType
     * @return
     */
    Class<?> getFieldType(String dataType);
}
