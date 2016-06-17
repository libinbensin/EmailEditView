package com.libin.emaileditview;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Custom view to disable the copy paste feature on {@link EditText} used for entering Email address.
 * This will block the text paste from clipboard , but you will still able to see the paste menu when tapped on cursor bubble.
 *
 * - Long click is disabled {@link #setLongClickable(boolean)}
 * - Input type set to Email Address {@link InputType#TYPE_TEXT_VARIATION_EMAIL_ADDRESS}
 * - Set custom selection action to prevent the selection action mode from being showing.
 *
 * @see {@link android.R.id#paste}
 *  @see {@link android.R.id#pasteAsPlainText}
 *
 * @author Libin
 */
public class EmailEditView extends EditText {

    public EmailEditView(Context context) {
        super(context);
        init();
    }

    public EmailEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EmailEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        switch (id){
            // Return false to prevent paste when paste menu tapped.
            case android.R.id.paste:
            case android.R.id.pasteAsPlainText:
                return false;

        }
        return super.onTextContextMenuItem(id);
    }

    private void init() {
        // Set the inout type as email address , so that the keyboard will show @ key.
        setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        // Disable long clickable.
        setLongClickable(false);
        // Set custom selection action to prevent the selection action mode from being showing.
        setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // NOP
            }
        });
    }
}
