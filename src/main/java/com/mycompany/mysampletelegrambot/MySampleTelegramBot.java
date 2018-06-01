package com.mycompany.mysampletelegrambot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;



public class MySampleTelegramBot {

 
    public static void main(String[] args) {
         
        System.out.print("Hello, world!");
        
        ApiContextInitializer.init();
          
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        
        try {
            telegramBotsApi.registerBot(Bot.getBot());
            
        }
        
        catch (TelegramApiRequestException e) 
        
        {
            
            e.printStackTrace();
        }
    }
}






  
    