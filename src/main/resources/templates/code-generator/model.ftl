package com.yangrd.codegenerator.factory;

import lombok.Data;
import lombok.EqualsAndHashCode;
<#list fields as field>
    <#list fields as field2>
        <#if field.fieldType == field2.fieldType>
            <#if field_index==field2_index>
import ${field.fieldType};
            <#else>
                <#break >
            </#if>
        </#if>
    </#list>
</#list>

/**
* ${tableName}
* ${tableComment}
*
* @author yangrd
* @date 2019/07/10
*/

@Data
@EqualsAndHashCode(of = "${meta.idName}")
public class ${clazzName?cap_first} {
<#list fields as field >

    /**
    * ${field.fieldDescription!''}
    */
    private ${field.fieldType?split('.')?last} ${field.fieldName}
</#list>
}
