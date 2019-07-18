package com.yangrd.codegenerator.factory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

/**
* ${clazzName?cap_first}Service
*
* @author yangrd
* @date 2019/07/11
*/
public interface ${clazzName?cap_first}Service {

    /**
    * 新增
    * @param ${clazzName}
    * @return ${clazzName?cap_first}
    */
    ${clazzName?cap_first} save(${clazzName?cap_first} ${clazzName});

    /**
    * 删除
    *
    * @param id
    */
    void deleteById(${meta.idType} id);


    /**
    * 修改
    *
    * @param ${clazzName}
    * @param id
    */
    void updateById(${clazzName?cap_first} ${clazzName}, ${meta.idType} id);

    /**
    * 查询
    *
    * @param id
    * @return ${clazzName?cap_first}
    */
    ${clazzName?cap_first} findOne(${meta.idType} id);

    /**
    * 查询
    *
    * @param specification
    * @param pageable
    * @return Page<${clazzName?cap_first}>
    */
    Page<${clazzName?cap_first}> findAll(Specification<${clazzName?cap_first}> specification, Pageable pageable);
}
