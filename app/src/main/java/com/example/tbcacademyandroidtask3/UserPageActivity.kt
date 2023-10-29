package com.example.tbcacademyandroidtask3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tbcacademyandroidtask3.data.User
import com.example.tbcacademyandroidtask3.databinding.ActivityMainBinding
import com.example.tbcacademyandroidtask3.databinding.ActivityUserPageBinding

class UserPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserPageBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserPageBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val user = intent.getSerializableExtra("user") as User
        binding.textViewEmail.text = "Email: ${user.email}";
        binding.textViewUsername.text = "Username: ${user.username}";
        binding.textViewFullName.text = "Full name: ${user.firstName} ${user.lastName}";
        binding.textViewAge.text = "Age: ${user.age.toString()}";

        binding.buttonBack.setOnClickListener{
            finish()
        }
    }
}