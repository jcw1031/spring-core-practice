package woopaca.practice.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import woopaca.practice.AutoAppConfig;

class AutoAppConfigTest {

    @Test
    void autoAppConfigTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        int beanDefinitionCount = ac.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount = " + beanDefinitionCount);
    }

}