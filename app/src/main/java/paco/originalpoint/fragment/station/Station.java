package paco.originalpoint.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.storage.FirebaseStorage;

import paco.originalpoint.R;
import paco.originalpoint.TitleBar;
import paco.originalpoint.baseFragment;


public class Station extends baseFragment {
    private View view;
    private Context thisContext;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_case, container, false);

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);
        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setTitle("服務據點");
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
