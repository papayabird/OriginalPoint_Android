package paco.originalPoint;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by tsaiyuheng on 2017/6/15.
 */

public class CustomDialog extends Dialog{

    //	private static int default_width = 160; // 默认宽度
//	private static int default_height = 120;// 默认高度

    public CustomDialog(Context context, int width, View layout, int style)
    {
        super(context, style);
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
//		params.width = 350;
        window.setAttributes(params);
    }

    public CustomDialog(Context context, View layout, int style)
    {
        super(context, style);
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }
}
