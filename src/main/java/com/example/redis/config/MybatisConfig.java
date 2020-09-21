package com.example.redis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * MyBatis 配置
 */
@Configuration
@MapperScan("com.example.redis.dao.*")
public class MybatisConfig {

    @Value("${mysql.jdbc.driverClassName}")
    private String driverClassName;
    @Value("${mysql.jdbc.url}")
    private String url;
    @Value("${mysql.jdbc.username}")
    private String username;
    @Value("${mysql.jdbc.password}")
    private String password;
    /**
     * 连接池最大使用连接数
     */
    @Value("${mysql.jdbc.maxActive}")
    private int maxActive;
    /**
     * 初始化连接大小
     */
    @Value("${mysql.jdbc.initialSize}")
    private int initialSize;
    /**
     * 获取连接最大等待时间
     */
    @Value("${mysql.jdbc.maxWait}")
    private long maxWait;
    /**
     * 连接池最小空闲
     */
    @Value("${mysql.jdbc.minIdle}")
    private int minIdle;
    /**
     * 自动清除无用连接
     */
    @Value("${mysql.jdbc.removeAbandoned}")
    private String removeAbandoned;
    /**
     * 清除无用连接的等待时间
     */
    @Value("${mysql.jdbc.removeAbandonedTimeout}")
    private int removeAbandonedTimeout;
    /**
     * 连接属性
     */
    @Value("${mysql.jdbc.connectionProperties}")
    private String connectionProperties;

    @Value("${mysql.jdbc.timeBetweenEvictionRunsMillis}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${mysql.jdbc.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${mysql.jdbc.testOnReturn}")
    private boolean testOnReturn;

    @Bean(name = "druidDataSource")
    @Primary
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setMinIdle(minIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        if ("true".equals(removeAbandoned)) {
            dataSource.setRemoveAbandoned(true);
        } else {
            dataSource.setRemoveAbandoned(false);
        }
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dataSource.setConnectionProperties(connectionProperties);

        return dataSource;
    }

    @Bean(name = "druidTransactionManager")
    @Primary
    public PlatformTransactionManager druidTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("druidDataSource") DataSource rdsDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(rdsDataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] mappers = resolver.getResources("classpath*:mappers/*.xml");
        sessionFactory.setMapperLocations(mappers);
        return sessionFactory.getObject();
    }

}
