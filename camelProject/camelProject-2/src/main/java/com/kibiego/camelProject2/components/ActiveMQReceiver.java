package com.kibiego.camelProject2.components;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQReceiver extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("activemq:testing-MQ")
                .log("log:receiving messages => ${body}");
    }
}
