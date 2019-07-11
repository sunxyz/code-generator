package com.yangrd.codegenerator.clazz.support;

import com.yangrd.codegenerator.clazz.EntityClazz;

/**
 * EntityClazzHook
 *
 * @author yangrd
 * @date 2019/07/11
 */
public interface EntityClazzHook {

    void after(EntityClazz entityClazz);
}
