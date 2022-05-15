package com.spb.houqin.common.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 符浩天
 * @version ?
 */
public class MD5Util {




    public static String getMD5Str(String str) {
            byte[] digest = null;
            try {
                MessageDigest md5 = MessageDigest.getInstance("md5");
                digest = md5.digest(str.getBytes("utf-8"));
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //16是表示转换为16进制数
            String md5Str = new BigInteger(1, digest).toString(16);
            return md5Str;
        }

        @Test
        public void Test(){
            String pwd = "1";
            MD5Util md5Util = new MD5Util();
            String md5Pwd = md5Util.getMD5Str(pwd);
            System.out.println(md5Pwd);
        }

}



