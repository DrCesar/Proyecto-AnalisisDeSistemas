package com.example.wadeowen.usersignup;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by WadeOwen on 09-May-17.
 */

public class SignUpActivity extends AppCompatActivity {


    private UserLoginTask loginTask;

    private EditText editName;
    private EditText editEmail;
    private EditText editPassword;
    private Button signUpButton;

    private View loginView;
    private View progressView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usersignup);

        editName = (EditText) findViewById(R.id.name);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);

        editPassword.setOnEditorActionListener(new EditTextListener());

        signUpButton = (Button) findViewById(R.id.signup);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });

        loginView = (View) findViewById(R.id.loginForm);
        progressView = (View) findViewById(R.id.loginProgress);

    }


    public void signUp(){

        View focusView = null;
        boolean error = false;

        String pass =editPassword.getText().toString();
        String email = editEmail.getText().toString();
        String name = editName.getText().toString();

        if(!isPasswordValid(pass)){
            editPassword.setError("Invalid Password");
            focusView = editPassword;
            error = true;
        }else{
            if(!isEmailValid(email)){
                editEmail.setError("Invalid Email");
                focusView = editEmail;
                error = true;
            }else{
                if(!isNameValid(name)){
                    editName.setError("Invalid Name");
                    focusView = editName;
                    error = true;
                }
            }
        }

        if(!error) {
            showProgress(true);
            loginTask = new UserLoginTask(name, email, pass);
            loginTask.execute((Void) null);
            new AlertDialog.Builder(SignUpActivity.this).setTitle("Message").setMessage("Usuario Creado Exitosamente.").show();

        }else{
            focusView.requestFocus();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            loginView.setVisibility(show ? View.GONE : View.VISIBLE);
            loginView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    loginView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            progressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    progressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            progressView.setVisibility(show ? View.VISIBLE : View.GONE);
            loginView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    public boolean isPasswordValid(String pass){

        return pass.length() > 6 && pass.matches(".*\\d+.*");
    }

    public boolean isEmailValid(String email){

        return email.length() > 6 && email.contains("@");
    }

    public boolean isNameValid(String name){

        return name.length() > 4;
    }

    public class EditTextListener implements TextView.OnEditorActionListener {


        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

            if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                signUp();
            }

            return false;
        }
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean>{

        private String name;
        private String email;
        private String pass;

        UserLoginTask(String n, String e, String p) {
            this.name = n;
            this.email = e;
            this.pass = p;
        }

        @Override
        protected Boolean doInBackground(Void... params){
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            /*for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }*/

            // TODO: register the new account here.
            return true;
        }


        @Override
        protected void onPostExecute(final Boolean success) {
            loginTask = null;
            showProgress(false);

            if (success) {
                finish();
            }
        }

        @Override
        protected void onCancelled() {
            loginTask = null;
            showProgress(false);
        }

    }
}
