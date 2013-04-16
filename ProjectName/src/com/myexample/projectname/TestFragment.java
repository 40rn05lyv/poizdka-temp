package com.myexample.projectname;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

public class TestFragment extends Fragment {

	public static final String EXTRA_TITLE = "title";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/*
		 * TextView txt = new TextView( inflater.getContext() ); txt.setGravity( Gravity.CENTER ); txt.setText( "Fragment" );
		 */

		View view = inflater.inflate(R.layout.activity_main2, container, false);
		ExpandableListView lv = (ExpandableListView) view.findViewById(R.id.expandableListView1);
		
		List<Map<String, String>> groupData = new ArrayList<Map<String, String>>();
		List<List<Map<String, String>>> childData = new ArrayList<List<Map<String, String>>>();
		for (int i = 0; i < 1; i++) {
			Map<String, String> curGroupMap = new HashMap<String, String>();
			groupData.add(curGroupMap);
			curGroupMap.put("NAME", s1);
			curGroupMap.put("IS_EVEN", (i % 2 == 0) ? "This group is even" : "This group is odd");

			List<Map<String, String>> children = new ArrayList<Map<String, String>>();
			for (int j = 0; j < 1; j++) {
				Map<String, String> curChildMap = new HashMap<String, String>();
				children.add(curChildMap);
				// curChildMap.put(NAME, "Child " + j);
				//curChildMap.put("IS_EVEN", (j % 2 == 0) ? "Hello " + j : "Good Morning " + j);
				curChildMap.put("IS_EVEN", s2);
			}
			childData.add(children);
		}

		// Создаем адаптер и передаем context и список с данными
		SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(inflater.getContext(), groupData,
				android.R.layout.simple_expandable_list_item_1, new String[] { "NAME", "IS_EVEN" }, new int[] { android.R.id.text1,
						android.R.id.text2 }, childData, android.R.layout.simple_expandable_list_item_2, new String[] { "NAME", "IS_EVEN" },
				new int[] { android.R.id.text1, android.R.id.text2 });
		lv.setAdapter(adapter);

/*		if (getArguments() != null && getArguments().containsKey(EXTRA_TITLE)) {
			// lv.sette
			// txt.setText( getArguments().getString( EXTRA_TITLE ) );
		}*/
		return view;
	}

	public static Bundle createBundle(String title) {
		Bundle bundle = new Bundle();
		bundle.putString(EXTRA_TITLE, title);
		return bundle;
	}
	
	static String s1 = "п-п. 2., 2.2.1., 2.2.2., 3., 3.1., 3.11., 3.13. (абзац 2) Державних санітарних правил та норм гігієни транспорту";
	static String s2 = "2. Правила підготовки пасажирських вагонів до рейсу"+
"2.2.1. Повна підготовка та екіпіровка пасажирських вагонів в пунктах формування включає в собі: ... - прибирання внутрішніх приміщень вагонів із використанням миючих засобів;"+
"2.2.2. Часткова підготовка пасажирських вагонів в пунктах зворотнього виїзду включає в собі: ... - прибирання внутрішніх приміщень вагонів з використанням миючих засобів;"+
"3. Правила утримання пасажирських вагонів на шляху прямування поїзду"+
"3.1. З метою додержання чистоти в вагоні на шляху прямування не менше як 2 рази на добу повинно проводитися вологе прибирання."+
"Не менше 4-х разів на добу і в міру необхідності необхідно проводити прибирання туалетів з обов'язковим миттям підлоги. При прибиранні туалетів повинні застосовуватися миючі та дезінфікуючі засоби, або миючі засоби з дезінфікуючим наповнювачем. ..."+
"Обезпилювання килимових доріжок повинно проводитися пилососом не менше 2-х разів на добу."+
"У вагоні необхідно забезпечити роздільне зберігання прибирального інвентаря, призначеного для прибирання туалетів, пасажирських та службових приміщень вагонів."+
"...Прибирання вагону виконується провідником тільки в спецодязі (халат, гумові рукавички)."+
"3.11. Провідник … несе відповідальність за забезпечення чистоти в приміщеннях вагону, в тому числі службових, туалетах, додержання періодичності прибирання, ..."+
"3.13. ... Порушення вимог санітарних правил тягне за собою дисциплінарну, адміністративну, цивільно-правову та кримінальну відповідальність.";

}