package hw5;

public class Rec {


    public static void main(String[] args) {

        // System.out.println(pow(5, 3));
        System.out.println(backpack(4, 0, 0));
    }


    public static int pow(int number, int pow) {

        if (pow == 1) {
            return number;
        }
        return number * pow(number, pow - 1);
    }

    //Написать программу «Задача о рюкзаке» с помощью рекурсии.
    //1 - ноут   2- телфон   3 - утюг  4 - монитор 5 - комп
    private static int[] costArr = new int[]{1000, 500, 100, 950, 600};
    private static int[] sizeArr = new int[]{4, 2, 1, 3, 2};
    static int result;

    public static int backpack(int size, int index, int result) {
        int newResult = 0;
        int sizeT = size;
        if (index == size) {
            return result;
        }

        for (int i = index; i < sizeArr.length; i++) {
            if (newResult < costArr[i] && sizeT - sizeArr[i] >= 0) {
                newResult += costArr[i];
                sizeT -= sizeArr[i];
            }
        }
        if ( newResult > result){
            result = newResult;
        }
        index++;
        return backpack(size, index, result);
    }


}
