package com.yangrd.codegenerator.config;

import com.yangrd.codegenerator.clazz.EntityClazzHandler;
import com.yangrd.codegenerator.clazz.support.ColumnCommentConverter;
import com.yangrd.codegenerator.clazz.support.ColumnDataTypeMapper;
import com.yangrd.codegenerator.clazz.support.EntityClazzHook;
import com.yangrd.codegenerator.clazz.support.NameConverter;
import com.yangrd.codegenerator.clazz.support.impl.*;
import com.yangrd.codegenerator.extract.DataBaseExtract;
import com.yangrd.codegenerator.extract.inner.JdbcDataBaseExtract;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * CodeGeneratorConfig
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Configuration
public class CodeGeneratorConfig {

    @Bean
    public DataBaseExtract dataBaseExtract(JdbcTemplate jdbcTemplate) {
        return new JdbcDataBaseExtract(jdbcTemplate);
    }

    @Bean
    public ColumnCommentConverter jsonColumnCommentConverter() {
        return new JsonColumnCommentConverter();
    }

    @Bean
    public ColumnCommentConverter stringColumnCommentConverter() {
        return new StringColumnCommentConverter();
    }

    @Bean
    @Primary
    public ColumnCommentConverter compositionColumnCommentConverter(List<ColumnCommentConverter> columnCommentConverters) {
        return new CompositionColumnCommentConverter(columnCommentConverters);
    }

    @Bean
    @ConditionalOnMissingBean(ColumnDataTypeMapper.class)
    public ColumnDataTypeMapper columnDataTypeMapper() {
        return new DefaultColumnDataTypeMapper();
    }

    @Bean
    @ConditionalOnMissingBean(NameConverter.class)
    public NameConverter nameConverter() {
        return new DefaultNameConverter();
    }

    @Bean
    public EntityClazzHook idEntityClazzHook() {
        return new IdEntityClazzHook();
    }

    @Bean
    public EntityClazzHook entityClazzHook(List<EntityClazzHook> entityClazzHooks) {
        return new CompositionEntityClassHook(entityClazzHooks);
    }

    @Bean
    public EntityClazzHandler entityClazzHandler(ColumnCommentConverter columnCommentConverter, ColumnDataTypeMapper columnDataTypeMapper, NameConverter nameConverter, DataBaseExtract dataBaseExtract, EntityClazzHook entityClazzHook) {
        return new EntityClazzHandler(columnCommentConverter, columnDataTypeMapper, nameConverter, dataBaseExtract, entityClazzHook);
    }

}
