public class BinarySearch {
    public  static final int NOT_FOUND = -1;
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    static int binarySearch( int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return NOT_FOUND; /* Now high < low, key not found */
    }

    public static void main(String[] args) {
        System.out.println(binarySearch( 2));  /* 0 */
        System.out.println(binarySearch(11)); /* 4 */
        System.out.println(binarySearch(79)); /*12 */
        System.out.println(binarySearch(1));  /*-1 */
        System.out.println(binarySearch(5));  /*-1 */
        System.out.println(binarySearch(80)); /*-1 */
    }
}

