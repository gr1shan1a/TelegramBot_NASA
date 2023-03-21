import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyTelegramBot extends TelegramLongPollingBot {
    public static final String BOT_TOKEN = "6090466293:AAHyvepgCtMgWidGcTJQtXu3spclCpugO6A";
    public static final String BOT_USERNAME = "JAVA_NASA_imagesbot";
    public static final String URL = "https://api.nasa.gov/planetary/apod?api_key=meXuPit01arAzczsziwyU97LKABrdqxjYWmoy8e9";
    private static long chatId;

    public MyTelegramBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage())
            chatId = update.getMessage().getChatId();

        switch (update.getMessage().getText()) {
            case "/start":
                sendMessage("Hi, I am a bot, which sends message with an image from NASA ");
                break;
            case "/help":
                sendMessage("To get an image from NASA enter: /give");
            case "/give":
                try {
                    sendMessage(utils.getUrl(URL));
                } catch (IOException e){
                    e.printStackTrace();
            }
                break;
            default: sendMessage("Мая твоя не понимать");

        }
    }

    private void sendMessage(String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(messageText);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
