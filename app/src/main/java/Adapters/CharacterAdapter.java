package Adapters;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.apps.segundoparcial.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import Classes.Character;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private List<Character> charaters;

    public CharacterAdapter(List<Character> charaters) {
        this.charaters = charaters;
    }

    public void addUser(Character character) {
        charaters.add(character);
    }

    @NonNull
    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.ViewHolder holder, int position) {
        Character character = charaters.get(position);
        holder.bind(character);
    }

    @Override
    public int getItemCount() {
        return charaters.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAlive, txtSpecies;
        ImageView imgChar;
        Button btnSeeMore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAlive = itemView.findViewById(R.id.txtAlive);
            txtSpecies = itemView.findViewById(R.id.txtSpecies);
            imgChar = itemView.findViewById(R.id.imgChar);
            btnSeeMore = itemView.findViewById(R.id.btnSeeMore);
        }

        public void bind(Character character) {
            String alive = "Vivo";
            if (!character.isAlive()) alive = "Muerto";
            txtName.setText(character.getName());
            txtAlive.setText(alive);
            txtSpecies.setText(character.getSpecies());
            Picasso.get().load(Uri.parse(character.getImageUrl())).into(imgChar);
            btnSeeMore.setOnClickListener(view -> {
                Toast.makeText(view.getContext(), "No me dio tiempo :(", Toast.LENGTH_SHORT).show();
            });
        }
    }
}
