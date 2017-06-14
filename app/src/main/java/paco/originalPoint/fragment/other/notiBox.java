package paco.originalPoint.fragment.other;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import paco.originalPoint.BaseFragment;
import paco.originalPoint.R;
import paco.originalPoint.TitleBar;

public class Notibox extends BaseFragment {

    private View view;
    private Context thisContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_noti_box, container, false);

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setTitle("最新通知");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count = getFragmentManager().getBackStackEntryCount();

                if (count == 0) {
                    getActivity().onBackPressed();
                } else {
                    getFragmentManager().popBackStack();
                }
            }
        });

        //導入Tab分頁的Fragment Layout
        return view;
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