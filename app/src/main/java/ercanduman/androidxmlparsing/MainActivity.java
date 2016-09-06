package ercanduman.androidxmlparsing;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static String xmlURL;
    private Context context;
    private Button btnGetData;
    private boolean isTaskExecuted = false;
    private MyAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeAll();
    }

    private void initializeAll() {
        context = MainActivity.this;
        xmlURL = context.getString(R.string.parsed_url);

        btnGetData = (Button) findViewById(R.id.btnGetData);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestData();
            }
        });
    }

    private void requestData() {
        //check network connection
        if (CheckNetwork.isNetworkAvailable(context)) {
            if (!isTaskExecuted) {
                task = new MyAsyncTask((Activity) context);
                task.execute(xmlURL);
                isTaskExecuted = true;
            }
        } else {
            Toast.makeText(context, context.getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
