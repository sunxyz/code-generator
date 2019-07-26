package com.yangrd.codegenerator.clazz;

import com.yangrd.codegenerator.clazz.support.FieldDescription;
import com.yangrd.codegenerator.extract.ColumnInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * FieldModel
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Data
@AllArgsConstructor
public class EntityField {

    /**
     * 字段类型
     */
    private Class<?> fieldType;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段描述
     */
    private String fieldDescription;

    /**
     * 字段 kvs
     * @see com.yangrd.codegenerator.clazz.support.ColumnCommentConverter#isSupport(String)
     * @see com.yangrd.codegenerator.clazz.support.ColumnCommentConverter#converter(String)
     */
    private List<FieldDescription.FieldValue> fieldValues;

    /**
     * 数据库字段信息
     */
    private ColumnInfo columnInfo;

    @Data
    public static class FieldValue {

        private String key;

        private String value;
    }
}
