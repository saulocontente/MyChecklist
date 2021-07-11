package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aulaudemy.mychecklist.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;
import model.Item;

public class MainActivity extends AppCompatActivity {
    private EditText inputItem;
    private Button buttonAdd;
    private RecyclerView itemList;
    private List<Item> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList    = findViewById(R.id.checklist);
        inputItem   = findViewById(R.id.inputTextItem);
        buttonAdd   = findViewById(R.id.buttonAdd);

        Item item = new Item("Aspirina");
        items.add(item);

        item = new Item("Sabao");
        items.add(item);


        item = new Item("Confort");
        items.add(item);

        loadAdapterList(items);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputItem.getText() != null){
                    Item item = new Item();
                    item.setDescription(inputItem.getText().toString());
                    item.setCheckbox(false);
                    items.add(item);
                    inputItem.setText("");
                    loadAdapterList(items);
                } else {
                    Toast.makeText(getApplicationContext(),"Enter any Item description", Toast.LENGTH_LONG).show();
                    inputItem.hasFocus();
                }
            }
        });

    }


    public void loadAdapterList(List<Item> items) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        itemList.setLayoutManager(layoutManager);
        itemList.setHasFixedSize(true);
        MainAdapter adapter = new MainAdapter(items);
        itemList.setAdapter(adapter);
    }
}