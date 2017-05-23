package paco.originalPoint.fragment.massage;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import paco.originalPoint.BaseFragment;
import paco.originalPoint.R;
import paco.originalPoint.TitleBar;
import paco.originalPoint.fragment.Massage;

public class MassageDetail extends BaseFragment {

    private View view;
    private Context thisContext;
    Massage massage;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    FloatingActionMenu floatingActionMenu;
    FloatingActionButton floatingActionButtonAddCard,floatingActionButtonRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_massage_detail, container, false);

        hideStatusbarBG();

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                manager = getFragmentManager();
                transaction = manager.beginTransaction();
                massage = new Massage();
                transaction.replace(R.id.frame, massage);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        titleBar.setTitle("推按xxx");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        floatingActionMenu = (FloatingActionMenu) view.findViewById(R.id.fam);
        floatingActionButtonAddCard = (FloatingActionButton) view.findViewById(R.id.btn_setting);
        floatingActionButtonAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                interfaceSwitchingFragment.switchFragment(Modules.ADD_CARDS, null);
                floatingActionMenu.close(true);
            }
        });
        floatingActionButtonRefresh = (FloatingActionButton) view.findViewById(R.id.btn_noti_Box);
        floatingActionButtonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                floatingActionMenu.close(true);
//                dialog.show();
//                requestDigitizedCards();
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
