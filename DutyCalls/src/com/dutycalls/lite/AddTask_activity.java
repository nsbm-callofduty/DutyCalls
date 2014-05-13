package com.dutycalls.lite;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class AddTask_activity extends Activity {
	private TextView Output;
	private Button changeDate;

	private int year;
	private int month;
	private int day;

	static final int DATE_PICKER_ID = 1111; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_task);
		
		Output = (TextView) findViewById(R.id.outputdate);
		changeDate = (Button) findViewById(R.id.changeDate);

		// Get current date by calender
		
		final Calendar c = Calendar.getInstance();
		year  = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day   = c.get(Calendar.DAY_OF_MONTH);

		// Show current date
		
		Output.setText(new StringBuilder()
				// Month is 0 based, just add 1
				.append(month + 1).append("-").append(day).append("-")
				.append(year).append(" "));
 
		// Button listener to show date picker dialog
		
		changeDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
                
				// On button click show datepicker dialog 
				showDialog(DATE_PICKER_ID);

			}

		});
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_PICKER_ID:
			
			// open datepicker dialog. 
			// set date picker for current date 
			// add pickerListener listner to date picker
			return new DatePickerDialog(this, pickerListener, year, month,day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

		// when dialog box is closed, below method will be called.
		@Override
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			
			year  = selectedYear;
			month = selectedMonth;
			day   = selectedDay;

			// Show selected date 
			Output.setText(new StringBuilder().append(month + 1)
					.append("-").append(day).append("-").append(year)
					.append(" "));
	
		   }
	    };

}
