package com.canary.security.oauth.server;

import com.jaf.tools.security.ApMD5Util;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by jiahao on 2017/11/7.
 */
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return  charSequence == null ? "": ApMD5Util.getMD5(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.toString().equals(s);
    }
}
