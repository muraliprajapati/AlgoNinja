package com.teamdroid.algoninja;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

/**
 * Created by Vikas Kumar on 06-07-2015.
 */
public class Codedisplay {

    public void Codedisplayer(TextView textView, String text, int color) {

        Spannable raw = new SpannableString(textView.getText());
        BackgroundColorSpan[] spans = raw.getSpans(0, raw.length(), BackgroundColorSpan.class);
        for (BackgroundColorSpan span : spans) {
            raw.removeSpan(span);
        }

        int index = TextUtils.indexOf(raw, text);
        while (index >= 0) {
            raw.setSpan(new ForegroundColorSpan(color), index, index + text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            index = TextUtils.indexOf(raw, text, index + text.length());
        }

        textView.setText(raw);
    }


}
