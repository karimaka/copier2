package ru.krokhalev;

import java.io.Serializable;

public class LogFile implements Serializable{
    LogFile(){}// конструктор без параметров - чтоб Jackson смог преобразовать строку в Java объет

    String alias;
    boolean isChecked;
    String pathFrom;
    String pathTo;
    String serverLogin;
    String serverPass;
    String execute(){
        System.out.println("copying "+this.pathFrom+" to "+this.pathTo);
        return "copying "+this.pathFrom+" to "+this.pathTo;
    };

    /*Имя
      Откуда
      Куда
      Чекбокс
      Логин
      Пароль
      Сервер
    */
}
