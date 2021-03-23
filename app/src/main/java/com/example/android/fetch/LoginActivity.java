    package com.example.android.fetch;

    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.MotionEvent;
    import android.view.View;
    import android.widget.CheckBox;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.LinearLayout;
    import android.widget.PopupWindow;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView fetchBranding = (ImageView) findViewById(R.id.login_branding);
        fetchBranding.setImageResource(R.drawable.color_mustard_yellow);
    }

    /**
     * This method is called when the log in button is clicked.
     */
    public void logIn(View view) {
        EditText checkUsernameEntered = (EditText) findViewById(R.id.username_input);
        String username = checkUsernameEntered.getText().toString();
        EditText checkPasswordEntered = (EditText) findViewById(R.id.password_input);
        String password = checkPasswordEntered.getText().toString();
        if(username.equalsIgnoreCase("TRUE") && password.equals("TRUE")) {
            Toast toast = Toast.makeText(this, getString(R.string.login_success_message), Toast.LENGTH_SHORT);
            toast.show();
            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(loginIntent);
        } else {
            Toast toast = Toast.makeText(this, getString(R.string.login_error_message), Toast.LENGTH_SHORT);
            toast.show();
        }
        /**String priceMessage= createOrderSummary(quantity, price, hasWhippedCream, hasChocolate, customerName);
        Intent sendOrderSummary = new Intent(Intent.ACTION_SENDTO);
        sendOrderSummary.setData(Uri.parse("mailto:"));
        sendOrderSummary.putExtra(Intent.EXTRA_TEXT, priceMessage);
        sendOrderSummary.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        if(sendOrderSummary.resolveActivity(getPackageManager()) != null) {
            startActivity(sendOrderSummary);
        }**/
    }

    /**
     * This method is called when the log in button is clicked.
     */
    public void guestLogIn(View view) {

        //Inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.guest_login_popup_window, null);

        //create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the pop-up also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        //show the popup window
        //which view you pass in doesn't matter, it is only useed for the window token
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        //dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

    }

    public void submitPostcode(View view) {

        Intent postcodeIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(postcodeIntent);
        /**String priceMessage= createOrderSummary(quantity, price, hasWhippedCream, hasChocolate, customerName);
         Intent sendOrderSummary = new Intent(Intent.ACTION_SENDTO);
         sendOrderSummary.setData(Uri.parse("mailto:"));
         sendOrderSummary.putExtra(Intent.EXTRA_TEXT, priceMessage);
         sendOrderSummary.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
         if(sendOrderSummary.resolveActivity(getPackageManager()) != null) {
         startActivity(sendOrderSummary);
         }**/
    }

    public void detectLocation(View view) {

        Intent detectIntent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(detectIntent);
        /**String priceMessage= createOrderSummary(quantity, price, hasWhippedCream, hasChocolate, customerName);
        Intent sendOrderSummary = new Intent(Intent.ACTION_SENDTO);
        sendOrderSummary.setData(Uri.parse("mailto:"));
        sendOrderSummary.putExtra(Intent.EXTRA_TEXT, priceMessage);
        sendOrderSummary.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
        if(sendOrderSummary.resolveActivity(getPackageManager()) != null) {
            startActivity(sendOrderSummary);
        }**/
    }


}
