import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        //Чтение с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        //Проверка количества строк
        char[] chars = text.toCharArray();
        try{
            if (chars.length==1 || chars.length>500){
                throw new Exception("Неверное кол-во символов: введите текст с кол-вом символов от 2 до 500!");
            }
            System.out.println(checkSymbols(text));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Проверка текста на запрещённые символы и палиндромы
    private static boolean checkSymbols(String text){
        //Pattern pattern = Pattern.compile("^([a-z]|[A-Z]|[а-я]|[А-Я])+[+\\-:%/`]+.");
        return Pattern.matches("^[a-zA-Zа-яА-Я0-9][^+\\-:%/`]$",text);

    }
}
