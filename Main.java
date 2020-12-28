public class Main
{
    public static void main(String[] args) throws RuntimeException
    {
        int[] arr1 = {1,4,5,6,7,8,9,0,2};
        int[] arr2 = {0,2,5,6,7,8,9,0,2};
        int[] arr3 = {4,4,5,6,7,8,9,0,2};
        int[] arr4 = {1,1,5,6,7,8,9,0,2};

        Only1And4(arr1);
    }

    public static boolean Only1And4(int[] arr)
    {
        boolean i1 = false, i4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) i1 = true;
            else if (arr[i] == 4) i4 = true;
            else return false;
        }
        return i1 && i4;
    }
}
