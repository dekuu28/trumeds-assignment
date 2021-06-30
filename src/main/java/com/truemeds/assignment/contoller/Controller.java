package com.truemeds.assignment.contoller;

import com.truemeds.assignment.service.MainLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private MainLogic mainLogic;

    @Autowired
    public Controller(MainLogic mainLogic){
        this.mainLogic = mainLogic;
    }

    @PostMapping("/assignment/{input}")
    private int processInput(@PathVariable("input") String input)
    {
        return mainLogic.countIterations(input);
    }
}
