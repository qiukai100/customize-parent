package com.customize.common.constants;

public enum OptionEnum {
    YES(1), NO(0);

    private int val;

    OptionEnum(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
