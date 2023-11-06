package com.aunon.serviceprice.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Aunon
 * @Date: 2023/10/26/12:08
 * @Description:
 */
public class MysqlGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-price?characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root","123456")
                .globalConfig(builder -> {
                    builder.author("Aunon").fileOverride().outputDir("C:\\Users\\LJH\\IdeaProjects\\online-taxi-public\\service-price\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.aunon.serviceprice").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "C:\\Users\\LJH\\IdeaProjects\\online-taxi-public\\service-price\\src\\main\\java\\com\\aunon\\serviceprice\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("price_rule");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
