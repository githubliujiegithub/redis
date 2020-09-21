//package com.example.redis.study.jwt;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.util.Base64Utils;
//
//import java.util.HashMap;
//import java.util.UUID;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Slf4j
//public class Jwts extends ConcurrentHashMap {
//    private static Jwts jwts;
//    static {
//        jwts = new Jwts();
//    }
//
//    /**
//     * 默认加密密钥
//     */
//    private final String jwtSafetySecret = "0dcac1b6ec8843488fbe90e166617e34";
//
//    /**
//     * 指定加密算法和密钥
//     * @param header
//     * @param jwtSafetySecret
//     * @return
//     */
//    public static Jwts header(Header header, String jwtSafetySecret) {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("code", header);
//        map.put("jwtSafetySecret", jwtSafetySecret);
//        jwts.put("header", map);
//        return jwts;
//    }
//    public Jwts payload(JwtClaims jwtClaims) {
//        jwts.put("payload", jwtClaims);
//        return jwts;
//    }
//    public String compact() throws Exception {
//        HashMap<String,Object> headerObj = (HashMap<String, Object>) jwts.get("header");
//        JwtClaims jwtClaims = (JwtClaims) jwts.get("payload");
//        jwtClaims.put("uuid", UUID.randomUUID());
//
//        Object jwtSafetySecretObj  = headerObj.get("jwtSafetySecret");
//
//        // 从头部信息中去除密钥信息
//        headerObj.remove("jwtSafetySecret");
//        String jwtSafetySecret = jwtSafetySecretObj == null ? this.jwtSafetySecret : jwtSafetySecretObj.toString();
//        Object code = headerObj.get("code");
//        String encryptionType = code == null ? "AES" : code.toString();
//        // 开始签名
//        String signature = dataSignature(headerObj, jwtClaims, encryptionType, jwtSafetySecret);
//        // 生成token
//        String token = Base64Utils.getBase64(JSONObject.toJSONString(headerObj)) + "."
//                + Base64Utils.getBase64(JSONObject.toJSONString(jwtClaims)) + "."
//                + signature;
//        System.out.println("生成的token为:" + token);
//        return token;
//    }
//    /**
//     * 生成摘要
//     */
//    private static String dataSignature(HashMap<String, Object> headerObj, JwtClaims jwtClaims, String encryptionType, String jwtSafetySecret) throws Exception {
//        String dataSignature = null;
//        if (encryptionType.equals(Header.AES.name())) {
//            dataSignature = AESUtils.encrypt(JSONObject.toJSONString(headerObj) + JSONObject.toJSONString(jwtClaims), jwtSafetySecret);
//        } else if (encryptionType.equals(Header.SM3.name())) {
//            dataSignature = SM3Cipher.sm3Digest(JSONObject.toJSONString(headerObj) + JSONObject.toJSONString(jwtClaims), jwtSafetySecret);
//        } else if (encryptionType.equals(Header.SM4.name())) {
//            dataSignature = new SM4Util().encode(JSONObject.toJSONString(headerObj) + JSONObject.toJSONString(jwtClaims), jwtSafetySecret);
//        }
//        return dataSignature;
//    }
//    /**
//     * @demand: 校验token完整性和时效性
//     */
//    public static Boolean safetyVerification(String tokenString, String jwtSafetySecret) throws Exception {
//        // 有坑，转义字符
//        String[] split = tokenString.split("\\.");
//        if (split.length != 3) {
//            throw new RuntimeException("无效的token");
//        }
//        // 头部信息
//        HashMap<String, Object> obj = JSON.parseObject(Base64Utils.getFromBase64(split[0]), HashMap.class);
//        // 数据信息
//        JwtClaims jwtClaims = JSON.parseObject(Base64Utils.getFromBase64(split[1]), JwtClaims.class);
//        // 签名信息
//        String signature = split[2];
//
//        // 验证token是否在有效期内
//        if (jwtClaims.get("failureTime") != null) {
//            Date failureTime = (Date) jwtClaims.get("failureTime");
//            int i = failureTime.compareTo(new Date());
//            if (i > 0) {
//                throw new RuntimeException("此token已过有效期");
//            }
//        }
//
//        // 验证数据篡改
//        Object code = obj.get("code");
//        String encryptionType = code == null ? "AES" : code.toString();
//        // 比较签名
//        String signatureNew = dataSignature(obj, jwtClaims, encryptionType, jwtSafetySecret);
//        return signature.equals(signatureNew.replaceAll("\r\n","")) ? true : false;
//    }
//
//}
