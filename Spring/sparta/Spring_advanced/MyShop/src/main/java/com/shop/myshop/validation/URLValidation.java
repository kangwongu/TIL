package com.shop.myshop.validation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLValidation {

    public static boolean isValidURL(String link) {
        // link가 URL인지 확인
        try {
            // 매개변수로 받은 link를 URL로 만들고 URL여부 체크
            new URL(link).toURI();
            return true;
        } catch (URISyntaxException e) {
            return false;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
