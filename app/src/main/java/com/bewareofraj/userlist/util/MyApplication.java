package com.bewareofraj.userlist.util;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Application singleton to manage Volley Requests
 */
public class MyApplication extends Application {

    /**
     * Default tag for Volley requests
     */
    public static final String TAG = MyApplication.class.getSimpleName();

    private RequestQueue requestQueue;

    private static MyApplication instance;

    /**
     * Just singleton things...
     * @return
     */
    public static synchronized MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
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

    /**
     * Add a request to the queue with the specified tag
     * @param request
     * @param tag
     * @param <T>
     */
    public <T> void addToRequestQueue(Request<T> request, String tag) {
        // set default tag if it is empty
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    /**
     * Add a request to the queue with the default tag
     * @param request
     * @param <T>
     */
    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    /**
     * Cancel a request with the specified tag
     * @param tag
     */
    public void cancelPendingRequest(Object tag) {
        if (requestQueue != null) {
            requestQueue.cancelAll(tag);
        }
    }
}
