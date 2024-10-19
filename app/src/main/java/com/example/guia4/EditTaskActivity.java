package com.example.guia4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditTaskActivity extends AppCompatActivity {
    EditText editTitulo, editDescripcion, editFecha, editHora;
    Button btnGuardar;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        editTitulo = findViewById(R.id.editTitulo);
        editDescripcion = findViewById(R.id.editDescripcion);
        editFecha = findViewById(R.id.editFecha);
        editHora = findViewById(R.id.editHora);
        btnGuardar = findViewById(R.id.btnGuardar);

        position = getIntent().getIntExtra("position", -1);
        if (position != -1) {
            Tareas tarea = MainActivity.lstTareas.get(position);
            editTitulo.setText(tarea.getTitulo());
            editDescripcion.setText(tarea.getDescripcion());
            editFecha.setText(tarea.getFecha());
            editHora.setText(tarea.getHora());
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tareas tarea = MainActivity.lstTareas.get(position);
                tarea.setTitulo(editTitulo.getText().toString());
                tarea.setDescripcion(editDescripcion.getText().toString());
                tarea.setFecha(editFecha.getText().toString());
                tarea.setHora(editHora.getText().toString());
                finish();
            }
        });
    }
}