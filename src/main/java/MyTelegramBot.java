import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;





public class MyTelegramBot extends TelegramLongPollingBot {
    public static final String BOT_TOKEN = Config.getEnvVariable("BOT_TOKEN");
    public static final String BOT_USERNAME = "JAVA_NASA_imagesbot";
    public static final String URL = "https://api.nasa.gov/planetary/apod?api_key=" + Config.getEnvVariable("API_KEY");
    private static long chatId;
    private static boolean awaitingPassword = false;
    private static LocalDate lastImageSentDate = null;

    public MyTelegramBot() throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this);
        startDailyImageSending();
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
        if (update.hasMessage() && update.getMessage().hasText()) {
            chatId = update.getMessage().getChatId();
            String messageText = update.getMessage().getText();

            if (awaitingPassword) {
                if ("1234".equals(messageText)) {
                    sendMessage("Password correct. Restarting the bot...");
                    restartBot();
                } else {
                    sendMessage("Incorrect password. Action canceled.");
                }
                awaitingPassword = false;
            } else {
                switch (messageText) {
                    case "/start":
                        sendMessage("Hi, I am a bot, which sends message with an image from NASA\n" +
                                "Press '/help' for manual\n");
                        break;
                    case "/help":
                        sendMessage("Manual:\n" +
                                "To get an image from NASA enter: '/give'\n" +
                                "To restart bot enter: '/restart'\n" +
                                "To get manual again enter '/help'\n");
                        break;
                    case "/restart":
                        sendMessage("Enter password for this action");
                        awaitingPassword = true;
                        break;
                    case "/give":
                        try {
                            String nasaData = utils.getNasaData(URL);
                            sendMessage(nasaData);
                        } catch (IOException e) {
                            sendMessage("Error retrieving image.");
                            e.printStackTrace();
                        }
                        break;
                    default:
                        sendMessage("Sorry, I didn't understand that. Try '/help'.");
                }
            }
        }
    }

    private void startDailyImageSending() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        Runnable sendDailyImage = this::sendDailyNasaImage;

        long initialDelay = calculateInitialDelay();
        long period = TimeUnit.DAYS.toMillis(1);

        scheduler.scheduleAtFixedRate(sendDailyImage, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    private long calculateInitialDelay() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextRun = now.withHour(12).withMinute(0).withSecond(0).withNano(0);
        if (now.compareTo(nextRun) > 0) {
            nextRun = nextRun.plusDays(1);
        }
        return ChronoUnit.MILLIS.between(now, nextRun);
    }

    private void sendDailyNasaImage() {
        try {
            String nasaData = utils.getNasaData(URL);
            sendMessage(nasaData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void restartBot() {
        System.out.println("Restarting bot...");
    }

    private void sendMessage(String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(messageText);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

