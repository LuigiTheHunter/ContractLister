package eu.roggstar.contractlister;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NotSoSimpleAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<Contract> data;
    private static LayoutInflater inflater=null;

    public NotSoSimpleAdapter(Activity a, ArrayList<Contract> d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.custom_listview_item, null);

        TextView title = vi.findViewById(R.id.txt_title); // title
        TextView company = vi.findViewById(R.id.txt_company); // artist name
        TextView duration = vi.findViewById(R.id.txt_resign); // duration

        Contract contract;
        contract = data.get(position);

        // Setting all values in listview
        title.setText(contract.title);
        company.setText(contract.company);
        //duration.setText(contract.resignDeadline.toString());
        return vi;
    }
}