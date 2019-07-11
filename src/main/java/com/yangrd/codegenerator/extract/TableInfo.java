package com.yangrd.codegenerator.extract;

import lombok.Data;

import java.io.Serializable;

/**
 * TableInfo
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Data
public class TableInfo implements Serializable {


    private String tableName;

    private String tableComment;

}
