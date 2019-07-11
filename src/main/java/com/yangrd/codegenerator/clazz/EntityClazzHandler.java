package com.yangrd.codegenerator.clazz;

import com.yangrd.codegenerator.clazz.support.*;
import com.yangrd.codegenerator.extract.ColumnInfo;
import com.yangrd.codegenerator.extract.DataBaseExtract;
import com.yangrd.codegenerator.extract.TableInfo;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
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
        TableInfo tableInfo = dataBaseExtract.listTableInfo(tableSchema).stream().filter(tableInfo1 -> tableInfo1.getTableName().equals(tableName)).findFirst().orElseThrow(RuntimeException::new);
        List<ColumnInfo> columnInfos = dataBaseExtract.listColumnInfo(tableSchema, tableName);
        List<EntityField> fields = columnInfos.stream().map(this::fromColumnInfo).collect(Collectors.toList());
        EntityClazz entityClazz = toEntityClazz(tableInfo, fields);
        hook.after(entityClazz);
        return entityClazz;
    }

    private EntityClazz toEntityClazz(TableInfo tableInfo, List<EntityField> entityFields) {
        return new EntityClazz(
                tableInfo.getTableName(),
                tableInfo.getTableComment(),
                nameConverter.apply(tableInfo.getTableName()),
                entityFields,
                new HashMap<>()
        );
    }

    private EntityField fromColumnInfo(ColumnInfo columnInfo) {
        FieldDescription fieldDescription = new FieldDescription();
        if(columnCommentConverter.isSupport(columnInfo.getColumnComment())){
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
