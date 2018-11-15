class InterpolationSearch {
    private static int Search(int[] arr, int x) {
        int head = 0, 
            tail = arr.length - 1;

        while (head <= tail && x >= arr[head] && x <= arr[tail]) {
            int pos = head + ((x - arr[head]) * (tail - head) / (arr[tail] - arr[head]));

            if(arr[pos] == x)
                return pos;

            if(arr[pos] < x) {
                head = pos + 1;
            }

            else {
                tail = pos - 1;
            }
        }

        return -1;
    }

    public static void main(String args[]) {
        int[] arr = {0, 15, 69, 156, 258, 366, 756, 895, 965, 1125};

        int index = Search(arr, 895);

        System.out.println(index);

    }
}