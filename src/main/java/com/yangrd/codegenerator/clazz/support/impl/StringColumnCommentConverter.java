package com.yangrd.codegenerator.clazz.support.impl;

import com.yangrd.codegenerator.clazz.support.ColumnCommentConverter;
import com.yangrd.codegenerator.clazz.support.FieldDescription;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * StringColumnInfoConverter
 *
 * @author yangrd
 * @date 2019/07/10
 */
public class StringColumnCommentConverter implements ColumnCommentConverter {

    /**
     * desc[;[key:val] [key:val]]
     * @param columnComment
     * @return
     */
    @Override
    public FieldDescription converter(String columnComment) {
        FieldDescription fieldModel = new FieldDescription();
        if(columnComment.contains(";")){
            columnComment.replaceAll(" "," ");
            if(columnComment.contains("  ")){
                columnComment = columnComment.replaceAll("  "," ");
            }
            String[] split = columnComment.split(";");
            fieldModel.setFieldDescription(split[0]);
            String kvsStr = split[1];
            kvsStr.replaceAll(",",",");
            if(kvsStr.contains(",")){
                List<FieldDescription.FieldValue> fieldValues = new ArrayList<>();
                if(kvsStr.contains(" ")){
                   String[] kvs = kvsStr.split(" ");
                   Arrays.asList(kvs).forEach(str->{
                       String[] kv = kvsStr.split(",");
                       FieldDescription.FieldValue fieldValue = new FieldDescription.FieldValue();
                       fieldValue.setKey(kv[0]);
                       fieldValue.setValue(kv[1]);
                       fieldValues.add(fieldValue);
                   });
                }else {
                    String[] kv = kvsStr.split(",");
                    FieldDescription.FieldValue fieldValue = new FieldDescription.FieldValue();
                    fieldValue.setKey(kv[0]);
                    fieldValue.setValue(kv[1]);
                    fieldValues.add(fieldValue);
                }
                fieldModel.setFieldValues(fieldValues);
            }
        }else{
            fieldModel.setFieldDescription(columnComment);
        }
        return fieldModel;
    }

    /**
     *
     * @param columnComment
     * @return
     */
    @Override
    public boolean isSupport(String columnComment) {
        return StringUtils.hasText(columnComment);
    }
}
