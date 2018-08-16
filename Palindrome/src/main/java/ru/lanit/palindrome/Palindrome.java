package ru.lanit.palindrome;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Palindrome {

    public Palindrome (String text){
        checkPalindrome(text);
    }
    private void checkPalindrome(String text) {
        try {
            //Проверка количества символов
            if (text.length() == 1 || text.length() > 500) {
                throw new Exception("Неверное кол-во символов: введите текст с кол-вом символов от 2 до 500!");
            }
            //Проверка на наличие запрещённых символов
            checkSymbols(text);

            //Проверка слов на наличие полиндромов
            wordPalindrome(text);

            //Проверка предложений на наличие предложений-полиндромов
            sentencePalindrome(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Проверка текста на запрещённые символы
    private void checkSymbols(String text){
        try{
            if(Pattern.matches("[+\\-=%/`~^]",text)){
                throw new Exception("Введен один или несколько запрещённых символов: ^ + = - * % / `");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //Проверка текста на слова-палиндромы
    private void wordPalindrome(String text){
        //Разбиение предложения на отдельные слова по пробелу
        String[] strings = text.split("[\\s\\n\\r]");
        for (int i = 0; i<strings.length; i++){
            //Отделяем слово от ненужных знаков
            String word = strings[i].replaceAll("\\p{Punct}","");
            strings[i] = word;
        }
        ArrayList<String> palindromes = new ArrayList<String>();
        for (String string : strings) {

            //Замена ЗАГЛАВНЫХ букв прописными
            String words = string.toLowerCase();

            //Сама проверка слов
            StringBuilder sb = new StringBuilder(words);
            sb.reverse();
            String sdrow = sb.toString();
            if (words.equals(sdrow) && words.length() > 1) {
                palindromes.add(string);
            }
        }
        if (palindromes.size()>0)
            System.out.println("Слова палиндромы:");
        for (String palindrome : palindromes) {
            System.out.println(palindrome);
        }
    }

    //Проверка текста на предложения-палиндромы
    private void sentencePalindrome(String text){
        //Разделение предложений по точкам и пробелам после точки
        String[] strings = text.split("\\.\\s");
        ArrayList<String> palindromes = new ArrayList<String>();
        for (String string : strings) {
            String sentence = string.replaceAll("[\\p{Punct}\\s]", "");

            //Цикл преобразования ЗАГЛАВНЫХ букв в строчные
            sentence = sentence.toLowerCase();

            //Сама проверка предложения
            StringBuilder sb = new StringBuilder(sentence);
            sb.reverse();
            String ecnetnes = sb.toString();
            if (sentence.equals(ecnetnes)) {
                palindromes.add(string);
            }
        }
        if (palindromes.size()>0)
            System.out.println("Предложения палиндромы:");
        for (String palindrome : palindromes){
            System.out.println(palindrome);
        }
    }
}