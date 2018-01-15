package com.ozgurozturk.processes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ozgur on 9.06.2017.
 */

@Configuration
public class ProcessesConfigration {

    @Bean
    public AdminProcess getAdminProcess() {
        return new AdminProcess();
    }

    @Bean
    public GoldCustomerProcess getGoldCustomerProcess() {
        return new GoldCustomerProcess();
    }

    @Bean
    public SilverCustomerProcess getSilverCustomerProcess() {
        return new SilverCustomerProcess();

    }

    @Bean
    public BronzeCustomerProcess getBronzeCustomerProcess() {
        return new BronzeCustomerProcess();
    }
}
