package sg.edu.rp.c346.id19018582.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDbs, tvOcbc, tvUob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.textViewDBS);
        tvOcbc = findViewById(R.id.textViewOCBC);
        tvUob = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.equals(tvDbs) == true){
            menu.add(0, 0, 0, getString(R.string.web));
            menu.add(0, 1, 1, getString(R.string.contact));
        }
        else if(v.equals(tvOcbc) == true){
            menu.add(0, 2, 2, getString(R.string.web));
            menu.add(0, 3, 3, getString(R.string.contact));
        }
        else if(v.equals(tvUob) == true){
            menu.add(0, 4, 4, getString(R.string.web));
            menu.add(0, 5, 5, getString(R.string.contact));
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            Intent intentWeb = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.webDbs)));
            startActivity(intentWeb);

        }
        else if (item.getItemId() == 1){
            Intent intentCall =  new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.telDbs)));
            startActivity(intentCall);
        }
        else if(item.getItemId() == 2){
            Intent intentWeb = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.webOcbc)));
            startActivity(intentWeb);
        }
        else if (item.getItemId() == 3){
            Intent intentCall =  new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.telOcbc)));
            startActivity(intentCall);
        }
        else if (item.getItemId() == 4){
            Intent intentWeb = new Intent(Intent. ACTION_VIEW, Uri.parse(getString(R.string.webUob)));
            startActivity(intentWeb);
        }
        else if (item.getItemId() == 5){
            Intent intentCall =  new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.tel) + getString(R.string.telUob)));
            startActivity(intentCall);
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDbs.setText(getString(R.string.dbs));
            tvOcbc.setText(getString(R.string.ocbc));
            tvUob.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDbs.setText(getString(R.string.chDbs));
            tvOcbc.setText(getString(R.string.chOcbc));
            tvUob.setText(getString(R.string.chUob));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
