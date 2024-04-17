public class Formater {
    public static String getWordRuble(double number) {
        int num = (int) number;
        int remainderOf10 = num % 10;
        int remainderOf100 = num % 100;

        if (remainderOf100 >= 11 && remainderOf100 <= 14)
            return "рублей";
        if (remainderOf10 == 1)
            return "рубль";
        if (remainderOf10 >= 2 &&  remainderOf10 <= 4)
            return "рубля";
        else
            return "рублей";
    }
}
