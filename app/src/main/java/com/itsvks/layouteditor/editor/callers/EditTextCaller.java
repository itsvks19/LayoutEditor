package com.itsvks.layouteditor.editor.callers;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.itsvks.layouteditor.utils.Constants;

public class EditTextCaller {

  public static void setHint(View target, String value, Context context) {
    if (target instanceof EditText) ((EditText) target).setHint(value);
    else if (target instanceof AppCompatEditText) ((AppCompatEditText) target).setHint(value);
  }

  public static void setHintTextColor(View target, String value, Context context) {
    if (target instanceof EditText) ((EditText) target).setHintTextColor(Color.parseColor(value));
    else if (target instanceof AppCompatEditText)
      ((AppCompatEditText) target).setHintTextColor(Color.parseColor(value));
  }

  public static void setSingleLine(View target, String value, Context context) {
    if (value.equals("true")) {
      if (target instanceof EditText) ((EditText) target).setSingleLine(true);
      else if (target instanceof AppCompatEditText)
        ((AppCompatEditText) target).setSingleLine(true);
    } else {
      if (target instanceof EditText) ((EditText) target).setSingleLine(false);
      else if (target instanceof AppCompatEditText)
        ((AppCompatEditText) target).setSingleLine(false);
    }
  }

  public static void setInputType(View target, String value, Context context) {
    String[] flags = value.split("\\|");
    int result = 0;

    for (String flag : flags) result |= Constants.inputTypes.get(flag);

    if (target instanceof EditText) ((EditText) target).setInputType(result);
    else if (target instanceof AppCompatEditText) ((AppCompatEditText) target).setInputType(result);
  }
}
