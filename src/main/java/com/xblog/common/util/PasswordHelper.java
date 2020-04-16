package com.xblog.common.util;

import com.xblog.modules.user.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;


/**
 * 用户 加密工具
 * 生成随机salt
 * md5(md5(password))
 *
 * @author shimh
 * <p>
 * 2018年1月23日
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";
    private static final int hashIterations = 5;

    public static void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());    //用户加盐
        String newPassword = new Md5Hash(user.getPassword(),ByteSource.Util.bytes(user.getSalt()),hashIterations).toString();
        user.setPassword(newPassword);  //用户加盐后加密的密码
    }


}