package example.tvribbon;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements Button.OnClickListener {

    public static final String RIBBON = "RIBBON";
    private ViewPager mediaPager;
    private MediaPagerAdapter mediaPagerAdapter;
    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPager = (ViewPager) findViewById(R.id.media_strip);

        mediaPagerAdapter = new MediaPagerAdapter(getSupportFragmentManager());

        mediaPager.setAdapter(mediaPagerAdapter);

        mediaPager.setPageTransformer(true, new ZoomOutPageTransformer());

        close = (Button) findViewById(R.id.close);
        close.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == close) {
            super.onBackPressed();
            // Log.d(RIBBON,"Page:" + String.valueOf(item));
        }
    }
}
