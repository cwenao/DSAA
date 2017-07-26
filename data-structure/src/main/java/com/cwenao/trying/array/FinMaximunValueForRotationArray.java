package com.cwenao.trying.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cwenao
 * @version $Id FinMaximunValueForRotationArray.java, v 0.1 2017-07-26 00:02 cwenao Exp $$
 */
public class FinMaximunValueForRotationArray {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinMaximunValueForRotationArray.class);

    private static int findMaximunValue(int[] array) {

        int sumValue = 0;
        int currentValue = 0;
        int maxValue;

        for(int i=0;i<array.length;i++) {
            sumValue += array[i];
            currentValue += i * array[i];
        }

        maxValue = currentValue;

        for(int i=1;i<array.length;i++) {

            currentValue += sumValue - array.length * array[array.length - i];

            if (currentValue > maxValue) {
                maxValue = currentValue;
            }
        }

        LOGGER.info("The maxValue is {} ", maxValue);

        return maxValue;
    }

    public static void main(String[] args) {
        int[] array = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        findMaximunValue(array);
    }

}
