package com.customize.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class UELUtils {

    private static Map<String, Object> vars = Maps.newHashMap();

    /**
     * 变量
     */
    private static Map<String, String> variable = Maps.newHashMap();

    /**
     * 变量锁
     */
    private static final Object varLock = new Object();

    static {
        User user = new User().setName("test");
        List<User> list = Lists.newArrayList();
        list.add(new User().setName("listUser1"));
        list.add(new User().setName("listUser2"));
        vars.put("status", "Active");
        vars.put("user", user);
        vars.put("list", list);
    }

    // UEL-VALUE
    final static String el0 = "${'1' > '2' && '3' == '4' || '1' <= '2'}";
    final static String el1 = "${  status    }";
    final static String el2 = "${user.name}";
    final static String el3 = "${list[0]}";
    final static String el4 = "${list[0].name}";
    final static String el5 = "${cusFun()}";
    final static String el6 = "${cusFun('1', status)}";
    final static String el7 = "${false || (true && status == 'Active')}";
    final static String el8 = "${false || (true && status == 'Active') && cusFun()}";

    public static void main(String[] args) {
        analyticalExpression(el0);
    }

    public static Object analyticalExpression(String expression) {
        if (!ELPlaceholder.EL_EXPRESSION.isELPlaceholder(expression)) return null;
        // 获取表达式的字符串
        String text = ELPlaceholder.EL_EXPRESSION.getText(expression, true);
        if (text == null) return null;
        // 初始化当前表达式
        text = initVars(text);

        return null;
    }

    /**
     * 将表达式转换成明文
     * 明文：仅包含变量占位符、方法名、运算符的字符串
     *
     * @param text
     * @return
     */
    private static Object getVal(String text) {
        // 优先解决括号的内容
        Content content = ELPlaceholder.SMALL_BRACKETS.getContent(text, true);
        if (content == null) {
            // 无括号内容
        }
        return null;
    }

    private static String getVarNo() {
        // 202004301715000
        synchronized (varLock) {
            String varNo = DateUtils.parseDateToStr("yyyyMMddHHmmssSSS", new Date());
            try {
                Thread.sleep(1);
                // 停滞1毫秒防止重复
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return varNo;
        }
    }

    private static String initVars(String expression) {
        Content content = ELPlaceholder.STRING_TEXT.getContent(expression, false);
        if (content != null) {
            String varNo = getVarNo();
            variable.put(varNo, content.getContent());
            String placeholder = ELPlaceholder.VAL_EXPRESSION.setText(varNo);
            String text = expression.substring(0, content.getsIndx())
                    .concat(placeholder)
                    .concat(expression.substring(content.geteIndx() + 1, expression.length()));
            return initVars(text);
        } else {
            return expression;
        }
    }

    static class Content {

        private ELPlaceholder epr;

        private String content;

        private Integer sIndx;

        private Integer eIndx;

        public ELPlaceholder getEpr() {
            return epr;
        }

        public void setEpr(ELPlaceholder epr) {
            this.epr = epr;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getsIndx() {
            return sIndx;
        }

        public void setsIndx(Integer sIndx) {
            this.sIndx = sIndx;
        }

        public Integer geteIndx() {
            return eIndx;
        }

        public void seteIndx(Integer eIndx) {
            this.eIndx = eIndx;
        }
    }

    static class User {
        private String name;

        public String getName() {
            return name;
        }

        public User setName(String name) {
            this.name = name;
            return this;
        }
    }

    enum ELLogic {
        AND("&&"),
        OR("||");

        private String logic;

        ELLogic(String logic) {
            this.logic = logic;
        }

        public ELLogic getLogic(String str) {
            for (ELLogic elc : ELLogic.values()) {
                if (elc.logic.equals(str)) return elc;
            }
            return null;
        }

        public boolean compare(boolean a, boolean b) {
            switch (this) {
                case AND:
                    return a && b;
                case OR:
                    return a || b;
            }
            throw new RuntimeException("EL logic compare. no case.");
        }
    }

    enum ELOperator {
        GT(">"),
        LT("<"),
        GE(">="),
        LE("<="),

        EQ("=="),
        NE("!=");

        private String operator;

        ELOperator(String operator) {
            this.operator = operator;
        }

        public ELOperator getOperator(String str) {
            for (ELOperator eor : ELOperator.values()) {
                if (eor.operator.equals(str)) return eor;
            }
            return null;
        }

        public boolean compare(String a, String b) {
            if (a == null || b == null) throw new RuntimeException("EL operator compare. value has null.");
            Integer il, ir;
            switch (this) {
                case GT:
                    il = Integer.parseInt(a);
                    ir = Integer.parseInt(b);
                    return il > ir;
                case LT:
                    il = Integer.parseInt(a);
                    ir = Integer.parseInt(b);
                    return il < ir;
                case GE:
                    il = Integer.parseInt(a);
                    ir = Integer.parseInt(b);
                    return il >= ir;
                case LE:
                    il = Integer.parseInt(a);
                    ir = Integer.parseInt(b);
                    return il <= ir;
                case EQ:
                    return a.equals(b);
                case NE:
                    return !a.equals(b);
            }
            throw new RuntimeException("EL operator compare. no case.");
        }
    }

    /**
     * EL占位符
     */
    enum ELPlaceholder {
        /**
         * EL表达式
         */
        EL_EXPRESSION("${", "}"),

        /**
         * 值表达式
         */
        VAL_EXPRESSION("#{", "}"),

        /**
         * 字符串文字
         */
        STRING_TEXT("'", "'"),

        /**
         * 小括号
         */
        SMALL_BRACKETS("(", ")"),

        /**
         * 中括号
         */
        MEDIUM_BRACKETS("[", "]")
        ;

        private String leftText;

        private String rightText;

        ELPlaceholder(String leftText, String rightText) {
            this.leftText = leftText;
            this.rightText = rightText;
        }

        public boolean isELPlaceholder(String content) {
            if (content == null) return false;
            if (!content.startsWith(this.leftText)) return false;
            return content.endsWith(this.rightText);
        }

        public static ELPlaceholder getFirstEL(String content) {
            if (content == null) return null;
            for (ELPlaceholder epr : ELPlaceholder.values()) {
                if (epr.isELPlaceholder(content)) return epr;
            }
            return null;
        }

        public String setText(String text) {
            return this.leftText.concat(text).concat(this.rightText);
        }

        public String getText(String content, boolean BToE) {
            Content con = getContent(content, BToE);
            if (con == null) return null;
            return con.getContent();
        }

        public Content getContent(String content, boolean BToE) {
            Content con = new Content();
            if (content == null || content.trim().length() < 1) return null;
            int s_inx = content.indexOf(this.leftText);
            if (s_inx < 0) return null;
            con.setsIndx(s_inx);
            int s_len = this.leftText.length();
            s_inx += s_len;
            int e_inx;
            if (BToE) e_inx = content.lastIndexOf(this.rightText);
            else e_inx = content.indexOf(this.rightText, s_inx);
            if (e_inx < 0 || e_inx < s_inx) return null;
            String text = content.substring(s_inx, e_inx).trim();
            con.setEpr(this);
            con.setContent(text);
            con.seteIndx(e_inx);
            return con;
        }
    }
}
