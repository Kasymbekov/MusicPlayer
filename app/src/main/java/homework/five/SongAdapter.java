package homework.five;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import homework.five.databinding.ItemSongBinding;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private ArrayList<Song> data;
    private OnItemClick onItemClick;

    public SongAdapter(ArrayList<Song> data, OnItemClick onItemClick) {
        this.data = data;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SongViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.bind(position, data.get(position).getTitle(), data.get(position).getAuthor(), data.get(position).getDuration());
        holder.itemView.setOnClickListener(view -> {
            onItemClick.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class SongViewHolder extends RecyclerView.ViewHolder {
        private ItemSongBinding binding;
        private int count = 1;

        public SongViewHolder(ItemSongBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(int count, String title, String author, String duration) {
            binding.count.setText(String.valueOf(count + 1));
            binding.title.setText(title);
            binding.author.setText(author);
            binding.duration.setText(duration);
        }
    }
}
