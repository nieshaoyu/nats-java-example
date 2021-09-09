package org.example.controller;

import org.example.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    private PublishService publishService;

    @GetMapping("/send_name")
    public String sendName(@RequestParam String name) {
        publishService.publish(name);
        return "send success";
    }

}
