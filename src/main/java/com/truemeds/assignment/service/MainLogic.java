package com.truemeds.assignment.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MainLogic {

    private Integer count;

    public int countIterations(String input){
        count = 0;
        processInput(StringUtils.trimAllWhitespace(input));
        return count;
    }

    private void processInput(String input) {
        while(true){
            char[] arrayOfChars = input.toCharArray();
            int i,j, k = 0;
            for(i = 0; i < arrayOfChars.length; i++){
                j = i;
                while(j+1 < arrayOfChars.length){
                    if(arrayOfChars[j+1] == arrayOfChars[i])
                        j++;
                    else
                        break;
                }

                if(i != j)
                {
                    input = input.substring(0,i) + input.substring(j+1);
                    count++;
                    k++;
                    break;
                }
            }
            if(k == 0){
                break;
            }
        }
    }
}
