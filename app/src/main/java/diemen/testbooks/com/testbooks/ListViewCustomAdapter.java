package diemen.testbooks.com.testbooks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import diemen.testbooks.com.testbooks.diemen.testbooks.com.constants.URLConstants;

/**
 * Created by hitesh on 02/03/15.
 */
public class ListViewCustomAdapter extends BaseAdapter {


    public ListViewCustomAdapter(Context context) {
        this.mContext = context;
        this.layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return URLConstants.IMAGE_URL.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView iThImage;
                /*.centerCrop()
                .resize(100, convertView.getWidth())*/
        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.image_view,null);
            iThImage = (ImageView) convertView.findViewById(R.id.individual_image_view);
            convertView.setTag(iThImage);
        }
        else
        {
            iThImage = (ImageView) convertView.getTag();
        }
        Picasso.with(mContext).load(URLConstants.IMAGE_URL[position])
                .into(iThImage);

        return convertView;
    }

    private Context mContext;
    LayoutInflater layoutInflater;
}
