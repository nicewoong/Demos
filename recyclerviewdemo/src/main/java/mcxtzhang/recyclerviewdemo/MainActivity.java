package mcxtzhang.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mcxtzhang.zxtcommonlib.recyclerview.CommonAdapter;
import com.mcxtzhang.zxtcommonlib.recyclerview.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRv;
    private List<TestBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new CstLinearLayoutManager());
        //mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(new CommonAdapter<TestBean>(this, R.layout.item_rv_1, mDatas) {
            @Override
            public void convert(ViewHolder holder, TestBean testBean) {
                Log.d("TAG", "convert() called with: holder = [" + holder + "], testBean = [" + testBean + "]");
                holder.setText(R.id.tv, testBean.getName());
            }
        });
    }

    private void initDatas() {
        int i = 0;
        mDatas = new ArrayList<>();

        mDatas.add(new TestBean((i++) + "", "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://fudaoquan.com/wp-content/uploads/2016/04/wanghong.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://news.k618.cn/tech/201604/W020160407281077548026.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://www.kejik.com/image/1460343965520.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg"));
        mDatas.add(new TestBean((i++) + "", "http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://fudaoquan.com/wp-content/uploads/2016/04/wanghong.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://news.k618.cn/tech/201604/W020160407281077548026.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://www.kejik.com/image/1460343965520.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg"));
        mDatas.add(new TestBean((i++) + "", "http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg"));
        mDatas.add(new TestBean((i++) + "", "http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg"));


    }
}
