package com.customize.manage.component;

import com.customize.common.constants.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
class MsgSource {

    private static MessageSource messageSource;

    @Autowired
    private MsgSource(MessageSource messageSource) {
        MsgSource.messageSource = messageSource;
    }

    static String getMessage(ResultCodeEnum code, Object...objects) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code.name(), objects, locale);
    }
}
