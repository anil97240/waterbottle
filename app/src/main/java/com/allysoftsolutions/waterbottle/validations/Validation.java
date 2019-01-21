package com.allysoftsolutions.waterbottle.validations;

import android.text.TextUtils;
import android.util.Patterns;

 public class Validation
{
    public static boolean isValidEmail(CharSequence target,CharSequence Password) {
        return (!TextUtils.isEmpty(target) && !TextUtils.isEmpty(Password) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }


}
