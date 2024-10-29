package lk.ijse.greenshadowbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "crop_details")
public class CropDetails {
    @Id
    @Column(name = "log_code")
    private String logCode;
    private Date logDate;
    private String logDetails;
    @Column(columnDefinition = "LONGTEXT")
    private String observedImage;

    @OneToMany
    @JoinColumn(name = "field_code")
    private List<Field> fields;
    @OneToMany
    @JoinColumn(name = "crop_code")
    private List<Crop> crops;
    @OneToMany
    @JoinColumn(name = "staff_member_id")
    private List<Staff> staff;
}