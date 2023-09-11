package com.page.utils;

import com.intellij.AbstractBundle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

/**
 * @author pageqiu
 *
 */
public class ReplaceBundle extends AbstractBundle {
    /**
     * 注意并没有后缀.properties
     */
    private static final String REPLACE_BUNDLE = "messages.ReplaceBundle";
    private static final ReplaceBundle INSTANCE = new ReplaceBundle();
    private ReplaceBundle() {
        super(REPLACE_BUNDLE);
    }

    @NotNull
    @Contract(pure = true)
    public static String message(@PropertyKey(resourceBundle= REPLACE_BUNDLE) @NotNull String key, Object... objs) {
        return INSTANCE.getMessage(key,objs);
    }

}
