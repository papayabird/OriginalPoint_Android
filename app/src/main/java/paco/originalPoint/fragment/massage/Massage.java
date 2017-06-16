package paco.originalPoint.fragment.massage;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import paco.originalPoint.R;

import paco.originalPoint.TitleBar;
import paco.originalPoint.BaseFragment;
import paco.originalPoint.Utils;
import paco.originalPoint.fragment.other.*;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class Massage extends BaseFragment {

    private ImageView mCollectView;
    private boolean mIsSelected;
    private View view;
    private Context thisContext;
    paco.originalPoint.fragment.massage.MassageDetail massageDetail;
    Settings settings;
    Notibox notibox;
    FloatingActionMenu floatingActionMenu;
    FloatingActionButton floatingActionButtonAddCard,floatingActionButtonRefresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_message, container, false);

        hideStatusbarBG();

        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);
        titleBar.setImmersive(true);

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setTitle("推按資訊");
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setSubTitleColor(Color.WHITE);
        titleBar.setDividerColor(Color.GRAY);

        /*
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
        */

        Button detailButton = (Button)view.findViewById(R.id.button2);
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                manager = getFragmentManager();
                transaction = manager.beginTransaction();
                transaction.addToBackStack(null);
                massageDetail = new MassageDetail();
                transaction.replace(R.id.frame, massageDetail);
                transaction.commit();
                */
                Utils.show2BtnMessageDialog("111","22",new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                    }
                },"333",new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        });

        floatingActionMenu = (FloatingActionMenu) view.findViewById(R.id.fam);
        floatingActionButtonAddCard = (FloatingActionButton) view.findViewById(R.id.btn_noti_Box);
        floatingActionButtonAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                manager = getFragmentManager();
                transaction = manager.beginTransaction();
                transaction.addToBackStack(null);
                notibox = new Notibox();
                transaction.replace(R.id.frame, notibox);
                transaction.commit();

                floatingActionMenu.close(true);
            }
        });
        floatingActionButtonRefresh = (FloatingActionButton) view.findViewById(R.id.btn_setting);
        floatingActionButtonRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager = getFragmentManager();
                transaction = manager.beginTransaction();
                transaction.addToBackStack(null);
                settings = new Settings();
                transaction.replace(R.id.frame, settings);
                transaction.commit();
                floatingActionMenu.close(true);
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
