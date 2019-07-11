package com.yangrd.codegenerator.factory;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DemoServiceImpl
 *
 * @author yangrd
 * @date 2019/07/11
 */
@AllArgsConstructor

@Transactional(rollbackFor = Exception.class)
@Service
public class DemoServiceImpl implements DemoService {

    private DemoRepository repository;

    @Override
    public Demo save(Demo demo) {
        return repository.save(demo);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void updateById(Demo demo, String id) {
        demo.setId(id);
        repository.save(demo);
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public Demo findOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public Page<Demo> findAll(Specification<Demo> specification, Pageable pageable) {
        return repository.findAll(specification,pageable);
    }
}
