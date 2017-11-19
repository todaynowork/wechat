package com.tn.wechat;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.mybatis.cli")
public class MybatisConfig {
	
//	  @Bean
//	  public DataSource dataSource() {
////	    return new EmbeddedDatabaseBuilder().addScript("schema.sql").build();
//		  return null;
//	  }

        @ConfigurationProperties("app.datasource")
        @Bean
        public DataSource dataSource() {
            return DataSourceBuilder.create().build();
        }

	  @Bean
	  public SqlSessionFactory sqlSessionFactory() throws Exception {
	    SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource());
          PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

          sessionFactory.setMapperLocations(resolver.getResources("classpath:/xml/*.xml"));
//          sessionFactory.setMapperLocations(new Resource[]{new ClassPathResource("xml/*.xml")});
	    return sessionFactory.getObject();
	  }

}
