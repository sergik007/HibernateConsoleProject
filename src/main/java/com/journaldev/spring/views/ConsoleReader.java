package com.journaldev.spring.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * Created by sergey on 30.6.17.
 */
public class ConsoleReader {
    private static BufferedInputStream inputStream = new BufferedInputStream(System.in);
    private static Logger logger = LoggerFactory.getLogger(ConsoleReader.class);
    public static String read() {
        String s = new String("");
        try {
            char a = '0';
            while ((a = (char) inputStream .read()) != '\n') {
                s += (char) a;
            }
        } catch (IOException e) {
            logger.error("ошибка чтения", e);
        }
        return s;
    }
    public static void closeInputStream() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                logger.error("ошибка закрытия потока");
            }
        }
    }
}
