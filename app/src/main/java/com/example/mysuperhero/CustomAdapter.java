package com.example.mysuperhero;
import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
//import android.support.annotation.NonNull;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {

    private ArrayList<DataModel> dataSet;
    Bundle bundle = new Bundle();
    public CustomAdapter(ArrayList<DataModel> dataSet) {

        this.dataSet = dataSet;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
       CardView cardView;
       TextView textViewName;
       TextView textViewDetail;
       TextView textViewData;
       ImageView imageViewIcon;

       public MyViewHolder (View itemView)
       {
           super(itemView);

           cardView = (CardView) itemView.findViewById(R.id.card_view);
           textViewName = ( TextView) itemView.findViewById(R.id.textViewName);
           textViewDetail = ( TextView) itemView.findViewById(R.id.textViewDetail);
           imageViewIcon = (ImageView) itemView.findViewById(R.id.imageViewHero);

           //ImageView textName = imageViewIcon.get
           String textDetail = textViewDetail.getText().toString();

           //Bundle bundle = new Bundle();
           //bundle.putString("Name", textName);
           //bundle.putString("Detail", textDetail);


           cardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   String clickedItem = textViewName.getText().toString();
                   String data = "";
                   Bundle bundle = new Bundle();


                   for(int i = 0; i < MyData.nameArray.length ; i++){
                       if(MyData.nameArray[i] == clickedItem){
                           data = MyData.dataArray[i];
                           bundle.putInt("Image",  MyData.drawableArray[i]);
                       }
                   }

                   bundle.putString("Data",  data);
                   //bundle.putString("Image",  MyData.drawableArray[i]);

                   Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentHero,bundle);
               }
           });

       }

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext() ).inflate(R.layout.cards_layout , parent ,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder,  int listPosition) {

        TextView textViewName = viewHolder.textViewName;
        TextView textViewDetail = viewHolder.textViewDetail;
        TextView textViewData = viewHolder.textViewData;
        ImageView imageView = viewHolder.imageViewIcon;
        CardView cardView = viewHolder.cardView;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewDetail.setText(dataSet.get(listPosition).getDetail());
        imageView.setImageResource(dataSet.get(listPosition).getImage());



        
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}


