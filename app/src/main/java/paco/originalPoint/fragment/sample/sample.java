package paco.originalPoint.fragment.sample;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import paco.originalPoint.MainActivity;
import paco.originalPoint.R;
import paco.originalPoint.TitleBar;
import paco.originalPoint.BaseFragment;


public class Sample extends BaseFragment {

    private View view;
    private Context thisContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_case, container, false);

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setTitle("案例分享");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

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
