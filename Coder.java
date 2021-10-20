package task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/*
 * @created 20/10/2021 - 14:45
 * @project untitled1
 * @author note-admin
 */
public class Coder {
    Scanner scanner = new Scanner(System.in);
    void checkCode(String code){
        System.out.print("Введите код доступа: ");
        String userCode = scanner.next();
        if(userCode.equals(code) && userCode.length()==6){
            System.out.println("Успешная авторизация!");
        } else {
            System.out.println("Неверный код. Повторите попытку.");
            Auth auth = new Auth();
            auth.signUp();
        }
    }
    public void sendCode(){
        String notACode = Integer.toString(ThreadLocalRandom.current().nextInt(100000, 999999 + 1));
        writeToFile(notACode);
        checkCode(notACode);

    }
    void writeToFile(String str) {
        try
        {
            FileWriter writer = new FileWriter("code.txt", false);
            writer.write(str);
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

