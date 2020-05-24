package com.example.appmobile.presentation.view;

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

import com.example.appmobile.presentation.model.Matchs;
import com.example.appmobile.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private final List<Matchs> values;
    private Dialog myDialog;
    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(Matchs item);
    }

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
    public ListAdapter(List<Matchs> myDataset, OnItemClickListener listener) {
        this.values = myDataset;
        this.listener = listener;
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(currentMatch);
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
                break;

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

        side1.setText(currentMatch.getSide1().getName());
        side2.setText(currentMatch.getSide2().getName());
        title.setText(currentMatch.getTitle());



        //Logo Équipe à domicile
        switch (currentMatch.getSide1().getName()){

            case "Slavia-Mozyr":
                side1Image.setImageResource(R.drawable.slavia_mozyr);
                break;

            case "Torpedo-BelAZ":
                side1Image.setImageResource(R.drawable.torpedo_belaz);
                break;

            case "Juventus":
                side1Image.setImageResource(R.drawable.juventus);
                break;

            case "Inter Milan":
                side1Image.setImageResource(R.drawable.intermilan);
                break;

            case "Manchester United" :
                side1Image.setImageResource(R.drawable.manchester_united);
                break;

            case "Manchester City":
                side1Image.setImageResource(R.drawable.manchester_city);
                break;

            case "Chelsea":
                side1Image.setImageResource(R.drawable.chelsea);
                break;

            case "Everton":
                side1Image.setImageResource(R.drawable.everton);
                break;

            case "Real Betis":
                side1Image.setImageResource(R.drawable.real_betis);
                break;

            case "Real Madrid":
                side1Image.setImageResource(R.drawable.real_madrid);
                break;

            case "AC Milan":
                side1Image.setImageResource(R.drawable.ac_milan);
                break;

            case "Genoa":
                side1Image.setImageResource(R.drawable.genoa);
                break;

            case "Burnley":
                side1Image.setImageResource(R.drawable.burnley);
                break;

            case "Tottenham Hotspur":
                side1Image.setImageResource(R.drawable.tottenham_hotspur);
                break;

            case "Arsenal":
                side1Image.setImageResource(R.drawable.arsenal);
                break;

            case "West Ham United":
                side1Image.setImageResource(R.drawable.westham_united);
                break;

            case "Barcelona":
                side1Image.setImageResource(R.drawable.barcelona);
                break;

            case "Real Sociedad":
                side1Image.setImageResource(R.drawable.real_sociedad);
                break;

            case "Liverpool":
                side1Image.setImageResource(R.drawable.liverpool);
                break;

            case "Bournemouth":
                side1Image.setImageResource(R.drawable.bournemouth);
                break;

            case "Atletico Madrid":
                side1Image.setImageResource(R.drawable.atletico_madrid);
                break;

            case "Sevilla":
                side1Image.setImageResource(R.drawable.seville);
                break;

            case "Derby County":
                side1Image.setImageResource(R.drawable.derby_county);
                break;

            case "Sheffield Wednesday":
                side1Image.setImageResource(R.drawable.sheffield_wednesday);
                break;

            case "Norwich City":
                side1Image.setImageResource(R.drawable.norwich_city);
                break;

            case "Portsmouth":
                side1Image.setImageResource(R.drawable.portsmouth);
                break;

            case "Wolves":
                side1Image.setImageResource(R.drawable.wolverhampton);
                break;

            case "Espanyol":
                side1Image.setImageResource(R.drawable.espanyol_barcelona);
                break;

            case "Aston Villa":
                side1Image.setImageResource(R.drawable.aston_villa);
                break;

            case "Caligari":
                side1Image.setImageResource(R.drawable.caligari);
                break;

            case "Roma":
                side1Image.setImageResource(R.drawable.as_roma);
                break;

            case "PSG":
                side1Image.setImageResource(R.drawable.psg);
                break;

            case "Dijon":
                side1Image.setImageResource(R.drawable.dijon);
                break;

            case "Watford":
                side1Image.setImageResource(R.drawable.watford);
                break;

            case "Napoli":
                side1Image.setImageResource(R.drawable.napoli);
                break;

            case "Torino":
                side1Image.setImageResource(R.drawable.torino);
                break;

            case "Club Brugge":
                side1Image.setImageResource(R.drawable.club_brugge);
                break;

            case "Lyon":
                side1Image.setImageResource(R.drawable.lyon);
                break;

            case "Bayern Munich":
                side1Image.setImageResource(R.drawable.bayern_munchen);
                break;

            case "Lecce":
                side1Image.setImageResource(R.drawable.lecce);
                break;

            case "Bordeaux":
                side1Image.setImageResource(R.drawable.bordeaux);
                break;

            case "Villareal":
                side1Image.setImageResource(R.drawable.villareal);
                break;

            case "Levante":
                side1Image.setImageResource(R.drawable.levante);
                break;

            case "Fiorentina":
                side1Image.setImageResource(R.drawable.fiorentina);
                break;

            case "Leicester City":
                side1Image.setImageResource(R.drawable.leicester_city);
                break;

            case "Spal":
                side1Image.setImageResource(R.drawable.spal);
                break;
        }

        //Logo Équipe à l'extérieur
        switch (currentMatch.getSide2().getName()){

            case "Slavia-Mozyr":
                side2Image.setImageResource(R.drawable.slavia_mozyr);
                break;

            case "Torpedo-BelAZ":
                side2Image.setImageResource(R.drawable.torpedo_belaz);
                break;

            case "Juventus":
                side2Image.setImageResource(R.drawable.juventus);
                break;

            case "Inter Milan":
                side2Image.setImageResource(R.drawable.intermilan);
                break;

            case "Manchester United" :
                side2Image.setImageResource(R.drawable.manchester_united);
                break;

            case "Manchester City":
                side2Image.setImageResource(R.drawable.manchester_city);
                break;

            case "Chelsea":
                side2Image.setImageResource(R.drawable.chelsea);
                break;

            case "Everton":
                side2Image.setImageResource(R.drawable.everton);
                break;

            case "Real Betis":
                side2Image.setImageResource(R.drawable.real_betis);
                break;

            case "Real Madrid":
                side2Image.setImageResource(R.drawable.real_madrid);
                break;

            case "AC Milan":
                side2Image.setImageResource(R.drawable.ac_milan);
                break;

            case "Genoa":
                side2Image.setImageResource(R.drawable.genoa);
                break;

            case "Burnley":
                side2Image.setImageResource(R.drawable.burnley);
                break;

            case "Tottenham Hotspur":
                side2Image.setImageResource(R.drawable.tottenham_hotspur);
                break;

            case "Arsenal":
                side2Image.setImageResource(R.drawable.arsenal);
                break;

            case "West Ham United":
                side2Image.setImageResource(R.drawable.westham_united);
                break;

            case "Barcelona":
                side2Image.setImageResource(R.drawable.barcelona);
                break;

            case "Real Sociedad":
                side2Image.setImageResource(R.drawable.real_sociedad);
                break;

            case "Liverpool":
                side2Image.setImageResource(R.drawable.liverpool);
                break;

            case "Bournemouth":
                side2Image.setImageResource(R.drawable.bournemouth);
                break;

            case "Atletico Madrid":
                side2Image.setImageResource(R.drawable.atletico_madrid);
                break;

            case "Sevilla":
                side2Image.setImageResource(R.drawable.seville);
                break;

            case "Derby County":
                side2Image.setImageResource(R.drawable.derby_county);
                break;

            case "Sheffield Wednesday":
                side2Image.setImageResource(R.drawable.sheffield_wednesday);
                break;

            case "Norwich City":
                side2Image.setImageResource(R.drawable.norwich_city);
                break;

            case "Portsmouth":
                side2Image.setImageResource(R.drawable.portsmouth);
                break;

            case "Wolves":
                side2Image.setImageResource(R.drawable.wolverhampton);
                break;

            case "Espanyol":
                side2Image.setImageResource(R.drawable.espanyol_barcelona);
                break;

            case "Aston Villa":
                side2Image.setImageResource(R.drawable.aston_villa);
                break;

            case "Caligari":
                side2Image.setImageResource(R.drawable.caligari);
                break;

            case "Roma":
                side2Image.setImageResource(R.drawable.as_roma);
                break;

            case "PSG":
                side2Image.setImageResource(R.drawable.psg);
                break;

            case "Dijon":
                side2Image.setImageResource(R.drawable.dijon);
                break;

            case "Watford":
                side2Image.setImageResource(R.drawable.watford);
                break;

            case "Napoli":
                side2Image.setImageResource(R.drawable.napoli);
                break;

            case "Torino":
                side2Image.setImageResource(R.drawable.torino);
                break;

            case "Club Brugge":
                side2Image.setImageResource(R.drawable.club_brugge);
                break;

            case "Lyon":
                side2Image.setImageResource(R.drawable.lyon);
                break;

            case "Bayern Munich":
                side2Image.setImageResource(R.drawable.bayern_munchen);
                break;

            case "Lecce":
                side2Image.setImageResource(R.drawable.lecce);
                break;

            case "Bordeaux":
                side2Image.setImageResource(R.drawable.bordeaux);
                break;

            case "Villareal":
                side2Image.setImageResource(R.drawable.villareal);
                break;

            case "Levante":
                side2Image.setImageResource(R.drawable.levante);
                break;

            case "Fiorentina":
                side2Image.setImageResource(R.drawable.fiorentina);
                break;

            case "Leicester City":
                side2Image.setImageResource(R.drawable.leicester_city);
                break;

            case "Spal":
                side2Image.setImageResource(R.drawable.spal);
                break;
        }



    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}