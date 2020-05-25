package com.enginegroupsolutions.pokemonfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText myInput;
    private TextView myText;
    private MyDbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInput = (EditText) findViewById(R.id.myInput);
        myText = (TextView) findViewById(R.id.myText);

        dbHandler = new MyDbHandler(this,null,null,1);
    }

    public void printFromDataBase(){
        String dbString = dbHandler.databaseToString();
        myText.setText(dbString);
        myInput.setText("");
    }


    public void addButtonClick(View view) {
        Pokemon pokemon = new Pokemon(myInput.getText().toString());
        dbHandler.addPokemon(pokemon);
        printFromDataBase();
    }

    public void deleteButtonClick(View view) {
        String inputText = myInput.getText().toString();
        dbHandler.deletePokemon(inputText);
        printFromDataBase();
    }
}
