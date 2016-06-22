package zhang.buaa.com.myapplication002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> mdata =new ArrayList<>();
    private RecyclerView mRecycle;
    private MyAdapter mAdapter;
    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolBar=(Toolbar)findViewById(R.id.toolbar);
        initData();
        mRecycle=(RecyclerView)findViewById(R.id.recycle);
        mAdapter=new MyAdapter(mdata);
        mRecycle.setAdapter(mAdapter);
        mRecycle.setLayoutManager(new LinearLayoutManager(this));
        mRecycle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));


        mAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void setOnClick(View v, int position, String name) {
                Toast.makeText(MainActivity.this, "name" + name + "position" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_add:
                mAdapter.addData(1,"基德");
                break;
            case R.id.action_delete:
                mAdapter.daleteData(0);
                break;
        }
        return true;
    }

    public void initData(){
        mdata.add("路飞");
        mdata.add("龙");
        mdata.add("卡普");
        mdata.add("香克斯");
        mdata.add("索隆");
        mdata.add("香克斯");
        mdata.add("乌索普");
        mdata.add("乔巴");
        mdata.add("罗宾");
        mdata.add("娜美");
        mdata.add("弗兰基");
        mdata.add("灵魂歌手");

    }
}
