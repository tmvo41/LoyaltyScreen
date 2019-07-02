package com.tmv.loyaltyscreen.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel {

    var firstName:String = ""

    var lastName:String = ""

    var email:String = ""

    var phone:String = ""

    constructor() : super()

    fun isAlphaOnly(name: String): Boolean {//If string has only letters
        return name.matches("[a-zA-Z]+".toRegex())
    }





}