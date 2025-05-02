package com.wms.common;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CodeGenerator {
    /**
     * <p>
     * Read from console
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("Please enter" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("Please enter again: " + tip + "！");
    }
    /**
     * Steps:
     * 1. Modify the data source including URL and password. See section I below.
     * 2. Module configuration, you can change the package name.
     * 3. Modify the template (optional).
     * @param args
     */
    public static void main(String[] args) {
        // Code generator
        AutoGenerator mpg = new AutoGenerator();
        // Global configuration
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir")+"/WMS/wms";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("wms");
        gc.setOpen(false);
        gc.setSwagger2(true); // Swagger2 annotations for entity fields
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        // Remove the 'I' prefix from service interface names (e.g. UserService instead of IUserService)
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);
        // Data source configuration
        DataSourceConfig dsc = new DataSourceConfig();
        // I. Modify your data source configuration here
        dsc.setUrl("jdbc:mysql://localhost:3306/wms?useUnicode=true&characterEncoding=UTF8&useSSL=false");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("student");
        mpg.setDataSource(dsc);
        // Package configuration
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName(scanner("Module name"));
        // II. Module configuration
        pc.setParent("com.wms")
                .setEntity("entity")
                .setMapper("mapper").setService("service")
                .setServiceImpl("service.impl")
                .setController("controller");
        mpg.setPackageInfo(pc);
        // Custom configuration
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // If template engine is freemarker
        String templatePath = "templates/mapper.xml.ftl";
        // If template engine is velocity
        // String templatePath = "/templates/mapper.xml.vm";
        // Custom output configuration
        List<FileOutConfig> focList = new ArrayList<>();
        // Custom configuration will take precedence
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // Customize output file name. If Entity has prefix/suffix, be aware that XML name may change accordingly.
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" +
                        StringPool.DOT_XML;
            }
        });
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // Check whether to create custom directories
                checkDir("Call default method to create directories, use custom for yours.");
                if (fileType == FileType.MAPPER) {
                    // Return false if mapper file already exists to avoid regeneration
                    return !new File(filePath).exists();
                }
                // Allow generation of template files
                return true;
            }
        });
        */
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);// Configure template
        TemplateConfig templateConfig = new TemplateConfig();
        // Custom template path, do not include .ftl/.vm as it will detect based on engine

        // III. Modify template if needed
        /*templateConfig.setEntity("templates/entity2.java");
        templateConfig.setService("templates/service2.java");
        templateConfig.setController("templates/controller2.java");
        templateConfig.setMapper("templates/mapper2.java");
        templateConfig.setServiceImpl("templates/serviceimpl2.java");*/
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // Strategy configuration
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // strategy.setSuperEntityClass("Your own base entity class, if any");
        // strategy.setSuperEntityClass("BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // Common superclass
        // strategy.setSuperControllerClass("BaseController");
        // strategy.setSuperControllerClass("you own parent controller, if there isn't, then there is not need to set");
        // Fields in the superclass
        // strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("Table name(s), separated by comma").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        // IV. Remove table prefix if needed (e.g. remove "tb_" from "tb_user" to map to "User")
        //strategy.setTablePrefix("tb_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}