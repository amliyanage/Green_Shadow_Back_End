package lk.ijse.greenshadowbackend.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropErrorResponse implements CropDetailsResponse , Serializable {
    private int errorCode;
    private String errorMessage;
}
