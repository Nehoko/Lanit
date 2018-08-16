import ru.lanit.palindrome.Palindrome;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        //Чтение с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        Palindrome palindrome = new Palindrome(text);
        palindrome.checkPalindrome();
    }
}