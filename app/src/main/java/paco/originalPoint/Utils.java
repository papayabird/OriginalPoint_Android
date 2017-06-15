package paco.originalPoint;

import android.content.DialogInterface;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by tsaiyuheng on 2017/6/15.
 */

public class Utils {

    public static void show1BtnMessageDialog(final String msg, final Object... listener)
    {
        MainActivity.getActivity().runOnUiThread(new Runnable()
        {
            View.OnClickListener defaultListener = new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    MainActivity.getDialog().dismiss();
                }
            };

            @Override
            public void run()
            {
                View view = MainActivity.getActivity().getLayoutInflater().inflate(R.layout.btn_1_message_dialog, null);

                ((TextView) view.findViewById(R.id.txt_message)).setText(msg);
                MainActivity.setDialog(new CustomDialog(MainActivity.getActivity(), view, R.style.dialog));
                MainActivity.getDialog().setCancelable(false);
                MainActivity.getDialog().show();

                if (listener != null && listener.length > 0)
                    view.findViewById(R.id.btn_ok).setOnClickListener((View.OnClickListener) listener[0]);
                else
                    view.findViewById(R.id.btn_ok).setOnClickListener(defaultListener);

                if (listener != null && listener.length > 1)
                    ((Button) view.findViewById(R.id.btn_ok)).setText((String) listener[1]);

            }
        });
    }

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

    public static void showProgressDialog(final String msg, final Object... objs)
    {
        Utils.dismiss();
        MainActivity.getActivity().runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                View view = MainActivity.getActivity().getLayoutInflater().inflate(R.layout.progress_dialog, null);
                final TextView txt_dialog = ((TextView) view.findViewById(R.id.textView1));
                txt_dialog.setText(msg);
                if (msg == null || msg.isEmpty())
                    txt_dialog.setVisibility(View.GONE);

                MainActivity.setDialog(new CustomDialog(MainActivity.getActivity(), view, R.style.dialog));
                MainActivity.getDialog().setCancelable(false);

                if (objs != null && objs.length > 0)
                    ((ProgressHandler) objs[0]).setText(txt_dialog);

                if (objs != null && objs.length > 1)
                    MainActivity.getDialog().setOnDismissListener((DialogInterface.OnDismissListener) objs[1]);

                MainActivity.getDialog().show();
            }
        });
    }

    class ProgressHandler extends Handler
    {

        private TextView text;

        public TextView getText()
        {
            return text;
        }

        public void setText(TextView text)
        {
            this.text = text;
        }
    }

    public static void dismiss()
    {
        MainActivity.getActivity().runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                if (MainActivity.getDialog() != null)
                    MainActivity.getDialog().dismiss();
            }
        });
    }
}
