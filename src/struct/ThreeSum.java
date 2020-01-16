package struct;

import sun.print.SunMinMaxPage;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public static List<List<Integer>> getList(int[] nums) {
        List<Integer> list = array2List(nums);
        Set<List<Integer>> result = new HashSet<>();
        list.forEach(it -> {
            int i = it;
            if (list.contains(-i) && list.contains(0)) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                list1.add(-i);
                list1.add(0);
                result.add(list1);
            }
            if (list.contains((-i) * 2) && list.stream().filter(p -> p == i).count() >= 2) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(i);
                list1.add(i);
                list1.add(-(i * 2));
                result.add(list1);
            }
        });
        return new ArrayList<>(result);
    }

    private static List<Integer> array2List(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getList(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
