package com.swipeable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import swipeable.com.layoutmanager.OnItemSwiped;
import swipeable.com.layoutmanager.SwipeableLayoutManager;
import swipeable.com.layoutmanager.SwipeableTouchHelperCallback;
import swipeable.com.layoutmanager.touchelper.ItemTouchHelper;

public class MainActivity extends AppCompatActivity {

  private ListAdapter adapter;
  private ItemTouchHelper itemTouchHelper;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    adapter = new ListAdapter();
    final RecyclerView recyclerView = findViewById(R.id.recycler_view);
    SwipeableTouchHelperCallback swipeableTouchHelperCallback =
        new SwipeableTouchHelperCallback(new OnItemSwiped() {
          @Override public void onItemSwiped() {
            adapter.removeTopItem();
          }

          @Override public void onItemSwipedLeft() {

          }

          @Override public void onItemSwipedRight() {

          }
        });
    itemTouchHelper = new ItemTouchHelper(swipeableTouchHelperCallback);
    itemTouchHelper.attachToRecyclerView(recyclerView);
    recyclerView.setLayoutManager(new SwipeableLayoutManager());
    recyclerView.setAdapter(adapter = new ListAdapter());
  }
}
