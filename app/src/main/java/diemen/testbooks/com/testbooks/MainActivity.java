package diemen.testbooks.com.testbooks;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private ListView imagesListView; // Show images loaded from the URL in this list view
    private ImageButton searchImageButton; // Button that triggers the search for the keyword entered
    private EditText searchEditText;  //Input box that gives the query

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagesListView = (ListView)findViewById(R.id.images_view);
        searchImageButton = (ImageButton) findViewById(R.id.search_button);
        searchEditText = (EditText) findViewById(R.id.search_text);


        searchImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = searchEditText.getText().toString().trim();

                if(searchText.length() == 0)
                {// Validate if the user has entered anything or not before making the call.
                    Toast.makeText(getApplicationContext(),"Enter some text",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Loading...",Toast.LENGTH_SHORT).show();
                imagesListView.setAdapter(new ListViewCustomAdapter(
                        getApplicationContext()));
            }
        });
        imagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Hell Ya "+position,Toast.LENGTH_SHORT).show();

            }
        });
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
}
