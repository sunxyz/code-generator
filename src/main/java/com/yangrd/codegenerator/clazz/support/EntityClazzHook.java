package com.yangrd.codegenerator.clazz.support;

import com.yangrd.codegenerator.clazz.EntityClazz;

/**
 * EntityClazzHook
 *
 * @author yangrd
 * @date 2019/07/11
 */
public interface EntityClazzHook {

    /**
     * 在完全生成之前
     * @param entityClazz
     */
    void after(EntityClazz entityClazz);
}
