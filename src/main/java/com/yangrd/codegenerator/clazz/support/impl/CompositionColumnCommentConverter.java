package com.yangrd.codegenerator.clazz.support.impl;

import com.yangrd.codegenerator.clazz.support.ColumnCommentConverter;
import com.yangrd.codegenerator.clazz.support.FieldDescription;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * CompositionColumnInfoConverter
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Slf4j
@AllArgsConstructor
public class CompositionColumnCommentConverter implements ColumnCommentConverter {

    private List<ColumnCommentConverter> columnInfoConverters;

    @Override
    public FieldDescription converter(String columnComment) {
        return columnInfoConverters.stream().filter(columnInfoConverter -> columnInfoConverter.isSupport(columnComment)).map(columnInfoConverter -> columnInfoConverter.converter(columnComment)).findFirst().orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean isSupport(String columnComment) {
        return columnInfoConverters.stream().anyMatch(columnInfoConverter -> columnInfoConverter.isSupport(columnComment));
    }
}
