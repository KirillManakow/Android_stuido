package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
    }

    String ConnectionResult = "";
    Connection connection;

    TextView Kod_id;

    public void Delete(View v) {

        Kod_id = findViewById(R.id.Kod_id);
        String id = Kod_id.getText().toString();

        try {
            ConnectionHelp conectionHellper = new ConnectionHelp();
            connection = conectionHellper.connect();

                if (connection != null) {

                    String query2 = "DELETE FROM Cklad WHERE Kod_cklada = '"+id+"'";
                    Statement statement2 = connection.createStatement();
                    statement2.execute(query2);
                    Toast.makeText(this,"Успешно удалено", Toast.LENGTH_LONG).show();
                } else {
                    ConnectionResult = "Check Connection";
                }


        } catch (SQLException throwable) {
            throwable.printStackTrace();
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