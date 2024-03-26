package org.example;

import java.util.ArrayList;
import java.util.List;

public class SumOfConsecutives {
    public static List<Integer> getSumConsecutives(List<Integer> inputList) {
        if (inputList.size() == 1) {
            return inputList;
        }
        List<Integer> result = new ArrayList<>();
        int sum = inputList.get(0);
        for (int i = 1; i < inputList.size(); i++) {
            if (inputList.get(i).equals(inputList.get(i - 1))) {
                sum += inputList.get(i);
            } else {
                result.add(sum);
                sum = inputList.get(i);
            }
        }
        result.add(sum); // add the last sum
        return result;
    }
}

/*
[1, 4, 4, 4, 0, 4, 3, 3, 1] // повертає [1, 12, 0, 4, 6, 1]
[1, 1, 7, 7, 3] // повертає [2, 14, 3]
[-5, -5, 7, 7, 12, 0] // повертає [-10, 14, 12, 0]
[1, 2 , 2]// повертає [1, 4]
 */
