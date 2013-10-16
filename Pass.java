package LAbIAR;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Artem on 16.10.13.
 */
public class Pass
{
    public static void main(String[] args) throws IOException
    {
        Random rn = new Random();
        int i = rn.nextInt(9);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] pass = {"имплантация",
                "параметр",
                "абракадабра",
                "возвращение",
                "акклиматизация",
                "акваланг",
                "ультрамодный",
                "алгоритмизация",
                "программирование",
                "транзакция"};

        File file = new File("C:\\JavaRush\\JavaRushHomeWork\\src\\LAbIAR\\pass.txt");
        List<String> passList = new ArrayList<String>();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "UTF-8"
                )
        );
        String line = null;
        while ((line = br.readLine()) != null)
        {
            passList.add(line);
        }
        br.close();


        System.out.println("Привет! Попробуй ввести пароль!");
        System.out.println("Вот тебе слово: " + pass[i]);
        System.out.println("Буковку 'а' замени на 'о', напиши все капсом и в конце добавь длину слова. Удачи!");
        //System.out.println(getTruePass(pass[i])); //для тестов

        for (int j = 3; j > 0; j--)
        {
            String userPass = reader.readLine(); //чтение пароля пользователя из консоли
            if (!userPass.equals(getTruePass(pass[i]))) //проверка попыток
            {
                if (j == 1)
                {
                    System.out.println("Жалкий неудачник!");
                    break;
                }
                System.out.println("Переводись на АС! Количество попыток: " + (j - 1));
            } else
            {
                System.out.println("А ты молодец! Далеко пойдешь!");
                break;
            }
        }


    }

    public static String getTruePass(String s) //функция преобразования
    {
        String s1 = s.replace("а", "о");
        String s2 = s1.toUpperCase();
        //String s3 = s2 + s.length();
        return s2 + s.length();
    }


}


