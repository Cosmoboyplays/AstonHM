package Tasks;

import java.util.*;


public class Tasks {

    public static void main(String[] args) {
        turnString("I love Java");  //1

        getDistinctNumbers(new int[] {1, 2, 2, 50, 4, 0, 5, 6, 7, 8000, 8, 9, 8000}); //2

        System.out.println(findSecondMaxElement(new int[] {10, 15, 23, 11, 44, 13, 66, 1, 6, 47, 100, 99})); //3

        System.out.println(lengthOfLastWord("    fly me    to the moon    "));//4

        System.out.println(isPalindrome("112211"));
    }

    //1
    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        char[] symbols = string.toCharArray();
        String res = "";
        for (char i : symbols ){
            res = i + res;
        }
        System.out.println(res);
    }

    //2
    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] innn) {
        Set<Integer> uniqueNumbers = new TreeSet<>(Arrays.stream(innn).boxed().toList());
        System.out.println(uniqueNumbers + " конец");
    }

    //3
    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int res = Arrays.stream(arr).min().getAsInt();;
        for (int i : arr) {
            if (res < i && i < max) {
                res = i;
            }
        }
        return res;
    }

    //4
    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(string.trim().split("\\s+")));

        return words.getLast().length();
    }

    //5
    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        return string.equals(Utils.reverse(string));
    }
}

class Utils{
    public static String reverse(String str){
        if (str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.substring(0, 1);
    }
}