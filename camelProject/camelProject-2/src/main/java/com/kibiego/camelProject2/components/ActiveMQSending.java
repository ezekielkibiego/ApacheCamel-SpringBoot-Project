package com.kibiego.camelProject2.components;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
//
//@Component
public class ActiveMQSending extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer://test?period=10000")
                .setBody(simple("testing 3"))
                .to("activemq:testing-MQ");
    }
}
