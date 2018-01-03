package elfirobotics.com.touchtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION = "io.elfix.act_intents.TOUCH_UI.REQUEST";
    public static final String TYPE = "io.elfix.extras.TOUCH_UI.REQUEST_TYPE";
    public static final String YES_OR_NO = "io.elfix.extras.TOUCH_UI.YES_OR_NO";
    public static final String YES_NO_DOES_NOT_KNOW = "io.elfix.extras.TOUCH_UI.YES_NO_DOES_NOT_KNOW";
    public static final String LIST_OF_VALUES = "io.elfix.extras.TOUCH_UI.LIST_OF_VALUES";
    public static final String VALUES = "io.elfix.extras.TOUCH_UI.LIST_OF_VALUES.VALUES";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_yes_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION);
                intent.putExtra(TYPE, YES_OR_NO);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                sendBroadcast(intent);
            }
        });

        findViewById(R.id.button_yes_no_dont_know).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION);
                intent.putExtra(TYPE, YES_NO_DOES_NOT_KNOW);
                sendBroadcast(intent);
            }
        });

        findViewById(R.id.button_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION);
                intent.putExtra(TYPE, LIST_OF_VALUES);
                EditText editTextValues = findViewById(R.id.edit_list_values);
                intent.putExtra(VALUES, editTextValues.getText().toString().split(","));
                sendBroadcast(intent);
            }
        });

        findViewById(R.id.button_registration).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notifyAttendanceIntent = new Intent("io.elfix.act_intents.FACE_CHECK_IN.REGISTRATION");
                notifyAttendanceIntent.putExtra("face_reco_name", ((EditText)findViewById(R.id.edit_face_reco_name)).getText().toString());
                notifyAttendanceIntent.putExtra("schedule_id", Integer.valueOf(((EditText)findViewById(R.id.edit_schedule_id)).getText().toString()));
                sendBroadcast(notifyAttendanceIntent);
            }
        });
    }
}
