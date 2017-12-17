package com.dheeraj.weatherapp;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by dheeraj on 16/12/17.
 */

public class MyRequestQueue {
    private static RequestQueue queue;

    public static RequestQueue requestQueue(Context context) {
        if (queue == null)
            queue = Volley.newRequestQueue(context);
        return queue;

    }
}
