package com.dark_phoenix09.app1pcon2k20.SignInUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.dark_phoenix09.app1pcon2k20.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.fragment_verify_phone.*
import java.util.concurrent.TimeUnit


class VerifyPhoneFragment : Fragment() {


    lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var mAuth: FirebaseAuth
    private var verificationId : String? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_phone, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutPhone.visibility = View.VISIBLE
        layoutVerification.visibility = View.GONE


        button_send_verification.setOnClickListener {

            val phone = edit_text_phone.text.toString().trim()

            if (phone.isEmpty() || phone.length != 10) {
                edit_text_phone.error = "Enter a valid phone"
                edit_text_phone.requestFocus()
                return@setOnClickListener
            }

            val phoneNumber = '+' + ccp.selectedCountryCode + phone


            layoutPhone.visibility = View.GONE
            layoutVerification.visibility = View.VISIBLE
        }
    }


}
