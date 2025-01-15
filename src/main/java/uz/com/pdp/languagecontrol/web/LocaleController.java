package uz.com.pdp.languagecontrol.web;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/locale")
public class LocaleController {
    private final MessageSource messageSource;
    public LocaleController(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String sayHello(){
        return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/with-header")
    public String sayHelloWithHeader(
            @RequestAttribute(name = "Accept-Language", required = false) Locale locale
            ){
        return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
    }


}
