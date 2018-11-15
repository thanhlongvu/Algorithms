//O(n)
//Just with digits number

class RadixSort {

    private static void CoutingSortSpecial(int[] nums, int d) {
        int size = nums.length;

        int[] count = new int[10];
        
        for(int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        //Counting by value: 0 -> 9
        for(int i = 0; i < size; i++) {
            count[(nums[i]/d) % 10]++;
        }

        //total
        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }


        //Result array
        int[] result = new int[size];
        for(int i = size - 1; i >= 0; i--) {
        //for(int i = 0; i < size; i++) {
            result[count[(nums[i] / d) % 10] - 1] = nums[i];
            count[(nums[i] / d) % 10]--;
        }

        //Assign value to old array
        for(int i = 0; i < size; i++) {
            nums[i] = result[i];
        }
    }

    private static int findMaxValue(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || max < nums[i]) {
                max = nums[i];
            }
        }

        return max;
    }


    public static void main(String args[]) {
        int[] nums = {123, 564, 12, 56, 9456, 5632, 12, 3658, 32568, 1235, 213, 12, 56, 98, 2154, 256};

        int maxValue = findMaxValue(nums);

        for(int i = 1; maxValue / i > 0; i *= 10) {
            CoutingSortSpecial(nums, i);
        }

        //Printf
        for(int i = 0; i < nums.length; i++) {
            System.out.printf(nums[i] + " ");
        }
    }
}