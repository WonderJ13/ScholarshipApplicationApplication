package orgbonfantij16.asmsa.compsci.scholarshipapplicationapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Jacob on 2/23/2018.
 */

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    List<String> names;

    public ItemAdapter(Context c, List list) {
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        names = new ArrayList<String>(list);
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.item_layout, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);

        nameTextView.setText(names.get(position));

        return v;
    }
}
