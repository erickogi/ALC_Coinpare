package com.erickogi14gmail.coinpare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.coinpare.Data.Pojos.CryPtoExchangePojo;
import com.erickogi14gmail.coinpare.Interfaces.cardItemListener;
import com.erickogi14gmail.coinpare.R;
import com.erickogi14gmail.coinpare.mPicasso.PicassoClient;
import com.mynameismidori.currencypicker.ExtendedCurrency;
import com.ramotion.foldingcell.FoldingCell;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Eric on 10/27/2017.
 */

public class CurrencyListAdapter extends RecyclerView.Adapter<CurrencyListAdapter.MyViewHolder> {
    private Context context;
    private LinkedList<CryPtoExchangePojo> modelList;
    private cardItemListener cardItemListener;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();


    public CurrencyListAdapter(Context context, LinkedList<CryPtoExchangePojo> modelList, cardItemListener cardItemListener) {
        this.context = context;
        this.modelList = modelList;
        this.cardItemListener = cardItemListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_item, parent, false);
        return new MyViewHolder(itemView, cardItemListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CryPtoExchangePojo CryPtoExchangePojo = modelList.get(position);
        String symbol = "";
        if (!CryPtoExchangePojo.getTOSYMBOL().equals(CryPtoExchangePojo.getNAME())) {
            symbol = CryPtoExchangePojo.getTOSYMBOL();
        }

        List<ExtendedCurrency> currencies = ExtendedCurrency.getAllCurrencies(); //List of all currencies
        ExtendedCurrency[] currenciesa = ExtendedCurrency.CURRENCIES; //Array of all currencies
        ExtendedCurrency currency = ExtendedCurrency.getCurrencyByName(CryPtoExchangePojo.getNAME()); //Get currency by its name
        Log.d("currencies", "" + currency);


//        String name = currency.getName();
//        String code = currenc.getCode();
        int flag = currenciesa[0].getFlag();  // returns android resource id of flag or -1, if none is associated
        //     String symbolc = currency.getSymbol();
        for (ExtendedCurrency currency1 : currencies) {
            if (currency1.getCode().equals(CryPtoExchangePojo.getNAME())) {
                flag = currency1.getFlag();
            }
        }

        PicassoClient.LoadDrawable(context, flag, holder.flag);


        holder.txtCurrencyName.setText(symbol + " " + CryPtoExchangePojo.getNAME());
        holder.txtCurrencyPrice.setText(CryPtoExchangePojo.getPRICE());
        holder.txtTime.setText(CryPtoExchangePojo.getLASTUPDATE());
        PicassoClient.LoadDrawable(context, flag, holder.img_currency);


        holder.txtDCurrencyName.setText(symbol + " " + CryPtoExchangePojo.getNAME());
        holder.txtDCurrencyPrice.setText(CryPtoExchangePojo.getPRICE());
        holder.txtDUpdateAt.setText(CryPtoExchangePojo.getLASTUPDATE());
        holder.txtMarket.setText(CryPtoExchangePojo.getMARKERT());
        holder.txtOpen.setText(CryPtoExchangePojo.getOPEN24HOUR());
        holder.txtHigh.setText(CryPtoExchangePojo.getHIGH24HOUR());
        holder.txtLow.setText(CryPtoExchangePojo.getLOW24HOUR());
        holder.txtChange.setText(CryPtoExchangePojo.getCHANGE24HOUR());
        holder.txtChnagePct.setText(CryPtoExchangePojo.getCHANGEPCT24HOUR());
        holder.txtCap.setText(CryPtoExchangePojo.getMKTCAP());
        holder.txtSupply.setText(CryPtoExchangePojo.getSUPPLY());

    }

    @Override
    public int getItemCount() {
        return (null != modelList ? modelList.size() : 0);
    }


    public void updateList(LinkedList<CryPtoExchangePojo> list) {

        modelList = list;
        notifyDataSetChanged();
    }

    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtCurrencyName, txtCurrencyPrice, txtTime, txtDUpdateAt, txtDCurrencyName,
                txtDCurrencyPrice, txtMarket, txtOpen, txtHigh, txtLow,
                txtChange, txtChnagePct, txtCap, txtSupply;
        private ImageView img_currency, flag;
        private FoldingCell foldingCell;
        private Button btn_share;
        private WeakReference<cardItemListener> listenerWeakReference;


        public MyViewHolder(View itemView, cardItemListener cardItemListener) {
            super(itemView);
            listenerWeakReference = new WeakReference<cardItemListener>(cardItemListener);
            flag = itemView.findViewById(R.id.flag_detail);

            btn_share = itemView.findViewById(R.id.btn_share);

            txtTime = itemView.findViewById(R.id.txt_updated_at);
            img_currency = itemView.findViewById(R.id.img_currency);
            txtCurrencyName = itemView.findViewById(R.id.txt_currency_name);
            txtCurrencyPrice = itemView.findViewById(R.id.txt_currency_price);

            txtDUpdateAt = itemView.findViewById(R.id.txt_updated_at_detail);
            txtDCurrencyName = itemView.findViewById(R.id.txt_currency_name_detail);
            txtDCurrencyPrice = itemView.findViewById(R.id.txt_currency_price_detail);

            txtMarket = itemView.findViewById(R.id.txt_market);
            txtOpen = itemView.findViewById(R.id.txt_open);
            txtHigh = itemView.findViewById(R.id.txt_high);
            txtLow = itemView.findViewById(R.id.txt_low);

            txtChange = itemView.findViewById(R.id.txt_change);
            txtChnagePct = itemView.findViewById(R.id.txt_change_pct);
            txtCap = itemView.findViewById(R.id.txt_market_cap);
            txtSupply = itemView.findViewById(R.id.txt_supply);
            btn_share.setOnClickListener(this);


            foldingCell = itemView.findViewById(R.id.folding_cell);
            foldingCell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foldingCell.toggle(false);
                    //((FoldingCell) view).toggle(false);
                    // register in adapter that state for selected cell is toggled
                    registerToggle(getAdapterPosition());
                }
            });

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.folding_cell:
                    listenerWeakReference.get().onFoldingCellClicked(getAdapterPosition(), foldingCell);
                    break;
                case R.id.btn_share:
                    listenerWeakReference.get().btnShareClicked(getAdapterPosition());
                    break;
            }
        }
    }

}
