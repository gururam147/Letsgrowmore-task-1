package com.codewithishita.letsgrowmore_task1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

// Create A Class Adapter
public class Adapter extends ArrayAdapter<Model> {
    private Context context;
    private List<Model> modelList;

    public Adapter(Context context, List<Model> modelList) {
        super(context, R.layout.testing, modelList);

        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.testing, null,true);

        // In this step we connect the XML with Java File
        TextView state = v.findViewById(R.id.state);
        TextView cured = v.findViewById(R.id.cured);
        TextView active = v.findViewById(R.id.active);
        TextView death = v.findViewById(R.id.death);
        TextView total = v.findViewById(R.id.total);

        TextView inccured = v.findViewById(R.id.inccured);
        TextView incactive = v.findViewById(R.id.incactive);
        TextView incdeath = v.findViewById(R.id.incdeath);

        // Adding Data to modellist
        state.setText(modelList.get(position).getName());
        cured.setText(modelList.get(position).getCured());
        active.setText(modelList.get(position).getActive());
        death.setText(modelList.get(position).getDeath());
        total.setText(modelList.get(position).getTotal());

        inccured.setText(modelList.get(position).getIncRec());
        incactive.setText(modelList.get(position).getIncAct());
        incdeath.setText(modelList.get(position).getIncDec());

        return v;
    }
}
