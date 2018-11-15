//O(n)

class CountingSort {
    private static int findMax(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i == 0 || max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }


    public static void main(String args[]) {
        int[] arr = {10, 15, 19, 2, 15, 56, 15};

        //Find max of input array
        int maxValue = findMax(arr);

        //Contructor array of counting value
        int[] countingArr = new int[maxValue + 1];
        for(int i = 0; i <= maxValue; i++) {
            countingArr[i] = 0;
        }

        //Set count value
        for(int i = 0; i < arr.length; i++){
            countingArr[arr[i]]++;
        }

        //Larger or equal
        for(int i = 1; i <= maxValue; i++){
            countingArr[i] += countingArr[i - 1];
        }

        
        //Result array
        int[] resultArr = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            //From counting value to sorting index
            resultArr[countingArr[arr[i]] - 1] = arr[i];
            countingArr[arr[i]] = countingArr[arr[i]] - 1; 
        }


        //Printf
        for(int i = 0; i < arr.length; i++) {
            System.out.printf(resultArr[i] + " ");
        }
    }
}