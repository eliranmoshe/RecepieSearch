package eliran.recepie.com.recepiesearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by eliran on 3/23/2017.
 */

public class RecepieAdapter extends RecyclerView.Adapter<RecepieAdapter.MyViewHolder>{

    ArrayList<recepieObj> allRecepie;
    Context c;
    FragIntrFace fragIntrFace;

    public RecepieAdapter(ArrayList<recepieObj> allRecepie, Context c,FragIntrFace fragIntrFace) {
        this.allRecepie = allRecepie;
        this.c = c;
        this.fragIntrFace=fragIntrFace;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(c).inflate(R.layout.item_recepie,null);
        MyViewHolder viewHolder=new MyViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        recepieObj recepieObj=allRecepie.get(position);
        holder.setitemData(recepieObj);
    }

    @Override
    public int getItemCount() {
        return allRecepie.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView itemTv;
        ImageView itemIV;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemTv= (TextView) itemView.findViewById(R.id.itemTV);
            itemIV= (ImageView) itemView.findViewById(R.id.itemIV);
        }

        public  void setitemData(final recepieObj recepieObj)
        {
            itemTv.setText(recepieObj.title);
            if (recepieObj.thumbnail.contains("http")) {
                Picasso.with(c).load(recepieObj.thumbnail).into(itemIV);
            }
            itemTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragIntrFace.ChangeFrag(recepieObj.href);
                }
            });


        }
    }
}
