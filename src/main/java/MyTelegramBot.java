import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class MyTelegramBot extends TelegramLongPollingBot {

    public static final String BOT_TOKEN = Config.getEnvVariable("BOT_TOKEN");
    public static final String BOT_USERNAME = "JAVA_NASA_imagesbot";
    public static final String URL = "https://api.nasa.gov/planetary/apod?api_key=" + Config.getEnvVariable("API_KEY");
    private static long chatId;
    private static boolean awaitingPassword = false;

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
                                sendMessage(utils.getUrl(URL));
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

        private void restartBot() {
            // Logic to restart the bot (e.g., reinitialize the bot, re-register with the Telegram API, etc.)
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

