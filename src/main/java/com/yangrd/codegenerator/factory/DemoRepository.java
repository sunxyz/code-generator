package com.yangrd.codegenerator.factory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * DemoRepository
 *
 * @author yangrd
 * @date 2019/07/11
 */
@NoRepositoryBean
public interface DemoRepository extends JpaRepository<Demo,String>, JpaSpecificationExecutor<Demo> {
}
