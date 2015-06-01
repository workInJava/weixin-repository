package com.text.project.utils;
import com.test.project.po.gen.UserDetail;

import org.apache.shiro.codec.Base64; 
import org.apache.shiro.codec.Hex; 
import org.apache.shiro.crypto.AesCipherService; 
import org.apache.shiro.crypto.SecureRandomNumberGenerator; 
import org.apache.shiro.crypto.hash.Md5Hash; 
import org.springframework.util.StringUtils;

import java.security.Key; 
/** 
* 备注： shiro进行加密解密的工具类封装 
*/ 
public final class EndecryptUtils { 
    /** 
     * base64进制加密 
     * 
     * @param password 
     * @return 
     */ 
    public static void encrytBase64(String password) { 
        byte[] bytes = password.getBytes(); 
        password = Base64.encodeToString(bytes); 
    } 
    /** 
     * base64进制解密 
     * @param cipherText 
     * @return 
     */ 
    public static void decryptBase64(String cipherText) { 
        cipherText = Base64.decodeToString(cipherText); 
    } 
    /** 
     * 16进制加密 
     * 
     * @param password 
     * @return 
     */ 
    public static void encrytHex(String password) { 
        byte[] bytes = password.getBytes(); 
        password = Hex.encodeToString(bytes); 
    } 
    /** 
     * 16进制解密 
     * @param cipherText 
     * @return 
     */ 
    public static void  decryptHex(String cipherText) { 
        cipherText = new String(Hex.decode(cipherText)); 
    } 
    public static String generateKey() 
    { 
        AesCipherService aesCipherService=new AesCipherService(); 
        Key key=aesCipherService.generateNewKey(); 
        return Base64.encodeToString(key.getEncoded()); 
    } 
    /** 
     * 对密码进行md5加密,并返回密文和salt，包含在User对象中 
     * @param username 用户名 
     * @param password 密码 
     * @return 密文和salt 
     */ 
    public static void md5Password(UserDetail userDetail){ 
        SecureRandomNumberGenerator secureRandomNumberGenerator=new SecureRandomNumberGenerator(); 
        String salt= secureRandomNumberGenerator.nextBytes().toHex(); 
        //组合username,两次迭代，对密码进行加密 
        String password_cipherText= new Md5Hash(StringUtils.trimAllWhitespace(userDetail.getPassword()),StringUtils.trimAllWhitespace(userDetail.getLoginName())+salt,2).toBase64(); 
        userDetail.setPassword(password_cipherText); 
        userDetail.setSalt(salt); 
    } 
   
}