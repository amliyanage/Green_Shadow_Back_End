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
@Table(name = "staff")
public class Staff {
        @Id
        @Column(name = "staff_member_id")
        private String id;
        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "designation")
        private String designation;
        @Column(name = "Gender")
        private Gender gender;
        @Column(name = "joined_date")
        private String joinedDate;
        @Column(name = "date_of_birth")
        private Date DOB;
        @Column(name = "address_line_1")
        private String addressLine1;
        @Column(name = "address_line_2")
        private String addressLine2;
        @Column(name = "address_line_3")
        private String addressLine3;
        @Column(name = "address_line_4")
        private String addressLine4;
        @Column(name = "address_line_5")
        private String addressLine5;
        @Column(name = "contact_no")
        private String contactNo;
        @Column(name = "email")
        private String email;
        @Column(name = "role")
        private Role role;

        @OneToMany(mappedBy = "assignedStaffDetails")
        private List<Equipment> equipment;

        @ManyToMany(mappedBy = "staff")
//    @Column(name = "fields")
        private List<Field> fields;

        @OneToMany(mappedBy = "allocatedStaffMemberDetails")
//    @Column(name = "vehicle")
        private List<Vehicle> vehicles;

        @ManyToOne
        @JoinColumn(name = "log_code")
        private CropDetails cropDetails;
}