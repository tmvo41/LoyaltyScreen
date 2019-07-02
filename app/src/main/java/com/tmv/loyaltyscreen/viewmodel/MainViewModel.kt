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

    var enableButton:MutableLiveData<Boolean> = MutableLiveData()

    init{
        firstNameIsError.value = false
        lastNameIsError.value = false
        phoneIsError.value = false
        emailIsError.value = false
        enableButton.value = false
    }

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

    fun isFirstNameEmpty():Boolean{
        var isEmpty:Boolean = false
        if(firstName.value != null) {
             isEmpty = firstName.value!!.isBlank()
        }
        firstNameIsError.value = isEmpty

        return isEmpty
    }
    fun isLastNameEmpty():Boolean{
        var isEmpty:Boolean = false
        if(lastName.value != null) {
            isEmpty = lastName.value!!.isBlank()
        }
        lastNameIsError.value = isEmpty

        return isEmpty
    }
    fun isEmailEmpty():Boolean{
        var isEmpty:Boolean = false
        if(email.value != null) {
            isEmpty = email.value!!.isBlank()
        }
        emailIsError.value = isEmpty

        return isEmpty
    }

    fun checkEnableButton(){
//        enableButton.value =
//            (!emailIsError.value!!) &&
//                (!lastNameIsError.value!!) &&
//                (!firstNameIsError.value!!) &&
//                (!phoneIsError.value!!) &&
//                (!email.value.isNullOrBlank()) &&
//                (!firstName.value.isNullOrBlank()) &&
//                (!lastName.value.isNullOrBlank())


            var x1 = !emailIsError.value!!
            var x2 = !lastNameIsError.value!!
            var x3 = !firstNameIsError.value!!
            var x4 =  !phoneIsError.value!!
            var x5 = !email.value.isNullOrBlank()
            var x6 = !firstName.value.isNullOrBlank()
            var x7 = !lastName.value.isNullOrBlank()

        enableButton.value = x1 && x2 && x3 && x4 && x5 && x6 && x7
    }

}