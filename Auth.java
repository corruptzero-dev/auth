package task;

import java.util.Scanner;

public class Auth {
    private final Coder coder = new Coder();
    private final Scanner scanner = new Scanner(System.in);
    void signUp(){
        System.out.print("Введите логин (Тел/почта): ");
        String login = scanner.next();
        fillLogin(login);
    }
    void fillLogin(String login){
        if(login.matches("\\+\\d{11}")){
            sendCode();
        } else if (login.matches("^\\w+@\\w+.\\w+")){
            sendCode();
        } else {
            System.out.println("Неверный логин!");
            signUp();
        }
    }
    void sendCode() {coder.sendCode();}
}