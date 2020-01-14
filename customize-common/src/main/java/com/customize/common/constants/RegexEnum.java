package com.customize.common.constants;

public enum RegexEnum {
    NONE("no regex")
    ;
    private String regex;

    RegexEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
