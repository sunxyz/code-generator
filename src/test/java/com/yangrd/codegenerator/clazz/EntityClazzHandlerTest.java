package com.yangrd.codegenerator.clazz;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * EntityClazzHandlerTest
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class EntityClazzHandlerTest {

    @Autowired
    private EntityClazzHandler entityClazzHandler;

    @Test
    public void getClazz() {
        EntityClazz clazz = entityClazzHandler.getEntityClazz("litemall", "litemall_user");
        log.info("{}", JSON.toJSONString(clazz));
    }
}
