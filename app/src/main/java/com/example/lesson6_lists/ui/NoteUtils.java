package com.example.lesson6_lists.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;

import androidx.appcompat.content.res.AppCompatResources;

import com.example.lesson6_lists.App;
import com.google.type.Color;
import com.google.type.Date;

import java.util.Locale;

public class NoteUtils {

    private static final String APP_START_COUNTER_KEY = "APP_START_COUNTER_KEY";
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.US);

    public static String dateToString(Date date) {
        return dateFormatter.format(date);
    }

//    public static Drawable colorCircleDrawable(Context context, Color color) {
//        int rgb = context.getResources().getColor(color.getColorId(), null);
//        Drawable colorCircle = AppCompatResources.getDrawable(context, R.drawable.bg_circle);
//        colorCircle.setColorFilter(rgb, PorterDuff.Mode.SRC_IN);
//        return colorCircle;
//    }

    public static int incStartAppCounter() {
        SharedPreferences preferences = App.get().getNoteSharedPreferences();
        int counter = preferences.getInt(APP_START_COUNTER_KEY, 0);
        preferences.edit()
                .putInt(APP_START_COUNTER_KEY, ++counter)
                .apply();
        return counter;
    }

}
