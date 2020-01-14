package com.customize.common.constants;

/**
 * 权限通用常量
 */
public enum PermissionEnum {

    ADD, EDIT, REMOVE, EXPORT, IMPORT, VIEW, LIST;

    public final String value() {
        return super.name().toLowerCase();
    }
}
