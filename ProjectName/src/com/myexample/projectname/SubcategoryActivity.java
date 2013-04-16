package com.myexample.projectname;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;

public class SubcategoryActivity extends SherlockActivity {

	Activity thiis = this;
	ListView subcategories;

    static String[] values = new String[] { "Немає питної (охолодженої кип'яченої) води", 
    	"Склянка загального користування в місці розбору питної води", 
    	"Немає окропу",
    	"Немає чаю, кави", 
    	"Немає їжі", 
    	"Не вистачає посуду", 
    	"Посуд погано вимитий, з відбитими краями, тріснутий", 
    	"Чай роздають не в санітарному одязі", 
    	"Оплата дорожча, ніж за прейскурантом"};               

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
		setTheme(MainActivity.THEME); // Used for theme switching in samples
		super.onCreate(savedInstanceState);
		ActionBar bar = getSupportActionBar();
		// bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.abs__textfield_searchview_holo_dark));
		bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.maroon)));
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayShowHomeEnabled(false);
		bar.setHomeButtonEnabled(true);
        setContentView(R.layout.subcategory);
        String category = getIntent().getStringExtra("selected");        
        bar.setTitle(category);
        subcategories = (ListView) findViewById(R.id.listView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.normal_list_size, values);
        subcategories.setAdapter(adapter);
        subcategories.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int position,
                    long paramLong) {
				String item = (String) paramAdapterView.getItemAtPosition(position);
				Intent intent = new Intent(thiis, Actions.class);
				intent.putExtra("selected", item);
				thiis.startActivity(intent);
            }
        });
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}    
}
