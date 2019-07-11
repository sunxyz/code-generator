package com.yangrd.codegenerator.clazz.support.impl;

import com.yangrd.codegenerator.clazz.support.ColumnDataTypeMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * DefaultColumnDataTypeMapper
 *
 * @author yangrd
 * @date 2019/07/10
 */
public class DefaultColumnDataTypeMapper implements ColumnDataTypeMapper {

    private static Map<String, Class<?>> columnDataType2FieldTypeRegistry = new HashMap<>();

    static {
        columnDataType2FieldTypeRegistry.put("VARCHAR", String.class);
        columnDataType2FieldTypeRegistry.put("BLOB", String.class);
        columnDataType2FieldTypeRegistry.put("TEXT", String.class);
        columnDataType2FieldTypeRegistry.put("INTEGER", Long.class);
        columnDataType2FieldTypeRegistry.put("TINYINT", Integer.class);
        columnDataType2FieldTypeRegistry.put("SMALLINT", Integer.class);
        columnDataType2FieldTypeRegistry.put("MEDIUMINT", Integer.class);
        columnDataType2FieldTypeRegistry.put("BIT", Boolean.class);
        columnDataType2FieldTypeRegistry.put("BIGINT", BigInteger.class);
        columnDataType2FieldTypeRegistry.put("FLOAT", Float.class);
        columnDataType2FieldTypeRegistry.put("DOUBLE", Double.class);
        columnDataType2FieldTypeRegistry.put("DECIMAL", BigDecimal.class);
        columnDataType2FieldTypeRegistry.put("BOOLEAN", Integer.class);
        columnDataType2FieldTypeRegistry.put("ID", Integer.class);
        columnDataType2FieldTypeRegistry.put("DATE", LocalDate.class);
        columnDataType2FieldTypeRegistry.put("TIME", LocalTime.class);
        columnDataType2FieldTypeRegistry.put("DATETIME", LocalDateTime.class);
        columnDataType2FieldTypeRegistry.put("TIMESTAMP", LocalDateTime.class);
        columnDataType2FieldTypeRegistry.put("YEAR", LocalDate.class);
    }

    @Override
    public Class<?> getFieldType(String dataType) {
        return columnDataType2FieldTypeRegistry.getOrDefault(dataType.toUpperCase(), String.class);
    }
}
