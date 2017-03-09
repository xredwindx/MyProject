package com.my.util.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created on 2017-02-07.
 */
@Component
public class MessageUtil {
     private static MessageSource messageSource;

     @Autowired
     public void setMessageSource(MessageSource messageSource) {
         MessageUtil.messageSource = messageSource;
     }
    /**
     * spring request locale에 맞는 메세지 보여주기
     * @param key
     * @return
     */
    public static String getMessage(String key) {
        return messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String key, Object[] obj) {
        return messageSource.getMessage(key, obj, LocaleContextHolder.getLocale());
    }

    public static String getMessage(String key, Object[] obj, Locale locale) {
        return messageSource.getMessage(key, obj, locale);
    }

    /**
     * config locale에 맞는 메세지 보여주기
     * @param key
     * @return
     */
    public static String getMessageEN(String key) {
        Locale locale = new Locale(getLocaleGlobalEN(CommonConfig.getLocaleDefault()));
        return messageSource.getMessage(key, null, locale);
    }

    public static String getMessageEN(String key, Object[] obj) {
        Locale locale = new Locale(getLocaleGlobalEN(CommonConfig.getLocaleDefault()));
        return messageSource.getMessage(key, obj, locale);
    }

    /**
     * ko를 제외한 언어는 en으로 설정
     * @return
     */
    public static String getLocaleGlobalEN(String localeStr) {
        if(localeStr.startsWith("ko")) {
            localeStr = "en";
        }
        return localeStr;
    }
}
