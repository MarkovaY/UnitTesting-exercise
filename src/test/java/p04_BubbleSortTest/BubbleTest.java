package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] numbers = {2, 14, -3, 67, 43, 69};
        int[] sortedArray = {-3, 2, 14, 43, 67, 69};
        Bubble.sort(numbers);
        assertArrayEquals(sortedArray, numbers);
    }

}