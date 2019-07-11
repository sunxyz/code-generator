package com.yangrd.codegenerator.factory;

import com.yangrd.codegenerator.clazz.EntityClazzHandler;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * CodeGeneratorTest
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class CodeGeneratorTest {

    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private EntityClazzHandler entityClazzHandler;

    @Test
    public void print() {
        try {
            codeGenerator.print(entityClazzHandler.getEntityClazz("litemall", "litemall_user"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
