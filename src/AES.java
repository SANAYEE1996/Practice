import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
 
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
 
import org.apache.commons.net.util.Base64;
 
public class AES {
 
    /** 암호키 (임의지정) */
    String encryptKey ="dladmlwlwjd";
 
    public String encrypt(String inputStr){
  
        String result =null;
   
        if ((inputStr ==null) || (inputStr.length() <1)) {
            return result;
        }
   
        SecretKeySpec keySpec =new SecretKeySpec(encryptKey.getBytes(),"AES");
         
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, keySpec);
     
            byte[] byteValue = cipher.doFinal(inputStr.getBytes("UTF-8"));
 
            Base64 base64EnDe =new Base64();           
 
            result = base64EnDe.encodeToString(byteValue).replaceAll("\r\n","");
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        }catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }catch (BadPaddingException e) {
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
         
        return result;
    }
     
     
    public String decrypt(String encStr){
     
        String result ="";
     
        if ((encStr ==null) || (encStr.length() <1)) {
            return result;
        }
         
        SecretKeySpec keySpec =new SecretKeySpec(encryptKey.getBytes(),"AES");
         
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, keySpec);
       
            Base64 base64EnDe =new Base64();           
 
            byte[] origianl = cipher.doFinal( base64EnDe.decode(encStr) );
      
            result =new String(origianl,"UTF-8");
             
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }catch (BadPaddingException e) {
            e.printStackTrace();
        }catch (InvalidKeyException e) {
            e.printStackTrace();
        }
     
        return result;
    }
}