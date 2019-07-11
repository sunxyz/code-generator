package com.yangrd.codegenerator.factory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
 * DemoService
 *
 * @author yangrd
 * @date 2019/07/11
 */
public interface DemoService {

    /**
     * 新增
     * @param demo
     * @return Demo
     */
    Demo save(Demo demo);

    /**
     * 删除
     *
     * @param id
     */
    void deleteById(String id);


    /**
     * 修改
     *
     * @param demo
     * @param id
     */
    void updateById(Demo demo, String id);

    /**
     * 查询
     *
     * @param id
     * @return Demo
     */
    Demo findOne(String id);

    /**
     * 查询
     *
     * @param specification
     * @param pageable
     * @return Page<Demo>
     */
    Page<Demo> findAll(Specification<Demo> specification, Pageable pageable);
}
