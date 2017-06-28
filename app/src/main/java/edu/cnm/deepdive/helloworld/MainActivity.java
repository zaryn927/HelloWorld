package edu.cnm.deepdive.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button btnMainActivity = (Button)findViewById(R.id.btnMainActivity);
    btnMainActivity.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        View txtHelloWorld = findViewById(R.id.txtHelloWorld);
        txtHelloWorld.setVisibility(View.VISIBLE);
      }
    });
  }
}
