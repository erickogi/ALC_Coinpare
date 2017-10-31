package com.erickogi14gmail.coinpare.mPicasso;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.erickogi14gmail.coinpare.R;
import com.squareup.picasso.Picasso;

/**
 * Created by kimani kogi on 4/22/2017.
 */

public class PicassoClient {

    public static void LoadUrl(final Context c, String url, ImageView img) {


        if (url != null && url.length() > 0) {
            try {
                Picasso.with(c).load(url).placeholder(R.drawable.arsenal).into(img);




            } catch (Exception b) {
                Picasso.with(c).load(R.drawable.arsenal).into(img);
            }


        } else {
            img.setVisibility(View.INVISIBLE);

        }
    }
    public static void LoadDrawable(final Context context,int drawable,ImageView imageView){
       Picasso.with(context).load(drawable).resize(90,90).centerCrop().into(imageView);
    }


}
