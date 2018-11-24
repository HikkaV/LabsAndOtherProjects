import java.util.Arrays;

class Test {

    public static void main(String[] args) {
        int[] num = {1, -8, 2, -4, 3, 6, -1, -7, 9, 5};
        Arrays.stream(num).filter(o -> Arrays.stream(num).min().getAsInt() < o && o < Arrays.stream(num).max().getAsInt()).sorted().forEach(System.out::println);
        Arrays.stream(num).filter(o -> Arrays.stream(num).min().getAsInt() < o && o < Arrays.stream(num).max().getAsInt()).reduce((o1, o2) -> o1 * o2).stream().forEach(System.out::println);

    }
}