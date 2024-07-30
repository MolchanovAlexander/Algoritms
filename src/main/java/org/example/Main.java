package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.example.normal.AlphabeticalSubstring;

public class Main {
    public static class Null {

        public int hashCode() {
            return 0;
        }

        public String toString() {
            return this.getClass().getSimpleName();
        }

        public boolean equals(Null o) {
            return this.getClass().getSimpleName().equals(o.getClass().getSimpleName());
        }



    }

    public static void main(String[] args) {
        Null n = new Null();
        System.out.println(n.equals(new Null()));
        System.out.println(AlphabeticalSubstring.getLongestAlphabeticalSubstring("dddeeghijjhhhvvwxxxyy") + " result999");
        //        System.out.println(LevenshteinDistance.distance("abcdef", "azcde"));
        //        int[] customers = new int[]{2, 2, 3, 3, 4, 4}; // if checkout - 2 - res - 9
        //        System.out.println(SupermarketQueue.calculateTotalTime(customers, 6));
        //        STACK
        //        Stack2<String> newStack = new Stack2();
        //        System.out.println(newStack.isEmpty());
        //        newStack.push("guf0");
        //        newStack.push("guf1");
        //        newStack.push("guf2");
        //        newStack.push("guf3");
        //        System.out.println(newStack.pop());
        //        System.out.println(newStack.peek());
        //        System.out.println(newStack.isEmpty());
        //        System.out.println(newStack.size());
//        //        pretty array
//        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7}; // pretty
//        int[] arr2 = new int[]{1, 2, 2, 2, 2, 2}; // pretty
//        int[] arr3 = new int[]{0, 2, 3, 4, 5, 6, 7}; // not pretty
//        System.out.println(PrettyArray.isArrayPretty(arr2));
//        System.out.println(PrettyArray.isBadunPretty(arr3));
//        System.out.println(Primorial.getPrimorialOfNumber(6));
//        String[] ssss = new String[]{"Frodo", "Gandalf", "Saruman", "Gollum"};
//        System.out.println(Likes.whoLikesIt(ssss));
//        String all = "abcdefghijklmnopqrstuvwxyz";
//        String res = "";
//        String string = "ghaaskjdfsdy";
//
//        string = string.replaceFirst(String.valueOf(all.charAt(0)), "");
//        System.out.println(string);
//        List<String> eee = new ArrayList<>();
//        eee.add("asd");
//        eee.add(null);
//        eee.add("SfRggb");
//        List<Character> ccc = eee.stream()
//                .filter(Objects::nonNull)
//                .map(String::toLowerCase)
//                .map(s ->  s.charAt(0))
//                .sorted()
//                .toList();
//        System.out.println(ccc);

    }
}
