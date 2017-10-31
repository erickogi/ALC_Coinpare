package com.erickogi14gmail.coinpare;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.erickogi14gmail.coinpare.Adapter.CurrencyListAdapter;
import com.erickogi14gmail.coinpare.Controller.CurrencyViewModel;
import com.erickogi14gmail.coinpare.Interfaces.cardItemListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;
import com.mynameismidori.currencypicker.CurrencyPicker;
import com.ramotion.foldingcell.FoldingCell;

/**
 * Created by Eric on 10/27/2017.
 */

public class Fragment_BTC extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private CurrencyListAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_btc,container,false);
        recyclerView =  view.findViewById(R.id.recycler_view);
        CurrencyViewModel model = ViewModelProviders.of(this).get(CurrencyViewModel.class);
        FloatingActionButton fab =  getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            CurrencyPicker picker = CurrencyPicker.newInstance("Select Currency");  // dialog title
            picker.setListener((name, code, symbol, flagDrawableResID) -> {
                toast(name+" - "+code+" - "+symbol);
                picker.dismiss();
            });
            picker.show(getActivity().getSupportFragmentManager(), "CURRENCY_PICKER");
        });
        swipeRefreshLayout = view. findViewById(R.id.swipe_refresh_layout_recycler_view);
        swipeRefreshLayout.setColorSchemeResources(R.color.google_blue, R.color.google_green, R.color.google_red, R.color.google_yellow);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if(haveNetworkConnection()){
                model.clear();
            }else {
                toast("No internet connection");
            }
           model.getBTC().observe(this,pojos -> {
               adapter.updateList(pojos);
               swipeRefreshLayout.setRefreshing(false);
           });

        });
        swipeRefreshLayout.setRefreshing(true);


        model.getBTC().observe(this, pojo-> {

            adapter=new CurrencyListAdapter(getContext(), pojo, new cardItemListener() {
                @Override
                public void onFoldingCellClicked(int postion, FoldingCell foldingCell) {
//                    foldingCell.toggle(false);
                    //((FoldingCell) view).toggle(false);
                    // register in adapter that state for selected cell is toggled
                   // adapter.registerToggle(postion);
                }
            });
            adapter.notifyDataSetChanged();
             mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mStaggeredLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(adapter);
            swipeRefreshLayout.setRefreshing(false);



        });

        return view;
    }
    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager)getActivity(). getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }
    private void toast(String msg) {
        StyleableToast st = new StyleableToast(getContext(), msg, Toast.LENGTH_SHORT);
        st.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        st.setTextColor(getResources().getColor(R.color.black));
        st.setIcon(R.drawable.ic_error_outline_black_24dp);

        st.setMaxAlpha();
        st.show();

    }

}
