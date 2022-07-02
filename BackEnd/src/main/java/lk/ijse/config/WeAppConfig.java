package lk.ijse.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tharindu Nilanga
 * @created 6/26/2022
 */
@Configuration
public class WeAppConfig {

        @Bean
        public ModelMapper modelMapper(){
            return new ModelMapper();
        }
}
