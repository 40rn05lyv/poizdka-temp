package com.myexample.projectname;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.view.SubMenu;

public class MainActivity extends SherlockActivity {

	ListView themeslist;
	final Activity thiis = this;
	public static int THEME = R.style.Theme_Sherlock_Light_DarkActionBar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		setTheme(THEME); // Used for theme switching in samples
		super.onCreate(savedInstanceState);
		ActionBar bar = getSupportActionBar();
		// bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.abs__textfield_searchview_holo_dark));
		bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.maroon)));
		// bar.setTitle(Html.fromHtml("<font color='#ffffff'>App Name</font>"));
		// bar.setSubtitle("Виберіть категорію");
		setContentView(R.layout.activity_main);
		themeslist = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.normal_list_size, categories);
		themeslist.setAdapter(adapter);
		themeslist.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int position, long paramLong) {
				String item = (String) paramAdapterView.getItemAtPosition(position);
				Intent intent = new Intent(thiis, SubcategoryActivity.class);
				intent.putExtra("selected", item);
				thiis.startActivity(intent);
				// TODO: open new Activity
			}
		});
	}

	SubMenu subMenu1 = null;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		subMenu1 = menu.addSubMenu(Menu.NONE, 98765, Menu.NONE, "Action Item");
		subMenu1.add(Menu.NONE, 12345, Menu.NONE, "Мова");
		subMenu1.add(Menu.NONE, 54321, Menu.NONE, "Про нас");

		MenuItem subMenu1Item = subMenu1.getItem();
		subMenu1Item.setIcon(R.drawable.ic_action_settings);
		subMenu1Item.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 12345:
			// getMenuInflater().inflate(R.menu.menu_langs, menu);
			Toast.makeText(this, "Theme changed to \"" + item.getTitle() + "\"", Toast.LENGTH_SHORT).show();
			return true;
		case 54321:
			Toast.makeText(this, "Theme changed to \"" + item.getTitle() + "\"", Toast.LENGTH_SHORT).show();
			return true;
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

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			//subMenu1.findItem(98765);
			if (event.getAction() == KeyEvent.ACTION_UP && subMenu1 != null) { //&& subMenu1.findItem(98765) != null
				//subMenu1.performIdentifierAction(12345, 0);
				MenuItem it = subMenu1.getItem();
				it.expandActionView();
				if (it.isVisible()) {
					it.setVisible(false);
				} else {
					it.setVisible(true);
				}
				return true;
			}
		}
		return super.onKeyUp(keyCode, event);
	}

	static String[] categories = new String[] { "Посадка / перевірка квитків", "Провідник / персонал", "Місце / речі / обладнання",
			"Проблеми з попутниками", "Повітря / температура / вологість", "Антисанітарія / інші незручності", "Постіль", "Туалет",
			"Чай / кава / вода / їжа", "Стоянка / відставання від графіку", "Підготовка до висадки / висадка", "НЕПЕРЕДБАЧУВАНІ  СИТУАЦІЇ" };

}
