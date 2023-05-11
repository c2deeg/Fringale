package com.app.fringale.Activities

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Base64
import android.util.Log
import com.app.fringale.R
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            val info: PackageInfo = this.getPackageManager().getPackageInfo(
                "com.humanresource",
                PackageManager.GET_SIGNATURES
            )
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d(
                    "KeyHash", "KeyHash:" + Base64.encodeToString(
                        md.digest(),
                        Base64.DEFAULT
                    )
                )
                Log.e("SHA1", md.toString())
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val intent2 = Intent(this, SplashActivity2::class.java)
            startActivity(intent2)

        }, 3000)

    }
}