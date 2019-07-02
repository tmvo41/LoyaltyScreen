package com.tmv.loyaltyscreen.viewmodel


import android.app.Application
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import java.util.*

class MainViewModel:ViewModel() {

    var firstName:MutableLiveData<String> = MutableLiveData()

    var firstNameIsError: MutableLiveData<Boolean> = MutableLiveData()

    var lastName:MutableLiveData<String> = MutableLiveData()

    var lastNameIsError:MutableLiveData<Boolean> = MutableLiveData()

    var email:MutableLiveData<String> = MutableLiveData()

    var emailIsError:MutableLiveData<Boolean> = MutableLiveData()

    var phone:MutableLiveData<String> = MutableLiveData()

    var phoneIsError:MutableLiveData<Boolean> = MutableLiveData()















}