package com.example.tbcacademyandroidtask3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.tbcacademyandroidtask3.Util.Validate
import com.example.tbcacademyandroidtask3.data.User
import com.example.tbcacademyandroidtask3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        val view = binding.root
        setContentView(view)

        val textEmail: EditText = binding.editTextEmail
        val textUsername: EditText = binding.editTextUsername
        val textFirstName: EditText = binding.editTextFirstName
        val textLastName: EditText = binding.editTextLastName
        val textAge: EditText = binding.editTextAge

        binding.btnSaveInformation.setOnClickListener {
            val arrayOfInputs = arrayOf(
                textEmail.text.toString(),
                textUsername.text.toString(),
                textFirstName.text.toString(),
                textAge.text.toString(),
                textLastName.text.toString()
            )
            val validate: Validate = Validate(this);

            validate.valuesFilled(arrayOfInputs);
            validate.stringMinLength(textUsername.text.toString(), 10);
            validate.isEmail(textEmail.text.toString());

            if (validate.validationPassed) {
                val userPageIntent = Intent(this, UserPageActivity::class.java)
                val user = User(
                    textEmail.text.toString(),
                    textUsername.text.toString(),
                    textFirstName.text.toString(),
                    textLastName.text.toString(),
                    textAge.text.toString().toInt()
                )
                userPageIntent.putExtra("user",user)
                startActivity(userPageIntent);
            } else {
                binding.textViewMessage.text = validate.errorListToString();
            }
        }

        binding.btnClearInformation.setOnClickListener {
            clearFormInformation()
            Toast.makeText(this, "Information Cleared!", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onResume() {
        super.onResume()
        clearFormInformation()
    }

    private fun clearFormInformation() {
        binding.editTextEmail.text.clear()
        binding.editTextUsername.text.clear()
        binding.editTextFirstName.text.clear()
        binding.editTextLastName.text.clear()
        binding.editTextAge.text.clear()
        binding.textViewMessage.text = "";
    }
}