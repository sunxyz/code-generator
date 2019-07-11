package com.yangrd.codegenerator.clazz.support.impl;

import com.yangrd.codegenerator.clazz.EntityClazz;
import com.yangrd.codegenerator.clazz.EntityField;
import com.yangrd.codegenerator.clazz.support.EntityClazzHook;

import java.util.List;

/**
 * DefaultEntityClazzHook
 *
 * @author yangrd
 * @date 2019/07/11
 */
public class IdEntityClazzHook implements EntityClazzHook {

    @Override
    public void after(EntityClazz entityClazz) {
        List<EntityField> fields = entityClazz.getFields();
        for(EntityField field:fields){
            if("PRI".equals(field.getColumnInfo().getColumnKey())){
                String idName = field.getFieldName();
                String  idType = field.getFieldType().getSimpleName();
                entityClazz.putMeta("idName",idName);
                entityClazz.putMeta("idType",idType);
            }
        }
    }
}
