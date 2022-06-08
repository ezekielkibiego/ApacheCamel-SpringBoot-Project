package com.kibiego.camelProject2.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestConsumerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer://testing-rest-api?period=5000")
                .log("Rest api calling")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:9090/api/deposit")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        String output = exchange.getIn().getBody(String.class);

                        System.out.println("output is: " + output);
                    }
                });

    }
}
