package polinema.ac.id.dtsdesigntolayout;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    // Deklarasi EditText
    EditText edtTextCode, edtTextNew, edtTextConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        //binding edtTextCode, edtTextNew, edtTextConfirm ke variabel EditText
        edtTextCode=findViewById(R.id.edt_txt_code);
        edtTextNew=findViewById(R.id.edt_new_password);
        edtTextConfirm=findViewById(R.id.edt_confirm_password);

    }

    public void postChangePassword(View view) {
        // Validasi input reset code, password baru dan konfirmasi kosong
        if(TextUtils.isEmpty(edtTextCode.getText().toString().trim()) && TextUtils.isEmpty(edtTextNew.getText().toString().trim()) &&
                TextUtils.isEmpty(edtTextConfirm.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Reset Code dan Password baru tidak boleh kosong!",
                    Toast.LENGTH_LONG).show();
        }
        // Validasi input password kosong
        else if(TextUtils.isEmpty(edtTextCode.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Reset Code tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(edtTextNew.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Password Baru tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        else if(TextUtils.isEmpty(edtTextConfirm.getText().toString())){
            Toast.makeText(view.getContext(), "Password Konfirmasi tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
        //syntax confirm and password harus sama
        else if(!edtTextNew.getText().toString().equals(edtTextConfirm.getText().toString()) ){
            AlertDialog alertDialog = new AlertDialog.Builder(ResetPassword.this).create();
            alertDialog.setTitle("oops!");
            alertDialog.setMessage("Passwords do not match");
            alertDialog.show();
        }

        else{
            Intent i = new Intent(ResetPassword.this, SuccessActivity.class);
            startActivity(i);
        }

    }


}
