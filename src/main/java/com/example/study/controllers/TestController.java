package com.example.study.controllers;

import com.example.study.models.Test;
import com.example.study.requests.RawDataRequest;
import com.example.study.services.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tests")
@RestController
public class TestController {
    final private TestService testService;

    TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("")
    public List<Test> search(@RequestParam String query) {
        return testService.search(query);
    }

    @PostMapping("")
    public Test register(@RequestBody ) {
        return testService.register(request);
    }
}
