package com.page;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class AutoInsertBraces extends AnAction {

    /**
     * Displays a message with information about the current caret.
     *
     * @param e Event related to this action
     */
    @Override
    public void actionPerformed(@NotNull final AnActionEvent e) {
        // Get access to the editor and caret model. update() validated editor's existence.
        final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
//    final CaretModel caretModel = editor.getCaretModel();
//    // Getting the primary caret ensures we get the correct one of a possible many.
//    final Caret primaryCaret = caretModel.getPrimaryCaret();
//    // Get the caret information
//    LogicalPosition logicalPos = primaryCaret.getLogicalPosition();
//    VisualPosition visualPos = primaryCaret.getVisualPosition();
//    int caretOffset = primaryCaret.getOffset();
//    // Build and display the caret report.
//    String report = logicalPos.toString() + "\n" + visualPos.toString() + "\n" +
//       "Offset: " + caretOffset;
//    Messages.showInfoMessage(report, "Caret Parameters Inside The Editor");

//    Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();
        Project project = editor.getProject();
        CaretModel caretModel = editor.getCaretModel();
        Caret primaryCaret = caretModel.getPrimaryCaret();
        int offset = primaryCaret.getOffset();
        System.out.println(offset);
        Runnable runnable = () -> document.insertString(offset, "{}");
        WriteCommandAction.runWriteCommandAction(project, runnable);
        primaryCaret.moveToOffset(offset + 1);


    }

    /**
     * Sets visibility and enables this action menu item if:
     * <ul>
     *   <li>a project is open</li>
     *   <li>an editor is active</li>
     * </ul>
     *
     * @param e Event related to this action
     */
    @Override
    public void update(@NotNull final AnActionEvent e) {
        // Get required data keys
        final Project project = e.getProject();
        final Editor editor = e.getData(CommonDataKeys.EDITOR);
        //Set visibility only in case of existing project and editor
        e.getPresentation().setEnabledAndVisible(project != null && editor != null);
        try {

        } catch (Exception e1) {
        }
    }
}
