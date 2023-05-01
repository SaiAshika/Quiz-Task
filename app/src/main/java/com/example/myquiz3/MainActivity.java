package com.example.myquiz3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
	TextView heading;
	TextView user_name;

	 EditText namevalue;
	 Button start;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		heading = findViewById(R.id.HeadView);
		namevalue = findViewById(R.id.ValueName);
		user_name = findViewById(R.id.EnterName);

		
		 start = findViewById(R.id.startbutton);
	
		start.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			String name1 = namevalue.getText().toString();
			if(name1.isEmpty())
			{
				Toast.makeText(MainActivity.this, "Kindly enter your name
				here:", Toast.LENGTH_SHORT).show();
			}
			else
			{
			String name2 = namevalue.getText().toString();
			Intent intent = new Intent(MainActivity.this,
			,QuestionActivity.class);
			intent.putExtra("Name", name2);
			startActivity(intent);

			}
		}
	   });

	}

}