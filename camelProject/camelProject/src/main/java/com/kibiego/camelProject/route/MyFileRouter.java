package com.kibiego.camelProject.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyFileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/Tz")
                .log("${body}")
                .to("file:files/Kenya");
    }
}
