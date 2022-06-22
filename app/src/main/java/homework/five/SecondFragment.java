package homework.five;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import homework.five.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment implements OnItemClick {
    private FragmentSecondBinding binding;
    private ArrayList<Song> songs;
    public static final String KEY_FOR_INTENT = "key1";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        SongAdapter songAdapter = new SongAdapter(songs, this);
        binding.recyclerview.setAdapter(songAdapter);

    }

    private void loadData() {
        songs = new ArrayList<>();
        songs.add(new Song("Blank Space", "Taylor Swift", "3:22"));
        songs.add(new Song("Watch Me", "Silento", "5:36"));
        songs.add(new Song("Earned It", "The Weekend", "4:51"));
        songs.add(new Song("The Hills", "The Weekend", "3:41"));
        songs.add(new Song("Mockinbird", "Eminem", "2:00"));
        songs.add(new Song("Самурай", "Miyagi", "3:55"));
        songs.add(new Song("Жалынам", "Мирбек Атабеков", "2:57"));
        songs.add(new Song("Lost on you", "LP", "4:25"));
        songs.add(new Song("As it was", "Harry Styles", "2:19"));
        songs.add(new Song("Bones", "Imagine Dragons", "3:33"));
        songs.add(new Song("MMM", "Minelli", "2:01"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(requireContext(), SecondActivity.class);
        intent.putExtra(KEY_FOR_INTENT, songs.get(position).getTitle());
        startActivity(intent);
    }
}