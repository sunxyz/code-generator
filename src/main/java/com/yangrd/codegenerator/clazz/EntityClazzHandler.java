package com.yangrd.codegenerator.clazz;

import com.google.common.collect.Sets;
import com.yangrd.codegenerator.clazz.support.*;
import com.yangrd.codegenerator.extract.ColumnInfo;
import com.yangrd.codegenerator.extract.DataBaseExtract;
import com.yangrd.codegenerator.extract.TableInfo;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClazzHandler
 *
 * @author yangrd
 * @date 2019/07/10
 */
@AllArgsConstructor
public class EntityClazzHandler {

    private ColumnCommentConverter columnCommentConverter;

    private ColumnDataTypeMapper columnDataTypeMapper;

    private NameConverter nameConverter;

    private DataBaseExtract dataBaseExtract;

    private EntityClazzHook hook;

    public EntityClazz getEntityClazz(String tableSchema, String tableName) {
        TableInfo tableInfo = dataBaseExtract.findTableInfo(tableSchema, tableName).orElseThrow(RuntimeException::new);
        return fromTableInfo(tableSchema, tableInfo);
    }

    public List<EntityClazz> listEntityClazz(String tableSchema, String... tableNames){
        HashSet<String> tableNameSet = Sets.newHashSet(tableNames);
        List<TableInfo> tableInfos = dataBaseExtract.listTableInfo(tableSchema).stream().filter(tableInfo -> tableNameSet.contains(tableInfo.getTableName())).collect(Collectors.toList());
        return tableInfos.stream().map(tableInfo->fromTableInfo(tableSchema,tableInfo)).collect(Collectors.toList());
    }

    private EntityClazz fromTableInfo(String tableSchema, TableInfo tableInfo){
        List<ColumnInfo> columnInfos = dataBaseExtract.listColumnInfo(tableSchema, tableInfo.getTableName());
        List<EntityField> fields = columnInfos.stream().map(this::fromColumnInfo).collect(Collectors.toList());
        EntityClazz entityClazz = toEntityClazz(tableInfo, fields);
        hook.after(entityClazz);
        return entityClazz;
    }

    private EntityClazz toEntityClazz(TableInfo tableInfo, List<EntityField> entityFields) {
        Map<String, Object> meta = new HashMap<>();
        return new EntityClazz(
                tableInfo.getTableName(),
                tableInfo.getTableComment(),
                nameConverter.apply(tableInfo.getTableName()),
                entityFields,
                meta
        );
    }

    private EntityField fromColumnInfo(ColumnInfo columnInfo) {
        FieldDescription fieldDescription = new FieldDescription();
        if (columnCommentConverter.isSupport(columnInfo.getColumnComment())) {
            fieldDescription = columnCommentConverter.converter(columnInfo.getColumnComment());
        }
        return new EntityField(
                columnDataTypeMapper.getFieldType(columnInfo.getDataType()),
                nameConverter.apply(columnInfo.getColumnName()),
                fieldDescription.getFieldDescription(),
                fieldDescription.getFieldValues(),
                columnInfo
        );
    }

}
