package paco.originalPoint.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import paco.originalPoint.R;

import paco.originalPoint.TitleBar;
import paco.originalPoint.BaseFragment;

public class Message extends BaseFragment {

    private ImageView mCollectView;
    private boolean mIsSelected;
    private View view;
    private Context thisContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_message, container, false);

        hideStatusbarBG();

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
            }
        });

        titleBar.setTitle("推按資訊");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        titleBar.setActionTextColor(Color.WHITE);
        mCollectView = (ImageView) titleBar.addAction(new TitleBar.ImageAction(R.mipmap.ic_launcher) {
            @Override
            public void performAction(View view) {
                Toast.makeText(thisContext, "点击了收藏", Toast.LENGTH_SHORT).show();
                mCollectView.setImageResource(R.mipmap.ic_launcher);
                titleBar.setTitle(mIsSelected ? "文章详情\n朋友圈" : "帖子详情");
                mIsSelected = !mIsSelected;
            }
        });

        titleBar.addAction(new TitleBar.TextAction("发布") {
            @Override
            public void performAction(View view) {
                Toast.makeText(thisContext, "点击了发布", Toast.LENGTH_SHORT).show();
            }
        });

        //導入Tab分頁的Fragment Layout
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
}
