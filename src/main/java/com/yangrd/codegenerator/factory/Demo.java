package com.yangrd.codegenerator.factory;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Demo
 *
 * @author yangrd
 * @date 2019/07/10
 */
@Data
@EqualsAndHashCode(of = "id")
public class Demo {

    private String id;

    /**
     *
     */
    private String date;
}
