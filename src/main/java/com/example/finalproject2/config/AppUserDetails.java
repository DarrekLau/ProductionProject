package com.example.finalproject2.config;

import com.example.finalproject2.models.Employee;
import com.example.finalproject2.repository.EmployeeRepository;
import com.example.finalproject2.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserDetails implements UserDetailsService {

    @Autowired
    private EmployeeRepository eRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<Employee> employees = eRepository.findByEmail(email);
        if (employees.size() == 0) {
            throw new UsernameNotFoundException("User details not found for the user "+email);
        }
        return new EmployeeService(employees.get(0));
    }

}
