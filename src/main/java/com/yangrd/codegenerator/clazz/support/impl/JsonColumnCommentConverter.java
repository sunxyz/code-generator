package com.yangrd.codegenerator.clazz.support.impl;

import com.alibaba.fastjson.JSON;
import com.yangrd.codegenerator.clazz.support.ColumnCommentConverter;
import com.yangrd.codegenerator.clazz.support.FieldDescription;
import org.springframework.util.StringUtils;

/**
 * JSONDataModelConverter
 *
 * @author yangrd
 * @date 2019/07/10
 */
public class JsonColumnCommentConverter implements ColumnCommentConverter {

    @Override
    public FieldDescription converter(String columnComment) {
        FieldDescription fieldModel = JSON.parseObject(columnComment, FieldDescription.class);
        return fieldModel;
    }

    @Override
    public boolean isSupport(String columnComment) {
        if (StringUtils.hasText(columnComment)) {
            try {
                JSON.parseObject(columnComment, FieldDescription.class);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }
}
