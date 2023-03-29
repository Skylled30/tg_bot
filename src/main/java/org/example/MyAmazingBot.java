package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyAmazingBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            SendPhoto photo;
            if (update.getMessage().getText().equals("Мой профиль")){
                setProfileKeyboard(message);
            }
            if (update.getMessage().getText().equals("Главное меню")){
                setMainKeyboard(message);
            }
            if (update.getMessage().getText().equals("картинка")){

            }
            if (update.getMessage().getText().equals("Кнопка")){
                setInline(message);
            }
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(checkMessage(update.getMessage().getText()));

            photo = new SendPhoto();
            File file = new File("/Users/aleksandrvanteev/IdeaProjects/tg_bot/src/main/java/org/example/photo.PNG");
            InputFile p = new InputFile(file);
            photo.setChatId(update.getMessage().getChatId().toString());
            photo.setPhoto(p);
            photo.setCaption("check");

            try {
                execute(message);
                execute(photo);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if (update.hasCallbackQuery()) {
            processCallbackQuery(update.getCallbackQuery());
        }
    }

    private void processCallbackQuery(CallbackQuery callbackQuery) {
        AnswerCallbackQuery answer = new AnswerCallbackQuery();
        if (callbackQuery.getData().equals("17")) {
            answer.setCallbackQueryId(callbackQuery.getId());
            answer.setText("кол бек 17 сработал");

        }
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "mytestbot";
    }

    @Override
    public String getBotToken() {
        return "5368258406:AAGYXbdrCmnOsdhiErrSvRAgZHCTZtigkMs";
    }

    public synchronized void setMainKeyboard(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Сделать заказ"));
        keyboardFirstRow.add(new KeyboardButton("Мои заказы"));
        keyboardFirstRow.add(new KeyboardButton("Мой профиль"));


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized void setProfileKeyboard(SendMessage sendMessage) {
        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Изменить"));
        keyboardFirstRow.add(new KeyboardButton("Кнопка"));
        keyboardFirstRow.add(new KeyboardButton("Главное меню"));


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public String checkMessage(String text){
        if (text.equals("Сделать заказ")){
            return "Функция в разработке";
        }
        if (text.equals("Мои заказы")){
            return "Функция в разработке";
        }
        if (text.equals("Мой профиль")){
            return "Функция в разработке";
        }
        if (text.equals("Главное меню")){
            return "Вы вернулись в главное меню";
        }
        return "Неизвестная команда";
    }

    private synchronized void setInline(SendMessage sendMessage) {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
        List<InlineKeyboardButton> buttons2 = new ArrayList<>();

        InlineKeyboardButton inline = new InlineKeyboardButton();
        inline.setText("Добавить в корзину");
        inline.setCallbackData("17");

        InlineKeyboardButton inline2 = new InlineKeyboardButton();
        inline2.setText("Оплатить сразу");
        inline2.setCallbackData("16");

        // 1 первая строка кнопок
        buttons1.add(inline);
        buttons2.add(inline2);

        buttons.add(buttons1);
        buttons.add(buttons2);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);

        sendMessage.setReplyMarkup(markupKeyboard);
    }

}
