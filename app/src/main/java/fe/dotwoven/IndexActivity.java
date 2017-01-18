package fe.dotwoven;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.weimob.dotwoven.annotation.WovenPV;
import com.weimob.dotwoven.annotation.WovenTap;

/**
 * Created by lenovo on 2017/1/18.
 */
public class IndexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.text_request_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                re();
            }
        });
    }

    @WovenTap(pageName = "IndexActivity", elementId = "request")
    public void re() {
    }

    @WovenPV(pageName = "IndexActivity")
    @Override
    protected void onResume() {
        super.onResume();
    }
}
