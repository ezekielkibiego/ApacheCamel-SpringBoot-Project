package com.kibiego.camelProject.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class WhenMethod extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/Tz")
                .choice()
                .when(simple("${header.Tz} == '.json'"))
                .to("file:files/Kenya")
                .when(simple("${header.Tz} == '.xml'"))
                .to("file:files/Tanzania")
                .otherwise()
                .to("file:files/Tz");
    }
}
