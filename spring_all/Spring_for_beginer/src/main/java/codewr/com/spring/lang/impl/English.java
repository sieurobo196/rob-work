package codewr.com.spring.lang.impl;

import codewr.com.spring.lang.Language;

// Tiếng anh
public class English  implements Language {

    @Override
    public String getGreeting() {
        return "Hello";
    }

    @Override
    public String getBye() {
        return "Bye bye";
    }
}
