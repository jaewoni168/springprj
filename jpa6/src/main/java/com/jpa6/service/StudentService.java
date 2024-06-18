package com.jpa6.service;

import com.jpa6.entity.Student;
import com.jpa6.model.Pagination;
import com.jpa6.model.StudentEdit;
import com.jpa6.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class StudentService {
    @Autowired StudentRepository studentRepository;
    ModelMapper modelMapper = new ModelMapper();

    public StudentEdit findOne(int id) {
        Student studentEntity = studentRepository.findById(id).get();
        return toEditModel(studentEntity);
    }

    public Student findByStudentNo(String studentNo) {
        return studentRepository.findByStudentNo(studentNo);
    }

    public List<Student> findAll(Pagination pagination) {
        PageRequest pageRequest = PageRequest.of(pagination.getPg() - 1,
                pagination.getSz(),
                Sort.Direction.ASC, "id");
        Page<Student> page;
        if (pagination.getSt().length() == 0)
            page = studentRepository.findAll(pageRequest);
        else

            page = studentRepository.findByStudentNoOrNameStartsWithOrDepartmentNameStartsWith(
                    pagination.getSt(), pagination.getSt(), pagination.getSt(), pageRequest);
        pagination.setRecordCount((int)page.getTotalElements());
        return page.getContent();
    }

    public void insert(StudentEdit studentEdit, BindingResult bindingResult,
                       Pagination pagination) throws Exception {
        if (hasErrors(studentEdit, bindingResult))
            throw new Exception("입력 데이터 오류");
        Student student = toEntity(studentEdit);
        studentRepository.save(student);
        int lastPage = (int)Math.ceil((double)studentRepository.count() / pagination.getSz());
        pagination.setPg(lastPage);
    }



    public void update(StudentEdit studentEdit,
                       BindingResult bindingResult) throws Exception {
        if (hasErrors(studentEdit, bindingResult))
            throw new Exception("입력 데이터 오류");
        Student student = toEntity(studentEdit);
        studentRepository.save(student);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public Student toEntity(StudentEdit studentEdit) {
        return modelMapper.map(studentEdit, Student.class);
    }

    public StudentEdit toEditModel(Student studentEntity) {
        return modelMapper.map(studentEntity, StudentEdit.class);
    }

    public boolean hasErrors(StudentEdit studentEdit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return true;
        Student student2 = findByStudentNo(studentEdit.getStudentNo());
        if (student2 != null && student2.getId() != studentEdit.getId()) {
            bindingResult.rejectValue("studentNo", null, "학번이 중복됩니다.");
            return true;
        }
        return false;
    }
}