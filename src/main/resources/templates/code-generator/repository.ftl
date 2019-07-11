package com.yangrd.codegenerator.factory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* ${clazzName?cap_first}Repository
* ${tableName}
* ${tableComment}
*
* @author yangrd
* @date 2019/07/11
*/
public interface ${clazzName?cap_first}Repository extends JpaRepository<${clazzName?cap_first},${meta.idType}>, JpaSpecificationExecutor<${clazzName?cap_first}> {

}
