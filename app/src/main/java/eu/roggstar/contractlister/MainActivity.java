package eu.roggstar.contractlister;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    NotSoSimpleAdapter adapter;
    ArrayList<Contract> contractsList = new ArrayList <>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("NoAD ContractManager");
        ListView lv_contracts = findViewById(R.id.lv_contracts);

        fetchDatabase();

        adapter = new NotSoSimpleAdapter(this, contractsList);
        lv_contracts.setAdapter(adapter);

        //Click Listview

        lv_contracts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, ContrDetailsActivity.class);
                intent.putExtra("contract_id", position+1); //übergeben von contract
                startActivity(intent);
            }
        });

        //FloatingButton
        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void fetchDatabase(){
        SQLiteDatabase db = openOrCreateDatabase("contracts.db",MODE_PRIVATE,null);
        try{
            Cursor resultSet = db.rawQuery("SELECT * FROM contract",null);
            resultSet.moveToFirst();
            while(resultSet.isAfterLast() == false){
                contractsList.add(new Contract(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),null,null,null,true));
                resultSet.moveToNext();
            }
        } catch (Exception e){
            Toast.makeText(this, "2 "+e.toString(), Toast.LENGTH_LONG).show();
        }
        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
