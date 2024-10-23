package com.programacion2.mancusoaugusto;

import com.programacion2.mancusoaugusto.config.AsyncSyncConfiguration;
import com.programacion2.mancusoaugusto.config.EmbeddedRedis;
import com.programacion2.mancusoaugusto.config.EmbeddedSQL;
import com.programacion2.mancusoaugusto.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { Monolito3P2BeApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedRedis
@EmbeddedSQL
public @interface IntegrationTest {
}
