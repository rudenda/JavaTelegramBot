package com.mycompany.mysampletelegrambot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.LongPollingBot;
import static org.telegram.telegrambots.logging.BotLogger.log;
import java.util.Date;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*; // for StyledDocument

import java.util.Random;
import java.util.Scanner;






public class Bot extends TelegramLongPollingBot {

    static LongPollingBot getBot() {
    
        return new Bot();
    }
    /**
     * Метод возвращает имя бота, указанное при регистрации.
     * @return имя бота
     */
    @Override
    public String getBotUsername() {
        return "Rudenda_bot";
    }
    /** Метод возвращает token бота для связи с сервером Telegram
     * @return token для бота*/
    @Override
    public String getBotToken() {
        return "578106516:AAEQY8lOu4iuO8buKDS87tdhcPHL5XQthsU";
    }
    /**
     * Метод для приема сообщений.
     * @param update Содержит сообщение от пользователя.
     */
    @Override
    public void onUpdateReceived(Update update) {
	//
        if (update.hasMessage() && update.getMessage().hasText()) {
        //
        
          // Set variables
            Date currentDate = new Date();
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/time")) 
            {
               //
                String messageSend = currentDate.toString();
                SendMessage message = new SendMessage().setChatId(chat_id).setText(messageSend);
                setButtons(message);
                try {
                    sendMessage(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }  
              //
            }
            else
            {
                String message = update.getMessage().getText();
	        sendMsg(update.getMessage().getChatId().toString(), message);
            }
        //    
        }
        //
        else
        {
        }
    }
    /**
     * Метод для настройки сообщения и его отправки.
     * @param chatId id чата
     * @param s Строка, которую необходимот отправить в качестве сообщения.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }
public synchronized void setButtons(SendMessage sendMessage) {
    
    
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
        keyboardFirstRow.add(new KeyboardButton("Бумага"));
        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
          // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Ножницы"));
         // Добавляем кнопки во третью строчку клавиатуры
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        
        keyboardThirdRow.add(new KeyboardButton("Камень"));
        // Добавляем все строчки клавиатуры в список
        
        
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }
}








