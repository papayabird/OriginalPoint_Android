package paco.originalpoint;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    FragmentTransaction transaction;

    paco.originalpoint.fragment.Message messageVC;
    paco.originalpoint.fragment.Case caseVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup group = (RadioGroup)findViewById(R.id.radiogp);
        group.check(R.id.rbMessasge);

        //
        RadioButton messageBtn = (RadioButton) findViewById(R.id.rbMessasge);
        messageBtn.setSelected(true);
        messageBtn.setOnClickListener(this);

        RadioButton caseBtn = (RadioButton) findViewById(R.id.rbCase);
        caseBtn.setOnClickListener(this);
        //
        transaction = getSupportFragmentManager().beginTransaction();

        messageVC = new paco.originalpoint.fragment.Message();
        transaction.add(R.id.frame, messageVC);

        transaction.commit();

    }

    @Override
    public void onClick(View v) {

        transaction = getSupportFragmentManager().beginTransaction();
        System.out.println("this is radiobtn");
        RadioButton rb = (RadioButton) v;
        transaction.addToBackStack(null);
        switch (rb.getId()) {
            case R.id.rbMessasge:

                if (messageVC == null) {
                    messageVC = new paco.originalpoint.fragment.Message();
                }

                transaction.replace(R.id.frame, messageVC);

                transaction.commit();

                break;
            case R.id.rbCase:

                if (caseVC == null) {
                    caseVC = new paco.originalpoint.fragment.Case();
                }
                transaction.replace(R.id.frame, caseVC);
                transaction.commit();

                break;
            case R.id.rbprofile:



                break;
            default:
                System.out.println("nothing");
        }


    }
}
