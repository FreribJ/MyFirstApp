package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileActivity extends AppCompatActivity {

    EditText InputFolderName;
    EditText InputFileName;
    EditText InputContent;
    Button WriteFileButton ;
    Button ReadFileButton;

    TextView Output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        InputFolderName = findViewById(R.id.filesOrdner);
        InputFileName = findViewById(R.id.filesDateiname);
        InputContent = findViewById(R.id.filesInhalt);
        WriteFileButton = findViewById(R.id.filesButton);
        ReadFileButton = findViewById(R.id.filesButton2);
        Output = findViewById(R.id.fileView);

        WriteFileButton.setOnClickListener(view -> {
            createFile(InputFolderName.getText().toString(), InputFileName.getText().toString(), InputContent.getText().toString());
        });

        ReadFileButton.setOnClickListener(view -> {
            Output.setText(loadFile(InputFolderName.getText().toString(), InputFileName.getText().toString()));
        });

    }

    String loadFile(String folderName, String fileName) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            File file = new File(getDir(folderName, MODE_PRIVATE), fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            reader.lines().forEach(l -> stringBuilder.append(l).append("\n"));
            reader.close();
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void createFile(String folderName, String fileName, String fileContent) {

        try {
            File file = new File(getDir(folderName, MODE_PRIVATE), fileName);
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
            writer.write(fileContent);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}