package com.bewareofraj.userlist.util;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by raj on 7/10/15.
 */
public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();

    private RequestQueue requestQueue;

    private static MyApplication instance;

    /**
     * Just singleton things...
     * @return
     */
    public static MyApplication getInstance() {
        return instance;
    }

    /**
     * Return the request queue or create one if it doesn't exist
     * @return
     */
    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }
}
