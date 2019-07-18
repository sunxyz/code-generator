package com.yangrd.codegenerator.factory;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* ${clazzName?cap_first}ServiceImpl
*
* @author yangrd
* @date 2019/07/11
*/
@AllArgsConstructor

@Transactional(rollbackFor = Exception.class)
@Service
public class ${clazzName?cap_first}ServiceImpl implements ${clazzName?cap_first}Service {

    private DemoRepository repository;

    @Override
    public ${clazzName?cap_first} save(${clazzName?cap_first} ${clazzName}) {
        return repository.save(${clazzName});
    }

    @Override
    public void deleteById(${meta.idType} id) {
        repository.deleteById(id);
    }

    @Override
    public void updateById(${clazzName?cap_first} ${clazzName}, ${meta.idType} id) {
        demo.setId(id);
        repository.save(${clazzName});
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public ${clazzName?cap_first} findOne(${meta.idType} id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public Page<${clazzName?cap_first}> findAll(Specification<${clazzName?cap_first}> specification, Pageable pageable) {
        return repository.findAll(specification,pageable);
    }
}
