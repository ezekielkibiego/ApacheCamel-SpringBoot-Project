package com.kibiego.camelProject.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;



@Component
public class SplitRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {
       from ("file:files/Tz?noop=true&idempotent=true&shuffle=true")
                .split().xpath("//xml/data/customer/name")
                .log("${body}")
                .to("file:files/Kenya?idempotent=true&fileName=customerName.txt");

    }
}
