public class Demo {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static final int NOT_FOUND = -1;

    public static int linearSearch( int keySearch) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == keySearch) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
