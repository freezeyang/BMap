package ia.information.collector;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import notifications.Constants;
import sensor.information.collector.Contact;
import sensor.information.collector.DatabaseHandler;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by yin on 5/14/18.
 */

public class BehaviorList extends Activity {
    private RadioGroup radioGroup;
    private String[] segment;
    private DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior);
        radioGroup = (RadioGroup) findViewById(R.id.RGroup);
        /*RadioButton option1=radioGroup.getCheckedRadioButtonId(R.id.option1);
        option1.setVisibility(View.VISIBLE);
        */

        segment = Constants.TEXT.split("#");
        if (segment != null && segment.length > 1) {
            //has valid content
            int len = segment.length;
            Button btn = (Button) findViewById(R.id.button2);
            btn.setVisibility(View.VISIBLE);
            for (int i = 0; i < len; i++) {
                //initialize RadioButton
                if (i == 0 && segment[i].length() > 0) {
                    RadioButton option1 = (RadioButton) findViewById(R.id.option1);
                    option1.setVisibility(View.VISIBLE);
                    option1.setText(segment[i]);
                } else if (i == 1) {
                    RadioButton option2 = (RadioButton) findViewById(R.id.option2);
                    option2.setVisibility(View.VISIBLE);
                    option2.setText(segment[i]);
                } else if (i == 2) {
                    RadioButton option3 = (RadioButton) findViewById(R.id.option3);
                    option3.setVisibility(View.VISIBLE);
                    option3.setText(segment[i]);
                } else {
                    break;
                }
            }
        }

    }

    public void onClickSave(View view) {
        radioGroup = (RadioGroup) findViewById(R.id.RGroup);
        int selected = radioGroup.getCheckedRadioButtonId();
        RadioButton rbt1 = (RadioButton) findViewById(R.id.option1);
        RadioButton rbt2 = (RadioButton) findViewById(R.id.option2);
        RadioButton rbt3 = (RadioButton) findViewById(R.id.option3);
        String temp = "";
        if (selected == rbt1.getId()) {
            temp = rbt1.getText().toString();
        } else if (selected == rbt2.getId()) {
            temp = rbt2.getText().toString();
        } else if (selected == rbt3.getId()) {
            temp = rbt3.getText().toString();
        }
        if (!temp.equals(null) && temp.length() > 0) {
            Log.d("Insert: ", "Inserting ..");
            db.addContact(new Contact("", "", "", "", "", "", "", "", "", "", "*" + temp, "", ""));
            //insert to database succeed
            Toast.makeText(getApplicationContext(), "Succeed",
                    Toast.LENGTH_SHORT).show();
            Button btn = (Button) findViewById(R.id.button2);
            btn.setVisibility(View.INVISIBLE);
            //clear the message send from server
            Constants.TEXT="";
        }
    }

}
