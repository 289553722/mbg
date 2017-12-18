package com.wind.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * mybatis代码生成器
 * 用于实现
 *
 * @author wind
 * @date 2017-12-17 20:47:26
 */
public class MyGenerator implements CommentGenerator {

    /**
     * 属性.
     */
    private Properties properties;

    /**
     * 注释是否显示时间.
     */
    private boolean suppressDate;

    /**
     * 是否显示注释.
     */
    private boolean suppressAllComments;

    /**
     * 是否生成字段注释
     */
    private boolean addRemarkComments;

    /**
     * 时间格式
     * 
     */
    private SimpleDateFormat dateFormat;

    /**
     * 初始化代码生成工具
     */
    public MyGenerator() {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        addRemarkComments = false;
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.CommentGenerator#addJavaFileComment(org.mybatis.generator.api.dom.java.CompilationUnit)
     */
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        // add no file level comments by default
    }

    /**
     * xml mapper注释生成方法
     *
     * @param xmlElement the xml element
     */
    public void addComment(XmlElement xmlElement) {
        if (suppressAllComments) {
            return;
        }
        
        /**
        xmlElement.addElement(new TextElement("<!--"));

        StringBuilder sb = new StringBuilder();
        sb.append("  警告 - ");
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        xmlElement.addElement(new TextElement(sb.toString()));
        xmlElement.addElement(new TextElement(
                        "  此元素是mbg自动生成的代码，请不要修改."));

        String s = getDateString();
        if (s != null) {
            sb.setLength(0);
            sb.append("  此元素生成的时间是 ");
            sb.append(s);
            sb.append('.');
            xmlElement.addElement(new TextElement(sb.toString()));
        }

        xmlElement.addElement(new TextElement("-->"));
         */
    }

    /* (non-Javadoc)
     * @see org.mybatis.generator.api.CommentGenerator#addRootComment(org.mybatis.generator.api.dom.xml.XmlElement)
     */
    public void addRootComment(XmlElement rootElement) {
        // add no document level comments by default
    }

    /*
     * 获取设置
     */
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

