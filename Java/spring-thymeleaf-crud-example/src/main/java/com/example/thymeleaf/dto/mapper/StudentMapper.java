package com.example.thymeleaf.dto.mapper;

import static org.apache.commons.lang3.Validate.matchesPattern;

import com.example.thymeleaf.dto.CreateStudentDTO;
import com.example.thymeleaf.dto.StudentResponseDTO;
import com.example.thymeleaf.entity.Address;
import com.example.thymeleaf.entity.Student;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentMapper {

    private static final String LETTERS = "[A-Za-z-\\s]+";
    private static final String LETTERS_AND_NUMBERS = "[0-9A-Za-z-\\s]+";

    public static Student toEntity(CreateStudentDTO dto) {
        Student student = new Student();

        matchesPattern(dto.getName(), LETTERS, "Invalid name");
        student.setName(dto.getName());

        student.setEmail(dto.getEmail());
        student.setBirthday(dto.getBirthday());

        Address address = new Address();
        address.setZipCode(dto.getZipCode());

        matchesPattern(dto.getStreet(), LETTERS, "Invalid street");
        address.setStreet(dto.getStreet());

        matchesPattern(dto.getNumber(), LETTERS_AND_NUMBERS, "Invalid number");
        address.setNumber(dto.getNumber());

        matchesPattern(dto.getComplement(), LETTERS, "Invalid complement");
        address.setComplement(dto.getComplement());

        matchesPattern(dto.getDistrict(), LETTERS, "Invalid district");
        address.setDistrict(dto.getDistrict());

        matchesPattern(dto.getCity(), LETTERS, "Invalid city");
        address.setCity(dto.getCity());

        matchesPattern(dto.getCity(), LETTERS, "Invalid state");
        address.setState(dto.getState());
        address.setStudent(student);

        student.setAddress(address);

        return student;
    }

    public static StudentResponseDTO toDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setBirthday(student.getBirthday());
        dto.setCreatedAt(student.getCreatedAt());
        dto.setZipCode(student.getAddress().getZipCode());
        dto.setStreet(student.getAddress().getStreet());
        dto.setNumber(student.getAddress().getNumber());
        dto.setComplement(student.getAddress().getComplement());
        dto.setDistrict(student.getAddress().getDistrict());
        dto.setCity(student.getAddress().getCity());
        dto.setState(student.getAddress().getState());

        return dto;
    }

    public static List<StudentResponseDTO> toDTO(List<Student> students) {
        return students.stream()
                .map(student -> toDTO(student))
                .collect(Collectors.toList());
    }

}
