package com.tmv.loyaltyscreen.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.databinding.DataBindingUtil
import com.tmv.loyaltyscreen.R
import com.tmv.loyaltyscreen.databinding.ActivityMainBinding
import com.tmv.loyaltyscreen.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    val phoneIsInvalidErrorMessage:String = "This must be a valid phone number"

    val invalidEmailErrorMessage:String = "This must be a valid email"

    val emptyErrorMessage:String = "This field cannot be empty"

    var lettersOnlyErrorMessage:String = "This field can only contain letters"

    lateinit var mainViewModel:MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Specify the current activity as the lifecycle owner.
        binding.lifecycleOwner = this

        mainViewModel =  MainViewModel()
        et_firstname.addTextChangedListener(firstNameListener)

        et_lastname.addTextChangedListener(lastNameListener)

        et_phonenumber.addTextChangedListener(phoneNameListener)

        et_email.addTextChangedListener(emailNameListener)
        binding.viewmodel = mainViewModel

        val buttonClick = object: View.OnClickListener{
            override fun onClick(v: View?) {

            }
        }
    }

    var firstNameListener = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(mainViewModel.isFirstNameEmpty()) {
                til_firstname.error = emptyErrorMessage
            }
            else if( ! mainViewModel.isAlphaOnly(s.toString())) {
                mainViewModel.firstNameIsError.value = true
                til_firstname.error = lettersOnlyErrorMessage
            }
            else {
                mainViewModel.firstNameIsError.value = false
            }

            mainViewModel.checkEnableButton()
        }
    }

    var lastNameListener = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if( mainViewModel.isLastNameEmpty()) {
                til_lastname.error = emptyErrorMessage
            }
            else if( ! mainViewModel.isAlphaOnly(s.toString())) {
                mainViewModel.lastNameIsError.value = true
                til_lastname.error = lettersOnlyErrorMessage
            }
            else
                mainViewModel.lastNameIsError.value = false

            mainViewModel.checkEnableButton()
        }
    }
    var phoneNameListener = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(!mainViewModel.isValidPhoneInput(s.toString())) {
                    mainViewModel.phoneIsError.value = true
                    til_phonenumber.error = phoneIsInvalidErrorMessage
                }
                else
                    mainViewModel.phoneIsError.value = false

            mainViewModel.checkEnableButton()
        }
    }

    var emailNameListener = object: TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if(mainViewModel.isEmailEmpty()) {
                til_email.error = emptyErrorMessage
            }
            else if(! mainViewModel.isEmail(s.toString())) {
                mainViewModel.emailIsError.value = true
                til_email.error = invalidEmailErrorMessage
            }
            else
                mainViewModel.emailIsError.value = false

            mainViewModel.checkEnableButton()
        }
    }
}
