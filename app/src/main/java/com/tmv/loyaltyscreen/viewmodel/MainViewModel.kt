package com.tmv.loyaltyscreen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var firstName:MutableLiveData<String> = MutableLiveData()

    var firstNameIsError: MutableLiveData<Boolean> = MutableLiveData()

    var lastName:MutableLiveData<String> = MutableLiveData()

    var lastNameIsError:MutableLiveData<Boolean> = MutableLiveData()

    var email:MutableLiveData<String> = MutableLiveData()

    var emailIsError:MutableLiveData<Boolean> = MutableLiveData()

    var phone:MutableLiveData<String> = MutableLiveData()

    var phoneIsError:MutableLiveData<Boolean> = MutableLiveData()

    fun isAlphaOnly(name: String): Boolean {//If string has only letters
        return name.matches("[a-zA-Z]+".toRegex())
    }

    fun isEmail(email:String): Boolean{
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

        return  email.matches(emailPattern.toRegex())
    }

    fun isValidPhoneInput(phone:String):Boolean {

        if(phone.isBlank())
            return true

        val numberPattern1 = "((\\(\\d{3}\\)( |-)?)|(\\d{3}-))\\d{3}-\\d{4}"

        val numberPattern2 = "\\d{10}"
        return phone.matches(numberPattern1.toRegex()) || phone.matches(numberPattern2.toRegex())
    }

    fun isBlank(input:String):Boolean{

        return input.toString().isBlank()
    }
}