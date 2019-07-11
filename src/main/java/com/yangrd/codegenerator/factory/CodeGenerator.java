package com.yangrd.codegenerator.factory;

import com.alibaba.fastjson.JSON;
import com.yangrd.codegenerator.clazz.EntityClazz;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * CodeGenerator
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Component
public class CodeGenerator {

    public void print(EntityClazz entityClazz) throws IOException, TemplateException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

// Specify the source where the template files come from. Here I set a
// plain directory for it, but non-file-system sources are possible too:
        cfg.setClassLoaderForTemplateLoading(CodeGenerator.class.getClassLoader(),"templates");

// Set the preferred charset template files are stored in. UTF-8 is
// a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

// Sets how errors will appear.
// During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Template temp = cfg.getTemplate("/code-generator/model.ftl");
        Writer out = new OutputStreamWriter(System.out);
        Map root = new HashMap();
        System.out.println(JSON.toJSONString(entityClazz));
        root.put("o", entityClazz);
//        entityClazz.getFields().get(0).getFieldType().getSimpleName()
        temp.process(entityClazz,out);

        temp = cfg.getTemplate("/code-generator/repository.ftl");
        temp.process(entityClazz,out);
    }
}
