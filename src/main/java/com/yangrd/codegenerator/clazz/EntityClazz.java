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

    /**
     * table 名称
     */
    private String tableName;

    /**
     * table 评论
     */
    private String tableComment;

    /**
     * 类名
     */
    private String clazzName;

    /**
     * 类字段列表
     */
    private List<EntityField> fields;

    /**
     * 元信息
     * 使用方式参考
     *
     * @see com.yangrd.codegenerator.clazz.support.impl.IdEntityClazzHook#after(EntityClazz)
     */
    private Map<String,Object> meta;

    public void putMeta(String key,Object val){
        meta.put(key,val);
    }
}
