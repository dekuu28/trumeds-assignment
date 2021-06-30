package com.truemeds.assignment.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.truemeds.assignment.entities.InputDetailsEntity;
import com.truemeds.assignment.entities.OutputDetailsEntity;
import com.truemeds.assignment.repository.InputDetailsRepository;
import com.truemeds.assignment.repository.OutputDetailsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.sql.Timestamp;
import java.util.List;

/**
 * Main service class
 */
@Service
@NoArgsConstructor
public class AssignmentService {

    private static final Logger logger = LogManager.getLogger(AssignmentService.class);

    private CountIterationsLogic countIterationsLogic;
    private InputDetailsRepository inputDetailsRepository;
    private OutputDetailsRepository outputDetailsRepository;

    @Autowired
    public AssignmentService(CountIterationsLogic countIterationsLogic, InputDetailsRepository inputDetailsRepository, OutputDetailsRepository outputDetailsRepository) {
        this.countIterationsLogic = countIterationsLogic;
        this.inputDetailsRepository = inputDetailsRepository;
        this.outputDetailsRepository = outputDetailsRepository;
    }

    /**
     * Method to count number of iterations required to process input
     * @param input input
     * @return int result
     */
    public int countIterations(String input) {
        int output = countIterationsLogic.processInput(input);
        logger.info("Request processed successfully for input : {}",input);
        return output;
    }

    /**
     * Method to fetch data from input table, process it and store result in output table.
     */
    public void processInputAndStoreOutput(){
        this.processInputAndSaveResultInOutputTable();
    }

    private void processInputAndSaveResultInOutputTable(){
        InputDetailsEntity inputDetailsEntity = getInputDetails().get(0);

        OutputDetailsEntity outputDetailsEntity = new OutputDetailsEntity();
        outputDetailsEntity.setId(inputDetailsEntity.getId());
        outputDetailsEntity.setTimestamp(new Timestamp(System.currentTimeMillis()).toString());
        outputDetailsEntity.setInput(inputDetailsEntity.getInput());
        if(inputDetailsEntity.getInput() != null){
            outputDetailsEntity.setOutput(countIterations(StringUtils.trimAllWhitespace(inputDetailsEntity.getInput())));
        } else {
            outputDetailsEntity.setOutput(0);
        }

        this.saveOutput(outputDetailsEntity);
    }

    private List<InputDetailsEntity> getInputDetails() {
        return inputDetailsRepository.findAll();
    }

    private void saveOutput(OutputDetailsEntity outputDetailsEntity) {
        this.outputDetailsRepository.save(outputDetailsEntity);
    }
}
