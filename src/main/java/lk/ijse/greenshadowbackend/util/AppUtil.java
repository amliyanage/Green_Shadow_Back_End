package lk.ijse.greenshadowbackend.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String createCropDetailsID() {
        return "CD" + UUID.randomUUID();
    }

    public static String toBase64ProfilePic(MultipartFile profilePic){
        String proPicBase64 = null;
        try {
            byte [] proPicBytes = profilePic.getBytes();
            proPicBase64 =  Base64.getEncoder().encodeToString(proPicBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return proPicBase64;
    }
}