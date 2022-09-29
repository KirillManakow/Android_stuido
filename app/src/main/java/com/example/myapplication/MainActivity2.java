package com.example.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    Connection connection;

    TextInputLayout Nazvanie;
    TextInputLayout Adres;
    TextInputLayout Strix_kod_tovara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Nazvanie = findViewById(R.id.text_iname);
         Adres = findViewById(R.id.text_idadres);
         Strix_kod_tovara = findViewById(R.id.text_strixkod);
    }

    public void Add(View v) {
        try {
            ConnectionHelp connectionHelp = new ConnectionHelp();
            connection = connectionHelp.connect();
            String query = "insert into Cklad values("
                         + Float.parseFloat(String.valueOf(Nazvanie.getEditText().getText())) + "\'," +
                    "\'" + Float.parseFloat(String.valueOf(Adres.getEditText().getText()))+ "" +
                    "\',"+ Float.parseFloat(String.valueOf(Strix_kod_tovara.getEditText().getText()))+ ")";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(query);
            connection.close();
            Log.d("", String.valueOf((result.last())));
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.d("Error - ",throwables.getMessage());
        }
    }

    public void back(View v) {
        switch (v.getId()) {
            case R.id.button_back:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}