package events;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewItemClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener listener;
    private GestureDetector gestureDetector;

    @Override
    public boolean onInterceptTouchEvent(@NonNull  RecyclerView recyclerView, @NonNull  MotionEvent motionEvent) {
        View childView = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());
        if( childView != null && listener != null && gestureDetector.onTouchEvent(motionEvent) ) {
            listener.onItemClick(
                    childView,
                    recyclerView.getChildAdapterPosition(childView)
            );
            return true;
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull  RecyclerView rv, @NonNull  MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public RecyclerViewItemClickListener(Context context, final RecyclerView recyclerView, OnItemClickListener onItemClicklistener) {
        this.listener = onItemClicklistener;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public void onLongPress(MotionEvent e) {
                View childView = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if ( childView != null && listener != null ) {
                    listener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView));
                }
            }
        });
    }
}

