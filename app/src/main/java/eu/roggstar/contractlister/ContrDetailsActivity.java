package eu.roggstar.contractlister;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ContrDetailsActivity extends AppCompatActivity {

    int contract_id;
    TextView txt_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contr_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txt_title = findViewById(R.id.txt_title);

        contract_id = getIntent().getIntExtra("contract_id",9999);

        if(contract_id == 9999){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            finish();
        }

        fetchDatabase();

        //FloatingButton
        FloatingActionButton fab = findViewById(R.id.fab);
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
            Cursor resultSet = db.rawQuery("SELECT * FROM contract WHERE id ="+contract_id,null);
            resultSet.moveToFirst();
            txt_title.setText(resultSet.getString(2));
            this.setTitle(resultSet.getString(1));
        } catch (Exception e){
            Toast.makeText(this, "2 "+e.toString(), Toast.LENGTH_LONG).show();
        }
        db.close();
    }
}
