package ercanduman.androidxmlparsing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class MyAsyncTask extends AsyncTask<String, String, String> {
    private ProgressDialog dialog;
    static Activity activity;

    private static String titleText, descriptionText;
    private TextView tvTitle, tvDescription;
    private Horoscope horoscope;

    public MyAsyncTask(Activity activity) {
        this.activity = activity;
        tvTitle = (TextView) activity.findViewById(R.id.tvTitle);
        tvDescription = (TextView) activity.findViewById(R.id.tvDesc);

        dialog = new ProgressDialog(activity);
        dialog.setMessage(activity.getString(R.string.loading));
    }


    @Override
    protected void onPreExecute() {
        dialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String result = HttpManager.getDataFromURL(strings[0]);
        try {
            horoscope = XMLParser.parseFeed(result);
            titleText = horoscope.getTitle();
            descriptionText = horoscope.getDescription();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
        tvTitle.setText(titleText);
        tvDescription.setText(descriptionText);
        tvDescription.setMovementMethod(new ScrollingMovementMethod());
    }
}

