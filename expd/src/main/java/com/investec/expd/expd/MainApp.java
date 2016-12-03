package com.investec.expd.expd;

import javax.persistence.EntityManagerFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.component.jpa.JpaComponent;
import org.apache.camel.main.Main;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.addRouteBuilder(new MyRouteBuilder());
        //setupDBDataSource(main);
        main.run(args);
    }
    
	private static void setupDBDataSource(Main main) throws Exception {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUsername("investec");
		ds.setPassword("password");
		ds.setUrl("jdbc:mysql://localhost:3306/investec");
		main.bind("ExperienceDiscoverer", ds);
	}
}

