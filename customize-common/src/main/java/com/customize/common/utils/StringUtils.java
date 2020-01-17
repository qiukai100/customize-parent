package com.customize.common.utils;

import org.apache.commons.lang3.ArrayUtils;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    public static boolean isExistEmpty(CharSequence... css) {
        if (ArrayUtils.isEmpty(css)) {
            return true;
        } else {
            CharSequence[] var1 = css;
            int var2 = css.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                CharSequence cs = var1[var3];
                if (isEmpty(cs)) {
                    return true;
                }
            }

            return false;
        }
    }
}
