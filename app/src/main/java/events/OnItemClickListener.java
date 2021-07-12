package events;

import android.view.View;
import android.widget.AdapterView;

public interface OnItemClickListener extends AdapterView.OnItemClickListener {
    public void onItemClick(View view, int position);

    public void onItemLongClick(View childView, int childAdapterPosition);
}
