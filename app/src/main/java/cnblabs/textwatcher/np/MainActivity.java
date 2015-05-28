package cnblabs.textwatcher.np;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private Toolbar mToolbar;
    private EditText et1,et2;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().getThemedContext();

        if (Build.VERSION.SDK_INT >= 21)
        {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        result = (TextView) findViewById(R.id.result);

        // Instantiates a TextWatcher, to observe your EditTexts' value changes
        // and trigger the result calculation
        TextWatcher textWatcher = new TextWatcher()
        {
            public void afterTextChanged(Editable s)
            {
                calculateResult();
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        };

// Adds the TextWatcher as TextChangedListener to both EditTexts
        et1.addTextChangedListener(textWatcher);
        et2.addTextChangedListener(textWatcher);


    }

    // The function called to calculate and display the result of the multiplication
    private void calculateResult() throws NumberFormatException {
        // Gets the two EditText controls' Editable values
        Editable editableValue1 = et1.getText(),
                editableValue2 = et2.getText();

        // Initializes the double values and result
        String value1 = "",
                value2 = "",
                result1;

        // If the Editable values are not null, obtains their double values by parsing
        if (editableValue1 != null)
            value1 =editableValue1.toString();

        if (editableValue2 != null)
            value2 = editableValue2.toString();

        // Calculates the result
        result1 = value1 + value2;

        // Displays the calculated results
        result.setText("You Entered ="+result1);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
