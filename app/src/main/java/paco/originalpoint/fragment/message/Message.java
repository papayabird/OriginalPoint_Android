package paco.originalpoint.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import paco.originalpoint.R;

import paco.originalpoint.TitleBar;

public class Message extends Fragment {

    private ImageView mCollectView;
    private boolean mIsSelected;
    private View view;
    private Context thisContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        thisContext = container.getContext();
        view = inflater.inflate(R.layout.fragment_message, container, false);

        boolean isImmersive = false;

        if (hasKitKat() && !hasLollipop()) {
            isImmersive = true;
            //透明状态栏
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
//                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        } else if (hasLollipop()) {
            Window window = getActivity().getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            isImmersive = true;
        }


        final TitleBar titleBar = (TitleBar)view.findViewById(R.id.title_bar);

        titleBar.setImmersive(isImmersive);

        titleBar.setBackgroundColor(Color.parseColor("#64b4ff"));

        titleBar.setLeftText("返回");
        titleBar.setLeftTextColor(Color.WHITE);
        titleBar.setLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                finish();
            }
        });

        titleBar.setTitle("推案資訊");
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

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }
}
