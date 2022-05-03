package kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Controller;

import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.Controller.SwaggerController;
import kz.iitu.itse1909r_spring.ushurbakiev_davlatbek_itse1909r.config.SwaggerConf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class SwaggerControllerTest {
    SwaggerController swaggerController = new SwaggerController();


    @InjectMocks
    SwaggerConf swaggerConf;



    @Test
    void testSayHello() {
        String result = swaggerController.sayHello();
        swaggerConf = new SwaggerConf();

        Assertions.assertEquals("Swagger Hello World", result);

        Assertions.assertNotNull(swaggerConf.apiInfo());
        Assertions.assertNotNull(swaggerConf.postPaths());

    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme