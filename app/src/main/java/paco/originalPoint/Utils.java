package paco.originalPoint;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by tsaiyuheng on 2017/6/15.
 */

public class Utils {

    public static void show2BtnMessageDialog(final String msg, final String btn1, final View.OnClickListener btn1OnclClickListener, final String btn2, final View.OnClickListener btn2OnClickListener)
    {

        MainActivity.getActivity().runOnUiThread(new Runnable()
        {
            // AppMain.getHandler().post(new Runnable()
            @Override
            public void run()
            {
                View view = MainActivity.getActivity().getLayoutInflater().inflate(R.layout.btn_2_message_dialog, null);

                ((TextView) view.findViewById(R.id.txt_message)).setText(msg);
                MainActivity.setDialog(new CustomDialog(MainActivity.getActivity(), view, R.style.dialog));
                MainActivity.getDialog().setCancelable(false);
                MainActivity.getDialog().show();

                ((Button) view.findViewById(R.id.btn_dialog_ok)).setText(btn1);
                view.findViewById(R.id.btn_dialog_ok).setOnClickListener(btn1OnclClickListener);

                ((Button) view.findViewById(R.id.btn_dialog_cancel)).setText(btn2);
                view.findViewById(R.id.btn_dialog_cancel).setOnClickListener(btn2OnClickListener);
            }
        });
    }
}
