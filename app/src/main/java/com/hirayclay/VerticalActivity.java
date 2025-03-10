package com.hirayclay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VerticalActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_vertical)
    RecyclerView verticalRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical);
        ButterKnife.bind(this);
        vr();
    }

    private void vr() {
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            datas.add(String.valueOf(i));
        }

        Config config = new Config();
        config.secondaryScale = 1f;
        config.scaleRatio = 0.2f;
        config.maxStackCount = 2;
        config.initialStackCount = 0;
        config.space = 20;
        config.parallex = 1.5f;
        config.align = Align.TOP;
        verticalRecyclerview.setLayoutManager(new StackLayoutManager(config));
        verticalRecyclerview.setAdapter(new StackAdapter(datas).vertical());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.reset:
                vr();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rest, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
