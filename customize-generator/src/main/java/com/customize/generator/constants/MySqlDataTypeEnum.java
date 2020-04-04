package com.customize.generator.constants;

public enum MySqlDataTypeEnum {
    TINYINT("Integer"),
    SMALLINT("Integer"),
    MEDIUMINT("Integer"),
    INT("Long"),
    INTEGER("Long"),
    FLOAT("Float"),
    DOUBLE("Double"),
    BIGINT("BigInteger", "java.math.BigInteger"),
    DECIMAL("BigDecimal", "java.math.BigDecimal"),

    DATE("Date", "java.util.Date"),
    TIME("Date", "java.util.Date"),
    YEAR("Date", "java.util.Date"),
    DATETIME("Date", "java.util.Date"),
    TIMESTAMP("Date", "java.util.Date"),

    CHAR("String"),
    VARCHAR("String"),
    TINYTEXT("String"),
    MEDIUMTEXT("String"),
    TEXT("String"),
    LONGTEXT("String"),

    BLOB("byte[]"),
    TINYBLOB("byte[]"),
    MEDIUMBLOB("byte[]"),
    LONGBLOB("byte[]");

    private String javaType;

    private String packageName;

    MySqlDataTypeEnum(String javaType) {
        this.javaType = javaType;
    }

    MySqlDataTypeEnum(String javaType, String packageName) {
        this.javaType = javaType;
        this.packageName = packageName;
    }

    public static MySqlDataTypeEnum getEnum(String dataType) {
        return MySqlDataTypeEnum.valueOf(dataType.toUpperCase());
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
}
