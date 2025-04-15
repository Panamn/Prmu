package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements StateAdapter.OnStateClickListener {

    ArrayList<State> states = new ArrayList<State>();
    RecyclerView recyclerView;
    StateAdapter stateAdapter;
    LayoutInflater inflater;
    Button buttonAdd;
    boolean itemAdded;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        itemAdded = false;
        buttonAdd = findViewById(R.id.buttonAdd);

        buttonAddList();


    }
    private void buttonAddList(){

        buttonAdd.setOnClickListener(v -> {

            if (!itemAdded) {
                setInitialData();
                recyclerView = findViewById(R.id.recyclesView);
                inflater = LayoutInflater.from(this);
                stateAdapter = new StateAdapter(inflater, states, this);

                recyclerView.setAdapter(stateAdapter);
                itemAdded = true;
            } else if(itemAdded = true){
                Toast.makeText(this, "Этот элемент уже есть в списке", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void setInitialData(){
        states.add(new State(R.drawable.russia, "Москва", "Россия"));
        states.add(new State(R.drawable.belarus, "Минск", "Беларусь"));
        states.add(new State(R.drawable.china, "Пекин", "Китай"));
        states.add(new State(R.drawable.south_korea, "Сеул", "Южная Корея"));
        states.add(new State(R.drawable.spain, "Мадрид(Madrid)", "Испания"));

    }

    @Override
    public void onStateClick(State state, int position) {
        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(State state, int position) {
                Toast.makeText(getApplicationContext(), "Выбран: " + state.getName(), Toast.LENGTH_SHORT).show();
            }
        };
    }
}