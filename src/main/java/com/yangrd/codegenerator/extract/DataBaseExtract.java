package com.yangrd.codegenerator.extract;

import java.util.List;

/**
 * DataBaseExtra
 *
 * @author yangrd
 * @date 2019/07/10
 */
public interface DataBaseExtract {

    /**
     * @param tableSchema
     * @return
     */
    List<TableInfo> listTableInfo(String tableSchema);

    /**
     * @param tableSchema
     * @param tableName
     * @return
     */
    List<ColumnInfo> listColumnInfo(String tableSchema, String tableName);
}
