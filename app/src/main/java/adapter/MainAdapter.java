package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aulaudemy.mychecklist.R;

import java.util.List;

import model.Item;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.VH> {
    private List<Item> items;

    public MainAdapter(List<Item> itemsList) {
        this.items = itemsList;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View adapterlist = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.checklist, parent, false);
        return new VH(adapterlist);
    }

    @Override
    public void onBindViewHolder(@NonNull  MainAdapter.VH holder, int position) {
        Item itemAtPosition = items.get(position);
        holder.checkboxView.setChecked(itemAtPosition.getCheckbox());
        holder.checkboxView.setText(itemAtPosition.getDescription());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public class VH extends RecyclerView.ViewHolder {

        CheckBox checkboxView;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.checkboxView = itemView.findViewById(R.id.checkboxItem);
        }
    }
}
