package com.kibiego.camelProject.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class WhenMethod extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/Tz?noop=true")
                .choice()
                .when(simple("${file:ext} == 'json'"))
                .to("file:files/Kenya")
                .when(simple("${file:ext} == 'xml'"))
                .to("file:files/Tanzania")
                .otherwise()
                .to("file:files/Tz");
    }
}
