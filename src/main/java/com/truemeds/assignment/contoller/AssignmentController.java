package com.truemeds.assignment.contoller;

import com.truemeds.assignment.service.AssignmentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class
 */
@RestController
public class AssignmentController {

    private static final Logger logger = LogManager.getLogger(AssignmentService.class);

    private AssignmentService assignmentService;

    /**
     * Constructor to autowire assignmentService
     * @param assignmentService AssignmentService instance
     */
    @Autowired
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    /**
     * Endpoint which takes input as a path variable and gives processed output back
     * @param input input
     * @return int output
     */
    @PostMapping("/assignment/{input}")
    private int processInput(@PathVariable("input") String input)
    {
        logger.info("Request received with input : {}",input);
        return assignmentService.countIterations(input);
    }

    /**
     * Endpoint to update tables ( process input and store output )
     */
    @GetMapping("/assignment/processInput")
    private void processInput()
    {
        assignmentService.processInputAndStoreOutput();
    }

}
