package io.hxcode;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Bootstrap.class);

    public Bootstrap() {
    }

    @EventListener
    public void init(StartupEvent event) {
        logger.info("Startup");
        var person = new Person("Max", "Mustermann");
        var personDto = PersonMapper.INSTANCE.personToPersonDto(person);
        logger.info("personDto firstname: {}", personDto.getFirstname()); // Max
        logger.info("personDto lastname: {}", personDto.getLastname()); // Mustermann
    }

}