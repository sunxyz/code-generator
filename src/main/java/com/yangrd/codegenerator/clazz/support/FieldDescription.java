package com.yangrd.codegenerator.clazz.support;

import lombok.Data;

import java.util.List;

/**
 * DataModel
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Data
public class FieldDescription {

    /**
     * 字段描述(字段名称)
     */
    private String fieldDescription;

    /**
     * 字段kvs
     */
    private List<FieldValue> fieldValues;

    @Data
    public static class FieldValue {

        private String key;

        private String value;
    }
}
