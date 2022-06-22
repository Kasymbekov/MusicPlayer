package homework.five;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import homework.five.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        str = getIntent().getStringExtra(SecondFragment.KEY_FOR_INTENT);
        binding.song.setText(str);
    }
}