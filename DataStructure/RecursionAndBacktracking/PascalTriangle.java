package Recursion;

public class PascalTriangle {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        // code here
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);

        if (n == 1) {
            return list;
        }

        ArrayList<Long> prev = nthRowOfPascalTriangle(n - 1);

        for (int i = 1; i < (n + 1) / 2; i++) {
            long val = (prev.get(i - 1) + prev.get(i)) % 1_000_000_007L;
            list.add(val);
        }
        for (int i = n / 2 - 1; i >= 0; i--) {
            list.add(list.get(i));
        }
        return list;
    }
}