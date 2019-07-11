package com.yangrd.codegenerator.extract.inner;

import com.alibaba.fastjson.JSON;
import com.yangrd.codegenerator.extract.DataBaseExtract;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * JdbcDataBaseExtractTest
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcDataBaseExtractTest {

    @Autowired
    private DataBaseExtract dataBaseExtract;

    @Test
    public void listTableInfo() {
        dataBaseExtract.listTableInfo("litemall").forEach(tableInfo -> {
            log.info("{}", JSON.toJSONString(tableInfo));
        });
    }

    @Test
    public void listColumnInfo() {
        dataBaseExtract.listColumnInfo("litemall","litemall_user").forEach(tableInfo -> {
            log.info("{}", JSON.toJSONString(tableInfo));
        });
    }
}
