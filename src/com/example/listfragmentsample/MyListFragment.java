package com.example.listfragmentsample;

import java.util.ArrayList;
import java.util.List;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MyListFragment extends ListFragment {
	private List<ListItem> list;
	private ArrayAdapter<ListItem> adapter;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		list = new ArrayList<ListItem>();
		list.add(new ListItem("リスト1"));
        list.add(new ListItem("リスト2"));
        list.add(new ListItem("リスト3"));
        list.add(new ListItem("リスト4"));
        list.add(new ListItem("リスト5"));
        list.add(new ListItem("リスト6"));
        list.add(new ListItem("リスト7"));
        list.add(new ListItem("リスト8"));
        list.add(new ListItem("リスト9"));
        list.add(new ListItem("リスト10"));
        list.add(new ListItem("リスト11"));
        list.add(new ListItem("リスト12"));
        list.add(new ListItem("リスト13"));
        list.add(new ListItem("リスト14"));
        list.add(new ListItem("リスト15"));
        list.add(new ListItem("リスト16"));
        list.add(new ListItem("リスト17"));
        list.add(new ListItem("リスト18"));
        list.add(new ListItem("リスト19"));
        list.add(new ListItem("リスト20"));

        adapter = new ListAdapter(getActivity(), list);
        setListAdapter(adapter);
	}

	private class ListAdapter extends ArrayAdapter<ListItem> {
		private LayoutInflater mInflater;

		public ListAdapter(Context context,List<ListItem> objects) {
			super(context,0, objects);
			mInflater = (LayoutInflater)context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			final ViewHolder holder;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.my_listfragment_row, parent, false);
				holder = new ViewHolder();
				holder.tvListText = (TextView)convertView.findViewById(R.id.list_text);
				holder.btListButton = (Button)convertView.findViewById(R.id.list_button);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			final ListItem item = getItem(position);
			holder.tvListText.setText(item.getListText());
			holder.btListButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Toast.makeText(getActivity(),
							item.getListText(), Toast.LENGTH_SHORT).show();
				}
			});

			return convertView;
		}
	}
	private class ListItem {
		private String listText = "";

		public ListItem() {

		}
		public ListItem(String listText) {
			this.listText = listText;
		}
		public void setListText(String listText) {
			this.listText = listText;
		}
		public String getListText() {
			return this.listText;

		}
	}
	private class ViewHolder {
		TextView tvListText;
		Button btListButton;
	}

}
