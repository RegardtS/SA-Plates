package regimeister.saplates;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
 
public class ListViewAdapter extends BaseAdapter {
 
    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Numberplate> numberplatelist = null;
    private ArrayList<Numberplate> arraylist;
 
    public ListViewAdapter(Context context, List<Numberplate> numberplatelist) {
        mContext = context;
        this.numberplatelist = numberplatelist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Numberplate>();
        this.arraylist.addAll(numberplatelist);
    }
 
    public class ViewHolder {
        TextView registration;
        TextView location;
    }
 
    @Override
    public int getCount() {
        return numberplatelist.size();
    }
 
    @Override
    public Numberplate getItem(int position) {
        return numberplatelist.get(position);
    }
 
    @Override
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview_item, null);
            // Locate the TextViews in listview_item.xml
            holder.registration = (TextView) view.findViewById(R.id.registration);
            holder.location = (TextView) view.findViewById(R.id.location);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.registration.setText(numberplatelist.get(position).getRegistration());
        holder.location.setText(numberplatelist.get(position).getLocation());
        
        
        holder.registration.setTypeface(MainActivity.getTypeFace(mContext));
        holder.location.setTypeface(MainActivity.getTypeFace(mContext));
        
        
 
        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View arg0) {
            	//TODO
            	/*
                // Send single item click data to SingleItemView Class
                Intent intent = new Intent(mContext, SingleItemView.class);
                // Pass all data rank
                intent.putExtra("rank",(numberplatelist.get(position).getRank()));
                // Pass all data country
                intent.putExtra("country",(numberplatelist.get(position).getCountry()));
                // Pass all data population
                intent.putExtra("population",(numberplatelist.get(position).getPopulation()));
                // Pass all data flag
                // Start SingleItemView Class
                mContext.startActivity(intent);
                */
            	
            }
        });
 
        return view;
    }
 
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        numberplatelist.clear();
        if (charText.length() == 0) {
        	numberplatelist.addAll(arraylist);
        }
        else
        {
            for (Numberplate wp : arraylist)
            {
            	//TODO FIX OR BUG
                if (wp.getLocation().toLowerCase(Locale.getDefault()).contains(charText) ||
                		wp.getRegistration().toLowerCase(Locale.getDefault()).contains(charText) )
                {
                	numberplatelist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}