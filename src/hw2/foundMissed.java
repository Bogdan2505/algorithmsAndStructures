package hw2;

public class foundMissed {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 4, 5, 6};

        System.out.println(fountMissed(arr));
    }

    public static int fountMissed(int[] arr) {
        if (arr.length == 0 ){
            return 1;
        }

        int number = 0;
        int left = 0;
        int right = arr.length;
        int mid;

        while (left < right ) {
            mid = (right - left) / 2 + left;

            if (arr[mid]  - arr[mid - 1] == 2 ){
                return arr[mid] - 1;
            }
            if ( arr[mid + 1]  - arr[mid] == 2){
                return arr[mid] + 1;
            }
             if ( arr[mid] == mid + 1 ){
                left = mid + 1;
            }else if (arr[mid] > mid + 1 ){
                right = mid - 1;
            }
        }
        return number;
    }
}
