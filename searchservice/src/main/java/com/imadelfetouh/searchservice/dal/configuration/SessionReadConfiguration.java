package com.imadelfetouh.searchservice.dal.configuration;

import com.imadelfetouh.searchservice.dal.ormmodel.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class SessionReadConfiguration {

    private final static SessionReadConfiguration sessionReadConfiguration = new SessionReadConfiguration();
    private final ReadWriteConfiguration readWriteConfiguration;
    private final SessionFactory sessionFactory;

    public SessionReadConfiguration() {
        readWriteConfiguration = ReadWriteConfiguration.getInstance();
        Configuration configuration = new Configuration();

        Properties properties = readWriteConfiguration.getProperties();
        configuration.addProperties(properties);
        configuration.getProperties().put(Environment.URL, "jdbc:mysql://"+System.getenv("SEARCHSERVICE_MYSQL_REPLICA_HOST")+":"+System.getenv("SEARCHSERVICE_MYSQL_REPLICA_PORT")+"/searchservice");

        configuration.addAnnotatedClass(User.class);

        sessionFactory = configuration.configure().buildSessionFactory();
    }

    public static SessionReadConfiguration getInstance() {
        return sessionReadConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
