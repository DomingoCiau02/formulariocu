package com.example.formulariocu;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {

    private TextView textViewName, textViewBirthDate, textViewPhone, textViewEmail, textViewDescription;
    private Button buttonEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        textViewName = findViewById(R.id.textViewName);
        textViewBirthDate = findViewById(R.id.textViewBirthDate);
        textViewPhone = findViewById(R.id.textViewPhone);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewDescription = findViewById(R.id.textViewDescription);
        buttonEdit = findViewById(R.id.buttonEdit);

        Intent intent = getIntent();
        textViewName.setText("Nombre: " + intent.getStringExtra("name"));
        textViewBirthDate.setText("Fecha de Nacimiento: " + intent.getStringExtra("birthDate"));
        textViewPhone.setText("Teléfono: " + intent.getStringExtra("phone"));
        textViewEmail.setText("Email: " + intent.getStringExtra("email"));
        textViewDescription.setText("Descripción: " + intent.getStringExtra("description"));

        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(ConfirmationActivity.this, MainActivity.class);
                editIntent.putExtra("name", intent.getStringExtra("name"));
                editIntent.putExtra("birthDate", intent.getStringExtra("birthDate"));
                editIntent.putExtra("phone", intent.getStringExtra("phone"));
                editIntent.putExtra("email", intent.getStringExtra("email"));
                editIntent.putExtra("description", intent.getStringExtra("description"));
                startActivity(editIntent);
            }
        });
    }
}