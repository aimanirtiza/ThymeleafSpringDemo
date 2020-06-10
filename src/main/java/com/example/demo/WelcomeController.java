package com.example.demo;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("pageCount")
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @Value("${version}")
    private String version = "0";

    @Value("${environment}")
    private String environment = "undefined";

    @ModelAttribute("pageCount")
    AtomicInteger getPageCount() {
        return new AtomicInteger();
    }

    @RequestMapping("/")
    public String welcome(@ModelAttribute("pageCount") AtomicInteger pageCount, Map<String, Object> model) {
        model.put("message", this.message);
        model.put("version", this.version);
        model.put("environment", this.environment);
        model.put("count", pageCount.incrementAndGet());
        return "welcome";
    }

}