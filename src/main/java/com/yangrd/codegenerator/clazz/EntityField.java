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

    private Class<?> fieldType;

    private String fieldName;

    private String fieldDescription;

    private List<FieldDescription.FieldValue> fieldValues;

    private ColumnInfo columnInfo;

    @Data
    public static class FieldValue {
        private String key;

        private String value;
    }
}
