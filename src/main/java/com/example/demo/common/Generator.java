package com.example.demo.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import java.sql.Types;
import java.util.Collections;
import java.util.Scanner;

public class Generator {

    public static void main(String[] args) {
        // 数据库连接的URL地址
        String url = "jdbc:mysql://192.168.220.128:3306/wsm?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
        // 账号
        String username = "root";
        // 密码
        String password = "zh13079058260";
        // 作者名称
        String author = "your_author";

        // 创建Scanner对象用于接收用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表名，多个表名请用逗号分隔:");
        String tablesInput = scanner.nextLine();

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .outputDir(System.getProperty("user.dir") + "/src/main/java") // 指定输出目录
                   
                            .dateType(DateType.ONLY_DATE); // 设置日期类型，只使用 java.util.Date
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder -> {
                    builder.parent("com.example.demo") // 设置父包名
                            .moduleName(null) // 如果不需要模块名，可以设置为null
                            .entity("entity") // 设置entity包名
                            .mapper("mapper") // 设置mapper包名
                            .service("service") // 设置service包名
                            .serviceImpl("service.impl") // 设置serviceImpl包名
                            .controller("controller"); // 设置controller包名
                })
                .strategyConfig(builder -> {
                    String[] tableNames = tablesInput.split(","); // 将输入的表名分割成数组
                    builder.addInclude(tableNames) // 设置需要生成的表名
                            .entityBuilder()
                            .naming(NamingStrategy.underline_to_camel) // 实体类命名策略
                            .enableLombok() // 开启Lombok
                            .enableTableFieldAnnotation() // 开启生成实体时，生成字段注解
                            .controllerBuilder()
                            .enableRestStyle() // 开启生成@RestController控制器
                            .enableHyphenStyle() // 开启驼峰转连字符
                            .mapperBuilder()
                            .enableMapperAnnotation() // 开启@Mapper注解
                            .enableBaseResultMap() // 启用生成基本的ResultMap
                            .enableBaseColumnList() // 启用生成基本的SQL片段
                            .serviceBuilder()
                            .formatServiceFileName("%sService") // 设置服务接口名后缀
                            .formatServiceImplFileName("%sServiceImpl"); // 设置服务实现类名后缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}