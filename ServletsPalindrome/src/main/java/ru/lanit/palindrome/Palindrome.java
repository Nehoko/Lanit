package ru.lanit.palindrome;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class Palindrome {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Palindrome(){}
    public Palindrome(String text){
        setText(text);
    }
    public boolean checkPalindrome() {
        try {
            //Проверка количества символов
            checkLenght(text);
            //Проверка на наличие запрещённых символов
            checkSymbols(text);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //Проверка количества символов
    private void checkLenght(String text) throws Exception{
        if (this.text.length() == 1 || this.text.length() > 500) {
            throw new Exception("Неверное кол-во символов: введите текст с кол-вом символов от 2 до 500!");
        }
    }
    //Проверка текста на запрещённые символы
    private void checkSymbols(String text)throws Exception{
            if(Pattern.matches("[+\\-=%/`~^]",text)){
                throw new Exception("Введен один или несколько запрещённых символов: ^ + = - * % / `");
            }
    }
    //Проверка текста на слова-палиндромы
    public LinkedList<String> wordPalindrome(){
        //Разбиение предложения на отдельные слова по пробелу
        String[] strings = text.split("[\\s\\n\\r]");
        for (int i = 0; i<strings.length; i++){
            //Отделяем слово от ненужных знаков
            String word = strings[i].replaceAll("\\p{Punct}","");
            strings[i] = word;
        }
        LinkedList<String> palindromes = new LinkedList<>();
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
        return palindromes;
    }

    //Проверка текста на предложения-палиндромы
    public LinkedList<String> sentencePalindrome(){
        //Разделение предложений по точкам и пробелам после точки
        String[] strings = text.split("(\\.\\s)|\\.");
        LinkedList<String> palindromes = new LinkedList<>();
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
        return palindromes;
    }
    public String parseForHTML(LinkedList<String> arrayList){
        StringBuilder result = new StringBuilder();
        while(!arrayList.isEmpty()){
            result.append(arrayList.getFirst()).append("\n");
        }
        return result.toString();
    }
}