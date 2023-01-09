package com.page.listener;

import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.page.notify.ShortKeyNotify;
import com.page.utils.ReplaceBundle;
import java.util.EventListener;
import org.apache.batik.w3c.dom.events.KeyboardEvent;
import org.jetbrains.annotations.NotNull;

public class KeyBoardListener implements DocumentListener {


    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        if (event == null) {
            System.out.println("----");
        }

        CharSequence cs = event.getNewFragment();

        if ("-".equals(cs.toString())) {
            ShortKeyNotify.notifyInfo(null, ReplaceBundle.message("alt.w"));
        } else if("(".equals(cs.toString())) {
            ShortKeyNotify.notifyInfo(null, ReplaceBundle.message("alt.p"));
        } else if ("{".equals(cs.toString())) {
            ShortKeyNotify.notifyInfo(null,ReplaceBundle.message("alt.c"));
        }
    }

}