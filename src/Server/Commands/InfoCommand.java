package Server.Commands;

import Client.DataUtils.CommandObject;
import Server.Launch.CollectWorker;
import Server.Launch.ControlUnit;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Класс команды info-вывод информации о коллекции
 */
public class InfoCommand implements Command {
    private CollectWorker coll;
    static Logger LOGGER;
    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param p- переменная для управления командами
     * @param collection- переменнаяи для работы с коллекцией
     */
    public InfoCommand(ControlUnit p, CollectWorker collection){
        p.addCommand("info",this);
        this.coll=collection;
        LOGGER=Logger.getLogger(InfoCommand.class.getName());
    }
    /**
     * Функция выполнения команды
     */
    @Override
    public String execute(CommandObject user) throws IOException {
        LOGGER.log(Level.INFO,"Отправка результата выполнения команды на сервер");
        return coll.info();
    }
}
