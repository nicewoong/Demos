package com.mcxtzhang.databindingdemo.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.mcxtzhang.databindingdemo.databinding.ActivityRecyclerViewBinding;
import com.mcxtzhang.databindingdemo.recyclerview.base.BaseBindingAdapter;
import com.mcxtzhang.databindingdemo.recyclerview.m.FirstBindingBean;
import com.mcxtzhang.databindingdemo.recyclerview.multype.MulTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {
    private ActivityRecyclerViewBinding mBinding;
    private BaseBindingAdapter mAdapter;
    private List<FirstBindingBean> mDatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        initDatas();
        mBinding.rv.setLayoutManager(new LinearLayoutManager(this));
/*        mBinding.rv.setAdapter(mAdapter = new BaseBindingAdapter<ItemFirstRvBinding, FirstBindingBean>(this, R.layout.item_first_rv, mDatas) {
            @Override
            public void onBindViewHolder(BaseBindingViewHolder<ItemFirstRvBinding> holder, int position, ItemFirstRvBinding itemFirstRvBinding, final FirstBindingBean firstBindingBean) {
                itemFirstRvBinding.setBean(firstBindingBean);
                //普通的加载方法 但是当数据改变时 它不会立刻改变
                Glide.with(RecyclerViewActivity.this).load(firstBindingBean.getUrl()).into(itemFirstRvBinding.normalLoadIv);
                itemFirstRvBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(RecyclerViewActivity.this, "改变name", Toast.LENGTH_SHORT).show();
                        firstBindingBean.setName(firstBindingBean.getName() + "改变");
                        firstBindingBean.setUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
                    }
                });
                firstBindingBean.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
                    @Override
                    public void onPropertyChanged(Observable sender, int propertyId) {
                        switch (propertyId) {
                            case BR.name:
                                Toast.makeText(RecyclerViewActivity.this, "name propertyId:" + propertyId, Toast.LENGTH_SHORT).show();
                                break;
                            case BR.url:
                                break;

                        }
                    }
                });

                itemFirstRvBinding.addOnRebindCallback(new OnRebindCallback() {
                    @Override
                    public boolean onPreBind(ViewDataBinding binding) {
                        ViewGroup sceneRoot = (ViewGroup) binding.getRoot();
                        TransitionManager.beginDelayedTransition(sceneRoot);
                        return true;
                    }
                });
            }
        });*/

        //多种item
        mBinding.rv.setAdapter( new MulTypeAdapter(this, mDatas));
        mBinding.setPresenter(new FirstPresenter());
    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        ArrayList<FirstBindingBean> nestBeen = new ArrayList<>();
        mDatas.add(new FirstBindingBean("http://imgs.ebrun.com/resources/2016_03/2016_03_25/201603259771458878793312_origin.jpg", "张", 1));


        mDatas.add(new FirstBindingBean("http://p14.go007.com/2014_11_02_05/a03541088cce31b8_1.jpg", "旭童", 1));
        mDatas.add(new FirstBindingBean("http://news.k618.cn/tech/201604/W020160407281077548026.jpg", 1));
        mDatas.add(new FirstBindingBean("http://www.kejik.com/image/1460343965520.jpg", 0));
        mDatas.add(new FirstBindingBean("http://cn.chinadaily.com.cn/img/attachement/jpg/site1/20160318/eca86bd77be61855f1b81c.jpg", 0));
        mDatas.add(new FirstBindingBean("http://imgs.ebrun.com/resources/2016_04/2016_04_12/201604124411460430531500.jpg", 1));
        mDatas.add(new FirstBindingBean("http://imgs.ebrun.com/resources/2016_04/2016_04_24/201604244971461460826484_origin.jpeg", 0));
        mDatas.add(new FirstBindingBean("http://www.lnmoto.cn/bbs/data/attachment/forum/201408/12/074018gshshia3is1cw3sg.jpg", 1));
    }

    public class FirstPresenter {
        public void onAddClick() {
            mDatas.add(new FirstBindingBean("http://finance.gucheng.com/UploadFiles_7830/201603/2016032110220685.jpg", "add"));
            mAdapter.notifyItemInserted(mDatas.size());
        }

        public void onDelClick() {
            mDatas.remove(mDatas.size() - 1);
            mAdapter.notifyItemRemoved(mDatas.size());
        }
    }


}