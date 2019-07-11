package com.yangrd.codegenerator.clazz.support.impl;

import com.yangrd.codegenerator.clazz.EntityClazz;
import com.yangrd.codegenerator.clazz.support.EntityClazzHook;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * CompositionEntityClassHook
 *
 * @author yangrd
 * @date 2019/07/11
 */
@AllArgsConstructor
public class CompositionEntityClassHook implements EntityClazzHook {

    private List<EntityClazzHook> entityClazzHooks;

    @Override
    public void after(EntityClazz entityClazz) {
        entityClazzHooks.forEach(entityClazzHook -> entityClazzHook.after(entityClazz));
    }
}
