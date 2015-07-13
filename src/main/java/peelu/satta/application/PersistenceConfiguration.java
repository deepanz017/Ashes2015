package peelu.satta.application;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.platform.database.MySQLPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import peelu.satta.config.AppProperties;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("peelu.satta.persistence.repositories")
@EnableTransactionManagement
public class PersistenceConfiguration {


    @Autowired
    AppProperties applicationProperties;

    private static final int INITIAL_POOL_SIZE = 20;
    private static final int MAX_POOL_SIZE = 50;



    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws PropertyVetoException {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
        entityManagerFactory.setPackagesToScan("peelu.satta.persistence");
        Properties properties = new Properties();
        properties.put(PersistenceUnitProperties.BATCH_WRITING, "JDBC");
        properties.put(PersistenceUnitProperties.WEAVING, "false");
        entityManagerFactory.setJpaProperties(properties);
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(applicationProperties.getDatabaseUserName());
        dataSource.setPassword(applicationProperties.getDatabasePassword());
        dataSource.setDriverClass(applicationProperties.getDatabaseDriver());
        dataSource.setJdbcUrl(applicationProperties.getDatabaseHost());
        dataSource.setInitialPoolSize(INITIAL_POOL_SIZE);
        dataSource.setMaxPoolSize(MAX_POOL_SIZE);
        dataSource.setTestConnectionOnCheckout(true);
        dataSource.setAcquireIncrement(5);
        dataSource.setUnreturnedConnectionTimeout(3600);
        dataSource.setDebugUnreturnedConnectionStackTraces(true);
        dataSource.setMaxIdleTimeExcessConnections(10);
        System.out.print("Peelu Bhai Jaan ka password hai : " +applicationProperties.getDatabasePassword());
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        EclipseLinkJpaVendorAdapter eclipseLinkJpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
        eclipseLinkJpaVendorAdapter.setShowSql(true);
        eclipseLinkJpaVendorAdapter.setGenerateDdl(true);
        eclipseLinkJpaVendorAdapter.setDatabase(Database.MYSQL);
        eclipseLinkJpaVendorAdapter.setDatabasePlatform(MySQLPlatform.class.getName());
        return eclipseLinkJpaVendorAdapter;
    }
}
