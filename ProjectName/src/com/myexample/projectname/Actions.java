package com.myexample.projectname;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;

public class Actions extends TabSwipeActivity {

	ActionBar bar;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(MainActivity.THEME);
        bar = getSupportActionBar();
		//bar.setDisplayShowHomeEnabled(false);
		bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
		bar.setTitle(getIntent().getStringExtra("selected"));
		
        //bar.setDisplayShowHomeEnabled(false);
        //bar.setDisplayShowTitleEnabled(false);
        
        super.onCreate(savedInstanceState);
        
        addTab( "���������", TestFragment.class, TestFragment.createBundle( "Fragment 1") );
        addTab( "�� ������", TestFragment.class, TestFragment.createBundle( "Fragment 2") );        
        
/*		ActionBar.Tab currentTab = bar.newTab();
		currentTab.setText("Some text1");
		currentTab.setTabListener(new TabListener(this, "���������", MyFragment.class));
		bar.addTab(currentTab);
        
		ActionBar.Tab currentTab2 = bar.newTab();
		currentTab2.setText("Some text2");
		currentTab2.setTabListener(new TabListener(this, "��������", MyFragment.class));
		bar.addTab(currentTab2);*/
        //addTab( "Tab 3", TestFragment.class, TestFragment.createBundle( "Fragment 3") );
    }
	
}
