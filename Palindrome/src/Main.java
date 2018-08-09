import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        //Чтение с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        char[] chars = text.toCharArray();
        try{
            //Проверка количества символов
            if (chars.length==1 || chars.length>500){
                throw new Exception("Неверное кол-во символов: введите текст с кол-вом символов от 2 до 500!");
            }
            //Проверка на наличие запрещённых символов
            checkSymbols(text);

            //Проверка слов на наличие полиндромов
            wordPalindrome(text);

            //Проверка предложений на наличие предложений-полиндромов
            sentencePalindrome(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Проверка текста на запрещённые символы
    private static void checkSymbols(String text){
        try{
            if(!Pattern.matches("^([a-z]|[A-Z]|[а-я]|[А-Я]|[0-9])+.+$",text)&&
            Pattern.matches("[+\\-=%/`~^]",text)){
                throw new Exception("Введен один или несколько запрещённых символов: ^ + = - * % / `");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //Проверка текста на слова-палиндромы
    private static void wordPalindrome(String text){
        //Разбиение предложения на отдельные слова по пробелу
        String[] strings = text.split("\\s");
        for (int i = 0; i<strings.length-1; i++){
            //Отделяем слово от ненужных знаков
            String word = strings[i].replaceAll("(?U)\\p{Punct}","");
            strings[i] = word;

        }
        ArrayList<String> palindromes = new ArrayList<>();
        for (int j = 0; j<strings.length-1;j++) {
            String words = strings[j];
            char[] chars = words.toCharArray();

            //Цикл преобразования ЗАГЛАВНЫХ букв в строчные
            for (int i = 0; i < chars.length - 1; i++) {
                char ch = chars[i];
                chars[i] = Character.toLowerCase(ch);
            }
            words = new String(chars);

            //Сама проверка слов
            StringBuilder sb = new StringBuilder(words);
            sb.reverse();
            String sdrow = sb.toString();
            if (words.equals(sdrow) && words.length()>1){
                palindromes.add(strings[j]);
            }
        }
        if (palindromes.size()>0)
            System.out.println("Слова палиндромы:");
        for (String palindrome : palindromes) {
            System.out.println(palindrome);
        }
    }

    //Проверка текста на предложения-палиндромы
    private static void sentencePalindrome(String text){
        //Разделение предложений по точкам и пробелам после точки
        String[] strings = text.split("\\.\\s");
        ArrayList<String> palindromes = new ArrayList<>();
        for (int j = 0; j < strings.length;j++){
            String sentence = strings[j].replaceAll("[\\p{Punct}\\s]","");
            char[] chars = sentence.toCharArray();
            //Цикл преобразования ЗАГЛАВНЫХ букв в строчные
            for (int i = 0; i < chars.length - 1; i++) {
                char ch = chars[i];
                chars[i] = Character.toLowerCase(ch);
            }
            sentence = new String(chars);

            //Сама проверка предложения
            StringBuilder sb = new StringBuilder(sentence);
            sb.reverse();
            String ecnetnes = sb.toString();
            if (sentence.equals(ecnetnes)){
                palindromes.add(strings[j]);
            }
        }
        if (palindromes.size()>0)
        System.out.println("Предложения палиндромы:");
        for (String palindrome : palindromes){
            System.out.println(palindrome);
        }
    }
}
