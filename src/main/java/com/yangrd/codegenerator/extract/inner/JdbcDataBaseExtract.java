package com.yangrd.codegenerator.extract.inner;

import com.yangrd.codegenerator.extract.ColumnInfo;
import com.yangrd.codegenerator.extract.DataBaseExtract;
import com.yangrd.codegenerator.extract.TableInfo;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * JdbcDataBaseExtract
 *
 * @author yangrd
 * @date 2019/07/10
 */
@AllArgsConstructor
public class JdbcDataBaseExtract implements DataBaseExtract {

    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_TABLE_INFO_SQL = "select * from information_schema.tables where table_schema= ? ";

    private static final String QUERY_COLUMN_INFO_SQL = "select * from information_schema.columns where table_schema= ? and table_name = ?";

    @Override
    public List<TableInfo> listTableInfo(String tableSchema) {
        return jdbcTemplate.query(QUERY_TABLE_INFO_SQL, new BeanPropertyRowMapper<>(TableInfo.class), tableSchema);
    }

    @Override
    public List<ColumnInfo> listColumnInfo(String tableSchema, String tableName) {
        return jdbcTemplate.query(QUERY_COLUMN_INFO_SQL, new BeanPropertyRowMapper<>(ColumnInfo.class), tableSchema, tableName);
    }
}
