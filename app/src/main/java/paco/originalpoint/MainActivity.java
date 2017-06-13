package paco.originalPoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import paco.originalPoint.fragment.sample.Sample;
import paco.originalPoint.fragment.massage.Massage;
import paco.originalPoint.fragment.station.Station;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    FragmentTransaction transaction;

    Massage massageVC;
    Sample sampleVC;
    Station stationVC;


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

        RadioButton stationBtn = (RadioButton) findViewById(R.id.rbStation);
        stationBtn.setOnClickListener(this);
        //
        transaction = getSupportFragmentManager().beginTransaction();

        massageVC = new Massage();
        transaction.add(R.id.frame, massageVC);

        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        if (msg!=null)
            Log.d("FCM", "msg:"+msg);
    }

    @Override
    public void onClick(View v) {

        transaction = getSupportFragmentManager().beginTransaction();
        System.out.println("this is radiobtn");
        RadioButton rb = (RadioButton) v;
        transaction.addToBackStack(null);
        switch (rb.getId()) {
            case R.id.rbMessasge:

                if (massageVC == null) {
                    massageVC = new Massage();
                }

                transaction.replace(R.id.frame, massageVC);
                transaction.commit();

                break;
            case R.id.rbCase:

                if (sampleVC == null) {
                    sampleVC = new Sample();
                }
                transaction.replace(R.id.frame, sampleVC);
                transaction.commit();

                break;
            case R.id.rbStation:

                if (stationVC == null) {
                    stationVC = new Station();
                }
                transaction.replace(R.id.frame, stationVC);
                transaction.commit();

                break;
            default:
                System.out.println("nothing");
        }


    }
}
