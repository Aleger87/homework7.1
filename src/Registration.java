/*
Логин содержит в себе только латинские буквы, цифры и знак подчеркивания.
Длина логина может быть от 1 до 20 символов. Если логин не указан или длиннее заданной формы, содержит в себе другие знаки, то нужно выбросить
WrongLoginException
.
Password содержит в себе только латинские буквы, цифры и знак подчеркивания.
Длина password может быть от 1 до 20 символов. Password и confirmPassword должны быть равны.
Если password не указан или длиннее заданной формы, содержит в себе другие знаки, password и confirmPassword не равны, то нужно выбросить
WrongPasswordException
.
WrongPasswordException
 и
WrongLoginException
 — пользовательские классы исключения с двумя конструкторами: один по умолчанию, второй принимает сообщение исключения и передает его в конструктор класса
Exception
* */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    private String login;
    private String password;
    private String confirmPassword;

    public Registration(String login, String password, String confirmPassword) {
        try {
            checkData(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            //throw  new RuntimeException();
        }
    }

    private void checkData(String login, String password, String confirmPassword) throws WrongLoginException {
        final String regex = "^[\\w+]{8,20}\\z";
        final String[] data = new String[3];
        data[0] = login;
        data[1] = password;
        data[2] = confirmPassword;



        final Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < data.length; i++) {
             Matcher matcher = pattern.matcher(data[i]);
            if (matcher.find()) {
                data[i] = data[i];
             } else {
                throw new WrongLoginException("Не верно заполнено " + data[i]);
            }
        }

        this.login = data[0];
        if (!data[1].equals(data[2])) {
            throw new WrongLoginException("Пароль не совпадает");
        } else {
            this.password = data[1];
            this.confirmPassword = data[2];
        }



    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}

