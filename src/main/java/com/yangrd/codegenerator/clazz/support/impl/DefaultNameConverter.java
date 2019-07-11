package com.yangrd.codegenerator.clazz.support.impl;

import com.yangrd.codegenerator.clazz.support.NameConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DefaultNameConverter
 *
 * @author yangrd
 * @date 2019/07/10
 */
public class DefaultNameConverter implements NameConverter {

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * 下划线转驼峰
     * @param s
     * @return
     */
    @Override
    public String apply(String s) {
        s = s.toLowerCase();
        Matcher matcher = linePattern.matcher(s);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
