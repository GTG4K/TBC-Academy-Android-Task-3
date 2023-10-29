package com.example.tbcacademyandroidtask3.Util

import android.content.Context
import com.example.tbcacademyandroidtask3.R

class Validate(private val context: Context) {
    private val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    public var validationPassed: Boolean = true;
    public val errorsList:MutableList<String> = mutableListOf();

    public fun valuesFilled(input: Array<String>): Boolean {
        for (value in input) {
            if (value.trim() == ""){
                errorsList.add(context.getString(R.string.error_enter_all_fields))
                validationPassed = false
                return false
            }
        }
        return true
    }

    public fun stringMinLength(input: String, min: Int): Boolean {
        return if(input.length >= min) true
        else {
            errorsList.add(context.getString(R.string.error_username_too_small))
            validationPassed = false
            false
        }
    }

    public fun isEmail(input: String): Boolean {
        return if(input.matches(emailRegex)) true
        else {
            errorsList.add(context.getString(R.string.error_bad_email_format))
            validationPassed = false
            false
        }
    }

    public fun errorListToString():String{
        var errorMessage = "";
        for (error in errorsList){
            errorMessage += error + "\n"
        }
        return errorMessage
    }
}