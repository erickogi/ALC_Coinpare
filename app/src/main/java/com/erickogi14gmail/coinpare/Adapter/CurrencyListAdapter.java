package com.erickogi14gmail.coinpare.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erickogi14gmail.coinpare.Data.coinPojo;
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
    private LinkedList<coinPojo> modelList;
    private cardItemListener cardItemListener;
    private HashSet<Integer> unfoldedIndexes = new HashSet<>();


    public CurrencyListAdapter(Context context, LinkedList<coinPojo> modelList,cardItemListener cardItemListener) {
        this.context = context;
        this.modelList = modelList;
        this.cardItemListener=cardItemListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.coin_item, parent, false);
        return new MyViewHolder(itemView,cardItemListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        coinPojo coinPojo = modelList.get(position);String symbol="";
        if(!coinPojo.getTOSYMBOL().equals(coinPojo.getNAME())){
            symbol=coinPojo.getTOSYMBOL();
        }

        List<ExtendedCurrency> currencies = ExtendedCurrency.getAllCurrencies(); //List of all currencies
        ExtendedCurrency[] currenciesa = ExtendedCurrency.CURRENCIES; //Array of all currencies
        ExtendedCurrency currency = ExtendedCurrency.getCurrencyByName("Kenya"); //Get currency by its name


//        String name = currency.getName();
//        String code = currenc.getCode();
        int flag = currenciesa[0].getFlag();  // returns android resource id of flag or -1, if none is associated
   //     String symbolc = currency.getSymbol();




        holder.txtCurrencyName.setText(symbol + " " + coinPojo.getNAME());
        holder.txtCurrencyPrice.setText(coinPojo.getPRICE());
        holder.txtTime.setText(coinPojo.getLASTUPDATE());
         PicassoClient.LoadDrawable(context,flag,holder.img_currency);

    }

    @Override
    public int getItemCount() {
        return (null != modelList ? modelList.size() : 0);
    }


    public void updateList(LinkedList<coinPojo> list) {

        modelList=list;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtCurrencyName, txtCurrencyPrice,txtTime;
        private ImageView img_currency;
        private FoldingCell foldingCell;
        private WeakReference<cardItemListener> listenerWeakReference;


        public MyViewHolder(View itemView,cardItemListener cardItemListener) {
            super(itemView);
            listenerWeakReference=new WeakReference<cardItemListener>(cardItemListener);

            txtTime=itemView.findViewById(R.id.txt_updated_at);
            img_currency = itemView.findViewById(R.id.img_currency);
            txtCurrencyName = itemView.findViewById(R.id.txt_currency_name);
            txtCurrencyPrice =  itemView.findViewById(R.id.txt_currency_price);
            foldingCell=itemView.findViewById(R.id.folding_cell);
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
            switch (v.getId()){
                case R.id.folding_cell:
                    listenerWeakReference.get().onFoldingCellClicked(getAdapterPosition(),foldingCell);

            }
        }
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

}
