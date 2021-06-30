package com.truemeds.assignment.service;

import org.springframework.stereotype.Component;

@Component
public class CountIterationsLogic {

    int processInput(String input) {

        //set count to 0
        int count = 0;

        //check if input is null
        if(input == null){
            //if null return 0
            return count;
        }

        //remove whitespaces
        input = input.replaceAll("\\s","");

        //process input
        while(true){
            char[] arrayOfChars = input.toCharArray();

            boolean modifiedInput = false;
            for(int i = 0; i < arrayOfChars.length; i++){
                int j = i;
                while(j+1 < arrayOfChars.length){
                    if(arrayOfChars[j+1] == arrayOfChars[i])
                        j++;
                    else
                        break;
                }
                if(i != j)
                {
                    //remove duplicate chars from input
                    input = input.substring(0,i) + input.substring(j+1);
                    //increment the count
                    count++;
                    //update the flag
                    modifiedInput = true;
                    break;
                }
            }
            if(!modifiedInput){
                break;
            }
        }
        return count;
    }
}
