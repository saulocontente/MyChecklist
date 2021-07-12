package activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aulaudemy.mychecklist.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MainAdapter;
import events.OnItemClickListener;
import events.RecyclerViewItemClickListener;
import model.Item;

public class MainActivity extends AppCompatActivity {
    private EditText inputItem;
    private Button buttonAdd;
    private RecyclerView itemChecklist;
    private final List<Item> itemsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemChecklist = findViewById(R.id.checklist);
        inputItem   = findViewById(R.id.inputTextItem);
        buttonAdd   = findViewById(R.id.buttonAdd);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        itemChecklist.setLayoutManager(layoutManager);
        itemChecklist.setHasFixedSize(true);

        Item item = new Item("Aspirina");
        itemsList.add(item);

        item = new Item("Sabao");
        itemsList.add(item);


        item = new Item("Confort");
        itemsList.add(item);

        loadAdapterList(itemsList);

        itemChecklist.addOnItemTouchListener(new RecyclerViewItemClickListener(
                getApplicationContext(),
                itemChecklist,
                new OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            Item item = itemsList.get(position);
                            checkItem(item);
                        }

                        @Override
                        public void onItemLongClick(View childView, int childAdapterPosition) {
                            Item item = itemsList.get(childAdapterPosition);
                            checkItem(item);
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Item item = itemsList.get(position);
                            checkItem(item);
                        }
                }
        ));

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputItem.getText() != null){
                    addItemOnList();
                } else {
                    Toast.makeText(getApplicationContext(),"Enter any Item description", Toast.LENGTH_LONG).show();
                    inputItem.hasFocus();
                }
            }
        });
    }

    private void checkItem(Item item) {
        Toast.makeText(
                getApplicationContext(),
                "selected item: "+item.getDescription(),
                Toast.LENGTH_SHORT)
                .show();
        if (item.getCheckbox() != true) {
            item.setCheckbox(true);
        }else {
            item.setCheckbox(false);
        }
        loadAdapterList(itemsList);
    }

    private void addItemOnList() {
        Item item = new Item();
        item.setDescription(inputItem.getText().toString());
        item.setCheckbox(false);
        itemsList.add(item);
        inputItem.setText("");
        loadAdapterList(itemsList);
    }

    public void loadAdapterList(List<Item> items) {
        MainAdapter adapter = new MainAdapter(items);
        itemChecklist.setAdapter(adapter);
    }
}