        String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        } else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * This method adds the custom javadoc tag for. You may do nothing if you do not wish to include the Javadoc tag -
     * however, if you do not include the Javadoc tag then the Java merge capability of the eclipse plugin will break.
     *
     * @param javaElement       the java element
     * @param markAsDoNotDelete the mark as do not delete
     */
    protected void addJavadocTag(JavaElement javaElement,
                                 boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" 勿删");
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }

    /**
     * 获取当前时间
     */
    protected String getDateString() {
        if (suppressDate) {
            return null;
        } else if (dateFormat != null) {
            return dateFormat.format(new Date());
        } else {
            return new Date().toString();
        }
    }

    /* 
     * example内部类注释
     */
    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        /**
        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * aaa This class was generated by MyBatis Generator.");

        sb.append(" * This class corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, false);

        innerClass.addJavaDocLine(" * /");
         */
    }

    /* 
     * 实体类注释
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
                                     IntrospectedTable introspectedTable) {
        if (suppressAllComments || !addRemarkComments) {
            return;
        }
        
        /**
        StringBuilder sb = new StringBuilder();

        topLevelClass.addJavaDocLine("/**");

        String remarks = introspectedTable.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            topLevelClass.addJavaDocLine(" * Database Table Remarks:");
            String[] remarkLines = remarks.split(System.getProperty("line.separator")); 
            for (String remarkLine : remarkLines) {
                topLevelClass.addJavaDocLine(" *   " + remarkLine); 
            }
        }
        topLevelClass.addJavaDocLine(" *");

        topLevelClass
                .addJavaDocLine(" * This class aaabbb was generated by MyBatis Generator.");

        sb.append(" * This class corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(sb.toString());

        addJavadocTag(topLevelClass, true);

        topLevelClass.addJavaDocLine(" * /");
        */

        StringBuilder sb = new StringBuilder();
        topLevelClass.addJavaDocLine("/**");
        String remarks = introspectedTable.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator")); 
            for (String remarkLine : remarkLines) {
                topLevelClass.addJavaDocLine(" * " + remarkLine); 
            }
        }else{
            topLevelClass.addJavaDocLine(" * ");
        }
        topLevelClass
                .addJavaDocLine(" * 此类是由代码生成工具生成的类.");
        sb.append(" * 此类对应于数据库表 ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        topLevelClass.addJavaDocLine(sb.toString());
        addJavadocTag(topLevelClass, true);
        topLevelClass.addJavaDocLine(" */");
    }

    /* 
     * 枚举类注释
     */
    public void addEnumComment(InnerEnum innerEnum,
                               IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**");
        innerEnum
                .addJavaDocLine(" * 此类由代码生成工具生成.");

        sb.append(" * 此类对应数据库表 ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */");
    }

    /* 
     * 实体类字段注释
     */
    public void addFieldComment(Field field,
                                IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        /**
        field.addJavaDocLine("/**");

        String remarks = introspectedColumn.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            field.addJavaDocLine(" * Database Column Remarks:");
            String[] remarkLines = remarks.split(System.getProperty("line.separator")); 
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" *   " + remarkLine); 
            }
        }

        field.addJavaDocLine(" *");
        field
                .addJavaDocLine(" * This field was generated by MyBatis Generator.");

        StringBuilder sb = new StringBuilder();
        sb.append(" * This field corresponds to the database column ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" * /");
        */

        field.addJavaDocLine("/**");
        String remarks = introspectedColumn.getRemarks();
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
            String[] remarkLines = remarks.split(System.getProperty("line.separator")); 
            for (String remarkLine : remarkLines) {
                field.addJavaDocLine(" * " + remarkLine);
            }
        } else {
            field.addJavaDocLine(" * ");
        }
        field.addJavaDocLine(" */");
    }

    /* 
     * example类注释
     */
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        /**
        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**");
        field
                .addJavaDocLine(" * This  sss field was generated by MyBatis Generator.");

        sb.append(" * This field corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString());

        addJavadocTag(field, false);

        field.addJavaDocLine(" * /");
         */
        
        /**
        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**");
        sb.append(" *  ");
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" * /");
         */
    }

    /* 
     * example方法注释
     */
    public void addGeneralMethodComment(Method method,
                                        IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        /**
        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");
        method
                .addJavaDocLine(" * This medddthod was generated by MyBatis Generator.");

        sb.append(" * This method corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" * /");
         */
    }

    /** 
     * getter方法注释
     */
    public void addGetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        
        /**
        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");
        method
                .addJavaDocLine(" * This method was generated by MyBatis Generator.");

        sb.append(" * This method returns the value of the database column ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" *");

        sb.setLength(0);
        sb.append(" * @return the value of ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" * /");
         */
    }

    /** 
     * setter 方法注释
     */
    public void addSetterComment(Method method,
                                 IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        
        /**
        StringBuilder sb = new StringBuilder();

        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * This method was generated by MyBatis Generator.");

        sb.append(" * This method sets the value of the database column ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        method.addJavaDocLine(" *");

        Parameter parm = method.getParameters().get(0);
        sb.setLength(0);
        sb.append(" * @param ");
        sb.append(parm.getName());
        sb.append(" the value for ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append('.');
        sb.append(introspectedColumn.getActualColumnName());
        method.addJavaDocLine(sb.toString());

        addJavadocTag(method, false);

        method.addJavaDocLine(" * /");
         */
    }

    /* 
     * example内部查询条件类注释
     */
    public void addClassComment(InnerClass innerClass,
                                IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (suppressAllComments) {
            return;
        }
        /**
        StringBuilder sb = new StringBuilder();

        innerClass.addJavaDocLine("/**");
        innerClass
                .addJavaDocLine(" * This class was generated by MyBatis Generator.");

        sb.append(" * This class corresponds to the database table ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());

        addJavadocTag(innerClass, markAsDoNotDelete);

        innerClass.addJavaDocLine(" * /");
        */
        /**
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine(" * 本类是由mybatis代码生成工具生成.");
        sb.append(" * 数据库表： ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(sb.toString());
        //addJavadocTag(innerClass, markAsDoNotDelete);
        innerClass.addJavaDocLine(" * /");
         */
    }
}
