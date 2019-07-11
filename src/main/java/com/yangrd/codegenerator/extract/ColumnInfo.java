package com.yangrd.codegenerator.extract;

import lombok.Data;

import java.io.Serializable;

/**
 * ColumnInfo
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Data
public class ColumnInfo implements Serializable {

    /**
     * 字段名称
     */
    private String columnName;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 字符最大长度
     */
    private Integer characterMaximumLength;

    /**
     * 字段类型
     */
    private String columnType;

    /**
     * 字段key
     */
    private String columnKey;

    /**
     * 字段描述
     */
    private String columnComment;
}
