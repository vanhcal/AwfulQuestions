package org.hunt2.hunt.awfulquestions;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Van on 8/25/2016.
 */
public class RetrieveFeedTask extends AsyncTask<String, Void, String> {
    private final Context context;

    public RetrieveFeedTask(final Context context) {
        this.context = context;
    }

    protected String doInBackground(String... urls) {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            urlConnection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

    private String readStream(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader r = new BufferedReader(new InputStreamReader(is),1000);
        for (String line = r.readLine(); line != null; line =r.readLine()){
            sb.append(line);
        }
        is.close();
        return sb.toString();
    }
}
