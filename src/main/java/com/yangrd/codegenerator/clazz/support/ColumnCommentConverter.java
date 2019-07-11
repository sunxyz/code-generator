package com.yangrd.codegenerator.clazz.support;

/**
 * ColumnCommentConverter
 *
 * @author yangrd
 * @date 2019/07/10
 */
public interface ColumnCommentConverter {

    /**
     * 转换
     * @param columnComment
     * @return
     */
    FieldDescription converter(String columnComment);

    /**
     * 支持该字段
     * @param columnComment
     * @return
     */
    boolean isSupport(String columnComment);
}
