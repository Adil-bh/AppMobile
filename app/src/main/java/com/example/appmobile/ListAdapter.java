package com.example.appmobile;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Matchs> values;
    private Dialog myDialog;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
     class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
         TextView txtHeader;
         TextView txtFooter;
         ImageView image;
         VideoView video;
         View layout;


         ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = (ImageView) v.findViewById(R.id.icon);
            video = (VideoView) v.findViewById(R.id.video);
            myDialog = new Dialog(v.getContext());

        }
    }

    public void add(int position, Matchs item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListAdapter(List<Matchs> myDataset) {
        values = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Matchs currentMatch = values.get(position);
        holder.txtHeader.setText(currentMatch.getTitle());
        holder.txtFooter.setText(currentMatch.getDate());
        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(currentMatch);
                //remove(position);
            }
        });

        switch(currentMatch.getCompetition().getId()){

            case "10" :
                holder.image.setImageResource(R.mipmap.ligue1);
                break;

            case "13" :
                holder.image.setImageResource(R.mipmap.seriealogo);
                break;

            case "14" :
                holder.image.setImageResource(R.mipmap.liga);
                break;

            case "15" :
                holder.image.setImageResource(R.mipmap.premiereleague);
                break;


            case "76" :
                holder.image.setImageResource(R.mipmap.fa_cup);

            case "503" :
                holder.image.setImageResource(R.mipmap.ldc);
                break;

            case "749" :
                holder.image.setImageResource(R.mipmap.bielorussieprem);
                break;

            case "1545" :
                holder.image.setImageResource(R.mipmap.europaleague);
                break;

            default:

        }






    }


    /*private void setOnClick(TextView txtHeader, final Matchs currentMatch) {
        txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(currentMatch);
            }
        });
    }

    private void setOnClick(ImageView imageView, final Matchs currentMatch ) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(currentMatch);
            }
        });
    } */

    @SuppressLint("CutPasteId")
    public void showPopup(final Matchs currentMatch) {
        TextView title, date, side1, side2, txtclose;
        ImageView side1Image, side2Image;
        VideoView video;
        myDialog.setContentView(R.layout.custompopup);

        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();

        title = myDialog.findViewById(R.id.title);
        side1 = myDialog.findViewById(R.id.side1);
        side2 = myDialog.findViewById(R.id.side2);

        side1Image = myDialog.findViewById(R.id.side1Image);
        side2Image = myDialog.findViewById(R.id.side2Image);

        video = myDialog.findViewById(R.id.video);


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}