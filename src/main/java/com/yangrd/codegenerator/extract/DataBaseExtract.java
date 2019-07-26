package com.yangrd.codegenerator.extract;

import java.util.List;
import java.util.Optional;

/**
 * DataBaseExtra
 *
 * @author yangrd
 * @date 2019/07/10
 */
public interface DataBaseExtract {

    /**
     * findTableInfo
     * @param tableSchema
     * @param tableName
     * @return
     */
    Optional<TableInfo> findTableInfo(String tableSchema, String tableName);

    /**
     * listTableInfo
     * @param tableSchema
     * @return
     */
    List<TableInfo> listTableInfo(String tableSchema);

    /**
     * listColumnInfo
     * @param tableSchema
     * @param tableName
     * @return
     */
    List<ColumnInfo> listColumnInfo(String tableSchema, String tableName);
}
