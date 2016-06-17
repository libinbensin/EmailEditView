package com.libin.emaileditview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * @author Libin
 */
public class EmailEditView extends EditText {

    public EmailEditView(Context context) {
        super(context);
    }

    public EmailEditView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EmailEditView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTextContextMenuItem(int id) {
        switch (id){
            case android.R.id.paste:
            case android.R.id.pasteAsPlainText:
                return false;

        }
        return super.onTextContextMenuItem(id);
    }

}
