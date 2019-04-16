package com.customize.common.constants;

public enum SexEnum {
    MAN(1, "男"), WOMAN(2, "女");

    private int sexCode;

    private String sexName;

    SexEnum(int sexCode, String sexName) {
        this.sexCode = sexCode;
        this.sexName = sexName;
    }

    public static SexEnum getSex(int sexCode) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.sexCode == sexCode)
                return sexEnum;
        }
        return null;
    }

    public static String getSexName(int sexCode) {
        SexEnum sex = getSex(sexCode);
        return sex == null ? null : sex.getSexName();
    }

    public String getSexName() {
        return this.sexName;
    }

    public int getSexCode() {
        return this.sexCode;
    }

    public String getSexCodeStr() {
        return String.valueOf(this.sexCode);
    }
}
