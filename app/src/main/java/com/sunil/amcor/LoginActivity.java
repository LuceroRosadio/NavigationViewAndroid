package com.sunil.amcor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunil.amcor.data.UserResponse;
import com.sunil.amcor.data.api.RestClient;
import com.sunil.amcor.util.Constant;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private TextInputEditText user;
    private TextInputEditText password;
    private Button button;

    private UserLogin userLogin = new UserLogin();

    private CoordinatorLayout coordinatorLayout;

    private static final String TAG = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = (TextInputEditText)findViewById(R.id.edt_username);
        password = (TextInputEditText)findViewById(R.id.edt_password);
        button = (Button)findViewById(R.id.login);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayoutLogin);
    }

    @Override
    public void onClick(View v) {
        userLogin.setUsername(user.getText().toString());
        userLogin.setPassword(password.getText().toString());

        disableInputs();

        validarUsuario(userLogin);

    }

    private void disableInputs() {
        user.setEnabled(false);
        password.setEnabled(false);
        button.setEnabled(false);
    }

    private void enableInputs() {
        user.setEnabled(true);
        password.setEnabled(true);
        button.setEnabled(true);
    }

    private void validarUsuario(UserLogin usuario) {
        Log.d(TAG, "validarUserLogin: "+usuario.toString());
        String user = usuario.getUsername();
        String password = usuario.getPassword();
        Log.d(TAG, "validarUser: "+user);
        Log.d(TAG, "validarPassword: "+password);

        if (user.isEmpty()) {
            Snackbar.make (coordinatorLayout, "Ingrese el usuario.", Snackbar.LENGTH_LONG)
                    .show();
            enableInputs();
        } else if (password.isEmpty()) {
            Snackbar.make (coordinatorLayout, "Ingrese la contraseña", Snackbar.LENGTH_LONG)
                    .show();
            enableInputs();
        } else {
            loadJson(userLogin);
        }

    }


    private void loadJson(UserLogin u) {
        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                R.style.AppTheme_Dark_Dialog);
        //progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Iniciando sesión...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        Log.d(TAG, "getContext().getFilesDir1(): "+getApplicationContext().getFilesDir());
        Log.d(TAG, "loadJson");
        Log.d(TAG, "userLogin: "+u.toString());
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoginInterceptor(this))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        RestClient restClient = retrofit.create(RestClient.class);
        Call<UserResponse> call = restClient.authenticate(u);

        Log.d(TAG, "call request: "+call.request());

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Log.d(TAG, response.code() +"");
                switch (response.code()){
                    case 200:
                        UserResponse data = response.body();
                        Log.d(TAG, data.toString());
                        goHome(data);
                        break;
                    case 401:
                        progressDialog.dismiss();
                        Snackbar.make (coordinatorLayout, "Usuario o contraseña incorrecta.", Snackbar.LENGTH_LONG)
                                .show();
                        enableInputs();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
            }
        });
    }

    private void onLoginFailed() {
        Snackbar.make (coordinatorLayout, "Usuario o contraseña incorrecta.", Snackbar.LENGTH_LONG)
                .show();
    }

    private void goHome(UserResponse data) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("data", data);
        startActivity(intent);
    }
}
