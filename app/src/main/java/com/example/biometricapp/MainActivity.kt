package com.example.biometricapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.biometric.BiometricPrompt
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var fingerprintHandler = FingerprintHandler(this)
    private var biometricPrompt: BiometricPrompt? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        selectFingerPrintButton.setOnClickListener{
            fingerprintHandler.setNextActivity(NextActivity())
            biometricPrompt = BiometricPrompt( this, fingerprintHandler.executor,  fingerprintHandler.callback )

            findViewById<View>(R.id.selectFingerPrintButton).setOnClickListener { view ->
                val promptInfo = fingerprintHandler.buildBiometricPrompt()
                var res = biometricPrompt!!.authenticate(fingerprintHandler.promptInfo)
            }
        }



    }
}
