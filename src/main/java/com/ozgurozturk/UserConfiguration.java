package com.ozgurozturk;

        import com.ozgurozturk.commands.CommandsConfiguration;
        import com.ozgurozturk.processes.ProcessesConfigration;
        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Import;
        import org.springframework.context.annotation.PropertySource;

/**
 * Created by Ozgur on 6.06.2017.
 */

@Configuration
@PropertySource("classpath:myAppProperties")
@Import({ProcessesConfigration.class, CommandsConfiguration.class})
public class UserConfiguration {

    public UserConfiguration() {

    }

    @Bean
    public RandomCustomerCreator randomCustomerCreator() {
        System.err.println("Creator");
        return new RandomCustomerCreator();
    }

    @Bean
    public UserDAO userDAO(@Value("${default.DAO}") final String defaultDao) {

        System.err.println("DAO");

        switch (defaultDao) {
            case "FILE_DAO":
                return new UserFileDAOImpl();
            case "DEFAULT_DAO":
                return new UserDAOImpl();
            case "DB_DAO":
                return new UserDataBaseDAOImpl();
            default:
                return new UserDAOImpl();
        }
    }

    @Bean
    public UserCache getUserCache() {
        System.err.println("CACHE");
        return new UserCache();
    }

    @Bean
    public UserManager getUserManager() {
        System.err.println("Manager");
        return new UserManager();
    }

    @Bean
    public UserProcessorFactory getUserProcessorFactory(){
        return new UserProcessorFactory();
    }


}
