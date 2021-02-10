package com.dada.base.mybatis;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * MBG 生成的实体类属性时添加中文注释
 */
public class MybatisGenerateComments extends DefaultCommentGenerator implements CommentGenerator {


    private boolean suppressAllComments = false;
    private boolean addRemarkComments = false;

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        field.addJavaDocLine("/**");

        // 获取列注释并加入到注解中
        String remarks = introspectedColumn.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator"));
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" * <p>" + remarkLine + "</p>");
            }
        }

        field.addJavaDocLine(" */");
    }
}
