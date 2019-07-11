package com.yangrd.codegenerator.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Clazz
 *
 * @author yangrd
 * @date 2019/07/10
 */
@AllArgsConstructor
@Data
public class EntityClazz {

    private String tableName;

    private String tableComment;

    private String clazzName;

    private List<EntityField> fields;

    private Map<String,Object> meta;

    public void putMeta(String key,Object val){
        meta.put(key,val);
    }
}
