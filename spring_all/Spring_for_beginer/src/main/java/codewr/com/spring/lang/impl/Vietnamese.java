package codewr.com.spring.lang.impl;

import codewr.com.spring.lang.Language;

// Tiếng Việt
public class Vietnamese implements Language {

    @Override
    public String getGreeting() {
        return "Xin Chao";
    }

    @Override
    public String getBye() {
        return "Tam Biet";
    }
}