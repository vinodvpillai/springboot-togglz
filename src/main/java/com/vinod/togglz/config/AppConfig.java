package com.vinod.togglz.config;

import com.vinod.togglz.util.MyFeatures;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.spi.FeatureProvider;

@Configuration
public class AppConfig {

    /**
     * Model mapper.
     *
     * @return the model mapper
     */
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Togglz feature provider bean
     *
     * @return - Feature provider object.
     */
    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(MyFeatures.class);
    }
}
